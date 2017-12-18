C-------------------------------------------------------------------------
C-
C       --
C-   INSTITUT  DE RECHERCHE EN INFORMATIQUE DE TOULOUSE (I.R.I.T.)      --
C-       LABORATOIRE D'INFORMATIQUE et MATHEMATIQUE APPLIQUEE
C-                DE L'E.N.S.E.E.I.H.T.
C-
C-                   P.Amestoy,  M. Dayde
C-------------------------------------------------------------------------
C
      PROGRAM slaveJac
      IMPLICIT NONE
C-------------------------------------------------------------------------
C Code de l'esclave associe a la Version parallele  de Jacobi par bloc
C  Chaque processus esclave est en charge du calcul
C   d'un bloc de la solution x de taille m, et possede
C   un bloc de taille m de lignes de la matrice.

C EPS       definit la precision sur la solution recherchee.
C           par rapport a la norme max du residu global
C Maxiter   definit le nombre maximum d'iterations
C-------------------------------------------------------------------------

      INTEGER M, Maxiter, NBCOL, Nprocs
      INTEGER, DIMENSION(:), ALLOCATABLE           :: IPIV
      DOUBLE PRECISION, DIMENSION(:,:), ALLOCATABLE:: A, D
      DOUBLE PRECISION, DIMENSION(:), ALLOCATABLE  :: B, X, R, Y
C ----------------------------------
C A(M,NBCOL) Bloc ligne de taille m de la matrice initiale
C R(M): Vecteur residu a chaque iteration
C Y(M): Vecteur iterant supplementaire
C D(M,M):  Matrice des blocs diagonaux factorises
C              D(1:m,1:m) contiendra la factorization LU 
C              du kieme bloc diagonal de la matrice A
C IPIV (M) : 
C              IPIV(1..M) vecteur de permutations 
C                            associe a la factorization LU 
C                            du kieme bloc diagonal de A
C Err : Norme max du residu
C Iter: Compteur d'iterations
C
C ----------------------------------
      DOUBLE PRECISION Err, Errtemp, EPS
      INTEGER I, J, NoSlave, Iter, INFO, tidPrec, tidSuiv, 
     &        ierr, Jdiag, my_id, p_id, type, bufidR,  bufidS
*
      EXTERNAL NORM
      DOUBLE PRECISION NORM
*
      include 'fpvm3.h'

* --------------------------
* S'enregister sous PVM
* --------------------------
      call pvmfmytid(my_id)
      call pvmfparent(p_id)
      if (p_id.le.0) stop

* ----------------------
* Reception des donnees 
* ----------------------

      tidPrec = 0
      tidSuiv = 0 
      type = 0
      call pvmfrecv(p_id, type, bufidR)
C
C    -- extraire la taille des donnees
      call pvmfunpack(INTEGER4, Nprocs, 1, 1, info)
      call pvmfunpack(INTEGER4, NoSlave, 1, 1, info)
      call pvmfunpack(INTEGER4, M, 1, 1, info)
      write(6,*) ' Esclave ', NoSlave, ' Nprocs,M =',  Nprocs,M
C
      call pvmfunpack(INTEGER4,tidPrec,1,1,info)
      call pvmfunpack(INTEGER4,tidSuiv,1,1,info)
      write(6,*) NoSlave,' : Mes voisins : gauche ',tidPrec, 
     &            ' et droite ',tidSuiv
      call pvmfunpack(INTEGER4, NBCOL, 1, 1, info)
      call pvmfunpack(INTEGER4, Maxiter, 1, 1, info)
      write(6,*) NoSlave,' : Matrice locale ', M, ' Lignes', 
     &             NBCOL, ' Col'

C
C     ------- Allocation  des donnees en memoire
      ALLOCATE (A(M,NBCOL), D(M,M), B(M), X(NBCOL),
     &                  IPIV(M), R(M), Y(M), stat=ierr)
      IF (ierr.GT.0) THEN
        write(6,*) ' Testez un pb de plus petite taille'
        write(6,*) ' Pas assez d espace memoire '
        stop
      END IF
C
C    ----- Extraire la sous matrice et le morceau de second membre 
      call pvmfunpack(REAL8, EPS, 1, 1, info)
      DO J=1,NBCOL
        call pvmfunpack(REAL8, A(1,J), M, 1, info)
      END DO
      call pvmfunpack(REAL8, B, M, 1, info)


C -------------------------------------------
C Initialisations de
C     Iter = compteur d'iterations 
C     Xloc = vecteur iterant (X(i)=0, i=1,NBCOL) 
C     R    = vecteur residu  (R(i)=B(i), i=1,M)
C     Err  = || R ||
C -------------------------------------------
       Iter=0
       X(1:NBCOL) = DFLOAT(0)
       R(1:M)     = B(1:M)
C      Calcul de la premiere norme du residu
       Err=NORM(R,M)
C      Affichage de la premiere norme du residu
       WRITE(*,*)'iteration ',Iter,' norme du residu ',Err
C
C ----------------------------------------------
C Copie et ...
C Factorisation LU des Nprocs blocs diagonaux Aj
C ----------------------------------------------
*      -- copy du bloc diagonal de A dans D(1:m, 1:m)
       Jdiag = M+1
       IF (NoSlave.EQ.1) Jdiag =1
       CAll COPYDIAG (A(1, Jdiag), D, M, M)
C      -- factorisation LU du bloc k de D
       CALL DGETRF ( M, M, D, M, IPIV, INFO )
 
C -----------------------
C Boucle de convergence
C -----------------------
       DO WHILE ((Err.GT.EPS).AND.(Iter.LE.Maxiter))
        
C         
C
C -----------
C A completer 
C -----------
C
C        Affichage de la norme du residu
         WRITE(*,*)'iteration ',Iter,' norme du residu ',Err
         Iter = Iter + 1
       END DO
      
C
C      --- envoi du morceau de solution au maitre
       type = 4

       call pvmfinitsend( PVMDATADEFAULT, bufidS)
       call pvmfpack(INTEGER4, NoSlave, 1, 1, info)
       call pvmfpack(INTEGER4, Iter, 1, 1, info)
       call pvmfpack(REAL8, X (Jdiag), M, 1, info)
       call pvmfsend(p_id, type, info)

C
C      ---  Quitter PVM
       call pvmfexit(info)

       STOP
       END

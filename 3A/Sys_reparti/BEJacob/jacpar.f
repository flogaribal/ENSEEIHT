C------------------------------------------------------------------------
C-
C       --
C-   INSTITUT  DE RECHERCHE EN INFORMATIQUE DE TOULOUSE (I.R.I.T.)      --
C-       LABORATOIRE D'INFORMATIQUE et MATHEMATIQUE APPLIQUEE
C-                DE L'E.N.S.E.E.I.H.T.
C
C-                   P.Amestoy,  M. Dayde
C-
C-------------------------------------------------------------------------


      SUBROUTINE JACPAR (A, X, B, N, M, Nprocs, EPS, Maxiter )
      IMPLICIT NONE

C ----------------------------------------------------------
C -Resolution du systeme A.X=B (de dimension NxN ) par
C  la methode iterative de Jacobi par blocs.
C -Soit A une matrice carree d'ordre N
C      tridiagonale par blocs composee
C      de nprocs blocs diagonaux de taille M (N = Nprocs*M)
C
C -EPS       definit la precision sur la solution recherchee.
C -Maxiter   definit le nombre maximum d'iterations
C
C -Algorithme utilise: Version parallele  de Jacobi par bloc 
C    Le processus maitre effectue:
C      - creation des processus esclaves PVM, 
C      - Distribution des donnees
C      - Collecte des resultats en provenance des escalves
C        (morceaux de solution X de Ax=B)
C    Chaque processus esclave est en charge du calcul 
C    d'un bloc de la solution x de taille m, et possede 
C    un bloc de taille m de lignes de la matrice.
C ----------------------------------------------------------
C
C ----------
C Parametres: 
C ----------
C    Entree (non modifies en sortie) :
C         A(N,N), B(N), N, M, NPROCS, EPS
C    Sortie (ne devant pas etre initialise en entree) :
C         X(N)
C
      INTEGER N, M, NPROCS, Maxiter
      DOUBLE PRECISION A(N,N),B(N),X(N),EPS
C
C -------------------
C Variables Locales
C -------------------
C
*     Le bloc de la matrice a envoyer 
*     a chaque esclave est caracterise  par:
*         Ideb: indice (de ligne) de debut de A
*         M   : nombre de lignes (consant)
*         Jdeb: indice (de colonne) de debut de A
*         Jfin: indice (de colonne) de fin de A
*            (NBCOL = Jfin - Jdeb + 1)
*     Prec et Suiv correspondent aux numero logiques
*          des processus suivants et precedants (modulo Nprocs)
*     NoSlave : numero logique de l'esclave
*     Iter    : nombre d'iterations des escalves

*
      INTEGER I, J, K, NoSlave, Ideb, Jdeb, Jfin, Suiv, Prec, 
     &        NBCOL, Iter
*
*      -- Variables PVM
      INTEGER my_id,  tids(Nprocs), info, type, bufidR, bufidS, 
     &        FLAG, numt
      include 'fpvm3.h'



* --------------------------
* S'enregister sous PVM
* --------------------------
      call pvmfmytid(my_id)
      if (my_id .lt. 0) then
         write(*,*) ' failure in enrolling on host'
         stop
      endif
C---     write(6,*) ' master tid = ', my_id


* --------------------------
* Creer Nprocs esclaves
* --------------------------
      IF (Nprocs.LE.0) RETURN 
      numt = 0
      FLAG=PVMDEFAULT
      DO i=1, Nprocs
           call pvmfspawn( 'slaveJac',FLAG, '*', 1,
     &     tids(i),info)
           numt = numt + info
           if (info.eq.1) then
            write(6,*) ' ACTIVATION PVM proc.: ',I,' pvmtid:',
     &                  tids(i) 
           else
            write(6,*) ' failure spawning process no: ',i
            write(6,*) ' Error code is ', tids(i)
           endif
      ENDDO
      if (numt .ne. Nprocs) then
         write(*,*) ' failure in spawning one slave '
         stop
      endif
C
* -------------------------------
* Distribution des donnees 
* -------------------------------
      write(6,*) ' -- Maitre : DEBUT de la distribution des donnees '
*
      type = 0
*
      DO NoSlave = 1, Nprocs


*
*       -- calcul de Ideb, Jdeb, Jfin, Prec, Suiv
        Ideb = (NoSlave-1)*M + 1
        IF (NoSlave.EQ.1) THEN
          Jdeb = 1
          Prec = Nprocs
        ELSE 
          Jdeb = (NoSlave-2)*M + 1
          Prec =  NoSlave-1
        END IF
        IF (NoSlave.EQ.Nprocs) THEN
          Jfin = N
          Suiv = 1
        ELSE
          Jfin = (NoSlave+1)*M
          Suiv = (NoSlave+1)
        END IF
        NBCOL = Jfin-Jdeb+1
        write(6,*) ' Slave no', NoSlave, 
     &             ' No du proc. precedent/suivant : ', Prec, Suiv
        write(6,*) ' Slave no', NoSlave,
     &            ' Envoi du bloc de A : Ideb,Jdeb,Jfin, NBCOL =', 
     &               Ideb,Jdeb,Jfin, NBCOL
*       ----------------------------------
*       Initialiser/Remplir/envoyer buffer
*       ----------------------------------
        call pvmfinitsend( PVMDATADEFAULT, bufidS)
*
        call pvmfpack(INTEGER4, Nprocs, 1, 1, info)
        call pvmfpack(INTEGER4, NoSlave, 1, 1, info)
        call pvmfpack(INTEGER4, M, 1, 1, info)
        Call pvmfpack(INTEGER4, tids(Prec), 1, 1, info)
        call pvmfpack(INTEGER4, tids(Suiv), 1, 1, info)
*       -- Ranger le bloc de lignes dans le buffer
        call pvmfpack(INTEGER4, NBCOL, 1, 1, info)
        call pvmfpack(INTEGER4, Maxiter, 1, 1, info)
        call pvmfpack(REAL8, EPS, 1, 1, info)
        DO J= Jdeb, Jfin
         call pvmfpack(REAL8, A(Ideb,J), M, 1, info)
        END DO
*       -- Ranger du B(Ideb:Ideb+M-1) dans le buffer
        call pvmfpack(REAL8, B(Ideb), M , 1, info)
*       
*       -- Envoi du contenu du buffer a l'esclave NoSlave
        call pvmfsend(tids(NoSlave), type, info)
*
      END DO

      write(6,*) ' -- Maitre : FIN de la distribution des donnees '

* -----------------------
* Reception des resultats
* -----------------------
      write(6,*) ' -- Maitre : DEBUT de reception resultats '

      type = 4
      do K = 1, nprocs
*       - reception dans un ordre quelconque
        call pvmfrecv(-1, type, bufidR)
        call pvmfunpack(INTEGER4, NoSlave, 1, 1, info)
        call pvmfunpack(INTEGER4, Iter, 1, 1, info)
        write(*,*) ' Reception des resultats de ', NoSlave, 
     &    ' Nb d''iterations = ', Iter
        call pvmfunpack(REAL8,X((NoSlave-1)*M+1),M,1,info)
      enddo

      write(6,*) ' -- Maitre : FIN de reception resultats '
C
* ------------
* Quitter PVM
* ------------
      call pvmfexit(info)
C
      RETURN
      END

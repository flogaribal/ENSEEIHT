C-------------------------------------------------------------------------
C-
C       --
C-   INSTITUT  DE RECHERCHE EN INFORMATIQUE DE TOULOUSE (I.R.I.T.)      --
C-       LABORATOIRE D'INFORMATIQUE et MATHEMATIQUE APPLIQUEE
C-                DE L'E.N.S.E.E.I.H.T.
C-
C-                   P.Amestoy,  M. Dayde
C--
C-------------------------------------------------------------------------
       PROGRAM testjacob
       IMPLICIT NONE
C ----------------------------------------------------
C 
C Programme de test des algorithmes bloc-jacobi 
C sequentiel et paralleles pour la resolution 
C de systemes lineaire A X = B, ou 
C A est une matrice carree d'ordre N
C      tridiagonale par blocs composee
C      de nprocs blocs diagonaux de taille M (N = Nprocs*M)
C 
C EPS      definit la precision sur la solution recherchee.
C Maxiter  definit le nombre maximum d'iterations
C 
C ----------------------------------------------------
       DOUBLE PRECISION EPS
       INTEGER Maxiter
       PARAMETER (EPS=1.0D-10, Maxiter=30)
C
       INTEGER N, M, Nprocs
C
C A(N,N) : Matrice d'ordre carree N (N=M*Nprocs)
C B(N)   : Vecteur second membre (ordre N)
C Xseq(N): Vecteur solution calculee par l'algorithme sequentiel (ordre N)
C Xpar(N): Vecteur solution calculee par l'algorithme parallele (ordre N)
C SOl(N) : Vecteur solution exacte  (ordre N)
C 
       DOUBLE PRECISION, DIMENSION(:,:), ALLOCATABLE ::  A
       DOUBLE PRECISION, DIMENSION(:),   ALLOCATABLE :: 
     &                                  B, Xseq, Xpar, SOL
C Indices locaux
       INTEGER :: ierr
C
C Procedure de resolution externe
       DOUBLE PRECISION NORM
       EXTERNAL JACSEQ, NORM
C
C --------------------------------
C Lecture de la taille du probleme
C --------------------------------
 10    WRITE(6,*) ' Nombre de processus '
       READ(5,*) Nprocs
       IF (Nprocs.LE.0) GOTO 10
       WRITE(6,*) ' Taille des blocs diagonaux '
       READ(5,*) M
       IF (M.LE.0) GOTO 10
       N = Nprocs*M
       write(6,*) ' Matrice d ordre N= ', N
C -----------------------------------
C Allocation  des donnees en memoire
C -----------------------------------
      ALLOCATE (A(N,N), B(N), Xseq(N), Xpar(N),
     &                  SOL(N), stat=ierr)
      IF (ierr.GT.0) THEN
        write(6,*) ' Testez un pb de plus petite taille'
        write(6,*) ' Pas assez d espace memoire '
        stop
      ENDIF
C ------------------------------
C Initialisations de 
C         A   matrice bloc trigiagonale
C         SOL solution exacte 
C         B   second membre (B = A*SOL)
C ------------------------------
C
      CALL  INITALL ( A, SOL, B, N, M, Nprocs)


C
C -----------------------------------------
C Appel de la resolution par l'algorithme 
C     ( Bloc Jacobi sequentiel )
C -----------------------------------------
C
      CALL JACSEQ (A, Xseq, B, N, M, Nprocs, EPS, Maxiter )
C
C -----------------------------------------
C Verification de la solution
C          Calcul/affichage de || R || ( R = B - A Xseq )
C          et de || Xseq - SOL || / || SOL ||
C -----------------------------------------
C
      CALL VERIF ( A, Xseq, B, N, SOL )
C
C -----------------------------------------
C Appel de la resolution par l'algorithme 
C     ( Bloc Jacobi Parallel )
C -----------------------------------------
C
      CALL JACPAR (A, Xpar, B, N, M, Nprocs, EPS, Maxiter )
C
C -----------------------------------------
C Verification de la solution
C          Calcul de || R || ( R = B - A Xpar )
C          et de || Xpar - SOL || / || SOL ||
C          || Xpar-SOL ||
C -----------------------------------------
C
      CALL VERIF ( A, Xpar, B, N, SOL )
C
      IF ( NORM (Xpar-Xseq, N) .GT. EPS) THEN
        write(6,*) ' ***** Erreur numerique dans le code parallele !!! '
      ENDIF
     
C
      STOP
      END

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
C

       SUBROUTINE JACSEQ (A, X, B, N, M, Nprocs, EPS, Maxiter )
       IMPLICIT NONE

C -------------------------------------------------------------
C -Resolution du systeme A.X=B (de dimension NxN ) par 
C  la methode iterative de Jacobi par blocs. 
C -Soit A une matrice carree d'ordre N 
C      tridiagonale par blocs composee
C      de nprocs blocs diagonaux de taille M (N = Nprocs*M)
C
C -EPS: definit la precision sur la solution recherchee.
C
C -Algorithme utilise: Version sequentielle  de Jacobi par bloc 
C -------------------------------------------------------------
C
C ----------
C Parametres: 
C ----------
C    Input  : A, B, N, M, NPROCS, EPS
C    Output : X
C
       INTEGER N, M, NPROCS, Maxiter
       DOUBLE PRECISION A(N,N),B(N),X(N),EPS
C ------------------
C Variables locales
C ----------------------------------
C R(N): Vecteur residu a chaque iteration
C Y(M): Vecteur iterant supplementaire
C
C Pour la factorization LU des matrices Akk (Nprocs blocs diagonaux de A)
C    Akk = Pk*Lk*Uk , ou 
C      Pk est une matrice de permutation 
C      Lk et Uk sont respectivement des matrices triangulaires
C                  inferieures et superieures.
C   on introduit:
C     - D(M,M,NPROCS):  Matrice des blocs diagonaux factorises
C           D(1:m,1:m,k) (notee Dk) contiendra 
C           - dans un premier temps un copie de Akk, 
C           - puis Lk Uk associes a la factorisation de Akk
C     - IPIV (M, Nprocs) : 
C              IPIV(1..M, k) vecteur de permutations 
C              correspondant a une matrice de permutation Pk
C              et construit durant la factorization LU  de Akk
C 
C      
C Err : Norme max du residu
C Iter: Compteur d'iterations
C ----------------------------------
       DOUBLE PRECISION R(N), Y(M), D (M, M, Nprocs), Err 
       INTEGER IPIV(M,Nprocs)
C      -- Fonction de calcul de la norme max
       EXTERNAL NORM
       DOUBLE PRECISION NORM
       INTEGER I, K, Iter, INFO
C -------------------------------------------
C Initialisations de
C     Iter = compteur d'iterations (K=0)
C     X    = vecteur iterant (X(i)=0, i=1,N) 
C     R    = vecteur residu  (R(i)=B(i), i=1,N)
C     Err  = || R ||
C -------------------------------------------
       Iter=0
       X   = DFLOAT(0)
       R   = B
C      -- Calcul de la premiere norme de residu
       Err=NORM(R,N)
       WRITE(*,*)'iteration ',Iter,' norme du residu ',Err
    
C ----------------------------------------------
C Copie et 
C Factorisation LU des Nprocs blocs diagonaux Aj
C ----------------------------------------------
       DO k=1, Nprocs
C       -- copy de Akk dans Dk
        CALL COPYDIAG (A((k-1)*m+1, (k-1)*m+1), D(1,1,k), N, M)
C       -- factorisation LU de Dk  (Dk = Pk*Lk*Uk)
        CALL DGETRF ( M, M, D(1,1,k), M, IPIV(1,k), INFO )
C       -- Dk contient les matrices Lk et Uk. 
C       -- IPIV (1:N,k) est le vecteur de permutation associe a Pk
       ENDDO

C -----------------------
C Boucle de convergence
C -----------------------
       DO WHILE ((Err.GT.EPS).AND.(Iter.LE.Maxiter)) 
C
C        ---------------------------
C        Boucle sur les blocs de A
C        ----------------------------
C
         DO k =1, Nprocs
C
C          -- calcul de Y tel que Dk Y = Rk  
C               ou Rk = R((k-1)*m+1, k*m))
C               (en entree de DGETRS Y contient Rk)
           Y( 1 : M ) = R( (k-1)*M+1 : k*M )
           CALL DGETRS ( 'N', M, 1, D(1,1,k), M, 
     &                    IPIV(1,k), Y, M, INFO )
C               (en sortie de DGETRS Y contient la solution de 
C                  Dk Y = Rk )
C          -- Calcul du nouvel iterant
           X( (k-1)*M+1 : k*M ) = X( (k-1)*M+1 : k*M ) + Y( 1 : M )
C
         END DO
C
C        ---------------------------------------
C        Calcul du nouveau residu et de sa norme
C        ---------------------------------------
         CALL RESIDU (A, X, B, R, N, N)
         Err = NORM(R,N)
C
         Iter=Iter+1
         WRITE(*,*)'iteration ',Iter,' norme du residu ',Err
C
       END DO
       RETURN
       END

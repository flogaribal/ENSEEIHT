       SUBROUTINE VERIF(A, X, B, N, SOL)
       IMPLICIT NONE
C ------------------------------------------
C Verification de la solution X /  A X =B  :
C   (SOL = solution exacte  
C    X   = Solution calculee 
C
C   a/ Calcul de || R || ( R=B-AX ) et affichage 
C   b/     et de || X - SOL || / || SOL || et affichage 
C --------------------------- -------------------------
C---  Parametres
      INTEGER          N
      DOUBLE PRECISION A(N,N),X(N),B(N),SOL(N)
C
C---  Variables locales
      INTEGER          I, J
      DOUBLE PRECISION NormErreur, NormResidu
      DOUBLE PRECISION R(N)    ! allouee dynamiquement
C
C---  External
      DOUBLE PRECISION NORM 
      EXTERNAL NORM, RESIDU

      CALL RESIDU ( A, X, B, R, N, N)
      NormResidu = NORM(R,N)
      write(6,*) ' Erreur Residu || B - A X  ||          = ',
     &           NormResidu
C
      NormErreur = NORM(X-SOL,N)/NORM(SOL,N)
      write(6,*) ' Erreur Sol. || X - SOL || / || SOL || = ',
     &           NormErreur

      RETURN
      END

***************************************************************
 
       SUBROUTINE INITALL (A, SOL, B, N, M, NPROCS)
       IMPLICIT NONE
C ---------------------------------------
C Initialisations de
C         A   matrice bloc trigiagonale
c           A(N,N) est trigiagonale par blocs et 
C           est composee de Nprocs blocs de taille m.
C         SOL solution exacte 
C         B   second membre (B = A*SOL)
C ------------------------------

       DOUBLE PRECISION A(N,N), SOl(N), B(N)
       INTEGER N, M, Nprocs
C
C--- local variables
       INTEGER I, J, K, Ideb, Jdeb, Ifin, Jfin
C
C
       A = DFLOAT(0)
       DO K=1, Nprocs
         Ideb = (K-1)*M + 1
         Ifin =  K   *M
         IF (K.EQ.1) THEN
              Jdeb = 1
         ELSE
              Jdeb = (K-2)*M + 1
         END IF
         IF (K.EQ.Nprocs) THEN
              Jfin = N
         ELSE
              Jfin = (K+1)*M
         END IF

         DO I = Ideb, Ifin
           DO J= Jdeb, Jfin
               IF(I.GT.J) THEN
                 A(I,J)=DFLOAT(-1)/DFLOAT(K)
               ELSE
                 A(I,J)=DFLOAT(1)/DFLOAT(K)
               ENDIF
           END DO
           A(I,I) = DFLOAT(4*K*M)
C          write(6,*) 'Row ',I,' of A =', A(I,1:N)
         END DO
       END DO

C ------------------------------------
C Initialisation de la solution exacte
c   SOL(I) = DFLOAT(I)
C Initialisation du second membre
C  (a partir de la solution exacte)
C ------------------------------------
       DO I=1,N
         SOL(I) = DFLOAT(I)
       END DO
       DO I =1,N
          B(I) = DFLOAT(0)
          DO J=1,N
           B(I) = B(I)+A(I,J)*SOL(J)
          END DO
       END DO

       RETURN
       END

***************************************************************
C
       DOUBLE PRECISION FUNCTION NORM(R,N)
       IMPLICIT NONE
C ---------------------------------------------------
C Calcul de la norme max du vecteur R, de longueur N
C ---------------------------------------------------
       DIMENSION R(N)
       DOUBLE PRECISION R
       INTEGER N, I
C      -- Valeur provisoire de la norme
       DOUBLE PRECISION S
C      -- Initialisation
       S=DFLOAT(0)
       DO I=1,N
           S=MAX( S, ABS(R(I)) )
       END DO
       NORM = S
       RETURN
       END
C
***************************************************************
       SUBROUTINE RESIDU(A,X,B,R,M,N)
       IMPLICIT NONE
C ------------------------------------------------
C Calcul du residu R, vecteur de taille M tel que
C   R = B- AX 
C avec A une matrice (MxN) 
C      (ayant M lignes et N colonnes).
C      X vecteur de taille N
C      B vecteur de taille M
C ------------------------------------------------
C
       INTEGER M, N, I, J
       DOUBLE PRECISION A(M,N),X(N),B(M),R(M)
C      -- Boucle sur les composantes du vecteur residu
       DO I=1, M
           R(I)=B(I)
           DO J=1,N
               R(I)=R(I)-A(I,J)*X(J)
           END DO
       END DO
       RETURN
       END

***************************************************************
C
       SUBROUTINE COPYDIAG ( A, D, M, N)
C
C ---------------------------------------------
C Copie du bloc diagonal constitue
C par les premieres N lignes et N colonnes
C de A dans la matrice carre D carree d'ordre N.
C ----------------------------------------------
       IMPLICIT NONE
        INTEGER M, N
        DOUBLE PRECISION A(M,N), D(N,N)
        INTEGER I,J
       
        D(1:N, 1:N) = A(1:N, 1:N)

       RETURN
       END


***************************************************************
C
C  -------------------------------------------------
C  Lecture du nom des machines constituant la
C  machine virtuelle
C  -------------------------------------------------
       subroutine read_file(name)
        character*32 name
*
        character*32 machine
        integer i
 5      read(10,1000,END=100) machine
1000    format(a32)
        do 10, i=1,32
           name(i:i)=' '
10      continue
        i=1
20      continue
          if (machine(i:i).ne.' ') then
            name(i:i) = machine(i:i)
            i = i+1
            goto 20
          endif
        GOTO 500
******* error end of file ***************
*       we restart from beginning of file
100     rewind(10)
        GOTO 5
***********************************
 500    return
        end


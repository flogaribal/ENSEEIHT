        SUBROUTINE VERIF(M,CT,C)

        INTEGER  M
        double precision  C(M) , CT(M)
        double precision  ERMAX, MAXV, RELER,EPS, ONE
        INTEGER  I
C
C Cette routine calcule l'erreur max entre C et CT
C
        ONE  = 1.0D0
        EPS  = 1.0D-9
        ERMAX = ABS(CT(1)-C(1))
        MAXV  = ABS(C(1))
           DO  10 I=1,M
             ERMAX = MAX(ABS(CT(I)-C(I)), ERMAX)
             MAXV  = MAX(ABS(C(I)),MAXV)
 10        CONTINUE
        WRITE (6,*) 'Erreur maximum           =',ERMAX
        IF (MAXV.LE.EPS) MAXV = ONE
        RELER = ERMAX/MAXV
        WRITE (6,*) 'Erreur maximum  Relative =',RELER
        RETURN
        END


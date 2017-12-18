/* Elapsed time measurement.                         */
/* Use is similar to cputime (Veclib)                */
/* Can be called from fortran:                       */
/*      real*4 xx, time_begin, elapse                */
/*      xx = elapse(0.0) or xx = elapse(time_begin)  */
/* Or   real*8 xx, time_begin, elapse                */
/*      xx = elapse8(0.0) or xx = elapse8(time_begin)*/
/* Accuracy: microsecond.                            */

#include <sys/time.h>

static double elapse_debut;

float elapse(val)
float *val;
{
        struct timeval time;
        double tt;
        gettimeofday(&time,(struct timezone *)0);
        tt=time.tv_sec+time.tv_usec*1.e-6;
        if (elapse_debut == (double)0.0) {
                elapse_debut=tt;
                return(0.0);
                }
        else {
                return((float)(tt-elapse_debut));
        }
}

#if defined(RS6K)
double elapse8(val)
#else
double elapse8_(val)
#endif
double *val;
{
        struct timeval time;
        double tt;
        gettimeofday(&time,(struct timezone *)0);
        tt=time.tv_sec+time.tv_usec*1.e-6;
        if (elapse_debut == (double)0.0) {
                elapse_debut=tt;
                return(0.0);
                }
        else {
                return(tt-elapse_debut);
        }
}




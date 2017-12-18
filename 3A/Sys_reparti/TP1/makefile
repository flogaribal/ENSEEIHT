F90   =  gfortran
CC    =  gcc
OPTF  = -c -g
OPTL  =  -g
#################################################################
# PVM related data
PVMLIB  = -lfpvm3 -lpvm3 -lgpvm3
LIBS    = -L/usr/lib  $(PVMLIB)
INCLUDE = -I/usr/include
#
# Directory to save the executable files
IDIR        = $(HOME)/pvm3/bin/$(PVM_ARCH)/
#
# user's object files
BLAS   = blas.o
OTHER = verif.o timings.o elapse.o readhost.o

all : matvec_master matvec_slave 

matvec_master : matvec_master.o $(BLAS) $(OTHER) 
	$(F90) $(OPTL) -o matvec_master matvec_master.o $(BLAS) $(OTHER) $(LIBS)
	mv matvec_master $(IDIR)

matvec_slave : matvec_slave.o $(BLAS)
	$(F90) $(OPTL) -o matvec_slave matvec_slave.o $(BLAS) $(LIBS)
	cp matvec_slave $(IDIR); rm $(IDIR)/matvec_slave; mv matvec_slave $(IDIR)

.F.o :
	$(F90) $(INCLUDE) -D${PVM_ARCH} $(OPTF) $*.F

.f.o : 
	$(F90) $(INCLUDE) $(OPTF) $*.f
	
.c.o :
	$(CC) -c -D$(PVM_ARCH) $*.c

clean :
	-/bin/rm *.o; touch *.F

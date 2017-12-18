F90   = gfortran
CC    = gcc
OPTF  = -c -g 
OPTL  = -g 
#################################################################
# PVM related data
PVMLIB  = -lfpvm3 -lpvm3 -lgpvm3
LIBS    =  -L/usr/lib  $(PVMLIB)
INCLUDE = -I/usr/include

#
# Directory to save the executable files
IDIR        = $(HOME)/pvm3/bin/$${PVM_ARCH}
#
# user's object files
#
BLAS   = blas.o
OTHER = verif.o timings.o elapse.o readhost.o

all : masterD slaveD

masterD : masterD.o $(BLAS) $(OTHER) 
	$(F90) $(OPTL) -o masterD masterD.o $(BLAS) $(OTHER) $(LIBS)
	mv masterD $(IDIR)

slaveD : slaveD.o $(BLAS)
	$(F90) $(OPTL) -o slaveD slaveD.o $(BLAS) $(OTHER) $(LIBS)
	cp slaveD $(IDIR); rm $(IDIR)/slaveD; mv slaveD $(IDIR)

.F.o :
	$(F90) $(INCLUDE) -D$${PVM_ARCH} $(OPTF) $*.F

.f.o : 
	$(F90) $(INCLUDE) $(OPTF) $*.f
	
.c.o :
	$(CC) -c -D$(PVM_ARCH) $*.c

clean :
	-/bin/rm *.o ; touch *.F

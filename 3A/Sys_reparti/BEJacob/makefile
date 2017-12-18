F90   =  gfortran
CC    =  gcc
OPTF  = -c -g
OPTL  =  -g
####################################################
# PVM related data
PVMLIB  = -lfpvm3 -lpvm3 -lgpvm3
LIBS    = -L/usr/lib  $(PVMLIB)
INCLUDE = -I/usr/include
#
# Directory to save the executable files
IDIR        = $(HOME)/pvm3/bin/$(PVM_ARCH)

#
# user's object files
#
OBJETS = jacseq.o jacpar.o util.o lapack.o


all: testjacob slaveJac

testjacob: testjacob.o $(OBJETS)
	$(F90) $(OPTL) -o testjacob testjacob.o $(OBJETS)  $(LIBS)
	mv testjacob $(IDIR)

slaveJac: slaveJac.o $(OBJETS)
	$(F90) $(OPTL) -o slaveJac slaveJac.o $(OBJETS)  $(LIBS)
	cp slaveJac $(IDIR); rm $(IDIR)/slaveJac; mv slaveJac $(IDIR)

.f.o:
	$(F90) $(INCLUDE) $(OPTF) $*.f

clean:
	\rm *.o $(IDIR)/testjacob $(IDIR)/slaveJac

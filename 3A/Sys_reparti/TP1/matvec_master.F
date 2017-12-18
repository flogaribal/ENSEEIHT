C-------------------------------------------------------------------------
C-
C       --
C-   INSTITUT  DE RECHERCHE EN INFORMATIQUE DE TOULOUSE (I.R.I.T.)      --
C-       LABORATOIRE D'INFORMATIQUE et MATHEMATIQUE APPLIQUEE
C-                DE L'E.N.S.E.E.I.H.T.
C               --
C-                   P.Amestoy,  M. Dayde
CC      --
C-------------------------------------------------------------------------
*
C------------------------------------------
C Version statique 
C du produit matrice-vecteur.
c Le programme maitre est en charge 
C du calcul du premier block de lignes, 
C de la distribution des donnees initiales
C et de la collecte des resultats.
C--------------------------------------------

      program matvec_master
      implicit none
* -----------------
* static parameters
* -----------------
      integer slave_max, NITER, lda
      double precision one, zero, small
      PARAMETER(lda=5000)
      PARAMETER (slave_max=32, NITER=2000)
      PARAMETER ( small = 1.0D-3, one=1.0D0, zero=0.0D0)
* -----------------------------------------------
* Input Matrices and vectors used to compute Ax=y
* -----------------------------------------------
      double precision a(lda,lda),x(lda),y(lda)
      double precision yseq(lda)
      integer incx
* -------------
* PVM variables
* -------------
* inst : inst(I) is the PVM tid of slave process I
* FLAG : specifies process spawning options
* type = 0 to broadcast initial informations
*      = 1 to distribute data to the slaves
*      = 2 to receive results from the slaves
      integer inst(slave_max)
      integer FLAG, type, my_id, info
      integer numt, bufidS, bufidR
      include 'fpvm3.h'
* ---------------
* local variables
* ---------------
* nb_of_slaves    : number of pvm processes activated
* nb_of_processes : number of processes doing computation
*                    nb_of_processes=nb_of_slaves+1 (master works!)
* first_row(I)    : Index of the first row processed by task I
*                   The number of rows processed by task I is then
*                   first_row(I+1) - first_row(I)
* HFILE           : File name holding a list of computer names 
*                   (one per line)
* sflops          : Mflop/s rate of the sequential computation
*                     (Million of floating point operations /second)
* pflops          : Mflop/s rate of the // computation

*
      integer nb_of_slaves,no_slave,nb_of_processes,recv_no_salve
      integer first_row(slave_max+2)
      integer n,m,i,j
      character*1 AUTRE
      double precision t1,t2,t12,pflops,sflops,totalflops
*
      write (6,*) "Algorithme:"
      write (6,*) " Version statique initiale "
      write (6,*) " Decoupage statique de la matrice initiale "
      write (6,*) " Le maitre traite le premier bloc"
*
* --------------------------
* Enroll this program in Pvm
* --------------------------
      call pvmfmytid(my_id)
      if (my_id .lt. 0) then
         write(*,*) 'failure in enrolling on host'
         stop
      endif
      write(6,*) ' master tid = ', my_id
*
*           |-   L O O P  over T E S T S -|
*           V                             V
*
 1    continue
*
* ---------------------------------------------
* BEGIN of data initialisation/preparation
* ---------------------------------------------
*
      write(*,*) ' How many slave processes ? '
      read(*,*) nb_of_slaves
      if ((nb_of_slaves.lt.0).OR.(nb_of_slaves.gt.slave_max)) goto 1
*     --------------------------------------------------
*     initialize nb_of_slaves instances of slave program
*     --------------------------------------------------
      if (nb_of_slaves.ge.1) then
       numt = 0
       FLAG=PVMDEFAULT
       DO i=1, nb_of_slaves
           call pvmfspawn( 'matvec_slave',FLAG, '*', 1,
     &     inst(i),info)
           numt = numt + info
           if (info.ne.1) then
            write(6,*) ' failure spawning process no: ',i
            write(6,*) ' Error code is ', inst(i)
           endif
       ENDDO
       if (numt .ne. nb_of_slaves) then
         write(*,*) 'failure in spawning one slave '
         stop
       endif
      endif
      nb_of_processes = nb_of_slaves +1
*
2     write(6,*)' Enter number of rows in the matrix <= ', lda
      read(5,*) m
      if ( m .gt. lda ) goto 2
*
3     write(6,*)' Enter number of columns in the matrix <= ', lda 
      read(5,*) n
      if ( n .gt. lda ) goto 3
*
      write(6,*)' Generate data for the computation'

      do j=1,n
         do i = 1,m
           a(i,j) = DBLE(i+j)/DBLE(m+n) + one
         enddo
         x(j) = one + DBLE(j)/DBLE(n)
      enddo
*
*     ------------------------------------------------------------
*     compute the index of the first row performed by each process
*     ------------------------------------------------------------
      first_row(1)                 = 1
      first_row(nb_of_processes+1) = m+1
      j = (m / nb_of_processes)
      if (nb_of_slaves.gt.0) then
       do i=2,nb_of_processes
        first_row(i) = j*(i-1) +1
       enddo
*      --------------
*      work balancing
*      --------------
       j = mod(m,nb_of_processes)
       do i=1, j-1
         first_row(nb_of_processes-i+1) =
     &       first_row(nb_of_processes-i+1) +j -i
       enddo
      endif
*
      do i=1,nb_of_processes+1
            write(6,*) 'i, first_row(i) ',i,first_row(i)
      enddo
*
*
* ---------------------------------------------
* END of data initialisation/preparation
* ---------------------------------------------
*

      write(6,*)' *** Compute parallel m*v, dot product method *** '
* 
      call secdeb(t2)
*
      if (nb_of_slaves.gt.0) then
*
* -------------------------------
* broadcast n and x to the slaves
* -------------------------------

       write(6,*) ' broadcast n and x to all slaves '
       type =0
       call pvmfinitsend( PVMDATADEFAULT, bufidS)
       call pvmfpack(INTEGER4, n, 1, 1, info)
       call pvmfpack(REAL8,    x, n, 1, info)
       call pvmfmcast(nb_of_slaves, inst, type, info)
*
* ------------------------------------
* send submatrix to each slave process 
* ------------------------------------
        write(6,*) ' first block of size   : ',
     &       first_row(2)-first_row(1), ' processed by master'
       type = 1
       do 60, no_slave = 1, nb_of_processes-1
*       number of components computed by the slave no_slave
        j = first_row(no_slave+2) - first_row(no_slave+1)
        write(6,*) ' send submatrix of size: ',j,
     *                  ' rows to slave: ', no_slave
        call pvmfinitsend( PVMDATADEFAULT, bufidS)
        call pvmfpack(INTEGER4, j, 1, 1, info)
        call pvmfpack(INTEGER4, no_slave, 1, 1, info)
        call pvmfsend(inst(no_slave), type, info)
        call pvmfinitsend( PVMDATADEFAULT, bufidS)
        do 70, i=1, n
         call pvmfpack(REAL8, a(first_row(no_slave+1),i),j,1,info)
 70     continue
        call pvmfsend(inst(no_slave), type, info)
 60    continue
      endif
* 
* -------------------------
* Compute his part of work
* -------------------------
      incx = 1
      DO I=1,NITER
      call dgemv('N',first_row(2)-first_row(1),n, 
     &            one,a,lda,x,incx,zero,y,incx)
      ENDDO
      if (nb_of_slaves.gt.0) then
* ---------------------
* Collect the results
* ---------------------
       type = 2
       write(*,*) ' start to receive results from slaves '

       do no_slave = 1, nb_of_slaves
*       number of components computed by the slave no_slave
        call pvmfrecv(-1, type, bufidR)
        call pvmfunpack(INTEGER4,recv_no_salve,1,1,info)
        j = first_row(recv_no_salve+2) - first_row(recv_no_salve+1)
        call pvmfunpack(REAL8,y(first_row(recv_no_salve+1)),j,1,info)
       enddo
      endif
*
      call secfin(t2)
*
      write(6,2000)(y(i),i=1,8)
c     do i=1,m
c       print *, i,' y = ',y(i)
c       y(i)=0
c     enddo
*
*
* -------------------------------------------------
* Compute sequential matrix vector product
* for both error analysis and performance analysis
* -------------------------------------------------
*
      write(6,*)' *** Compute sequential m*v, dot product method *** '
*
      call secdeb(t1)
      DO I=1,NITER
      call dgemv('N',m,n,one,a,lda,x,incx,zero,yseq,incx)
      ENDDO
      call secfin(t1)
      write(6,2000)(yseq(i),i=1,8)
*
*      --------------------------------------------------
*      compare sequential and // results of matrix vector
*      product. Print max/relative error and performance
*      --------------------------------------------------
       call verif(m,y,yseq)

*
*
      if ( (t1 .lt. small) .or. (t2 .lt. small) ) then
        write(6,9000)
        write(6,9001)
      else
        t12=t1/t2
        write (6,3000) t1,t2,t1/t2
        totalflops = float(2*NITER)*float(m)*float(n)
        sflops=totalflops/t1
        pflops=totalflops/t2
        write (6,4000) sflops,pflops
      endif
*
*
       WRITE(6,*) " Autre Factorization (O/N)?"
        read(*,*) AUTRE
        IF ((AUTRE.EQ.'O').OR.(AUTRE.EQ.'o')) GOTO 1
*
*           ^                                  ^
*           |-   END  OF  T E S T   L O O P   -|
*
*
*     leaving pvm environment
1000  call pvmfexit(info)
*
2000  format(1x,'Dot product of first 8 elements'/4(1pg14.5,5x))
3000  format(4x,'Seq. Time',5x,'Para. Time',4x,'Speedup'/3(1pe14.5))
4000  format(2x,'Sequential FlopRate  Parallel FlopRate',
     &           /1pg14.5,5x,1pg14.5)
9000  format(1x,' Parallel timing was too small to do calculations')
9001  format(1x,' Use a larger value for problem size and rerun')
      stop 
      end
   

        


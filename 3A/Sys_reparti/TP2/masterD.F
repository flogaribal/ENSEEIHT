C-------------------------------------------------------------------------
C-
C       --
C-   INSTITUT  DE RECHERCHE EN INFORMATIQUE DE TOULOUSE (I.R.I.T.)      --
C-       LABORATOIRE D'INFORMATIQUE et MATHEMATIQUE APPLIQUEE
C-                DE L'E.N.S.E.E.I.H.T.
C               --
C-                   P.Amestoy, M. Dayde
CC      --
C-------------------------------------------------------------------------
* pvm3 version of the code
* Dynamic version of the matrix vector
C-------------------------------------------------------------------------
      program masterD
      implicit none
* -------------------
* static parameters
* -------------------
      integer slave_max, ntask_max, NITER, lda
      parameter(lda=5000, slave_max=32)
      parameter (ntask_max=256,NITER=2000)
      double precision small, one, zero
      parameter ( small = 1.0D-6, one = 1.0D0, zero = 0.0D0)
* --------------------------
* matrix-vector related data
* --------------------------
      double precision a(lda,lda),x(lda),y(lda)
      double precision yseq(lda)
      integer incx, num_task,task_id, slave_id
      integer n,m,i,j
* --------------
* pvm variables
* --------------
* FLAG = specifies process spawning options
*        default is PVMTASKHOST

      integer FLAG, my_id, info, type, typeR, bufid,
     &        bufidR, nbytes, tid_slave
      integer inst(slave_max)
      integer numt
      include 'fpvm3.h'
* 
* ----------------
* local variables:
* ----------------
*     nb_of_slaves  : Total number of PVM processes activated 
*     nblig         : Task granularity (number of lines per task)
*     nbtasks       : Total number of tasks to be processed
*     task_processed: Number of tasks already processed
*                     by the slaves.
*     next_task     : Index of the next task to be processed
*     first_row(I)  : Index of the first row processed by task I
*     sflops        : Mflops rate of the sequential computation
*                     (Million of floating point operations /second)
*     pflops        : Mflops rate of the // computation
*
*
      integer nb_of_slaves, nblig, nbtasks, task_processed, 
     &        next_task, first_row(ntask_max+1), no_slave, task_id
      integer FIN
      PARAMETER (FIN=-1)
      double precision t1,t2,t12,pflops,sflops,totalflops
*
*
      write (6,*) "Algorithme:"
      write (6,*) " Version dynamique du produit mat-vec "
*
* --------------------------
* Enroll this program in Pvm
* --------------------------
      call pvmfmytid(my_id)
      if (my_id .lt. 0) then
         write(*,*) 'failure in enrolling on host'
         stop
      endif
* 
* ----------------
* Read input data 
* ----------------
1     write(*,*) ' How many slave worstations will you used '
      read(*,*) nb_of_slaves
      if ((nb_of_slaves.le.0).OR.(nb_of_slaves.gt.slave_max)) goto 1
*
* --------------------------------------------------
* initialize nb_of_slaves instances of slave program
* --------------------------------------------------
*
       numt = 0
       FLAG = PVMDEFAULT
         do i=1, nb_of_slaves
           call pvmfspawn( 'slaveD',FLAG, '*', 1,
     &     inst(i),info)
           numt = numt + info
           if (info.eq.1) then
             write(6,*) ' task no: ',I,' pvmtid:', inst(i)
           else
             write(6,*) ' failure spawning process no: ',i
             write(6,*) ' Error code is ', inst(i)
           endif
         enddO
      if (numt .ne. nb_of_slaves) then
        write(*,*) 'failure in spawning one slave '
        stop
      endif
*
* ---------------------------------------------
* Begin of data initialisation/preparation 
* ---------------------------------------------
*
      m = lda+1
      DO WHILE (m.GT.lda)
        write(6,*)' Enter number of rows in the matrix <= ', lda
        read(5,*) m
      END DO
*
      n = lda+1
      DO WHILE (n.GT.lda)
       write(6,*)' Enter number of columns in the matrix <= ', lda
       read(5,*) n
      END DO
*
4     write(6,*)' task granularity: nb of lines processed per task ?'
      read(5,*) nblig
      if (nblig.LE.0) goto 4
      nbtasks = m/nblig
      if (nbtasks.LT.nb_of_slaves) then
       nblig = m/nb_of_slaves
       nbtasks = m/nblig
       write(6,*) ' Decreased task granularity ',nblig
      endif
      if (mod(m,nblig).NE.0) nbtasks = nbtasks+1
      if (nbtasks.GT.ntask_max) then
       write(6,*) ' Increase nb of lines per task '
       goto 4
      endif
*
      write(6,*)' Generate data for the computation'

      do j=1,n
         do i = 1,m
           a(i,j) = DBLE(i+j)/DBLE(m+n) + one
         enddo
         x(j) = one + DBLE(j)/DBLE(n)
      enddo
      do i=1,m
        y(i)    = zero
        yseq(i) = zero
      enddo
*     ------------------------------------------------------------
*     compute the index of the first row processed by each task 
*     ------------------------------------------------------------
      first_row(1) = 1
      do i=1,nbtasks-1
        first_row(i+1) = i*nblig +1
      enddo
      first_row(nbtasks+1) = m+1
       do i=1,nbtasks
            write(6,*) 'i first_row(i)',i,first_row(i)
       enddo
*
* ---------------------------------------------
* END of data initialisation/preparation 
* ---------------------------------------------
*
*
      write(6,*)' *** Compute parallel m*v, dot product method *** '
* 
      call secdeb(t2)
* 
* -------------------------------
* broadcast n and x to the slaves
* -------------------------------
      type =0
      call pvmfinitsend( PVMDATADEFAULT, bufid)
      call pvmfpack(INTEGER4, n, 1, 1, info)
      call pvmfpack(REAL8,    x, n, 1, info)
      call pvmfmcast(nb_of_slaves, inst, type, info)
*   
* ------------------------------------
* send submatrix to each slave process 
* ------------------------------------
*
      type =  1
      do no_slave = 1, nb_of_slaves
*       number of components computed by the slave no_slave
        task_id = no_slave
        j = first_row(task_id+1) - first_row(task_id)
        call pvmfinitsend( PVMDATADEFAULT, bufid)
        call pvmfpack(INTEGER4, task_id, 1, 1, info)
        call pvmfpack(INTEGER4, j, 1, 1, info)
        do i=1, n
           call pvmfpack(REAL8, a(first_row(task_id),i), j, 1, info)
        enddo
        call pvmfsend(inst(no_slave), type, info)
      enddo



*     TO BE DONE ......
      do nr = 1, nbtasks
        call pvmfrecv(-1, type, bufidR)
*       TODO
        call pvmfbufinfo(bufidR, TYPE, BYTES, slave_id, info)
        call pvmfunpack(INTEGER4,num_task,1,1,info)
        j = first_row(num_task+1) - first_row(num_task)
        call pvmfunpack(REAL8,y(first_row(num_task)),j,1,info)

        if (num_task.eq.ntask_max) then
*         TODO VERIFIER          
          task_id = num_task+1
          j = first_row(task_id+1) - first_row(task_id)
          call pvmfinitsend( PVMDATADEFAULT, bufid)
          call pvmfpack(INTEGER4, task_id, 1, 1, info)
          call pvmfpack(INTEGER4, j, 1, 1, info)
          do i=1, n
             call pvmfpack(REAL8, a(first_row(task_id),i), j, 1, info)
          enddo
          call pvmfsend(inst(no_slave), type, info)



      write(6,*) ' Voir Algorithme du maitre dans le README '
      write(6,*) ' a ecrire ... !! '
      write(6,*) ' TEMPORAIRE : ', 
     &           ' Diffusion message de fin aux esclaves '
      type =1
      call pvmfinitsend( PVMDATADEFAULT, bufid)
      call pvmfpack(INTEGER4, FIN, 1, 1, info)
      call pvmfmcast(nb_of_slaves, inst, type, info)



*
* -------------------
* End of computation
* -------------------
      call secfin(t2)
*
      write(6,2000)(y(i),i=1,8)
*
* -------------------------------------------------
* Compute sequential matrix vector product 
* for both error analysis and performance analysis
* -------------------------------------------------
*
      write(6,*)' *** Compute sequential m*v, dot product method *** '
*
      call secdeb(t1)
*
* perform yseq <-- one*Ax + zero*yseq
* where A is an mxn matrix of leading dimension lda
      incx = 1
      DO i=1,NITER
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
 500  call pvmfexit(info)
*
2000  format(1x,'Dot product of first   elements'/4(1pg14.5,5x))
3000  format(4x,'Seq. Time',5x,'Para. Time',4x,'Speedup'/3(1pe14.5))
4000  format(2x,'Sequential FlopRate  Parallel FlopRate',
     &      /1pg14.5,5x,1pg14.5)
9000  format(1x,' Parallel timing was too small to do calculations')
9001  format(1x,' Use a larger value for problem size and rerun')
      stop 
      end
   

        


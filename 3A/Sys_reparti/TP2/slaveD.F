C-------------------------------------------------------------------------
C-
C       --
C-   INSTITUT  DE RECHERCHE EN INFORMATIQUE DE TOULOUSE (I.R.I.T.)      --
C-       LABORATOIRE D'INFORMATIQUE et MATHEMATIQUE APPLIQUEE
C-                DE L'E.N.S.E.E.I.H.T.
C-
C-                   P.Amestoy,  M. Dayde
CC      --
C-------------------------------------------------------------------------
************************************************************************
      program slave
      implicit none
* -------------------
* static parameters
* -------------------
      integer NITER, lda
      parameter (NITER=2000, lda=5000)
      double precision one, zero
      parameter ( one = 1.0D0, zero = 0.0D0)
* --------------------------
* matrix-vector related data
* --------------------------
      double precision a(lda,lda),x(lda),y(lda)
      integer incx
      integer n,m,i
      logical fini
*
* --------------
* pvm variables
* --------------
      integer my_id, info
      include 'fpvm3.h'
      integer p_id, bufid, bufidS, type, typeS, task_id
*
*
* ---------------------------
* Enroll this program in PVM_3
* Get the tid of the master task id
* ---------------------------
      call pvmfmytid(my_id)
      call pvmfparent(p_id)
      if (p_id.le.0) goto 500
* 
* ------------------------
* Receive broadcasted data
* ------------------------
      type = 0
      call pvmfrecv(p_id, type, bufid)
      call pvmfunpack(INTEGER4, n, 1, 1, info)
      if (n.gt.lda) goto 500
      call pvmfunpack(REAL8   , x, n, 1, info)
*
* ------------------------------------------------------------
* Receive work from the master:
* the task_id, the size of the block of row and the sub-matrix
*           |-   MAIN LOOP OF SLAVE      -|
*           V                             V
* ------------------------------------------------------------
      type = 1
      fini = .false.
      DO WHILE ( .NOT.fini )
        call pvmfrecv(p_id, type, bufid)
        call pvmfunpack(INTEGER4, task_id, 1, 1, info)
      write(6,*) ' slave', my_id, ' processes task:',task_id
*       --------------------------
*       test if end of computation
*       --------------------------
        if (task_id.EQ.-1) then
         write(6,*)  ' slave', my_id,' no more work'
         fini = .true.
         cycle
        endif
        call pvmfunpack(INTEGER4, m, 1, 1, info)
        if (m.gt.lda) stop
        do i=1,n
         call pvmfunpack(REAL8, a(1,i), m, 1, info)
        enddo
*
*       ----------------
*       task computation
*       -----------------
        incx = 1
        DO I=1,NITER
         call dgemv
     &       ('N',m,n,one,a,lda,x,incx,zero,y,incx)
        ENDDO
*
*       --------------------------------------
*       send back task_id and results to master
*       --------------------------------------
        call pvmfinitsend( PVMDATADEFAULT, bufidS)
        call pvmfpack(INTEGER4, task_id, 1, 1, info)
        call pvmfpack(REAL8, y, m, 1, info)
        typeS = 0
        call pvmfsend(p_id, typeS, info)
      write(6,*) ' slave', my_id, ' sends results',
     &             ' task:',task_id
      END DO
*
* leave Pvm before exiting
 500  call pvmfexit(info)
*
      stop 
      end

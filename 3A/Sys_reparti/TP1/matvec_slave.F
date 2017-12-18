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
*
************************************************************************
      program slave
      implicit none
************************************************************************
C------------------------------------------
C Version statique
C du produit matrice-vecteur.
C-------------------------------------------
      integer NITER
      PARAMETER (NITER=2000)
* ----------
* input data
* ----------
      integer lda
      parameter(lda=5000)
      double precision a(lda,lda),x(lda),y(lda)
      integer incx, no_slave
      integer n,m,i
      double precision one, zero
*
* --------------------
* PVM local variables
* --------------------
* bufidS buffer for sending data
* bufidR buffer for receiving data
*
* type = 0 to reveive data broadcasted by the master
*      = 1 to reveive local data from the master 
*      = 2 to send results to the master
      integer my_id, info, type
      integer p_id, bufidS, bufidR
      include 'fpvm3.h'
      DATA one /1.0D0/, zero /0.0D0/
*
* ---------------------------------------
* Enroll this program in PVM_3
* and Get the tid of the master's task id
* ---------------------------------------
      call pvmfmytid(my_id)
      call pvmfparent(p_id)
      if (p_id.le.0) stop
      write(6,*) ' slave: ',my_id, ' enrolled '
      write(6,*) ' parent tid : ', p_id
*
* ---------------------------------------
* Receive number of columns and vector x
* ---------------------------------------
      write(6,*) ' slave: ',my_id,' starts receiving'
      type = 0
      call pvmfrecv(p_id, type, bufidR)
      call pvmfunpack(INTEGER4, n, 1, 1, info)
      if (n.gt.lda) goto 500
      call pvmfunpack(REAL8   , x, n, 1, info)
      write(6,*) ' slave: ',my_id, ' n= ',n
* 
* -------------------------------------------------------
* receive size of the block of row followed by sub-matrix
* -------------------------------------------------------
      type = 1
      call pvmfrecv(p_id, type, bufidR)
      call pvmfunpack(INTEGER4, m, 1, 1, info)
      call pvmfunpack(INTEGER4, no_slave, 1, 1, info)
      write(6,*) ' slave: ',my_id, ' m= ',m
      if (m.gt.lda) goto 500
      call pvmfrecv(p_id, type, bufidR)
      do 10, i=1,n
        call pvmfunpack(REAL8, a(1,i), m, 1, info)
 10   continue
      write(6,*) ' slave: ',my_id, ' end of data reception'
*
* ------------------------
* Compute his part of work
* ------------------------
      write(6,*) ' slave: ', my_id,' starts computation '
      incx = 1
      DO I=1,NITER
      call dgemv('N',m,n,one,a,lda,x,incx,zero,y,incx)
      ENDDO
*
* -----------------------------
* Send back results
* and leave Pvm before exiting
* -----------------------------
      write(6,*) ' slave: ', my_id,' sends results '
      call pvmfinitsend( PVMDATADEFAULT, bufidS)
      call pvmfpack(INTEGER4, no_slave, 1, 1, info)
      call pvmfpack(REAL8, y, m, 1, info)
      type = 2
      call pvmfsend(p_id, type, info)
* 
      write(6,*) ' slave: ', my_id, ' leaves PVM '
 500  call pvmfexit(info)
*
      stop 
      end

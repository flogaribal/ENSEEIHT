C*******************************************************
        subroutine secdeb(t)
C****************************************************
        real*8 t,t1
        real*8 ELAPSE8
        EXTERNAL ELAPSE8
*
        t=ELAPSE8(t1)
        return
        end
C*******************************************************
        subroutine secfin(t)
C****************************************************
        real*8 t
        real*8 ELAPSE8
        EXTERNAL ELAPSE8
*
        t=ELAPSE8(0.0)-t
        return
        end
*
C*******************************************************
       real*8 function Max(n,x)
C*******************************************************
*
       integer n
       real*8 x(n)
*
       integer i
       Max = x(1)
       do 10, i=2,n
         if ( x(i).gt.Max ) then
           Max = x(i)
         endif
 10    continue
       return
       end
* 
C*******************************************************
       real*8 function Min(n,x)
C*******************************************************
*
       integer n
       real*8 x(n)
*
       integer i
       Min = x(1)
       do 10, i=2,n
         if ( x(i).lt.Min ) then
           Min = x(i)
         endif
 10    continue
       return
       end

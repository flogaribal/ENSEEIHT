program test_solve
  implicit none

  integer :: i, j, ierr, n
  double precision, allocatable :: L(:,:), x(:), b(:)
  double precision :: relative_error, debut, fin 

  write(*,*) 'n?'
  read(*,*) n

  ! Initialization: L is spd
  write(*,*) 'Initialization...'
  write(*,*)
  
  allocate(L(n,n), stat=ierr)
  if(ierr.ne.0) then
    write(*,*)'Could not allocate L(n,n) with n=',n
    stop
  end if

  allocate(x(n), stat=ierr)
  if(ierr.ne.0) then
    write(*,*)'Could not allocate x(n) with n=',n
    stop
  end if

  allocate(b(n), stat=ierr)
  if(ierr.ne.0) then
    write(*,*)'Could not allocate b(n) with n=',n
    stop
  end if

  L = 0.D0
  do i=1,n  
    L(i,i) = n+1D0
    do j=1,i-1
      L(i,j) = 1
    end do
  end do
  b = 1D0





  ! Left-looking triangular solve of Lx=b
  write(*,*) 'Solving with a left-looking method...'
 
  call cpu_time(debut )
        
  call left_looking_solve(L, b, n, x)

  call cpu_time(fin) 

  write(*,*) 'Temps passé :', fin-debut

  write(*,*)

  !write(*,*),x
  !do i = 0,n
  !      write(*,*) x(i)
  !end do
  !write(*,*)

  write(*,*) 'Relative error : ', relative_error(L,x,b,n)




  ! Right-looking triangular solve of Lx=b
  write(*,*) 'Solving with a right-looking method...'

  call cpu_time(debut )

  call right_looking_solve(L, b, n, x)

  call cpu_time(fin) 
  
  write(*,*) 'Temps passé :', fin-debut

  write(*,*)

  !write(*,*),x
  !do i = 0,n
  !      write(*,*) x(i)
  !end do
  !write(*,*)

  write(*,*) 'Relative error : ', relative_error(L,x,b,n)

  deallocate(L,x,b)

end program test_solve



!===========================================================
!
! Préconditions : L est initialisée et aucun terme de sa diagonale n’est nul.
!                 n >0
!===========================================================
    subroutine left_looking_solve(L, b, n, x)
        implicit none

        integer, intent(in) :: n
        double precision, intent(in), dimension(n,n) :: L
        double precision, intent(in), dimension(n) :: b
        double precision, intent(out), dimension(n) :: x 
        
        integer :: i,j

        x = b

        b1 : do j = 1,n
            b2 : do i = 1, j-1
                x(j) = x(j) - L(j,i)*x(i)
            end do b2

            x(j) = x(j)/L(j,j)

        end do b1



    end subroutine left_looking_solve



!===========================================================
! 
! Préconditions : L est initialisée et aucun terme de sa diagonale n’est nul.
!                 n >0
!===========================================================
    subroutine right_looking_solve(L, b, n, x)
        implicit none
        
        integer, intent(in) :: n
        double precision, intent(in), dimension(n,n) :: L
        double precision, intent(in), dimension(n) :: b
        double precision, intent(out), dimension(n) :: x 

        integer :: i,j

        x = b

        b1 : do j = 1,n 
            x(j) = x(j)/L(j,j)
            b2 : do i = j+1, n
                x(i) = x(i) - L(i,j)*x(j)
            end do b2
        end do b1
            

    end subroutine right_looking_solve



!===========================================================
! 
! Préconditions : n >0
!===========================================================

    double precision function relative_error(L,x,b,n)
        implicit none
        
        integer, intent(in) :: n
        double precision, intent(in), dimension(n,n) :: L
        double precision, intent(in), dimension(n) :: b
        double precision, intent(out), dimension(n) :: x
        double precision, dimension(n) :: res

        res = matmul(L,x)-b

        relative_error  = SQRT(dot_product(res,res))/SQRT(dot_product(b,b))

    end function relative_error


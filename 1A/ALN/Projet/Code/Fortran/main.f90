! This file is provided as part of the "projet long" for the Algebre Lineaire Numerique course
! at ENSEEIHT
! Date: 19/04/2016
! Authors: P. Amestoy, P. Berger, A. Buttari, Y. Diouane, S. Gratton, F.H. Rouet, E. Simon
!
! This file contains the driver for testing the developed methods
! 
program main
  ! use m_subspace_iter
  implicit none
  integer                       :: ierr, m, n, l, p, maxit, lwork, i, j, it, n_sv, disp, version, imat
  real(kind(1.d0)), allocatable :: z(:,:), v(:,:), u(:,:), work(:), a(:,:), s_vals(:)
  real(kind(1.d0)), allocatable :: s(:), res_sv(:)
  integer, allocatable          :: it_sv(:)
  integer                       :: t_start, t_end, t_rate, len
  real(kind(1.d0))              :: time, eps, res=0d0, percentage, percentage_ev, dummy
  real(kind(1.d0)), parameter   :: done=1.d0, dzero=0.d0
  logical                       :: reverse
  
  interface
     subroutine matgen(imat, a, m, n, d, info)
       real(kind(1.d0)), allocatable :: a(:,:)
       integer :: imat, m, n, info
       real(kind(1.d0)), allocatable :: d(:)
     end subroutine matgen
  end interface


  !! parameter initializations 
  ierr=0

  maxit=1000
  eps=1d-13

  call parse_args(m, n, l, p, version, imat, percentage, disp)
  
  ! Generate the matrix
  call matgen(imat, z, m, n, s_vals, ierr)

  ! call random_number(a)
  
  if(disp.eq.1) then
     write(*,'("Here are the first ",i2," singular values: ")', advance='no')min(n,10)
     do i=1, min(n,10)
        write(*,'(f10.3,x)',advance='no')s_vals(i)
     end do
     write(*,'(" ")')
  end if

  write(*,'(" ")')
  write(*,'(" ")')
  select case(version)
  case(0)
     write(*,'("Calling LAPACK DGESVD on Z")')
     ! LAPACK, for testing
     lwork=2*max(1,3*min(m,n)+max(m,n),5*min(m,n))
     allocate(s(n), work(lwork), u(m,n), res_sv(n), it_sv(n), stat=ierr)
     if(ierr .ne.0) then
        write(*,'("Cannot allocate data, Input matrix is too big for the LAPACK version")')
        stop
     endif
     call system_clock(t_start)
     call dgesvd('S', 'N', m, n, z, m, s, u, m, dummy, m, work, lwork, ierr)
     call system_clock(t_end, t_rate)
     time = real(t_end-t_start)/real(t_rate)
     n_sv   = n
     it_sv  = 1
     res_sv = 0.d0
     reverse = .true.

  case(1)
     write(*,'("Calling the code for symmetric matrices on Z^T*Z")')
     allocate(a(m,m), s(l), res_sv(l), it_sv(l), u(m,l), stat=ierr)
     if(ierr .ne.0) then
        write(*,'("Cannot allocate data, Input matrix is too big for the symmetric version")')
        stop
     endif

     call system_clock(t_start)

     ! Build B=A*A'
     call dgemm('n', 't', m, m, n, done, z, m, z, m, dzero, a, m )
     call subspace_iter_ev(a, u, s, m, l, p, percentage, maxit, eps, res_sv, it_sv, it, n_sv, ierr)
     call system_clock(t_end, t_rate)
     time = real(t_end-t_start)/real(t_rate)
     deallocate(a, stat=ierr)
     if(ierr.eq.0) then
        do i=1, n_sv
           s(i) = sqrt(s(i))
        end do
     end if
     reverse = .false.
     
  case(2)
     write(*,'("Calling the left-sided code for unsymmetric matrices on Z")')
     allocate(s(l), res_sv(l), it_sv(l), u(m,l), stat=ierr)
     if(ierr .ne.0) then
        write(*,'("Cannot allocate data.")')
        stop
     endif

     call system_clock(t_start)
     call subspace_iter_sv_left(z, u, s, m, n, l, p, percentage, maxit, eps, res_sv, it_sv, it, n_sv, ierr)
     call system_clock(t_end, t_rate)
     time = real(t_end-t_start)/real(t_rate)
     reverse=.false.

  case(3)
     write(*,'("Calling the left-sided code for unsymmetric matrices on Z^T")')
     allocate(a(n,m), s(l), res_sv(l), it_sv(l), u(n,l), stat=ierr)
     if(ierr .ne.0) then
        write(*,'("Cannot allocate data.")')
        stop
     endif

     a = transpose(z)
     
     call system_clock(t_start)
     call subspace_iter_sv_left(a, u, s, n, m, l, p, percentage, maxit, eps, res_sv, it_sv, it, n_sv, ierr)
     call system_clock(t_end, t_rate)
     time = real(t_end-t_start)/real(t_rate)
     reverse=.false.

  case(4)
     write(*,'("Calling the both-sided code for unsymmetric matrices on Z")')
     allocate(s(l), res_sv(l), it_sv(l), u(m,l), v(n,l), stat=ierr)
     if(ierr .ne.0) then
        write(*,'("Cannot allocate data.")')
        stop
     endif

     call system_clock(t_start)
     call subspace_iter_sv_both(z, u, v, s, m, n, l, p, percentage, maxit, eps, res_sv, it_sv, it, n_sv, ierr)
     call system_clock(t_end, t_rate)
     time = real(t_end-t_start)/real(t_rate)
     reverse=.false.

  case(5)
     write(*,'("Calling the both-sided code with alternate iterations for unsymmetric matrices on Z")')
     allocate(s(l), res_sv(l), it_sv(l), u(m,l), v(n,l), stat=ierr)
     if(ierr .ne.0) then
        write(*,'("Cannot allocate data.")')
        stop
     endif

     call system_clock(t_start)
     call subspace_iter_sv_both(z, u, v, s, m, n, l, p, percentage, maxit, eps, res_sv, it_sv, it, n_sv, ierr)
     call system_clock(t_end, t_rate)
     time = real(t_end-t_start)/real(t_rate)
     reverse=.false.

  case default
     write(*,'("Version is not valid")')
     
  end select
  
  write(*,'(" ")')
  write(*,'(" ")')
  if(ierr.eq.0) then
     write(*,'("Done in ",f5.2,"  seconds")')time
     if(disp.eq.1) then
        if(reverse) then
           do i=n_sv,max(1,n_sv-9),-1
              write(*,'("Singular value ",i4,":",f10.3,"  with a residual:",es8.1," which converged at it:",i4,".    %",f4.0)')&
                   & i,s(i),res_sv(i),it_sv(i),100.d0*s(n_sv)/s(i)
           end do
        else
           do i=1, min(n_sv,10)
              write(*,'("Singular value ",i4,":",f10.3,"  with a residual:",es8.1," which converged at it:",i4,".    %",f4.0)')&
                   & i,s(i),res_sv(i),it_sv(i),100.d0*s(i)/s(1)
           end do
        end if
        write(*,'(" ")')
     end if
  else
     write(*,'("An error was found. IERR=",i4)')ierr
  end if
     
  deallocate(s, u, res_sv, it_sv, stat=ierr)
  if(allocated(work)) deallocate(work, stat=ierr)

  stop

contains

  subroutine parse_args(m, n, l, p, version, imat, percentage, disp)

    integer          :: m, n, l, p, version, imat, disp
    real(kind(1.d0)) :: percentage

    character(len=20)  :: str
    integer :: i, cln

    ! default values
    p          = 1
    version    = 0
    imat       = 1
    m          = -1
    n          = -1
    l          = -1
    disp       = 0
    percentage = 0.7


    cln = command_argument_count()

    if (cln/2 .lt. 3) then
       call print_use()
       stop
    else
       do i=1, cln, 2
          call get_command_argument(i,value=str,length=len)

          select case(str(1:len))
          case('-m')
             call get_command_argument(i+1,value=str,length=len)
             read(str(1:len),*)m
          case('-n')
             call get_command_argument(i+1,value=str,length=len)
             read(str(1:len),*)n
          case('-l')
             call get_command_argument(i+1,value=str,length=len)
             read(str(1:len),*)l
          case('-p')
             call get_command_argument(i+1,value=str,length=len)
             read(str(1:len),*)p
          case('-imat')
             call get_command_argument(i+1,value=str,length=len)
             read(str(1:len),*)imat
          case('-v')
             call get_command_argument(i+1,value=str,length=len)
             read(str(1:len),*)version
          case('-per')
             call get_command_argument(i+1,value=str,length=len)
             read(str(1:len),*)percentage
          case('-disp')
             call get_command_argument(i+1,value=str,length=len)
             read(str(1:len),*)disp
          case default
             write(*,'("Wrong argument!")')
             write(*,'(" ")')
             call print_use()
             stop
          end select
       end do
    end if

    if(min(m,min(n,l)) .le. 0) then
       write(*,'("m, n and l are mandatory arguments and should be positive!")')
       write(*,'(" ")')
       call print_use()
       return
    end if
    
    if(m .lt. n) then
       write(*,'("m, should be greater than n!")')
       write(*,'(" ")')
       call print_use()
       return
    end if

    return
  end subroutine parse_args

    
  subroutine print_use()
    write(*,'("================================================='//&
         & '=================================================================================")')
    write(*,'("This program should be invoked like this:        '//&
         &'                                                                                 ")')
    write(*,'("                                                 '//&
         &'                                                                                 ")')
    write(*,'("./main args                                      '//&
         &'                                                                                 ")')
    write(*,'("                                                 '//&
         &'                                                                                 ")')
    write(*,'("where args can be                                '//&
         &'                                                                                 ")')
    write(*,'("-m m     : the number of lines in the Z matrix   '//&
         &'                                                                                 ")')
    write(*,'("-n n     : the number of columns in the Z matrix '//&
         &'                                                                                 ")')
    write(*,'("-l l     : the size of the iteration subspace    '//&
         &'                                                                                 ")')
    write(*,'("-p p     : the block-product size (default=1)    '//&
         &'                                                                                 ")')
    write(*,'("-imat i  : the matrix type (default=1)           '//&
         &'                                                                                 ")')
    write(*,'("           i = 1 : Singular values are uniformly '//&
         &'distributed between 1 and n                                                      ")')
    write(*,'("           i = 2 : Singular values are D(I)=COND*'//&
         &'*(-(I-1)/(N-1)) with cond=1e4                                                    ")')
    write(*,'("           i = 3 : Singular values are D(I)=COND*'//&
         &'*(-(I-1)/(N-1)) with cond=1e5                                                    ")')
    write(*,'("           i = 4 : Singular values are D(i)=1 - ('//&
         &'i-1)/(N-1)*(1 - 1/COND) with cond=1e6                                            ")')
    write(*,'("-v v     : which solver version to use (default=0'//&
         &', i.e., LAPACK DGESVD)                                                           ")')
    write(*,'("           v = 0 : the LAPACK DGESVD reoutine is '//&
         &'called on Z                                                                      ")')
    write(*,'("           v = 1 : the code for symmetric matrice'//&
         &'s is called on A=Z*Z^T which is explicitly computed                              ")')
    write(*,'("           v = 2 : the left-sided code for non-sy'//&
         &'mmetric matrices is called on Z. It iterates implicitly on Z*Z^T                 ")')
    write(*,'("           v = 3 : the left-sided code for non-sy'//&
         &'mmetric matrices is called on A=Z^T. It iterates implicitly on Z^T*Z             ")')
    write(*,'("           v = 4 : the code for non-symmetric mat'//&
         &'rices is called on Z and computes both the left and r'//&
         &'ight singular vectors.")')
    write(*,'("           v = 5 : the code for non-symmetric mat'//&
         &'rices is called on Z and computes both the left and r'//&
         &'ight singular vectors through alternate iterations.")')
    write(*,'("-per x.y : the amount of information to retain (d'//&
         &'efault=0.7, i.e., 70% of the trace)                                              ")')
    write(*,'("-disp d  : whether to print the eigenvalues (d=1)'//&
         &' or not (d=0, default)                                                           ")')
    write(*,'("                                                 '//&
         &'                                                                                 ")')
    write(*,'("Note that -m, -n and -l are mandatory            '//&
         &'                                                                                 ")')
    write(*,'("                                                 '//&
         &'                                                                                 ")')
    write(*,'("Example:                                         '//&
         &'                                                                                 ")')
    write(*,'(" ./main -m 100 -n 50 -l 20 -per 0.1 -imat 2 -p 2 '//&
         &'-v 1                                                                             ")')
    write(*,'("================================================='//&
         &'=================================================================================")')
  end subroutine print_use
  

  
end program main

       subroutine read_file(name)
        character*32 name
*
        character*32 machine
        integer i
 5      read(10,1000,END=100) machine
1000    format(a32)
        do 10, i=1,32
           name(i:i)=' '
10      continue
        i=1
20      continue
          if (machine(i:i).ne.' ') then
            name(i:i) = machine(i:i)
            i = i+1
            goto 20
          endif
cok f77        name(i:i)='\0'
        GOTO 500
******* error end of file ***************
*       we restart from beginning of file
100     rewind(10)
        GOTO 5
***********************************
 500    return
        end 

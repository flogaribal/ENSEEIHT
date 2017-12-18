#############################################################
######    Begin of Makefile
#############################################################

SCADE=C:\Program Files (x86)\Esterel Technologies\Esterel SCADE 6.2.1\SCADE Suite\.

SHELL=cmd.exe

C_FLAGS = -O2 -pedantic

all: falling_edge.dll falling_edge.exe 

win32/falling_edge.o: falling_edge.c
	gcc -I"." -I"$(SCADE)" -I"C:\Program Files (x86)\Esterel Technologies\Esterel SCADE 6.2.1\SCADE Suite\include" -I"C:\Program Files (x86)\Esterel Technologies\Esterel SCADE 6.2.1\SCADE Suite\libraries\libmathext" $(C_FLAGS) -DBUILD_DLL -DSIM -DWIN32 -D_CONSOLE -D_MBCS -c "falling_edge.c" -o "win32\falling_edge.o"	
	ar -r falling_edge.a "win32\falling_edge.o"

win32/kcg_types.o: kcg_types.c
	gcc -I"." -I"$(SCADE)" -I"C:\Program Files (x86)\Esterel Technologies\Esterel SCADE 6.2.1\SCADE Suite\include" -I"C:\Program Files (x86)\Esterel Technologies\Esterel SCADE 6.2.1\SCADE Suite\libraries\libmathext" $(C_FLAGS) -DBUILD_DLL -DSIM -DWIN32 -D_CONSOLE -D_MBCS -c "kcg_types.c" -o "win32\kcg_types.o"	
	ar -r falling_edge.a "win32\kcg_types.o"

win32/kcg_consts.o: kcg_consts.c
	gcc -I"." -I"$(SCADE)" -I"C:\Program Files (x86)\Esterel Technologies\Esterel SCADE 6.2.1\SCADE Suite\include" -I"C:\Program Files (x86)\Esterel Technologies\Esterel SCADE 6.2.1\SCADE Suite\libraries\libmathext" $(C_FLAGS) -DBUILD_DLL -DSIM -DWIN32 -D_CONSOLE -D_MBCS -c "kcg_consts.c" -o "win32\kcg_consts.o"	
	ar -r falling_edge.a "win32\kcg_consts.o"

win32/falling_edge_type.o: falling_edge_type.c
	gcc -I"." -I"$(SCADE)" -I"C:\Program Files (x86)\Esterel Technologies\Esterel SCADE 6.2.1\SCADE Suite\include" -I"C:\Program Files (x86)\Esterel Technologies\Esterel SCADE 6.2.1\SCADE Suite\libraries\libmathext" $(C_FLAGS) -DBUILD_DLL -DSIM -DWIN32 -D_CONSOLE -D_MBCS -c "falling_edge_type.c" -o "win32\falling_edge_type.o"

win32/falling_edge_mapping.o: falling_edge_mapping.c
	gcc -I"." -I"$(SCADE)" -I"C:\Program Files (x86)\Esterel Technologies\Esterel SCADE 6.2.1\SCADE Suite\include" -I"C:\Program Files (x86)\Esterel Technologies\Esterel SCADE 6.2.1\SCADE Suite\libraries\libmathext" $(C_FLAGS) -DBUILD_DLL -DSIM -DWIN32 -D_CONSOLE -D_MBCS -c "falling_edge_mapping.c" -o "win32\falling_edge_mapping.o"

win32/falling_edge_interface.o: falling_edge_interface.c
	gcc -I"." -I"$(SCADE)" -I"C:\Program Files (x86)\Esterel Technologies\Esterel SCADE 6.2.1\SCADE Suite\include" -I"C:\Program Files (x86)\Esterel Technologies\Esterel SCADE 6.2.1\SCADE Suite\libraries\libmathext" $(C_FLAGS) -DBUILD_DLL -DSIM -DWIN32 -D_CONSOLE -D_MBCS -c "falling_edge_interface.c" -o "win32\falling_edge_interface.o"

win32/SmuProxy.o: C:/Program\ Files\ (x86)/Esterel\ Technologies/Esterel\ SCADE\ 6.2.1/SCADE\ Suite/lib/SmuProxy.c
	gcc -I"." -I"$(SCADE)" -I"C:\Program Files (x86)\Esterel Technologies\Esterel SCADE 6.2.1\SCADE Suite\include" -I"C:\Program Files (x86)\Esterel Technologies\Esterel SCADE 6.2.1\SCADE Suite\libraries\libmathext" $(C_FLAGS) -DBUILD_DLL -DSIM -DWIN32 -D_CONSOLE -D_MBCS -c "C:\Program Files (x86)\Esterel Technologies\Esterel SCADE 6.2.1\SCADE Suite\lib\SmuProxy.c" -o "win32\SmuProxy.o"

falling_edge.dll: win32/falling_edge.o win32/kcg_types.o win32/kcg_consts.o win32/falling_edge_type.o win32/falling_edge_mapping.o win32/falling_edge_interface.o win32/SmuProxy.o SmuExport.def 
	dllwrap --driver-name=gcc  "win32\falling_edge_type.o" "win32\falling_edge_mapping.o" "win32\falling_edge_interface.o" "win32\SmuProxy.o" "falling_edge.a" --def "SmuExport.def" -lm -lwsock32 --dllname "falling_edge.dll" 

SmuExport.def: C:/Program\ Files\ (x86)/Esterel\ Technologies/Esterel\ SCADE\ 6.2.1/SCADE\ Suite/lib/SmuExport.def
	copy "C:\Program Files (x86)\Esterel Technologies\Esterel SCADE 6.2.1\SCADE Suite\lib\SmuExport.def" "SmuExport.def"

win32/falling_edge_dll.o: falling_edge_dll.c
	gcc -I"." -I"$(SCADE)" -I"C:\Program Files (x86)\Esterel Technologies\Esterel SCADE 6.2.1\SCADE Suite\include" -I"C:\Program Files (x86)\Esterel Technologies\Esterel SCADE 6.2.1\SCADE Suite\libraries\libmathext" $(C_FLAGS) -DBUILD_DLL -DSIM -DWIN32 -D_CONSOLE -D_MBCS -c "falling_edge_dll.c" -o "win32\falling_edge_dll.o"

win32/SmuMainWindows.o: C:/Program\ Files\ (x86)/Esterel\ Technologies/Esterel\ SCADE\ 6.2.1/SCADE\ Suite/lib/SmuMainWindows.c
	gcc -I"." -I"$(SCADE)" -I"C:\Program Files (x86)\Esterel Technologies\Esterel SCADE 6.2.1\SCADE Suite\include" -I"C:\Program Files (x86)\Esterel Technologies\Esterel SCADE 6.2.1\SCADE Suite\libraries\libmathext" $(C_FLAGS) -DBUILD_DLL -DSIM -DWIN32 -D_CONSOLE -D_MBCS -c "C:\Program Files (x86)\Esterel Technologies\Esterel SCADE 6.2.1\SCADE Suite\lib\SmuMainWindows.c" -o "win32\SmuMainWindows.o"

falling_edge.exe: win32/falling_edge_dll.o win32/SmuMainWindows.o 
	gcc "win32\falling_edge_dll.o" "win32\SmuMainWindows.o" -lm -lwsock32 -o "falling_edge.exe" 

#############################################################
######    End of Makefile
#############################################################

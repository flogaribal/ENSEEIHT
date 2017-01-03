#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

int vglob = 0;

int main() {
    int vloc = 0;
    int pid = fork();

    printf("Valeur de fork = %d ",pid);

    printf("Processus %d de père %d\n",(int) getpid(), (int)getppid());

    if (pid == 0) {
        vglob += 100;
        vloc += 100;
        printf("Var globale : %d         Var Locale : %d \n",vglob,vloc);
        printf("Fin du processus fils\n");
    }else{
        vglob += 10;
        vloc += 10;
        printf("Var globale : %d         Var Locale : %d \n",vglob,vloc);
        printf("Fin du processus père\n");
    } 

    return 0;
}

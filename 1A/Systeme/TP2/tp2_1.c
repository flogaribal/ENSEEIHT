#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>

int main(){

    int pid, status;

    pid = fork();

    if (pid == 0){
        printf("Processus fils %d de père %d\n\n",getpid(),getppid());
        sleep(50);
        exit(3);
    }else{
        printf("Processus père %d de père %d\n\n",getpid(),getppid());

        wait(&status);
        if (WIFEXITED(status)){
            printf("Code de retour du processus : %d\n",WEXITSTATUS(status));
        }
        if (WIFSIGNALED(status)){
           printf("Code du signal reçu par le processus : %d\n",WTERMSIG(status));
        }
    }
    


    return 0;
}

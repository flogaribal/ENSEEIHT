#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <signal.h>
#include <string.h>
#include <setjmp.h>
#include <wait.h>

int pid, tue;

void alarm_handler(int numSig){
    printf("JE VAIS TUER %d\n", pid);
    kill(pid,9);
    printf("Temps dépassé\n");
    tue = 1;
}


int main(int argc, char* argv[]){

    if(argc < 3){
        perror("Usage : timeout duree commande <arg1> <arg2> ...\n");
        exit(1);
    }

    pid = fork();

    if(pid == -1){
        perror("Fork error\n");
        exit(2);

    }else if(pid == 0) {
        sleep(2);
        execvp(argv[2], &argv[2]);
        
    }else{
        int i, status, ret;

        for(i = 1; i < NSIG; i++){
            signal(i,SIG_IGN);
        }

        signal(SIGALRM, alarm_handler);

        alarm(atoi(argv[1]));

        ret = wait(&status);

        if(ret == -1){
            perror("Error wait");
            exit(2);
        }

        if(tue == 1){
            printf("Processus %d tue par le signal %d\n", pid, WTERMSIG(status));

        }else if(WIFEXITED(status)){
            printf("Valeur retournée par le fils (%d) : %d\n", pid, WEXITSTATUS(status));

        } 
    }

    return 0;
}

#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <signal.h>
#include <string.h>
#include <setjmp.h>

jmp_buf env;

void signal2_handler(int numSig){
   printf("Gagné !\n");
   alarm(0);
}

void alarm_handler(int numSig){
    signal(SIGINT,SIG_IGN);
    siglongjmp(env,1);
}


int main(){

    int ret = -1;
    int i = 1;

    printf("Prêt à tester ta rapidité ?\n");
    sleep(2);

    signal(SIGALRM, alarm_handler);

    while(i < 11) {
        signal(SIGINT, signal2_handler);

        ret = sigsetjmp(env, 1);

        if(ret == 0){
            printf("Tape CTR+C\n");
            alarm(1);
            pause(); 

        }else{
            printf("Trop tard...\n");
        }
        sleep(i%3+1);
        i++;
    }

    printf("Fin du programme\n");
    return 0;
}

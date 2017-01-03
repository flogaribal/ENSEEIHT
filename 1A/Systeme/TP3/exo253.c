#include <signal.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>


    int nbSigRec;
    int nbAlarmRec;


void general_handler(int sigNumber) {
    printf("Signal reçu : %d\n", sigNumber);
    nbSigRec++;
}

void alarm_handler(int sigNumber) {
    printf("Je suis toujours actif et j'attend des signaux\n");
    nbAlarmRec++;
    alarm(3);
}

int main(){
    int i = 0 ;
    nbSigRec = 0;
    nbAlarmRec = 0;

    /* Association de tous les signaux avec le general_handler */
    for(i = 1; i < NSIG; i++){
        signal(i, general_handler);
    }

    signal(14,alarm_handler);

    alarm(3);
    
    /* Condition de terminaison */
    while (nbAlarmRec < 9 && nbSigRec <5){
        pause();
    }

    return 0;
}



#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

#include <sys/types.h>
#include <sys/wait.h>
#include <signal.h>
#include <string.h>


void signal2_handler(int numSig){
    

    /* PARTIE AVEC MASQUAGE */
    int ret;
    sigset_t sigSet;    

    sigfillset(&sigSet);

    ret = sigprocmask(SIG_SETMASK, &sigSet, NULL);

    if (ret == -1){
        perror("Erreur de masquage \n");
    }
    /* FIN PARTIE MASQUAGE */

    
    /* PARTIE SANS MASQUAGE *//*
    int i;

    for(i = 1; i < NSIG; i++){
        signal(i, SIG_IGN);
    }
    *//* FIN PARTIE SANS MASQUAGE */


    while(1){
        printf("Je suis immortel %d\n", getpid());
        sleep(5);
    };
}


int main(){

    signal(SIGINT, signal2_handler);
    while(1){
        printf("Je suis un processus : %d\n", getpid());
        sleep(5);
    };       
}

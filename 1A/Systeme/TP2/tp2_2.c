#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>


/**
 * Fonction permettant de tester et d'afficher la manière dont s'est terminé le processus 
 *      - Si le processus s'est terminé \"normalement\" (avec un exit) on affiche le code de retour
 *      - Si le processus a reçu un signal de terminaison on affiche le numéro de ce signal
 */
void testFin(int i,int s){

        /* Si le processus s'est terminé normalement */
        if (WIFEXITED(s)){
            /*  On affiche le code de retour du processus */
            printf("Code de retour du processus %d : %d\n",i,WEXITSTATUS(s));
        }

        /* Si le processus a reçu un signal de terminaison */
        if (WIFSIGNALED(s)){
            /* On affiche le numéro du signal reçu */
            printf("Code du signal reçu par le processus %d : %d\n",i,WTERMSIG(s));
        }
}


int main(){

    int pid = 1;
    int status;
    int i = 0;

    printf("Je suis le père : %d \n", (int) getpid());
    /* On crée 7 fils  */
    while (i<7 && pid != 0){
        i++;
        pid = fork(); 
    }
    if (pid == 0){ /* Si l'on est dans le processus fils */
        
        printf("Processus fils n°%d : %d de père %d\n",i,getpid(),getppid());
        sleep(i*2);
        exit(i);

    }else{ /*  Si l'on est dans le processus père */
        i = 7;
        while (i>0){
            /* On attend la fin du processus fils courant */
            wait(&status);

            /* On teste et on affiche de quelle manière s'est terminé le premier processus */
            testFin(i,status);    
        i--;
        }
    }
         

    return 0;
}

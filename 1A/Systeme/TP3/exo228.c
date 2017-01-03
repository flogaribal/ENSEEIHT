
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>

int main (int argc, char *argv[]){

    int pid; 
    int status;

    if (argc != 2) {
        perror("Erreur usage : ./exo228 nomDesFichiersARechercher\n");
        exit(1);
    }


    pid = fork();

    if (pid == -1) {            /* ERREUR */
        perror("Erreur sur le fork()");
        exit(2);

    }else if(pid == 0){      /* FILS */
        
        execlp("find","find",argv[1],NULL);

        perror("Erreur execution de la commande find");
        exit(3);

    } else {                    /* PERE */
        sleep(5);

        wait(&status);
        
        /* Si le processus s'est terminé normalement */
        if (WIFEXITED(status)){
            /*  On affiche le code de retour du processus */
            printf("Code de retour du processus : %d\n",WEXITSTATUS(status));
        }

        /* Si le processus a reçu un signal de terminaison */
        if (WIFSIGNALED(status)){
            /* On affiche le numéro du signal reçu */
            printf("Code du signal reçu par le processus : %d\n",WTERMSIG(status));
        }
    }

    return 0;
}

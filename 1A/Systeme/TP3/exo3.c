#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>

int main (int argc, char *argv[]){

    int pid; 
    int status;

    if (argc < 2) {
        perror("Erreur usage : ./exo3 cmd [args1] [args2] ... \n");
        exit(1);
    }


    pid = fork();

    if (pid == -1) {            /* ERREUR */
        perror("Erreur sur le fork()");
        exit(2);

    }else if(pid == 0){      /* FILS */
       
        sleep(20);
        
        execvp(argv[1],&argv[1]);

        perror("Erreur execution de la commande");
        exit(3);

    } else {                    /* PERE */
        sleep(5);

        waitpid(pid, &status, WUNTRACED | WCONTINUED);
        
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

        /* Si le processus a reçu un signal de suspension */
        if (WIFSTOPPED(status)){
            /* On affiche le numéro du signal reçu */
            printf("Processus suspendu avec le code : %d\n",WSTOPSIG(status));

            waitpid(pid, &status, WUNTRACED | WCONTINUED);
            /* Si le processus a reçu un signal de relance */
            if (WIFCONTINUED(status)){
                /*On affiche le numéro du signal reçu */
                printf("Processus relancé\n");
            } 

        }
    }

    return 0;
}

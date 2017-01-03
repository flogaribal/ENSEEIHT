#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>


void chld_handler(int sigNumber){
        
    int pid, status;
    printf("HANDLER\n");

    pid = waitpid(WAIT_ANY, &status, WNOHANG | WUNTRACED | WCONTINUED);

    if (pid < 0){
        perror("Erreur CHLD\n");
        exit(35);
    }
    if (pid == 0){
        
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
                
}


int main (int argc, char *argv[]){

    int pid; 

    if (argc < 2) {
        perror("Erreur usage : ./exo4 cmd [args1] [args2] ... \n");
        exit(1);
    }


    pid = fork();

    if (pid == -1) {            /* ERREUR */
        perror("Erreur sur le fork()\n");
        exit(2);

    }else if(pid == 0){      /* FILS */
       
        sleep(20);

        execvp(argv[1],&argv[1]);

        perror("Erreur execution de la commande\n");
        exit(3);

    } else {                    /* PERE */

        int pid2 = -1; 

        /* Création de l'autre fils */
        pid2 = fork();
       
        /* Si on est dans les fils */
        if (pid2 == 0) {
                printf("Je suis le fils %d, je dors\n",getpid());
                sleep(5);                        

        }else{ /* Père */
                signal(SIGCHLD, chld_handler);
                sleep(20);
                printf("Processus père fini! \n");
        }


          }
    return 0;
}




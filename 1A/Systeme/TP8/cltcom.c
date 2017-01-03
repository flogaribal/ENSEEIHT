#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/time.h>
#include <sys/stat.h>
#include <sys/wait.h>
#include <errno.h>
#include <sys/types.h>
#include <time.h>
#include <fcntl.h>
#include "sock_server.h"

#define TBUF 256    

int main(int argc, char ** argv){
        printf("Démarrage\n");
        int pid;
        int pp_p_f[2];
	char buf[TBUF];

        if (argc != 3){
                printf("Usage : ./cltcom machine port\n");      
                exit(1);
        }

        if (pipe(pp_p_f) == -1){
                perror("Erreur création pipes\n");
                exit(2);
        }

        if((pid = fork()) == -1){
                perror("Erreur fork\n");
                exit(3);
        
        }else if (pid == 0){    /* FILS */
            close(pp_p_f[1]);

            printf("avant Dup\n");
            dup2(pp_p_f[0],0);
            printf("après dup\n");

            execlp("./sc_client", "serveur client", argv[1], argv[2], NULL);
            
            perror("Erreur exec commande srvcom\n");
            exit(3);
        
        }else {                 /* PERE */
            int nblu;
            /* Fermeture des extrémités inutilisées */
            close(pp_p_f[0]);

            /* Boucle infinie de saisie */
            while(1){
        
                printf(">\n");
                write(0,">",1);
                /* Lecture au clavier */
                nblu = read(0, buf, TBUF);

                /* Si quelque chose saisi */
                if (nblu > 0){

                    /* Si chaine saisie égale à "exit" -> fermeture */
                    if (! strncmp(buf, "exit", 4)){
                        write(pp_p_f[1], "Fermee", 6);                        
                        exit(0);

                    /* Sinon envoi au fils pour comm avec srvcom */    
                    }else{
                        /* Ecriture dans le pipe vers le fils */
                       write(pp_p_f[1], buf, nblu);
                    }

                }
            }
        }
    return 0;

}

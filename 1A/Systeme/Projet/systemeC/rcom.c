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

#define TBUF 256   
#define MAX_ARG 16   

int main(int argc, char ** argv){

    int pid;
    int pp_p_f[2];
    char buf[TBUF];


    /* Si le nombre d'argument est incorrect */
    if (argc != 3){
            printf("Usage : ./cltcom machine port\n");      
            exit(1);
    }

    /* Si les pipes n'ont pas pu être créé */
    if (pipe(pp_p_f) == -1){
            perror("Erreur création pipes\n");
            exit(2);
    }



    /* Si la création du fils n'a pas fonctionnée */ 
    if((pid = fork()) == -1){
        perror("Erreur fork\n");
        exit(3);
    

    }else if (pid == 0){    /* FILS */

        /* Fermeture de l'écriture dans le pipe */
        close(pp_p_f[1]);

        /* L'entrée standard est remplacée par l'entrée du pipe */
        dup2(pp_p_f[0],0);

        /* Exécution de sc_client */
        execlp("./sc_client", "socket client", argv[1], argv[2], NULL);
        
        perror("Erreur de connexion au socket client\n");
        exit(3);
    
    }else {                 /* PERE */
        int nblu;
        FILE* fd_historique;

        /* Fermeture des extrémités inutilisées */
        close(pp_p_f[0]);

        /* Ouverture du fichier en écriture, création si non existant */
        fd_historique = fopen("historique.txt", "w");

        /* Boucle infinie de saisie */
        while(1){
    
            /* Lecture au clavier */
            nblu = read(0, buf, TBUF);

            /* Si quelque chose saisi */
            if (nblu > 0){

                /* Si chaine saisie égale à "exit" -> fermeture */
                if (! strncmp(buf, "exit", 4)){
                    write(pp_p_f[1], "Fermee", 6);
                    printf("PID FILS : %d\n", pid);
                    kill(pid, 9);

                    exit(0);

                /* Sinon envoi au fils pour comm avec sc_client */    
                }else{

                    /* Ecriture dans le pipe vers le fils */
                    write(pp_p_f[1], buf, nblu);

                    /* Ecriture de la commande dans l'historique */
                    fwrite(buf, 1, nblu, fd_historique);
                }
            }
        }
    }
    return 0;

}

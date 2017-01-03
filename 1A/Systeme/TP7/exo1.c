#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h> 
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

int main(int argc, char *argv[]){

        int pid, pp[2], pp2[2];
        int i, N;
        /* int j;*/
        /*int nbCharLu;*/
        char char_send[11];

        int somme = 0;

        if(argc != 2){
            printf("Erreur usage : ./exo1 N\n");
            exit(1);
        }

        if(pipe(pp) == 1){
              perror("Erreur pipe1 \n");
              exit(2);
        }

        if(pipe(pp2) == 1){
              perror("Erreur pipe2 \n");
              exit(2);
        }

        if((pid = fork()) == -1){ /* ERREUR */
            perror("Erreur fork() \n");
            exit(3);
            
        }else if (pid == 0){    /* FILS */
            close(pp[1]);
            close(pp2[0]);

            /* TRANSMISSION DE CARACTERES */ 
            /*while((nbCharLu = read(pp[0], &char_send, sizeof(char_send))) > 0){
                 
                for(j = 0; j < nbCharLu; j++){
                    if(isdigit(char_send[j])){
                        i = char_send[j] - '0';
                    }
                    printf("I = %d\n", i);
                    somme += i;
                }
            }*/


            /* TRANSMISSION D'ENTIERS */
            while(read(pp[0], &i, sizeof(int)) > 0){
                somme += i;
            }
            
            close(pp[0]);
            /* AFFICHAGE SOMME */
            printf("SOMME : %d \n", somme);

            /* ENVOI SOMME PERE */
            write(pp2[1], &somme, sizeof(int));

            close(pp2[1]);
            
        }else{                  /* PERE */
           close(pp[0]);
           close(pp2[1]);

           N = atoi(argv[1]);
           for(i = 1; i<= N; i++){
                
               sprintf(char_send, "%d", i);

                /* TRANSMISSION DE CARACTERES */
                /*write(pp[1], char_send, strlen(char_send));*/

                /* TRANSMISSION D'ENTIERS */
                write(pp[1], &i, sizeof(int));
           }
           close(pp[1]); 
        
           /* Reception SOMME */
           while(read(pp2[0], &somme, sizeof(int)) > 0){}

           printf("Je suis le père, je connais la somme : %d\n", somme);

           close(pp2[1]);
        };

        return 0;

}

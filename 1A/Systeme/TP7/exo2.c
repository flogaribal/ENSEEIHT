#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h> 
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

int main(int argc, char *argv[]){

        int pid, pp_pF_F[2], pp_f_p[2];

        if(argc != 2){
            printf("Erreur usage : ./exo2 nomRecherché\n");
            exit(1);
        }

        if(pipe(pp_f_p) == 1){
              perror("Erreur pipe Fils-Pere \n");
              exit(2);
        }

        if((pid = fork()) == -1){       /* ERREUR */
            perror("Erreur fork() \n");
            exit(3);

        }else if(pid == 0){             /* FILS */

            if(pipe(pp_pF_F) == 1){
                 perror("Erreur pipe2 \n");
                 exit(2);
            }


            if((pid = fork()) == -1){ /* ERREUR */
                perror("Erreur fork() \n");
                exit(3);

            }else if(pid == 0){        /* PETIT FILS */
                close(pp_pF_F[0]);
                close(pp_f_p[1]);
                close(pp_f_p[0]);

                dup2(pp_pF_F[1], 1);

                execlp("who", "quiEstLa", NULL);

                perror("Erreur exec who\n");
                exit(4);

            }else{                      /* FILS */
                
               close(pp_pF_F[1]);
               close(pp_f_p[0]);

               dup2(pp_pF_F[0],0);
               dup2(pp_f_p[1],1);

               execlp("grep","JeCherche",argv[1],NULL);
               perror("Erreur exec grep\n");
               exit(4);
            }

        }else{                          /* PERE */
              close(pp_f_p[1]);

              dup2(pp_f_p[0], 0);

              execlp("wc","JeComtpe","-l",NULL);
              
              perror("Erreur exec wc\n");
              exit(4);
        }
        return 0;

}

                

#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h> 
#include <string.h>
#include <stdlib.h>

int main(int argc, char *argv[]){
    int fdread, fdwrite, fdwrite2, pid, pid1, nblu;
    char bufPere [256];
    char bufFils [256];
    char buf [256];
    int nbSecondesPasseesFils = 0;
    int nbSecondesPassees = 0;

    pid = fork();

    if (pid == -1){
        perror("Erreur sur le fork\n");
        exit(1);

    }else if(pid == 0){ /* FILS QUI ECRIT */
       
       if((fdwrite2 = open("ficcom", O_WRONLY | O_CREAT, 0777)) == -1){
           perror("Erreur ouverture fichier père\n");
           exit(3);
       }
       
       while(1){
             bzero(bufFils, 256);

             sprintf(bufFils,"%d secondes passées   FILS\n", nbSecondesPasseesFils);

             write(fdwrite2, bufFils, strlen(bufFils));

             sleep(3);
             nbSecondesPasseesFils += 3;
       }


    }else{      /* PERE */

       pid1 = fork();

       if (pid1 == -1){
                perror("Erreur sur le fork\n");
                exit(1);

       }else if(pid1 == 0){ /* FILS  QUI AFFICHE LE FICHIER */

            if((fdread = open("ficcom", O_RDWR | O_CREAT, 0777)) == -1){
                perror("Erreur ouverture fichier fils\n");
                exit(2);
            }
            
            while(1){

                    while((nblu = read(fdread, buf, 256)) > 0){
                        if((write(1, buf, nblu)) == -1){
                            perror("Erreur sur le write\n");
                            return  -1;
                        }
                    }
                    sleep(3);

            }
       }

       /* ECRITURE DANS LE FICHIER */

       if((fdwrite = open("ficcom", O_WRONLY | O_CREAT, 0777)) == -1){
           perror("Erreur ouverture fichier père\n");
           exit(3);
       }
       
       while(1){
             bzero(bufPere, 256);

             sprintf(bufPere,"%d secondes passées   PERE\n", nbSecondesPassees);

             write(fdwrite, bufPere, strlen(bufPere));

             sleep(2);
             nbSecondesPassees += 2;
       }

    }


    return 0;
}


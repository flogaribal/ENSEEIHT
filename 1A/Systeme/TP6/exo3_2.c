#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h> 
#include <string.h>
#include <stdlib.h>

int main(int argc, char *argv[]){
    int fdread, fdwrite, pid, nblu;
    char buf [256];
    int nbSecondesPassees = 0;

    pid = fork();

    if (pid == -1){
        perror("Erreur sur le fork\n");
        exit(1);

    }else if(pid == 0){ /* FILS */
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


    }else{      /* PERE */
       if((fdwrite = open("ficcom", O_WRONLY | O_CREAT, 0777)) == -1){
           perror("Erreur ouverture fichier père\n");
           exit(3);
       }
       
       while(1){
             bzero(buf, 256);

             sprintf(buf,"%d secondes passées   PERE\n", nbSecondesPassees);

             if(lseek(fdwrite, 0, SEEK_SET) == -1) {
                 perror("Erreur placement curseur\n");
             }
             write(fdwrite, buf, strlen(buf));

             sleep(2);
             nbSecondesPassees += 2;
       }

    }


    return 0;
}


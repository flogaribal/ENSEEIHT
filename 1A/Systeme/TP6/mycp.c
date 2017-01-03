#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h> 
#include <stdlib.h>
/*
int recopier(int fdsrc, int fddest) {
    char buf[256];
    int nblu = 0;

    while((nblu = read(fdsrc, buf, 256)) > 0){
        if((write(fddest, buf, nblu)) == -1){
            perror("Erreur sur le write\n");
            return -1;
        }
    }
    return nblu;
}*/

int main(int argc, char *argv[]){
/*    int fdsrc;*/
    int fddest;

    if(argc != 3){
        perror("Usage : ./mycp fichiersource fichierdest\n");
        exit(1);
    }else{
           /*       
           if((fdsrc = open(argv[1], O_RDONLY)) == -1) {
                perror("Erreur ouverture du fichier source\n");
                exit(2);
           }*/

           if((fddest = open(argv[2], O_WRONLY | O_CREAT | O_TRUNC, 0644)) == -1) {
                perror("Erreur ouverture du fichier destination\n");
                exit(3);
           }

           dup2(fddest, 1);
           close(fddest);

           execlp("./mycat","./mycat",argv[1],NULL);
           perror("Erreur d'éxécution\n");
           exit(4);
    }
    return 0;
}


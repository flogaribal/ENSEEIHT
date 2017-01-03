#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h> 


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
}

int main(int argc, char *argv[]){
    int i = 0;
    int fd;

    if(argc == 1){
        recopier(0,1);
    }else{
        for(i = 1; i < argc; i++){
           fd = open(argv[i], O_RDONLY);

           if (fd == -1){
               perror("Erreur sur l'ouverture du fichier\n");
               return 1;
           }else{
               recopier(fd,1);
           }
           close(fd);
        }
    }
    return 0;
}


#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <sys/mman.h>

void remplir(char *base, char c, int taille){
        int i = 0;
        printf("Aucun soucis pour le moment\n");
        /* Ecriture dans base caractère c */ 
        for (i = 0; i < taille; i++){
                base[i] = c;
        }
}

void afficher(char *base, int taille){
        int i = 0;

        /* Affichage de base */ 
        for (i = 0; i < taille; i++){
        printf("11Aucun soucis pour le moment\n");
                printf("%c\n", base[i]);
        }
}

int main(){

    int fd;
    char *buf;
    int page_size = sysconf(_SC_PAGE_SIZE);
    char *base ;
    int status;
    int pid; 

    /* Allocation de 2 pages dans le buffer */
    buf = malloc(2*page_size);

    /* Création & ouverture du fichier en écriture */
    fd = open("Test", O_CREAT | O_TRUNC | O_WRONLY, 0700);
    
    if (fd == -1) {
        perror("Erreur sur 1a 1e ouverture\n");
        exit(EXIT_FAILURE);
    }
   
    /* Remplissage du buffer avec deux pages de 'a' */
    remplir(buf, 'a', 2*page_size);

    /* Fermeture du fichier */
    close(fd);

    /* ouverture du fichier en lecture/ecriture */ 
    fd = open("Test", O_RDWR);
    
    if (fd == -1) {
        perror("Erreur sur 1a 2e ouverture\n");
        exit(EXIT_FAILURE);
    }
   
    /* Création de la mémoire partagée */
    base = mmap(NULL, 2*page_size, PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0);

    if (base == MAP_FAILED) {
        close(fd);
        perror("Error mmapping the file");
        exit(EXIT_FAILURE);
    }
    
    pid = fork();

    if(pid == -1){
        perror("Erreur fork\n");
        exit(1);

    }else if(pid == 0) { /* FILS */
        
        sleep(2);

        /* Affichage 10 premiers octets 1ere page*/ 
        /*afficher(base, 10);*/

        /* Affichage 10 premiers octets 2e page */ 
        /*afficher(base + page_size, 10);*/

        /* Remplissage première page avec des 'c' */ 
        /*remplir(base, 'c', page_size);*/

        exit(0);

    }else{

        /* Remplissage deuxième page avec des 'b' */
        remplir(base + page_size, 'b', page_size);

        /* Attente du fils */
        wait(&status);

        /* Affichage 10 premiers octets page 1 */
        /*afficher(base, 10);*/

        exit(0);
    }
}



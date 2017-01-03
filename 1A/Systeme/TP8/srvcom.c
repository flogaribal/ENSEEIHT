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
#define MAXCL 2 
/* nombre max de clients */

int main(int argc, char *argv[]) {

	/*pr et pw pour les communications dediees avec chaque client*/
	int pr[MAXCL][2], pw[MAXCL][2];
	/*tableaux des descripteurs de lecture et d'ecriture */
	int tdr[MAXCL], tdw[MAXCL];
	int connecte[MAXCL];
	int i, nump, pid, nblu, nbcl;
	char buf[TBUF],mess[TBUF];

	if (argc!=2) {
		printf("Il faut un numero de port \n");
		exit(1);
	}
	nump=atoi(argv[1]);
	nbcl=0;
	/* on cree les pipes necessaires pour les echanges avec sock_server */
	while (nbcl<MAXCL && (pipe(pr[nbcl])!=-1) && (pipe(pw[nbcl])!=-1)) {
	  nbcl++;
	}
	if (nbcl<1) {
	  printf("Probleme de creation de pipes\n");
	  exit(2);
	}
	printf("nb max clients = %d\n",nbcl);
	pid = fork(); 
	if (pid==-1) {
	  perror("fork");
	  exit(4);
	}

	if (pid== 0) { /* Fils */
	  for (i=0; i<nbcl; i++) {
	    /*on ferme les extrremites non utilisees et on initialise les tableaux des descripteurs de communication avec sock_server*/
		close(pr[i][0]);
		close(pw[i][1]);
	 	tdr[i]=pr[i][1];    
	 	tdw[i]=pw[i][0];  
	  }
	  sock_server(nump, tdw, tdr, nbcl);
  	   /* sock_server sans retour*/
	}
	else { /*Pere*/
	  struct timeval time;
          fd_set set;
          int res ;
                
          timerclear(&time);
          time.tv_sec = 3;
          time.tv_usec = 0;
            
          for (i=0; i<nbcl; i++) {
	     	close(pr[i][1]);
		close(pw[i][0]);
		connecte[i]=0;
	  }
	  while(1) {
            FD_ZERO(&set);

            for(i = 0; i < nbcl ; i++){
                FD_SET(pr[i][0], &set);
            }

        
            res = select(FD_SETSIZE, &set, NULL, NULL, &time);
              
            if (res > 0){

                    for (i = 0; i< nbcl; i++){
                        if (FD_ISSET(pr[i][0], &set)) {
                            /* on lit ce qui arrive sur la connexion numero i */
                            nblu=read(pr[i][0],buf, TBUF);

                             if (nblu>0) {
                                /* si connexion non fermee */
                                if (strncmp(buf,"Fermee",6)) {
                                /* on affiche le message recu */
                                    sprintf(mess," %d <<< ",i);
                                    write(1,mess,strlen(mess));
                                    buf[nblu]='\n';
                                    write(1,buf,nblu+1);
                                    /* si c'est le premier message de connexion */
                                    if (!connecte[i]) {
                                        connecte[i]=1;
                                    }
                                    /* on confirme la reception du message */
                                    else {
                                        sprintf(mess," <<< : commande bien recue : ");
                                        write(pw[i][1],mess,strlen(mess));
                                        write(pw[i][1],buf,nblu+1);
                                    }
                                }
                                /* connexion fermee */
                                else {
                                    connecte[i]=0;
                                    sprintf(mess,"Connexion %d fermee\n ",i);
                                    write(1,mess,strlen(mess));
                                }
                            }
                        
                        }
                    }
            }
  	  }
        }
	
	return 0;
}	


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
#include "liste_proc.h"
#include "cmds.h"

#define TBUF 256    
#define MAXCL 2 
#define MAX_ARG 16   

/* nombre max de clients */

ListeProc liste_processus;

/****************************************************/
/* Fonction permettant de traiter la réception du   */
/* signal SIGCHLD afin de récupérer les changements */
/* d'états des fils                                 */
/****************************************************/
void chld_handler(int sigNumber){      
    int pid, status;

    /* ATTENTE DU FILS */
    pid = waitpid(WAIT_ANY, &status, WNOHANG | WUNTRACED | WCONTINUED);

    /* SI LE PROCESSUS NOUS INTERESSE */
    if(appartient(pid, liste_processus) != 0){

       /* Si le processus s'est terminé normalement */
      if (WIFEXITED(status)){
        /*  On affiche le code de retour du processus */
        printf("Code de retour du processus %d : %d\n",pid, WEXITSTATUS(status));

        /* SUPPRESSION PROCESSUS */
        #ifdef DEBUG
           printf("Suppression du processus %d de la liste \n",pid);
        #endif
        supprimer_proc(pid, &liste_processus);
      }

      /* Si le processus a reçu un signal de terminaison */
      if (WIFSIGNALED(status)){
        /* On affiche le numéro du signal reçu */
        printf("Code du signal reçu par le processus %d : %d\n",pid, WTERMSIG(status));

        if(WTERMSIG(status) == 9){
          /* SUPPRESSION PROCESSUS CAR SIGNAL */
          #ifdef DEBUG
        printf("Suppression du processus %d de la liste \n",pid);
          #endif
          supprimer_proc(pid, &liste_processus);
        }
      }

      /* Si le processus a reçu un signal de suspension */
      if (WIFSTOPPED(status)){
    /* On affiche le numéro du signal reçu */
    printf("Processus %d suspendu avec le code : %d\n",pid,WSTOPSIG(status));

    /* PASSAGE PROC SUSPENDU */
    #ifdef DEBUG
      printf("Passage du processus %d en SUSPENDU \n",pid);
    #endif
    modifier_etat_proc(pid, SUSPENDU, liste_processus);

    waitpid(pid, &status, WUNTRACED | WCONTINUED | WNOHANG);
    /* Si le processus a reçu un signal de relance */
    if (WIFCONTINUED(status)){
        /*On affiche le numéro du signal reçu */
        printf("Processus %d relancé\n", pid);
        
        /* PASSAGE PROC ACTIF */
        #ifdef DEBUG
      printf("Passage du processus %d en ACTIF \n",pid);
        #endif
        modifier_etat_proc(pid, ACTIF, liste_processus);
    } 

      }
  }
}


/****************************************************/
/* Fonction permettant l'éxécution d'une commande   */
/* externe (non interne à l'application)            */
/****************************************************/
void execution_cmd_externe(char *argv_cmd[]){

    int pid = fork();
    char *commande;

    commande = malloc(strlen(argv_cmd[0]) * sizeof(char));

    strcpy(commande, argv_cmd[0]);

    if (pid == -1) {            /* ERREUR */
        perror("Erreur sur le fork()");
        exit(2);

    }else if(pid == 0){       /* FILS */
  #ifdef DEBUG
          printf("\nExécution de la comande : %s \n", argv_cmd[0]);
      #endif
        execvp(argv_cmd[0],&argv_cmd[0]);

        perror("Erreur execution de la commande");
        exit(3);

    } else {                    /* PERE */

  inserer_proc_en_queue(pid, ACTIF, commande, &liste_processus);
        /* Insertion du processus dans la liste */
  #ifdef DEBUG
    printf("Insertion du processus %d dans la liste \n",pid);
    afficher_liste_proc(liste_processus);
      #endif
        
  signal(SIGCHLD, chld_handler);

     }
}



/********************************************************/
/* Fonction permettant de tuer un processus suivant des */
/* Paramètres                                           */
/********************************************************/
void kill_process(char *argv_cmd[], int argc_cmd) {
 
    int pid, pidFork; 
    int signal;
 
    if(argc_cmd == 3){
        pid = atoi(argv_cmd[2]);
        signal = atoi(&argv_cmd[1][1]);
        #ifdef DEBUG
          printf("VERSION 3 ARGUMENTS\n\n");
          printf("Processus a tuer : %d \n", pid);
          printf("Signal demandé : %d \n", signal);
        #endif
    }else{
        pid = atoi(argv_cmd[1]);
        signal = 15;
        #ifdef DEBUG
          printf("VERSION 2 ARGUMENTS\n\n");
          printf("Processus a tuer : %d \n", pid);
          printf("Signal demandé : %d \n", signal);
        #endif  
    }
    if(appartient(pid, liste_processus) != 0){
      if(signal == 9 || signal == 15) {
          /* Suppression du processus de la liste car terminé */
          #ifdef DEBUG
            printf("Suppression du processus %d de la liste \n",pid);
          #endif
          supprimer_proc(pid, &liste_processus); 

      }else if(signal == 19){
          /* PASSAGE PROC SUSPENDU */
          #ifdef DEBUG
            printf("Passage du processus %d en SUSPENDU \n",pid);
          #endif
          modifier_etat_proc(pid, SUSPENDU, liste_processus);
    
      }else if(signal == 18){
          /* PASSAGE PROC ACTIF */
          #ifdef DEBUG
            printf("Passage du processus %d en ACTIF \n",pid);
          #endif
          modifier_etat_proc(pid, ACTIF, liste_processus);
      }

      pidFork = fork();
     
      if(pidFork == -1){    /* ERREUR */
          perror("Erreur fork\n");
          return;

      }else if(pidFork == 0){   /* FILS */

          #ifdef DEBUG
            printf("Exécution du kill\n");
          #endif
          execvp("kill",&argv_cmd[0]);
          perror("ERREUR exec kill\n");

      }else{      /* PERE */
          return; 
      }    
    }else{
      printf("Aucun processus comportant le pid %d n'appartient à la liste des processus\n",pid);
    }

}


/****************************************************/
/* Fonction de traitement d'une commande            */ 
/****************************************************/

void traiter_cmd(int argc_cmd, char *argv_cmd[]) {
   if (argc_cmd) { /* commande non vide*/
      if(!strcasecmp(argv_cmd[0], "lp")) {
          /* afficher la liste des processus */
          afficher_liste_proc(liste_processus);

      }else if(!strcasecmp(argv_cmd[0], "kill")){
          if(argc_cmd < 2){
            perror("Usage : kill [-signal] pid\n");
            return;
          }

          kill_process(argv_cmd, argc_cmd);

      }else {
          execution_cmd_externe(argv_cmd);
  
      }
   }
   return;
}

/****************************************************/
/* Fonction principale du programme sdcom           */
/****************************************************/
int main(int argc, char *argv[]) {

	/* pr et pw pour les communications dediees avec chaque client*/
	int pr[MAXCL][2], pw[MAXCL][2];

	/* Tableaux des descripteurs de lecture et d'écriture */
	int tdr[MAXCL], tdw[MAXCL];

  /* Tableau ds connexions */
	int connecte[MAXCL];
	
  int i, nump, pid, nblu, nbcl, oldStdOut, oldStdErr;

  /*char *redirection = NULL;*/

  char buf[TBUF],mess[TBUF];

  /* Paramètres de la commande reçue */
  int argc_cmd;
  char *argv_cmd[MAX_ARG];


  /* Stockage de STDIN et STDERR */
  oldStdOut = dup(fileno(stdout));
  oldStdErr = dup(fileno(stderr));


	if (argc != 2) {
		printf("Usage : ./sdcom <numPort> \n");
		exit(1);
	}

	nump = atoi(argv[1]);
	nbcl = 0;

	/* On cree les pipes necessaires pour les echanges avec sock_server */
  while (nbcl<MAXCL && (pipe(pr[nbcl])!=-1) && (pipe(pw[nbcl])!=-1)) {
    nbcl++;
  }

	if (nbcl < 1) {
	  printf("Probleme de creation de pipes\n");
	  exit(2);
	}

	printf("Nombre de clients maximum : %d\n",nbcl);

	pid = fork(); 
	if (pid == -1) {
	  perror("Erreur sur le fork");
	  exit(4);
	}

	if (pid == 0) { /* Fils */
    	  for (i = 0; i < nbcl; i++) {
    	    /* On ferme les extrémites non utilisées et on initialise les tableaux des 
               descripteurs de communication avec sock_server */
        		close(pr[i][0]);
        		close(pw[i][1]);
        	 	tdr[i] = pr[i][1];    
        	 	tdw[i] = pw[i][0];  
    	  }
    	  sock_server(nump, tdw, tdr, nbcl);
      	/* sock_server sans retour*/

        perror("Erreur sock_server\n");
        exit(5);
	
  }else { /* Pere */
	    struct timeval time;
      fd_set set;
      int res ;
            
      timerclear(&time);
      time.tv_sec = 3;
      time.tv_usec = 0;
        
      /* On ferme les extremites non utilisées */
      for (i = 0; i < nbcl; i++) {
         	close(pr[i][1]);
    		  close(pw[i][0]);
    		  connecte[i] = 0;
    	}

  	  while(1) {
              FD_ZERO(&set);

              /* Rajoute le client à l'ensemble */
              for(i = 0; i < nbcl ; i++){
                  FD_SET(pr[i][0], &set);
              }

              /* Res retourne le nombre de descripteurs de fichiers modifié
                 select modifie l'ensemble de descripteur */
              res = select(FD_SETSIZE, &set, NULL, NULL, &time);
                
              if (res > 0){

                      for (i = 0; i < nbcl; i++){

                          if (FD_ISSET(pr[i][0], &set)) {

                              /* On lit ce qui arrive sur la connexion numero i */
                              nblu = read(pr[i][0],buf, TBUF);

                               if (nblu > 0) {

                                  /* Si connexion non fermee */
                                  if (strncmp(buf,"Fermee",6)) {

                                      /* Si c'est le premier message de connexion */
                                      if (!connecte[i]) {
                                          write(1, buf, nblu);
                                          write(1, "\n", 1);
                                          connecte[i]=1;
                                      }else { /* On confirme la reception du message */

                                          /* Remplacement des descripteurs de fichier par
                                             le pipe */
                                          dup2(pw[i][1], 1);
                                          dup2(pw[i][1], 2);

                                          buf[nblu] = '\0';

                                          argc_cmd = get_args(MAX_ARG, argv_cmd, buf);
                                          
                                          /*
                                          j = 0;

                                          Tant que le caractère courant n'est pas un ">" 
                                          while (j < argc_cmd && strcmp(argv_cmd[j],">")){
                                              redirection = argv_cmd[j+1];
                                              argv_cmd[j] = NULL;
                                              j++;
                                          }

                                          Si redirection, modification stdout & stderr 
                                          if (redirection != NULL){
                                              newOut = open(redirection, O_RDWR|O_CREAT|O_APPEND, 0600);

                                              Modification de stdin et stderr
                                              dup2(newOut, 1);
                                              dup2(newOut, 2);

                                          }else{
                                              Changement sortie standard et sortie err 
                                              dup2(pw[i][1], 1);
                                              dup2(pw[i][1], 2);  
                                          }*/

                                          if (argc_cmd > 0) {

                                              traiter_cmd(argc_cmd, argv_cmd);
                                           
                                              sleep(1); /* laisser un peu de temps entre deux commandes */

                                              /* libere l'espace memoire reserve par get_args pour stocker les differents arguments*/
                                              free_args(argc_cmd, argv_cmd);                                        
                                          }

                                          /* Rétablissement OUT/ERR standard */
                                          dup2(oldStdOut, fileno(stdout));
                                          dup2(oldStdErr, fileno(stderr));

                                      }
                                     
                                  }
                                  /* Connexion fermee */
                                  else {
                                      connecte[i] = 0;
                                      /* AMELIORATION POSSIBLE SI STOCKAGE DE L'USER DANS LA LISTE */
                                      /*if(liste_processus != NULL){
                                          
                                          detruire_liste(&liste_processus);
                                      }*/
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


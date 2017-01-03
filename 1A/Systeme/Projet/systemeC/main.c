
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/wait.h>
#include <errno.h>
#include "cmds.h"
#include "liste_proc.h"

#define TBUF 256    
#define MAX_ARG 16   
/*#define DEBUG*/

ListeProc liste_processus;

  
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

/****************************************************/

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
     
      if(pidFork == -1){		/* ERREUR */
  	      perror("Erreur fork\n");
          return;

      }else if(pidFork == 0){		/* FILS */

  	      #ifdef DEBUG
  	        printf("Exécution du kill\n");
      	  #endif
          execvp("kill",&argv_cmd[0]);
          perror("ERREUR exec kill\n");

      }else{			/* PERE */
     	    return;	
      }    
    }else{
      printf("Aucun processus comportant le pid %d n'appartient à la liste des processus\n",pid);
    }

}

/****************************************************/

/* traitement d'une commande */ 
void traiter_cmd(int argc_cmd, char *argv_cmd[]) {
   if (argc_cmd) { /* commande non vide*/
      if(!strcasecmp(argv_cmd[0], "exit")) {

          if(liste_processus != NULL){
              /* Libération de la mémoire allouée pour la liste */
            detruire_liste(&liste_processus);
          }

          /* tout fermer et sortie proprement */
            exit(0);

      }else if(!strcasecmp(argv_cmd[0], "rlp")) {
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



/************************************************************/

int main (int argc, char *argv[]) {

  int argc_cmd;
  char *argv_cmd[MAX_ARG];
  int nblu;
  char buf[TBUF];
  char invite[TBUF];

  /* Pour illustrer la manipulation de chaines */

  strcpy(invite,"Entrez une commande");
  /* strcpy copie le second argument dans le premier (chaines) */
	
  strcat(invite," >");
  /* Pour illustrer le strcat qui concatene deux chaines */

  /* on peut utiliser 
   sprintf(invite,"Entrez une commande >");
   */

  liste_processus = NULL;

  while(1) {

  	write(1,invite,strlen(invite));
	/* write : niveau en dessous de celui du printf
	 * on indique le descripteur sur lequel on ecrit, la chaine a ecrire et sa longuer (obtenue avec strlen */
	
	bzero(buf, sizeof(buf)); /* vider buf avant le read */

	nblu = read(0, buf, sizeof(buf));

	/* lecture au clavier. Memes remarques que pour le write / printf */
	if (nblu > 0) {
	  argc_cmd = get_args(MAX_ARG, argv_cmd, buf);

	  if (argc_cmd > 0) {

	       traiter_cmd(argc_cmd, argv_cmd);
	   
            sleep(1); /* laisser un peu de temps entre deux commandes */

            free_args(argc_cmd, argv_cmd);
	    /* libere l'espace memoire reserve par get_args pour stocker les differents arguments*/
	  }
	}

  }
  return 0;
}

/****************************************************/


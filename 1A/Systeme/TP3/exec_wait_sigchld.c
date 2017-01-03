#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

#include <sys/types.h>
#include <sys/wait.h>
#include <signal.h>
#include <string.h>

int nbfils=0;		/* nombre de fils en cours*/

/* handler de traitement du signal SIGCHLD */
void handler_chld(int signal_num) {
  int status, nump;
  printf("SIGCHLD recu par proc %d \n",getpid());
  nump=1;
  while (nump > 0) {  
	 nump = (int) waitpid(-1, &status, WNOHANG | WUNTRACED | WCONTINUED);  
         if (nump > 0) {
	 if (WIFSIGNALED(status)) {
               	printf("Processus %d tue par le signal %d\n", nump, WTERMSIG(status));
		nbfils--;
         } else if (WIFEXITED(status)) {
                	printf("Processus %d termine, code retour=%d\n",nump, WEXITSTATUS(status));
			nbfils--;
        	} else if (WIFSTOPPED(status)) {
                		printf("Processus %d suspendu par le signal %d\n", nump, WSTOPSIG(status));
              		} else if (WIFCONTINUED(status)) {
              				printf("Processus %d relance\n", nump);
		   		}
	}
  }
}

/* main :
- lance la commande passe en argument s'il y en a une
- lance 3 commandes sleep avec durees differentes
- rend compte des changements d'etats des fils jusqu'a leur disparition complete
*/
int main(int argc, char *argv[]) {
  int i, pid;

  signal(SIGCHLD, handler_chld);
  if (argc>1) { /*main avec arguments*/
    pid=fork();
    if (pid==-1) {
      perror("fork"); exit(1);
    }
    if (pid==0) { /*premier fils execute la commande passee en argument du main */
      execvp(argv[1], argv+1); 
      perror("exec"); /* on se trouve ici seulement si erreur du exec*/
      exit(2);
    }
    nbfils++;
  }
  /*pere cree 3 fils qui executent la commande sleep avec des durees differentes */
  for (i=1; i<4; i++) {
    	pid=fork();
    	if (pid==-1) {
      		perror("fork"); exit(1);
    	}
	if (pid==0) { 
	  /*fils i execute la commande sleep avec une duree = i*100
  	  Pour illustrer execvp, sinon il est plus simple d'utiliser la primitive sleep */
	  char duree[8];
	  char *argcommand[]={"dodo","10",'\0'};
	  sprintf(duree,"%d",i*100);
	  argcommand[1]=duree;
	  execvp("sleep",argcommand);
	  perror("sleep");
	  exit(i+3);
	}
	/*pere*/
    	nbfils++;
  }
  /* perer reste actif tant qu'il est exite des fils */
  while (nbfils>0) {
	printf("Je suis le processus %d et j'ai %d fils dont j'attends la fin\n",getpid(),nbfils);
	sleep(10);
  }
  return 0;
}

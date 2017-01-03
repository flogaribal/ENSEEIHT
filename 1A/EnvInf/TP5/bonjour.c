/*** 10 BONJOUR en langage C ***/

#include <stdio.h>
/*** necessaire pour importer les fonctions d'entrées/sorties de la bibliotheque stdio ***/

int main() {

  int N=10;
  int d=10;
  int i; /*** pour compter le nombre de passage dans la boucle ***/
  for (i=0; i<10; i++) { /*** une boucle à 10 passages ***/
    printf("Bonjour : je m'endors pendant %d secondes ... et je m'arreterai après %d tours\n",d,N-i);
    sleep(d); /*** je m'endors pendant d secondes ***/
  }
  printf("Au revoir\n");
  return 0;
}

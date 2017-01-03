#include <stdio.h>
#include "liste_proc.h"

int main() {
	
  ListeProc lp;

  lp = NULL;
  /* remplir la liste avec quelques processus */

  printf("Ajout de 5 \n");
  inserer_proc_en_queue(5, SUSPENDU, &lp);


  /* test d'appartenance */
  if(appartient(7, lp)) {
    printf("processus 7 appartient à la liste\n");
  } else {
    printf("processus 7 n'appartient pas à la liste\n");
  }

  if(appartient(5, lp)) {
    printf("processus 5 appartient à la liste\n");
  } else {
    printf("processus 5 n'appartient pas à la liste\n");
  }

  afficher_liste_proc(lp);


  printf("\n");
  printf("Ajout de 7, 9 et 15 \n");  
  inserer_proc_en_queue(7, ACTIF, &lp);
  inserer_proc_en_queue(9, SUSPENDU, &lp);
  inserer_proc_en_queue(15, ACTIF, &lp);
  afficher_liste_proc(lp);
  printf("\n");

  printf("Modification état 15 \n");  
  modifier_etat_proc(15,SUSPENDU,lp);

  afficher_liste_proc(lp);
  printf("\n");

  printf("Suppression de 9 \n");  
  supprimer_proc(9,&lp);
  afficher_liste_proc(lp);

  printf("Suppression de 5 \n");  
  supprimer_proc(5,&lp);
  afficher_liste_proc(lp);


  printf("Num tête : %d\n", lire_num_tete(lp));


  /* Test des autres fonctions */
  /* TODO */

  return 0;
}

#include <stdio.h>
#include <malloc.h>
#include "liste_proc.h"

struct fiche_proc{
  int pid;
  State etat;
  struct fiche_proc* suivant;
};

/* fonction appartient : 
  -- indique si un processus de n° pid appartient à la liste
  -- paramètres : 
        int pid : n° du nouveau processus (D)
        ListeProc liste_proc : liste de processus (D)
  -- résultat :
        int : pseudo booléen indiquant l'appartenance
  -- pré : aucune
  -- post : aucune 
  --------------------------------------------------*/
int appartient(int pid, ListeProc liste_proc){

  while(liste_proc != NULL && liste_proc -> pid != pid) {
    liste_proc = liste_proc -> suivant;
  }

  return (liste_proc != NULL);
}


/* fonction afficher_liste_proc : 
  -- affiche la liste des processus
  -- paramètres : 
        liste_proc : liste de processus (D)
  -- résultat :
        aucun
  -- pré : aucune
  -- post : aucune 
  --------------------------------------------------*/
void afficher_liste_proc(ListeProc liste_proc){
        
    while(liste_proc != NULL) {
        printf("PID = %d \n", liste_proc -> pid);
        printf("Etat = %d \n\n", liste_proc -> etat);
        liste_proc = liste_proc -> suivant;
    }
}

/* fonction inserer_proc_en_queue : 
  -- insère un nouveau processus en queue de la liste de processus
  -- paramètres : 
        int pid : n° du nouveau processus (D)
        State etat : état du nouveau processus (D)
        ListeProc liste_proc : liste de processus (D/R)
  -- résultat :
        int : 0 OK, 1 KO
  -- pré : aucune
  -- post : aucune 
  --------------------------------------------------*/
int inserer_proc_en_queue(int pid, State etat, ListeProc *liste_proc){

    ListeProc tmp_liste = *liste_proc;

    ListeProc newListe = malloc(sizeof(struct fiche_proc));

    /* SI ALLOC IMPOSSIBLE */
    if (newListe == NULL){
        perror("Allocation mémoire impossible");
        return 1;
    }
    
    /* ASSIGNATION DES CHAMPS DU NOUVEL ELT */
    newListe -> etat = etat;
    newListe -> pid = pid;
    newListe -> suivant = NULL;
 
    if((*liste_proc) == NULL){
        (*liste_proc) = newListe;
    }else{
        /* PARCOURS JUSQU'A LA QUEUE */
        while(tmp_liste->suivant != NULL) {
            tmp_liste = tmp_liste -> suivant;
        }
            
        /* AJOUT DU NOUVEL ELT */
        tmp_liste->suivant = newListe;
    }

    return 0;   

}

/* fonction modifier_etat_proc : 
  -- change l'état du processus de n° pid
  -- paramètres : 
        int pid : n° du processus (D)
        State etat : nouvel état du processus (D)
        ListeProc liste_proc : liste de processus (D) 
                 [attention : la structure de liste n'est pas modifiée]
  -- résultat :
        int : 0 OK, 1 KO (processus non présent par exemple)
  -- pré : aucune
  -- post : aucune 
  --------------------------------------------------*/
int modifier_etat_proc(int pid, State etat, ListeProc liste_proc){

    while(liste_proc != NULL && liste_proc -> pid != pid){
            liste_proc = liste_proc -> suivant;
    }

    if(liste_proc == NULL){
        return 1;
    }else{
        liste_proc -> etat = etat;
    }

  return 0;

}

/* fonction supprimer_proc : 
  -- supprimer le processus de n° pid de la structure de liste
  -- paramètres : 
        int pid : n° du processus (D)
        ListeProc liste_proc : liste de processus (D) 
               [attention : la structure de liste est modifiée]
  -- résultat :
        int : 0 OK, 1 KO (processus non présent par exemple)
  -- pré : aucune
  -- post : aucune 
  --------------------------------------------------*/
int supprimer_proc(int pid, ListeProc *liste_proc){
    
    ListeProc tmp_liste = *liste_proc;


    /* CAS LISTE VIDE */
    if (liste_proc == NULL){
        return 1 ;
    }

    /* CAS PREMIER ELEMENT A SUPPRIMER */
    if((*liste_proc) -> pid == pid){
        (*liste_proc) = (*liste_proc) -> suivant;
        return 0;
    }


    /* CAS NIEME ELEMENT A SUPPRIMER */
    while(tmp_liste != NULL && tmp_liste -> suivant != NULL && tmp_liste -> suivant -> pid != pid){
            tmp_liste = tmp_liste -> suivant;
    }

    /* SI ELEMENT NON TROUVE */
    if (tmp_liste==NULL||tmp_liste->suivant==NULL){
        return 1;

    /* SINON */
    }else{
        tmp_liste -> suivant = tmp_liste -> suivant -> suivant;
    }

    return 0;
}




/* fonction lire_num_tete : 
  -- renvoi le numéro du processus en tête de liste
  -- paramètres : 
        ListeProc liste_proc : liste de processus (D) 
  -- résultat :
        int : le numéro du processus en tête
  -- pré : aucune
  -- post : aucune 
  --------------------------------------------------*/

int lire_num_tete(ListeProc liste_proc){
    if (liste_proc == NULL){
        return -1;    
    }else{
        return liste_proc -> pid;
    }
}

#ifndef _LISTE

  #define _LISTE

  typedef enum  {SUSPENDU, ACTIF} State;

  typedef struct fiche_proc *ListeProc;

#endif

/* fonction afficher_liste_proc : 
  -- affiche la liste des processus
  -- paramètres : 
        liste_proc : liste de processus (D)
  -- résultat :
        aucun
  -- pré : aucune
  -- post : aucune 
  --------------------------------------------------*/
void afficher_liste_proc(ListeProc liste_proc);

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
int inserer_proc_en_queue(int pid, State etat, ListeProc *liste_proc);

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
int appartient(int pid, ListeProc liste_proc);

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
int modifier_etat_proc(int pid, State etat, ListeProc liste_proc);

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
int supprimer_proc(int pid, ListeProc *liste_proc);



/* fonction lire_num_tete : 
  -- renvoi le numéro du processus en tête de liste
  -- paramètres : 
        ListeProc liste_proc : liste de processus (D) 
  -- résultat :
        int : le numéro du processus en tête
  -- pré : aucune
  -- post : aucune 
  --------------------------------------------------*/

int lire_num_tete(ListeProc liste_proc);

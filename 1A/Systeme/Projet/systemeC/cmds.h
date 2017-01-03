
 
#ifndef __LIRECMD
#define __LIRECMD

/*
Sépare les differents champs d'une chaine passée dans le troisième argument,
les enregistre dans des chaines reservees dynamiquement, 
et enregistre leurs adresses dans le tableau argv passé dans le deuxième argument. 
entrees :
- argmax : nombre max de champs attendus
- argv[] : tableau de pointeurs qui seront connectes aux differents champs de la commande
- resultat : nombre de champs trouves (argc)
- argv[argc] est mis a NULL
Les caracteres > < | & sont isoles dans des champs separes meme losrqu'ils sont colles a d'autres mots
Ex : ccc <fic1 arg1|arg2 >fic2& est eclatee en 9 champs :
ccc < fic1 arg1 | arg2 > fic2 &
*/
int get_args(int argmax, char *argv[], char *buf);

/* Libere la memoire occupee par les differents champs d'une commande.
entrees : 
- argc : nombre de champs de la commande
- argv[] : tableau de pointeurs sur les differents champs
*/
void free_args(int argc, char *argv[]);

#endif

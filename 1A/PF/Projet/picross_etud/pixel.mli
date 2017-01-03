
(* Le type abstrait des pixels du Picross.                                  *)
(* Permet de représenter efficacement des couples de valeurs entières       *)
(* (abscisse, ordonnée) comprises chacune entre 0 et 255.                   *)
type t;;


(* Le type de la couleur des pixels.                                        *)
(* Un pixel est blanc ou noir.                                              *)
type couleur =
| Blanc
| Noir;;


(* Création d'un pixel à l'aide de ses coordonnées.                         *)
(* Paramètres:                                                              *)
(* - une abscisse, entier entre 0 et 255                                    *)
(* - une ordonnée, entier entre 0 et 255                                    *)
(* Résultat:                                                                *)
(* - le pixel correspondant aux coordonnées fournies                        *)
(* Erreur:                                                                  *)
(* - exception levée si l'abscisse ou l'ordonnée ne sont pas                *)
(*   entre 0 et 255                                                         *)
val make : int -> int -> t;;

(* Création d'un pixel de coordonnées aléatoires dans une grille carrée.    *)
(* Paramètres:                                                              *)
(* - une taille de grille, entier entre 0 et 255                            *)
(* Résultat:                                                                *)
(* - un pixel dont les coordonnées sont comprises entre 0 et taille-1       *)
(* Erreur:                                                                  *)
(* - exception levée si la taille n'est pas entre 0 et 255                  *)
val random : int -> t;;

(* Coordonnée en x d'un pixel.                                              *)
(* Paramètre:                                                               *)
(* - un pixel                                                               *)
(* Résultat:                                                                *)
(* - un entier représentant l'abscisse du pixel, entre 0 et 255             *)
val get_x : t -> int;;

(* Coordonnée en y d'un pixel.                                              *)
(* Paramètre:                                                               *)
(* - un pixel                                                               *)
(* Résultat:                                                                *)
(* - un entier représentant l'ordonnée du pixel, entre 0 et 255             *)
val get_y : t -> int;;

(* Fonction calculant la liste de tous les pixels d'une ligne donnée,       *)
(* dans une grille carrée.                                                  *)
(* Paramètre:                                                               *)
(* - l'indice i de la ligne voulue, compté à partir de 0.                   *)
(* Résultat:                                                                *)
(* - la liste triée par ordre (générique) croissant de tous les pixels      *)
(*   composant la ligne i                                                   *)
val ligne : int -> int -> t list;;

(* Fonction calculant la liste de toutes les lignes d'une grille carrée.    *)
(* Paramètre:                                                               *)
(* - l'indice i de la ligne voulue, compté à partir de 0.                   *)
(* Résultat:                                                                *)
(* - la liste triée par ordre (générique) croissant de toutes les lignes    *)
(*   de la grille carrée                                                    *)
val lignes : int -> t list list;;

(* Fonction calculant la liste de tous les pixels d'une colonne donnée,     *)
(* dans une grille carrée.                                                  *)
(* Paramètre:                                                               *)
(* - l'indice i de la colonne voulue, compté à partir de 0.                 *)
(* Résultat:                                                                *)
(* - la liste triée par ordre (générique) croissant de tous les pixels      *)
(*   composant la colonne i                                                 *)
val colonne : int -> int -> t list;;

(* Fonction calculant la liste de toutes les colonnes d'une grille carrée.  *)
(* Paramètre:                                                               *)
(* - l'indice i de la ligne voulue, compté à partir de 0.                   *)
(* Résultat:                                                                *)
(* - la liste triée par ordre (générique) croissant de toutes les colonnes  *)
(*   de la grille carrée                                                    *)
val colonnes : int -> t list list;;

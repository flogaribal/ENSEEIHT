open Bdd_base;;

(* ************************************************************************* *)
(* FONCTIONS AVANCEES SUR LES BDD                                            *)
(* ************************************************************************* *)


(* La fonction qui calcule la conjonction de deux BDD.                       *)
(* Paramètres:                                                               *)
(* - deux BDD quelconques.                                                   *)
(* Résultat:                                                                 *)
(* - le bdd représentant la conjonction.                                     *)
val conjonction : bdd -> bdd -> bdd;;


(* La fonction qui calcule la substitution de variables par Top ou Bot       *)
(* dans un BDD. Permet de prendre en compte l'effet d'un pixel découvert     *)
(* dans les configurations possibles.                                        *)
(* Paramètres:                                                               *)
(* - une liste de paires (pixel, couleur) représentant les variables         *)
(*   à substituer. La couleur permet de savoir par quoi il faut substituer.  *)
(* - un bdd représentant un ensemble de configurations de pixels.            *)
(* Résultat:                                                                 *)
(* - le bdd représentant la substitution des variables par Top               *)
(*   si la couleur associée est Noir, ou par Bot si la couleur est Blanc.    *)
val substitution : (Pixel.t * Pixel.couleur) list -> bdd -> bdd;;


(* La fonction qui calcule un bdd représentant les combinaisons de pixels    *)
(* noirs, tirés dans un ensemble, à partir d'une indication.                 *)
(* Paramètres:                                                               *)
(* - une liste d'entiers [k_1;...;k_n], éventuellement vide, avec k_i > 0,   *)
(*   représentant les nombres de pixels noirs consécutifs à choisir.         *)
(* - une liste l de pixels, triée par ordre croissant, dans laquelle         *)
(*   on choisit les pixels noirs.                                            *)
(* Résultat:                                                                 *)
(* - le bdd représentant toutes les combinaisons possibles de pixels         *)
(*   de couleur noire dans l.                                                *)
val depuis_indication : int list -> Pixel.t list -> bdd;;



(* ************************************************************************* *)
(* TYPES + FONCTIONS GENERALES SUR LES CONFIGURATIONS                        *)
(* ************************************************************************* *)


(* Le type abstrait dont les valeurs représentent un ensemble                *)
(* de configurations du picross.                                             *)
(* Le type des configurations doit contenir:                                 *)
(* un bdd décrivant les couleurs possibles des pixels du dessin              *)
(* + toute autre information jugée nécessaire...                             *)
type configurations;;


(* Fonction qui calcule une indication de ligne/colonne en fonction          *)
(* de la liste de (couleurs de) pixels correspondante.                       *)
(* Paramètre:                                                                *)
(* - une ligne ou colonne de pixels sur laquelle calculer l'indication       *)
(* Résultat:                                                                 *)
(* - une indication, liste éventuellement vide d'entiers > 0                 *)
val indication : Pixel.couleur list -> int list;;

(* Fonction qui force la couleur d'un pixel dans les configurations,         *)
(* réduisant leur nombre. Ce pixel ne sera plus ambigu (voir ambiguite).     *)
(* Paramètre:                                                                *)
(* - un paire (pixel, couleur)                                               *)
(* Résultat:                                                                 *)
(* - les configurations restantes où le pixel choisi a la bonne couleur      *)
val selection : Pixel.t * Pixel.couleur -> configurations -> configurations;;

(* La fonction qui calcule les configurations initiales possibles            *)
(* en fonction des indications de chaque ligne/colonne.                      *)
(* Paramètre:                                                                *)
(* - une liste de paires (indication, ligne/colonne de pixels)               *)
(* Résultat:                                                                 *)
(* - les configurations initiales possibles.                                 *)
val initialisation : (int list * Pixel.t list) list -> configurations;;

(* Fonction qui teste si un ensemble de configurations est réduit à un seul  *)
(* élément. Teste la non-ambiguïté dans les configurations possibles, i.e.   *)
(* tous les pixels ont une couleur unique dans toutes les configurations.    *)
(* Paramètres:                                                               *)
(* - un ensemble de configurations possibles                                 *)
(* Résultat:                                                                 *)
(* - le booléen indiquant s'il y a une seule configuration possible, ou non  *)
val singleton : configurations -> bool;;

(* Fonction qui calcule une ambiguïté dans les configurations possibles,     *)
(* i.e. renvoie un pixel qui n'a pas de polarité, i.e. pas de couleur unique *)
(* dans toutes les configurations.                                           *)
(* Paramètres:                                                               *)
(* - un ensemble de configurations possibles ambiguës                        *)
(* Résultat:                                                                 *)
(* - un pixel ambigu                                                         *)
(* Erreur:                                                                   *)
(* - exception levée s'il n'y a pas de pixel ambigu, i.e. l'ensemble         *)
(*   des configurations est réduit à un élément                              *)
val ambiguite : configurations -> Pixel.t;;


(* ************************************************************************* *)
(* TYPES + FONCTIONS DE BASE SUR LES BDD                                     *)
(* ************************************************************************* *)

(* Le type des BDD où les variables sont des cases du démineur.              *)
(* L'ordre entre les cases est l'ordre générique croissant prédéfini.        *)
(* Les constructeurs sont "privés", i.e. on peut les utiliser uniquement     *)
(* dans un cas de filtrage, pas dans une expression.                         *)
(* Pour construire un noeud, il faut utiliser la fonction node fournie       *)
(* qui garantit les bonnes propriétés d'efficacité des bdd.                  *)
(* Pour les constantes Top et Bot, utiliser les fonctions top et bot.        *) 
type bdd = private
| Top                              (* True                                   *)
| Bot                              (* False                                  *)
| Node of bdd * Pixel.t * bdd;;    (* Décomposition de Shannon (f0, v, f1)   *)


(* Les deux constantes booléennes Bot et Top, définies respectivement        *)
(* par les variables bot et top.                                             *)
val bot : bdd;;
val top : bdd;;


(* La fonction qui permet de construire les noeuds des arbres binaires       *)
(* que sont les BDD. Elle permet également de garantir la canonicité         *)
(* de la représentation des formules logiques, ainsi que de diminuer         *)
(* l'occupation mémoire de ces structures, par rapport à l'usage naïf        *)
(* du constructeur Node.                                                     *)
(* Paramètre:                                                                *)
(* - un triplet représentant une décomposition de Shannon (voir Node).       *)
(*   La variable v doit être plus petite que toutes celles apparaissant      *)
(*   dans f0 et f1, sous peine de comportement incohérent.                   *)
(* Résultat:                                                                 *)
(* - le bdd représentant la même formule que celle obtenue avec Node,        *)
(*   mais garantissant de bonnes propriétés.                                 *)
val node : bdd * Pixel.t * bdd -> bdd;;


(* La fonction qui, à partir d'un pixel p, considére comme une variable      *)
(* propositionnelle, construit le BDD représentant la proposition 'p',       *)
(* associée conventionnellement à la phrase 'le pixel p est noir'.           *)
(* Paramètre:                                                                *)
(* - un pixel p quelconque.                                                  *)
(* Résultat:                                                                 *)
(* - le bdd 'node (bot, p, top)' représentant la proposition: 'p',           *)
(*   indiquant que p est de couleur noire.                                   *)
val posvariable : Pixel.t -> bdd;;


(* La fonction qui construit la proposition 'not p', à partir d'un pixel p,  *)
(* associée conventionnellement à la phrase 'le pixel p est blanc'.          *)
(* Paramètre:                                                                *)
(* - un pixel p quelconque.                                                  *)
(* Résultat:                                                                 *)
(* - le bdd 'node (top, p, bot)' représentant la proposition: 'not p',       *)
(*   indiquant que p est de couleur blanche.                                 *)
val negvariable : Pixel.t -> bdd;;

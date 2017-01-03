(* carre : int -> int 
 * Calcule la somme des n premiers nombres carrés, n fourni en paramètre
 * Paramètre n : la limite supérieure de l'intervalle des nombres à sommer, n>0  * Préconditions : n>0
 * Résultat : La somme des carrés des n premiers nombres
 *)

let rec carre n =
    match n with 
    | 1 -> 1
    | _ -> n*n + carre(n-1);;


(* TESTS *) 
carre(2) = 5;;
carre(5) = 55;;

(* La fonction termine :
    * n  est strictement positif et est décrémenté à chaque
    * récursivité/itération. De plus dans la fonction si n = 1, la récursivité
    * s'arrête. Donc comme n est strictement positif et est décrémenté il
    * passera forcément par le stade 1 et donc la fonction se terminera.
*)
(* La complexité est de n, il y aura n itérations *)

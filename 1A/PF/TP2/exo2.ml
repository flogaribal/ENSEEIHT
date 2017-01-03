(* factorielle : int -> int 
 * Calcule la factorielle d'un nombre fourni en paramètre en appliquant la
 * méthode fact(n)=n*fact(n-1) et fact 1
 * Paramètre n : entier naturel, n>=0
 * Précondition : n>=0
 * Résultat : factorielle du nombre fourni en paramètre
 * Postcondition : Résultat est un entier et est la factorielle de n
 *)

let rec factorielle n = 
    if n = 1 || n = 0 then 1
    else n*factorielle(n-1);;


(* TESTS *)
factorielle(5) = 120;;
factorielle(10) = 3628800;;
factorielle(3) = 6;;

(* La fonction termine :
    * n  est strictement positif et est décrémenté à chaque
    * récursivité/itération. De plus dans la fonction si n = 1, la récursivité
    * s'arrête. Donc comme n est strictement positif et est décrémenté il
    * passera forcément par le stade 1 et donc la fonction se terminera.
*)
(* La complexité est de n, il y aura n itérations *)

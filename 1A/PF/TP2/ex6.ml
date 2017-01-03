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



(* coefBinom1 : (int*int)->int
 * Calcule les coefficients binomiaux de n parmi k où n et k sont passés en
 * paramètre en utilisant l'expression
 *              (n|k) = n!/k!(n-k)!
 * Paramètre n : entier >= 0
 *           k : entier >= 0
 * Précondition : n et k >= 0 
 * Résultat : la valeur de n parmi k
 *)

let coefBinom1(n,k) = 
    factorielle n/(factorielle k*factorielle(n-k));; 


(* coefBinom2 : (int*int)->int
 * Calcule les coefficients binomiaux de n parmi k où n et k sont passés en
 * paramètre en utilisant la récurrence tel que
 *              (n+1|k+1) = (n|k)+(n|k+1)!
 * Paramètre n : entier >= 0
 *           k : entier >= 0
 * Précondition : n et k >= 0, k>=n 
 * Résultat : la valeur de n parmi k
 *)

let rec coefBinom2(n,k) = 
    match n,k with
    |0,0 -> 1
    |_,0 -> 1
    |n,k when n = k -> 1
    |_ -> coefBinom2((n-1),(k-1)) + coefBinom2((n-1),k);;


(* TESTS *)
coefBinom1(1,0) = 1;;
coefBinom1(5,3) = 10;;
coefBinom2(1,0) = 1;;
coefBinom2(5,3) = 10;;



(* COMPLEXITES *)
(* coeffBinom1 : n *)
(* coeffBinom2 : 2^n *)

(* coefBinom1 aura des problèmes de taille pour les grands nombres entiers *)
(* coefBinom2 aura des problèmes de complexité en temps pour les grands nombres entiers *)

(* inverse_ratio : (int*int) -> (int*int)
 * Calcule l'inverse d'un nombre rationnel fourni en paramètre par le couple
 * (p,q)
 * Paramètre (p,q) : le nombre rationnel p/q
 * Précondition : p <> 0 et q <> 0 
 * Résultat : le nombre (q,p) qui est l'inverse du nombre rationnel fourni en paramètre
 * Postcondition :  (q,p) est un nombre rationnel et p et q <> 0
 *)

let inverse_ratio(p,q) =
    (q,p);;

(* TESTS *)
(*inverse_ratio(1,2) = (2,1);;
inverse_ratio(4,5) = (5,4);;
inverse_ratio(1,0) = (0,1);; (* Appel ne respectant pas les préconditions *)
inverse_ratio(0,5) = (5,0);; (* Appel ne respectant pas les préconditions *)
*)

(* addition_ratio : (int*int)->(int*int) -> (int*int)
 * Additionne deux nombres rationnels fournis en paramètre par deux couples
 * (a,b) et (c,d)
 * Paramètre (a,b) : le premier rationnel à additionner, a et b <> 0
 *           (c,d) : le deuxième rationnel à additionner, c et d <> 0
 * Préconditions b et d <> 0 
 * Résultat : le nombre rationnel (p,q) résultant de la somme des deux nombres
 * rationnels fournis en paramètre
 * Postcondition : (p,q) est un nombre rationnel où p et q <> 0
 *)

let addition_ratio(a,b) (c,d) =
    (a*d+c*d,b*d);;

(* TESTS *) 

addition_ratio(1,2) (2,3) = (9,6);;
addition_ratio(2,2) (2,2) = (8,4);; 
addition_ratio(7,2) (5,1) = (12,2);;

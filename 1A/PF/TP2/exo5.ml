(* padovan : int -> int 
 * Calcule le nième terme de la suite de Padovan à savoir que 
 *      Un+3 = Un+1 + Un
 *      U2 = 1
 *      U1 = U0 = 0
 * Paramètre n : le nième terme que l'on veut calculer, n>0
 * Précondition : n>0
 * Résultat : le nième terme de la suite de Padovan
 *)

let rec padovan n = 
    match n with 
    | 0 -> 0 (* U0=0 *)
    | 1 -> 0 (* U1=0 *)
    | 2 -> 1 (* U2=1 *)
    | _ -> padovan (n-2) + padovan (n-3);;


(* TESTS *)
padovan 1 = 0;;
padovan 3 = 0;;
padovan 4 = 1;;
padovan 6 = 1;;
padovan 12 = 7;;

(* Complexité de 2^n *)

(* padovan2 : int -> int 
 * Calcule le nième terme de la suite de Padovan à savoir que 
 *      Un+3 = Un+1 + Un
 *      U2 = 1
 *      U1 = U0 = 0
 *      De plus on stocke les trois dernières valeurs connues pour améliorer la
 *      complexité 
 * Paramètre n : le nième terme que l'on veut calculer, n>=0
 * Précondition : n>=0
 * Résultat : le nième terme de la suite de Padovan
 *)

let padovan2 n =
    let rec pado_rec n n1 n2 n3 = 
        match n with 
        | 0 -> n3 
        | _ -> pado_rec (n-1) (n2+n3) n1 n2 in pado_rec n 1 0 0 ;;
               
(* TESTS *)
padovan2 1 = 0;;
padovan2 3 = 0;;
padovan2 4 = 1;;
padovan2 6 = 1;;
padovan2 12 = 7;;

(* Complexité de n *)


        


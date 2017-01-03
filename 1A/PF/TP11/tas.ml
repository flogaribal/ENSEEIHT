(* Florian Garibal 
 * 1A IMA Groupe A
 * TP11
 * Partie tas générique
 *)

open Tp11;;

type 'a tas = 'a abg;;

(* fonction creer_vide : unit -> 'a tas
 * Créer un tas vide
 * Précondition : -----
 * Postcondition : Le tas est vide
 *)
let creer_vide () = Vide;;

(* TESTS *)
let a = creer_vide();;


(* fonction estVide : 'a tas -> bool
 * Teste si le tas passé en paramètre est vide
 * Paramètre tas : le tas à tester
 * Précondition : ---------
 * Postconditions : True si le tas est vide
 *                  False sinon
 *)
let est_Vide tas = tas = Vide;; 

(* TESTS *)
est_Vide a = true;;


(* fonction fold : ('a->'b->'b)->'a tas->'b ->'b
 * Itère sur l'abre abg avec le cas de base casB et la fonction f 
 * Paramètres f : La fonction d'itération
 *          tas : Le tas surlequel on doit itérer
 *         casB : Le cas de base
 * Préconditions : ----------
 * Postconditions : -----
 *)
let rec fold f tas casB = 
        match tas with 
        |Vide -> casB
        |Noeud(fg,n,fd) -> let multi = multi_union fg fd in
                                f n (fold f multi casB);;



(* fonction cardinal : 'a tas-> int
 * Renvoi le cardinal du tas c'est à dire le nb d'éléments
 * Paramètre tas : le tas
 * Préconditions : ---------
 * Postconditions : Cardinal du tas
 *)
let cardinal tas = 
    fold (fun n nTraite -> 1+nTraite) tas 0;;

(* TESTS *)
cardinal a = 0;;
let a4 = (ajout(ajout(ajout(ajout a 1)2)5)9) ;;
cardinal a4 = 4;;
est_Vide a4 = false;;


(* Florian Garibal 
 * 1A IMA Groupe A
 * TP11
 * Partie tas générique
 *)


type 'a tas;; 


(* fonction creer_vide : unit -> 'a tas
 * Créer un tas vide
 * Précondition : -----
 * Postcondition : Le tas est vide
 *)
val creer_vide : unit -> 'a tas;;

(* fonction estVide : 'a tas -> bool
 * Teste si le tas passé en paramètre est vide
 * Paramètre tas : le tas à tester
 * Précondition : ---------
 * Postconditions : True si le tas est vide
 *                  False sinon
 *)
val est_Vide : 'a tas -> bool;;


(* fonction fold : ('a->'b->'b)->'a tas->'b ->'b
 * Itère sur l'abre abg avec le cas de base casB et la fonction f 
 * Paramètres f : La fonction d'itération
 *          tas : Le tas surlequel on doit itérer
 *         casB : Le cas de base
 * Préconditions : ----------
 * Postconditions : -----
 *)
val fold : ('a->'b->'b)->'a tas->'b ->'b;;


(* fonction cardinal : 'a tas-> int
 * Renvoi le cardinal du tas c'est à dire le nb d'éléments
 * Paramètre tas : le tas
 * Préconditions : ---------
 * Postconditions : Cardinal du tas
 *)
val cardinal : 'a tas->int;;



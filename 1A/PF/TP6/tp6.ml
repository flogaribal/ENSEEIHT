(* Florian Garibal 
 * 1A IMA Groupe A
 * TP6
 *)

(* EXERCICE 1 *)

(* insertion : ('a -> 'a -> bool)-> 'a -> 'a list -> 'a list
 * Insére l'élément e passé en paramètre dans la liste à sa place selon la
 * fonction d'ordre passé en paramètre
 * Paramètres fOrdre : Fonction qui donne l'ordre et permet la comparaison
 *                 e : L'élément à ajouter à la liste
 *             liste : La liste où l'on doit insérer l'élément
 * Précondition : liste déjà triée selon l'ordre
 * Postcondition : liste toujours triée et contenant l'élément e
 *)

let rec insertion fOrdre e liste = 
        match liste with 
            |[] -> [e]
            |t::q when fOrdre e t ->  e::t::q
            |t::q -> t::insertion fOrdre e q;;

(* TESTS *)


insertion (fun a b -> a <= b) 5 [1;2;3;4;6;9] = [1;2;3;4;5;6;9];;
insertion (fun a b -> a <= b) 1 [2;3;4;6;9] = [1;2;3;4;6;9];;
insertion (fun a b -> a <= b) 10 [2;3;4;6;9] = [2;3;4;6;9;10];;



(* EXERCICE 2 *)

(* tri : ('a -> 'a -> bool) -> 'a list -> 'a list
 * Tri la liste passée en paramètre selon la fonction d'ordre 
 * Paramètres fOrdre : Fonction qui donne l'ordre et permet la comparaison
 *             liste : La liste où l'on doit insérer l'élément
 * Précondition : ----
 * Postcondition : liste triée 
 *)
let rec tri fOrdre liste = 
    match liste with 
        |[] -> []
        |t::q -> insertion fOrdre t (tri fOrdre q);;


(* TESTS *)

tri (fun a b -> a <= b) [5;4;6;2;9;7;3;1] = [1;2;3;4;5;6;7;9];;
tri (fun a b -> a <= b) [1;2;3;4;0;9;5;6;7;8] = [0;1;2;3;4;5;6;7;8;9];;



(* EXERCICE 3 *)

(* decomposition : ('a -> bool) -> 'a liste -> ('a list * 'a list)
 * Fonction qui construit une paire de liste à partir d'une liste et d'un
 * prédicat. La première liste est composée des éléments qui satisfont le
 * prédicat la deuxième de ceux qui ne le satisfont pas
 * Paramètre predicat : Fonction
 *              liste : Liste d'élément à séparer en deux
 * Précondition : ---
 * Postcondition : Paire de liste composée d'une liste dont les éléments
 *                 satisfont le prédicat et d'une autre qui ne le satisfont pas
 *)
let rec decomposition predicat liste = 
    match liste with
        |[] -> ([],[])
        |t::q when predicat t -> let elt_vrai, elt_faux = decomposition predicat q in 
                                     (t::elt_vrai, elt_faux)
        |t::q -> let elt_vrai, elt_faux = decomposition predicat q in
                                     (elt_vrai,t::elt_faux );; 

(* TESTS *)
decomposition (fun a -> a mod 2 = 0) [1;2;3;4;5;6;7;8;9;10];;



(* EXERCICE 4 *)

(* tri_rapide : ('a -> 'a -> bool) -> 'a liste -> 'a liste
 * Fonction qui trie une liste selon l'ordre fourni en paramètre par la méthode
 * du tri rapide
 * Paramètre fOrdre : Fonction qui donne l'ordre du tri
 *            liste : Liste à trier
 * Précondition : ----
 * Postcondition : ----
 *)
let rec tri_rapide fOrdre liste = 
    match liste with 
    |[]->[]
    |t::q -> let elt_inf, elt_sup = decomposition (fun x -> fOrdre x t) q in
                              tri_rapide fOrdre elt_inf@(t::tri_rapide fOrdre elt_sup);;


(* TESTS *)
tri_rapide (fun a b -> a <= b) [5;4;6;2;9;7;3;1] (*= [1;2;3;4;5;6;7;9]*);;
tri_rapide (fun a b -> a <= b) [1;2;3;4;0;9;5;6;7;8] (*= [0;1;2;3;4;5;6;7;8;9]*);;



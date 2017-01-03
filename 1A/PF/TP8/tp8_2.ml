(* recherche : (’a -> ’a list) -> (’a -> bool) -> ’a -> ’a list *)
let recherche voisinage critere position =
        let rec cherche pos =
                if critere pos then
                        [ pos ] (* OK ! *)
                else
                        match cherche_liste (voisinage pos) with
                        | [] -> [] (* ECHEC ! *)
                        | solution -> pos :: solution
                                        and cherche_liste positions =
                                                match positions with
                                                | [] -> [] (* ECHEC ! *)
                                                | tpos::queue -> match cherche tpos with
                                                | [] -> cherche_liste queue
                                                | solution -> solution
        in cherche position;;




(* recherche_liste : (’a -> ’b list) -> ’a list -> ’b list *)
let rec recherche_liste cherche positions =
        match positions with
        | [] -> [] (* ECHEC ! *)
        | position::queue -> match (cherche position) with
                             | [] -> recherche_liste cherche queue
                             | solution -> solution (* OK ! *);;





(* recherche : (’a -> ’a list) -> (’a -> bool) -> ’a -> ’a list *)
let rec recherche voisinage critere position =
        if critere position then
                [ position ] (* OK ! *)
        else
                match recherche_liste (recherche voisinage critere) (voisinage position) with
                | [] -> [] (* ECHEC ! *)
                | solution -> position :: solution;;





(* EXERCICE 1 *)

(* TYPE ETAT *)
type position = int*int list*int list;;


let a = 70, [50;20;20;10],[];;
let b = 90, [50;20;50],[];;
let c = 100, [50;20;20;10],[];;
let d = 30, [50;20;20;10],[];;




(* EXERCICE 2 *)


(* voisinage : position -> position list
 * Renvoi l'ensemble des états voisins (que l'on peut atteindre en une
 * opération)
 * Paramètre pos : La position courante
 *)
let voisinage pos = 
        match pos with
        |(_,[],_) -> []
        |(montant,t::q,liste) -> let nouv_montant = montant-t in 
                                if nouv_montant>=0 then 
                                    [(nouv_montant,q,liste);(montant,q,liste)]
                                else 
                                    [(montant,q,t::liste)];;



(* EXERCICE 3 *)

(* Non il ne faut pas prendre en compte les cycles *)

(* La liste des pièces par lesquelles on est passé pour atteindre le montant si
 * on a réussi à l'atteindre exactement, une liste vide sinon 
 * Type : int list *)






(* EXERCICE 4 *)

(* critere : 'a -> bool 
 * Vérifie si la solution passé en paramètre est atteinte c'est à dire que le
 * montant est égal à 0
 * Paramètre montant : Le montant à tester 
 *)
let critere (montant,_,_) = 
    montant = 0;;




(* EXERCICE 5 *)

(* recherche_compl : position -> (int * int list) list
 * Renvoi l'ensemble des pièces à rendre 
 * Paramètre pos : la position initiale
 *)
let recherche_compl (montant, pieces, unused) = 
        match List.rev (recherche voisinage critere (montant, pieces, unused)) with
        |[] -> pieces
        |(_,p,q)::_ -> p@q;;

(* TESTS *)

recherche_compl a ;;
recherche_compl b ;;
recherche_compl c ;;
recherche_compl d ;;





(* EXERCICE 6 *)

(* Le résultat attendu est la liste des pièces à rendre *)
(* Une int list *)

(* EXERCICE 7 *)





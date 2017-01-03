(* Florian Garibal 
 * 1A IMA Groupe A
 * TP10
 *)

type 'a abr = Vide 
              |Noeud of 'a abr * 'a * 'a abr;;

(* fonction : 'a abr -> 'a -> bool
 * Teste l'appartenance de l'élément e à l'arbre arbre
 * Paramètre arbre : type 'a abr l'arbre à parcourir
 *               e : l'élément à rechercher
 * Préconditions : -----
 * Post conditions : True si l'élément appartient à l'arbre
 *                   False sinon
 *)
let rec appartenance arbre e = 
        match arbre with
        |Vide -> false
        |Noeud(g,n,d) -> if e=n then
                             true
                         else if e<n then 
                                appartenance g e
                              else
                                  appartenance d e;;

(* TESTS *)

let a =
    Noeud(Noeud(Noeud(Vide,0,Vide),1,Noeud(Vide,2,Vide)),3,Noeud(Noeud(Vide,5,Vide),7,Vide));;


appartenance a 0;;
appartenance a 5;;
appartenance a 3;;
appartenance a (-1);;


(* fonction : 'a arbr -> 'a -> 'a abr
 * Ajoute l'élément e à l'arbre arbre selon les règles suivantes
 *      - Si l'élément est plus grand que le noeud courant il sera ajouté au
 *      sous arbre gauche
 *      - Si il est supérieur ou égal il sera ajouté au sous arbre droit
 * Paramètre arbre : type 'a abr l'arbre à parcourir
 *               e : l'élément à ajouter
 * Préconditions : -----
 * Post conditions : L'élément e doit être ajouté selon les règles dites au
 *                  dessus
 *)
let rec ajout arbre e = 
    match arbre with 
    |Vide -> Noeud(Vide,e,Vide)
    |Noeud(g,n,d) ->  if e>=n then 
                        Noeud(g,n,ajout d e)
                      else 
                        Noeud(ajout g e,n,d);;

(* TESTS *)
ajout a 2;;

(* fonction fold : (’a -> ’b -> ’a -> ’a) -> ’b abr -> ’a -> ’a
 * Itérateur sur les arbres
 * Paramètres f : la fonction à appliquer sur les éléments de l'arbre
 *        arbre : l'arbre à parcourir
 *         casB : Le cas pour les arbres vides
 * Préconditions : ----------
 * Postconditions : Tous les éléments du nouvel arbre sont les images des
 *                  éléments de l'ancien arbre par la fonction f 
 *)
let rec fold f arbre casB =
        match arbre with
        |Vide -> casB
        |Noeud(g,n,d) -> f (fold f g casB) n (fold f d casB);;

(* TESTS *)
fold (fun sumG n sumD -> sumG+n+sumD) a 0;;

(* fonction : 'a abr -> int 
 * Calcule le cardinal de l'arbre c'est à dire le nb d'éléments dans l'arbre
 * Paramètre arbre : l'arbre à parcourir
 * Préconditions : -------
 * Postconditions : Le nombre d'éléments de l'arbre 
 *)

let cardinal arbre = 
    fold (fun cardG n cardD -> 1+cardG+cardD ) arbre 0;;

(* TESTS *)
cardinal a;;


(* fonction : 'a abr -> 'a list
 * Retourne la liste ordonné d'élément de l'arbre 
 * Paramètre arbre : l'arbre à parcourir
 * Préconditions : -------
 * Postconditions : La liste est triée 
 *)
let applatissement arbre = 
    fold (fun listG n listD -> listG@ (n::listD)) arbre [];;

(* TESTS *)

applatissement a ;;


(* fonction : 'a list -> 'a list
 * Retourne la liste ordonné d'élément en utilisant un arbre pour la trier 
 * Paramètre liste : la liste à trier
 * Préconditions : -------
 * Postconditions : La liste est triée 
 *)
let tri liste = 
    applatissement (List.fold_right (fun t arbreQ -> ajout arbreQ t) liste Vide);;


(* TESTS *)
tri [9;6;5;7;2;3;1;8;2];;


(* fonction : 'a abr -> 'a*'a abr
 * Renvoi le couple valeur minimum et l'abre privé de cette valeur 
 * Paramètre arbre : l'abre à parcourir
 * Préconditions : L'arbre ne doit pas être vide 
 * Postconditions : l'élément est l'élément minimum de l'abre passé en paramètre
 *                  l'abre est privé de l'élément
 *)
let rec retrait_min arbre = 
    match arbre with
    |Vide -> failwith("Arbre vide")
    |Noeud(Vide,n,d) -> (n,d)
    |Noeud(g,n,d) -> 
                     let min, arbr_restant = retrait_min g in 
                     (min,Noeud(arbr_restant,n,d));;
                   

(* TESTS *)

let b = Noeud(Noeud(Vide,4,Noeud(Vide,4,Vide)),5,Noeud(Vide,6,Vide));;

retrait_min b;;


(* fonction :'a abr -> 'a -> 'a abr
 * Renvoi l'arbre auquel on a retiré l'élément e
 * Paramètre arbre : L'arbre dans lequel on va retirer l'élément e
 *               e : L'élément à retirer
 * Préconditions : appartenance a e 
 * Postconditions : NOT appartenance a e
 *                  Invariant structurel toujours respecté
 *)
let rec retrait arbre e = 
        match arbre with 
        |Vide -> Vide
        |Noeud(g,n,d) when e = n -> if d <> Vide then
                                        let min_d, arbr_rest = retrait_min d in
                                            Noeud(g,min_d,arbr_rest)
                                    else
                                        g
        |Noeud(g,n,d) -> if e<n then
                            Noeud(retrait g e,n,d)
                         else 
                            Noeud(g,n,retrait d e);;

(* TESTS *)
           
retrait b 6;;
retrait b 4;;


(* fonction :'a abr -> 'a -> 'a abr
 * Renvoi l'arbre auquel on a retiré toutes les occurrences de l'élément e
 * Paramètre arbre : L'arbre dans lequel on va retirer l'élément e
 *               e : L'élément à retirer
 * Préconditions : appartenance a e 
 * Postconditions : NOT appartenance a e
 *                  Invariant structurel toujours respecté
 *)
(*
let rec retrait_all arbre e = 
        match arbre with 
        |Vide -> Vide
        |Noeud(g,n,d) when e = n -> if d <> Vide then
                                        let arbr_rest = retrait d in
                                            if arbr_rest <> Vide then
                                                let min_d, arbr = retrait_min
                                                arbr_rest in
                                                    if min_d = e then
                                                        let new_arbr = retrait_all d e in
                                                                Noeud(g,min_d,retrait_all new_arbr e)
                                                    else
                                                        Noeud(g,min_d,arbr_rest)
                                    else        
                                        g
        |Noeud(g,n,d) -> if e<n then
                            Noeud(retrait g e,n,d)
                         else 
                            Noeud(g,n,retrait d e);;
*)
(* TESTS *)
retrait_all b 4;;

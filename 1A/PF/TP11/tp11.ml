(* Florian Garibal 
 * 1A IMA Groupe A
 * TP11
 *)


type 'a abg = Vide 
             |Noeud of 'a abg * 'a * 'a abg;;



(* EXERCICE 1 *)

(* fonction : 'a abg -> int
 * Calcule la profondeur maximale d'un abg
 * Paramètre abg : l'arbre dont on doit calculer la profondeur
 * Préconditions : ----------
 * Postconditions : La profondeur maximale de l'abg
 *)
let rec profondeur abg = 
    match abg with
    |Vide -> 0
    |Noeud(fg,n,fd) -> 1+ profondeur fg;;

(* TESTS *)
let a =
    Noeud(Noeud(Noeud(Noeud(Vide,7,Vide),5,Noeud(Vide,6,Vide)),2,Vide),1,Noeud(Noeud(Vide,4,Vide),3,Noeud(Vide,5,Vide)));;

profondeur a = 4;;

(* EXERCICE 2 *)


(* fonction : 'a abg -> 'a abg -> 'a abg
 * Calcule le multi union de deux 'a abg
 * Paramètre abg1 : Le premier arbre
 *           abg2 : Le deuxième arbre
 * Préconditions : -----
 * Postconditions : Tout élément de abg1 et abg2 doivent se trouver dans l'abre
 *                  résultat
 *)
let rec multi_union abg1 abg2 =
    match abg1, abg2 with 
    |Vide,Vide -> Vide
    |Vide,Noeud(fg2,n2,fd2) -> Noeud(fg2,n2,fd2)
    |Noeud(fg1,n1,fd1), Vide -> Noeud(fg1,n1,fd1)
    |Noeud(fg1,n1,fd1),Noeud(fg2,n2,fd2) -> if n1>n2 then
                                      let multi = multi_union abg1 fd2 in
                                              if profondeur fg2 >= profondeur multi then
                                                  Noeud(fg2, n2, multi)
                                              else 
                                                  Noeud(multi,n2,fg2)

                                  else
                                      let multi = multi_union abg2 fd1 in
                                              if profondeur fg1 >= profondeur multi then
                                                  Noeud(fg1, n1, multi)
                                              else 
                                                  Noeud(multi,n1,fg1);;


(* TESTS *) 

let a1 = Noeud(Noeud(Vide,2,Vide),1,Noeud(Vide,3,Vide));;
let a2 = Noeud(Noeud(Noeud(Vide,6,Vide),5,Vide),4,Noeud(Vide,7,Vide));;

multi_union a1 a2 = Noeud(Noeud(Noeud (Noeud (Noeud (Vide, 6, Vide), 5, Vide), 4, Noeud (Vide, 7, Vide)),3, Vide),1, Noeud (Vide, 2, Vide));;



(* EXERCICE 3 *)

(* fonction : 'a abg -> 'a -> 'a abg
 * Ajoute l'élément e à l'arbre 
 * Paramètre abg : L'arbre auquel on doit ajouter l'élément e
 *             e : L'élément e à ajouter à l'abre
 * Préconditions : -----------
 * Postconditions : Il existe un élément dans l'abre = e
 *)
let rec ajout abg e = 
    multi_union (Noeud(Vide,e,Vide)) abg;; 

(* TESTS *)

let aj =
    Noeud(Noeud(Noeud(Vide,7,Vide),3,Noeud(Vide,6,Vide)),1,Noeud(Vide,4,Vide));;

ajout aj 2 =
    Noeud(Noeud(Noeud(Vide,7,Vide),3,Noeud(Vide,6,Vide)),1,Noeud(Noeud(Vide,4,Vide),2,Vide));;



(* EXERCICE 4 *)

(* fonction : 'a abg -> 'a
 * Renvoi l'élément minimum de l'arbre
 * Paramètre abg : L'arbre
 * Précondition : --------
 * Postconditions : La racine de l'abre si il n'est pas vide
 * Erreur : Arbre vide
 *)
let elt_min abg = 
    match abg with 
    |Vide -> failwith("Arbre vide")
    |Noeud(_,n,_) -> n;;

(* TESTS *)

elt_min a2 = 4;;


(* EXERCICE 5 *)

(* fonction : 'a abg -> 'a abg
 * Renvoi l'arbre amputé de son élément minimum
 * Paramètre abg : L'arbre à modifier
 * Préconditions : L'arbre ne doit pas être vide
 * Postconditions : Nb_elt = Nb_elt - 1 et l'arbre à été amputé de son minimum
 * Erreur : Arbre vide
 *)
let retrait_min abg = 
        match abg with
        |Vide -> failwith("Arbre vide")
        |Noeud(fg,n,fd) -> multi_union fg fd;;

(* TESTS *)

retrait_min a1 = Noeud (Noeud (Vide, 3, Vide), 2, Vide);;




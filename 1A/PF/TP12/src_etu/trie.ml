(* Florian Garibal 
 * 1A IMA Groupe A
 * TP12
 *)

#use "manip_chaine.ml";;


(* type 'a arbre n-aire *)
type 'a arbre_naire = Noeud of (bool * ('a * 'a arbre_naire) list);;



(* type trie
le mot est de type 'a, les "caractères" le composant de type 'b
*)
type ('a,'b) trie = 'b arbre_naire * ('a ->'b list) * ('b list -> 'a);;




(* nouveau : ('a -> 'b list) -> ('b list -> 'a) -> ('a, 'b) trie
fonction de création d'un trie
paramètres : ('a -> 'b list), la fonction de décomposition 
             ('b list -> 'a), la fonction de recomposition 
résultat   : un trie vide 
*)
let nouveau fDecomp fRecomp = (Noeud(false,[]),fDecomp,fRecomp);;  


(* rech_Branche_debutant : 'a ->  ('a * 'a arbre-naire) list -> 'a arbre-naire option
 * Renvoi la branche débutant par le caractère c
 * Paramètre c : Le caractère 
 *     list_br : La liste de branches à parcourir
 * Préconditions : ----------
 * Postconditions : Renvoi Some of abr ou None
 *)
let rec rech_branche_debutant c list_br = 
    match list_br with 
    |[] -> None
    |(n,arbr)::_ when n=c -> Some arbr
    |_::q -> rech_branche_debutant c q;;




(* maj_branche : ('a * 'a arbre-naire) ->  ('a * 'a arbre-naire) list -> ('a * 'a arbre-naire) list 
 * Met à jour la branche commençant par un caractère défini par une nouvelle
 * branche, si aucune branche ne commence par ce caractère elle est ajotuée
 * Paramètre br : La nouvelle branche commençant par le même caractère que celle
 *                recherché
 *      list_br : La liste de branches à parcourir
 * Préconditions : ----------
 * Postconditions : Renvoi la liste de branches mise à jour
 *)
let rec maj_branche (n,arbr) list_br = 
    match list_br with 
    |[] -> [(n,arbr)]
    |(k,a)::q when k=n -> (k,arbr)::q
    |(k,a)::q when k>n -> (k,a)::(maj_branche (n,arbr) q)
    |_::q -> q;;






(* retrait_branche : 'a ->  ('a * 'a arbre-naire) list -> ('a * 'a arbre-naire) list 
 * Supprimer la branche commençant par le caractère c
 * Paramètre c : Le caractère 
 *     list_br : La liste de branches à parcourir
 * Préconditions : ----------
 * Postconditions : Renvoi la liste de branche à laquelle on a supprimé la
 *                  branche commençant par c 
 *)
let rec retrait_branche c list_br = 
    match list_br with 
    |[] -> []
    |(n,_)::q when n>=c -> q
    |t::q -> t::(retrait_branche c q);;




(* appartient : 'a -> ('a, 'b) trie -> bool
fonction de test d'appartenance d'un mot au trie
paramètres : 'a, un mot
             ('a, 'b) trie, un trie 
résultat   : le résultat booléen du test
*)
let appartient e (arbr,fDecomp,fRecomp) = 
    let rec aux motDecomp arbr =
          match motDecomp,arbr with 
          |[],Noeud(b,_) -> b
          |_,Noeud(_,[]) -> false
          |t::q,Noeud(b,l) -> match rech_branche_debutant t l with
                              |None -> false
                              |Some arbr -> aux q arbr

    in aux (fDecomp e) arbr;;

                                   


(* ajout : 'a -> ('a, 'b) trie -> ('a, 'b) trie
fonction d'ajout d'un mot au trie
paramètres : 'a, un mot
             ('a, 'b) trie, un trie
résultat   : le trie avec le mot ajouté
*)
let ajout mot (abr,fDecomp,fRecomp) = 
    let rec aux motDecomp arbr=
        match motDecomp,arbr with
        |[],Noeud(_,l) -> Noeud(true,l)
        |t::q,Noeud(isValid,l) -> match rech_branche_debutant t l with
                            |None -> let newArbr = aux q (Noeud(false,[])) in 
                                        Noeud(isValid,maj_branche (t,newArbr)  l)
                            |Some a -> Noeud(isValid,maj_branche (t,aux q a) l)

    in ((aux (fDecomp mot) abr),fDecomp,fRecomp);;


(* TESTS *)

let arbr = nouveau decompose_chaine recompose_chaine in 
        let premierAjout = ajout "coucou" arbr in
                ajout "coco" premierAjout;;


(* retrait : 'a -> ('a, 'b) trie -> ('a, 'b) trie
fonction de retrait d'un mot au trie
paramètres : 'a , un mot
             ('a, 'b) trie, un trie
résultat   : le trie avec le mot retiré
*)

let retrait mot (abr,fDecomp,fRecomp) = 
    let rec aux motDecomp arbr=
        match motDecomp,arbr with
        |[],Noeud(_,l) -> Noeud(false,l)
        |t::q,Noeud(isValid,l) -> match rech_branche_debutant t l with
                            |None -> let newArbr = aux q (Noeud(false,[])) in 
                                        Noeud(isValid,maj_branche (t,newArbr)  l)
                            |Some a -> Noeud(isValid,maj_branche (t,aux q a) l)

    in ((aux (fDecomp mot) abr),fDecomp,fRecomp);;



(* normalisation : ('a,'b) trie -> ('a,'b) trie  
 * Supprime toutes les branches inutiles de l'arbre c'est à dire toutes els
 * branches qui ne mènent à aucun mot
 * Paramètre trie : Le trie a normaliser
 * Précondition : ------
 * Postconditions : Le trie ne comporte aucune branche inutile (ne menant à
 *                  aucun mot)
 *)
let normalisation (abr,fDecomp,fRecomp) = 
    let rec aux list_br = 
            match list_br with
            |[] -> []
            |(n,Noeud(isValid,l))::q -> if not isValid then 
                                           let listBR = aux l in
                                                if listBR <> [] then
                                                    (n,Noeud(isValid,listBR))::(aux q)
                                                else
                                                    aux q
                                        else 
                                            (n,Noeud(isValid,(aux l)))::(aux q)

    in let (n,listBr) = abr in 
           ((n,(aux listBr)),fDecomp,fRecomp);;


(* TESTS *)
let arbr = nouveau decompose_chaine recompose_chaine in 
        let premierAjout = ajout "coucou" arbr in
                let deuxAjout = ajout "coco" premierAjout in 
                        let retr = retrait "coco" deuxAjout in 
                                normalisation retr;;



(* affiche : ('a -> unit) -> ('a, 'b) trie -> unit
procédure d'affichage d'un trie 
paramètres : ('a -> unit), une procédure d'affichage d'un mot 
             ('a, 'b) trie, un trie 
résultat   : rien
*)


(* Florian Garibal 
 * 1A IMA Groupe A
 * TP6
 *)


(* Fonction auxiliaire 
 * inserer_devant : 'a -> 'a list list -> 'a list list 
 * Insere l'élément e devant chaque sous liste de la liste
 * Paramèter e : L'élément à insérer
 *       liste : La liste à modifier
 *)
let inserer_devant e liste = 
    List.map (fun elt -> e::elt) liste;;

(* TESTS *)
inserer_devant 8 [[1;2];[3;4];[5;6]] = [[8; 1; 2]; [8; 3; 4]; [8; 5; 6]] ;;





(* EXERCICE 1 *)

(* codeGray : int -> int list list 
 * Renvoi un code de gray à n bits où n
 * Paramètre n : la taille du code de Gray à renvoyer
 * Résultat : le code de Gray à n bits
 * Préconditions : n>=0
 *)
let rec codeGray n =
    match n with 
    |0 -> [[]]
    |_ -> let listTmp = codeGray (n-1) in
                (inserer_devant 0 listTmp)@(inserer_devant 1 (List.rev listTmp));;

(* TESTS *)
codeGray 2 = [[0; 0]; [0; 1]; [1; 1]; [1; 0]];;
codeGray 3 = [[0; 0; 0]; [0; 0; 1]; [0; 1; 1]; [0; 1; 0]; [1; 1; 0]; [1; 1; 1]; [1; 0; 1];[1; 0; 0]];;






(* EXERCICE 2 *)

(* combinaisons : 'a list -> int -> 'a list list
 * Renvoi l'ensembles des combinaisons possibles de taille k de la list passée
 * en paramètre
 * Paramètre liste : La liste à utiliser pour réaliser les combinaisons
 *               k : La taille des combinaisons à réaliser
 * Préconditions : k > 0
 *)
let rec combinaisons liste k =
    match k with 
    |0 -> [[]]
    |_ -> 
            match liste with 
            |[] -> [] 
            |t::q -> inserer_devant t (combinaisons q (k-1)) @ (combinaisons q k);;

(* TESTS *)
combinaisons [1;2;3;4] 3 = [[1; 2; 3]; [1; 2; 4]; [1; 3; 4]; [2; 3; 4]] ;;






(* EXERCICE 3 *)


(* insertions_partout : 'a -> 'a list -> 'a list list
 * Renvoie la liste des insertions à toutes les positions possibles de e dans l
 * Paramètre e : l'élément à ajouter 
 *       liste : la liste
 *)
let rec insertions_partout e liste =
        match liste with
        |[] -> [[e]]
        |t::q->(e::t::q)::(List.map (fun pq -> t::pq) (insertions_partout e q));;


(* TESTS *)
insertions_partout 0 [1;2] = [[0; 1; 2]; [1; 0; 2]; [1; 2; 0]];;


(* permutations : 'a list -> 'a list list
 * Renvoi l'ensemble des permutations possibles de la liste passée en paramètre
 * Paramètre liste : la liste
 *)
let rec permutations liste = 
    match liste with 
    |[] -> [[]]
    |t::q -> List.flatten (List.map (fun pq -> insertions_partout t pq) (permutations
    q));;

(* TESTS *)
permutations [0;1;2] = [[0; 1; 2]; [1; 0; 2]; [1; 2; 0]; [0; 2; 1]; [2; 0; 1]; [2; 1; 0]];;





(* EXERCICE 4 *)

(* partitions : int -> int list list
 * Renvoi l'ensemble des partitions possibles de n
 * Paramètre n : l'entier à partitionner
 *)

let partitions n = 
    let rec aux n k = 
        match k with 
        |p when p > n -> []
        |p when p = n -> [[p]]
        |_ -> (inserer_devant k (aux (n-k) k)) @ aux n (k+1) 
    in aux n 1;;

(* TESTS *)
partitions 4 = [[1; 1; 1; 1]; [1; 1; 2]; [1; 3]; [2; 2]; [4]];;

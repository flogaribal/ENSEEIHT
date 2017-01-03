(* Florian Garibal 
 * 1A IMA Groupe A
 * TP5
 *)


(* EXERCICE 1 *)

let pol0 = [9.0;0.0;0.0;3.0];; (* 3.0x³+9 *)
let pol1 = [3.0;2.0;4.0];;  (* 4x²+2x+3 *)
let pol2 = [1.0;5.1;4.6;9.2;8.3];;   (* 4x⁴+9.2x³+4.6x²+5.1x+1.0 *)
let pol3 = [0.0;8.0;3.0;6.4;1.2;3.5;4.9];; (*
4.9x⁶+3.5x⁵+1.2x⁴+6.4x³+3.0x²+8.0x*)
let pol4 = [];;





(* EXERCICE 2 *)


(* degree : 'a list -> int
 * Renvoi le degré du polynome passé en paramètre
 * Paramètre polynome : Liste de flottants signifiant le coefficient de chaque
 *                      puissance de x.
 *                      Ex : 4x³+1x²+3 se représente [3.0,0.0,1.0,4.0]
 * Resultat : Le degré du polynome
 * Erreur : Si le polynome fourni est le polyome nul ([]) une exception est
 *          levée
 *)
let rec degree polynome = 
    match polynome with
        |[] -> failwith("Le polynome est nul");
        |[_] -> 0
        |t::q -> 1+ (degree q);;


(* TESTS *)
degree pol1 = 2;;
degree pol2 = 4;;
degree pol3 = 6 ;;
(*degree pol4;;*)





(* EXERCICE 3 *)

(* degree : 'a list -> int -> float
 * Renvoi le coefficient de degré i du polynome fourni en paramètre
 * Paramètre polynome : Liste de flottants signifiant le coefficient de chaque
 *                      puissance de x.
 *                      Ex : 4x³+1x²+3 se représente [3.0,0.0,1.0,4.0]
 *                  i : La puissance de x dont on recherche le coefficient
 * Précondition : i > 0 
 * Resultat : Le coefficient dont la puissance de x est i si il est existe sinon
 *            0
 *)

let rec coeff polynome i = 
    match polynome with
        |[] -> 0.
        |t::_ when i=0 -> t
        |_::q -> coeff q (i-1);;


(* TESTS *)
coeff pol1 0 = 3.0;;
coeff pol2 4 = 8.3;;
coeff pol3 3 = 6.4;;
(*coeff pol4 5;;*)




(* EXERCICE 4 *)


(* monome : int -> 'a liste
 * Renvoi le monome X^n à partir du degré n fourni en paramètre
 * Ex : 3  donne [0.,0.,0.,1.0]
 * Paramètre n : le degré du monome souhaité
 * Précondition : n>=0
 * Résultat : le monome de degré n
 *)
let rec monome n =
    if n = 0 then
        [1.0]
    else 
        0.0::monome (n-1);;


(* TESTS *)
monome 3;;
monome 1;;



(* EXERCICE 5 *)

(* evaluate : 'a liste -> float -> float
 * Evalue la valeur une fonction en un point x donné en paramètre
 * Paramètre polynome : Liste de flottants signifiant le coefficient de chaque
 *                      puissance de x.
 *                      Ex : 4x³+1x²+3 se représente [3.0,0.0,1.0,4.0]
 *                  x : Réel auquel on doit évaluer la fonction
 * Préconditions : ---
 * Résultat : L'évaluation du polynome au point x
 *)
let rec evaluate polynome x =
    match polynome with
        |[] -> 0.
        |t::q -> t +. x*. evaluate q x;;


evaluate pol1 2. = 23.;;
evaluate pol0 2. = 33.;;




(* EXERCICE 6 *)

(* extend : 'a liste -> int -> 'a liste 
 * Complete le polynoe avec les coefficient nul jusqu'au degré m
 * Paramètre  polynome : Liste de flottants signifiant le coefficient de chaque
 *                       puissance de x.
 *                       Ex : 4x³+1x²+3 se représente [3.0,0.0,1.0,4.0]
 *                  m :  Entier représentant le degré jusqu'auquel on doit
 *                       compléter le polynome avec les coefficients nul
 * Précondition : m >= 0
 *                m > degre(polynome)
 * Résultat : Le polynome rempli de 0.0 jusqu'au degré m
 *)
let rec extend polynome m = 
    if m = -1 then
        polynome
    else
        match polynome with 
           |[] -> 0.::extend [] (m-1)
           |t::q -> t::extend q (m-1);;


extend pol0 5 = [9.0;0.0;0.0;3.0;0.0;0.0];;
extend pol2 9 = [1.0;5.1;4.6;9.2;8.3;0.0;0.0;0.0;0.0;0.0];;




(* EXERCICE 7 *)


(* retract : 'a liste -> 'a liste
 * Supprime les coefficients nuls dont la puissance est supérieure au terme de
 * plus haut degré
 * Paramètre listeCoeff : La liste de coefficients dans laquelle on doit
 *                        supprimer les termes nuls
 * Résultat : une liste de coefficient dont le terme de plus haut degré n'est
 *            pas nul
 *)

let rec retract listeCoeff = 
    match listeCoeff with
        |[] -> []
        | t::q when t=0. -> let a = retract q in
                                if a=[] then 
                                    []
                                else t::a
        |t::q -> t::retract q;;
       

(* TESTS *)
retract [9.0;0.0;0.0;3.0;0.0;0.0] = [9.0;0.0;0.0;3.0];;



(* EXERCICE 8 *)

(* map : ('a -> 'b) -> 'a liste -> 'a liste
 * Applique à tous les éléments de la liste "liste" la fonction f et renvoi une
 * liste des images par la fonction f
 * Paramètres f : la fonction a appliquer aux éléments de la liste
 *        liste : la liste d'éléments
 * Résultats : Liste d'éléments où a été appliqué la fonction f
 *)
let rec map f liste = 
    match liste with 
    |[] -> []
    |tete::queue -> f tete::(map f queue);;

(* TESTS *)
let f x = 2*x;;
map f [1;2;3;4;5;6;7;8;9] = [2;4;6;8;10;12;14;16;18];;

let g x = 'a';;
map g ['b';'c';'g';'t';'u';'i'] = ['a';'a';'a';'a';'a';'a'];;





(* map2 : 'a liste -> 'a liste -> ('a -> 'a -> 'a) -> 'b liste
 * Applique l'opérateur binaire passé en paramètre à un élément de la première
 * liste et un élément de la deuxième liste 
 * Paramètre liste1 : Liste 1
 *           liste2 : Liste 2
 *            opBin : Opérateur binaire à appliquer
 * Précondition : -----
 * Postcondition : Une nouvelle liste résultant de l'application de l'opérateur
 *                 binaire sur un élément de chaque liste
 *)
let rec map2 liste1 liste2 opBin = 
        match liste1,liste2 with 
             |[],[] -> []
             |[], t::q -> (opBin 0. t)::map2 [] q opBin
             |t::q, [] -> (opBin t 0.)::map2 q [] opBin
             |t1::q1, t2::q2 ->  (opBin t1 t2)::map2 q1 q2 opBin;;

(* TESTS *)

map2 [1.;2.;3.;4.] [5.;6.;7.;8.] (fun a b -> a+.b) = [6.;8.;10.;12.];;
map2 [1.;2.;3.;4.] [5.;6.;7.;8.;9.] (fun a b -> a+.b) = [6.;8.;10.;12.;9.];;
map2 [] [5.;6.;7.;8.] (fun a b -> a+.b) = [5.;6.;7.;8.];;
map2 [1.;2.;3.;4.] [] (fun a b -> a+.b) = [1.;2.;3.;4.];;



(* EXERCICE 9 *)


(* scal_mult : 'a list -> int -> 'a list
 * Multiplie un polynome par un scalaire
 * Paramètre polynome : Liste de flottants signifiant le coefficient de chaque
 *                      puissance de x.
 *                      Ex : 4x³+1x²+3 se représente [3.0,0.0,1.0,4.0]
 *                  k : Scalaire
 * Précondition : ----
 * Postcondition : Polynome multiplié par le scalaire k
 *)
let scal_mult polynome k = 
    map (fun x -> x*.k) polynome;;


(* TESTS *)
scal_mult pol0 2.;;





(* EXERCICE 10 *)

(* plus : 'a list -> 'a list -> 'a list
 * Additionne les deux polynomes
 * Paramètres poly1 : polynome 1
 *            poly2 : polynome 2
 * Précondition : Les deux polynomes doivent être du même degre maximal
 * Postcondition : La somme des deux polynomes en ayant comme terme du plus haut
 *                 degré un terme non nul
 *)
let plus poly1 poly2 = 
    retract(map2 poly1 poly2 (fun a b -> a+.b));;

(* minus : 'a list -> 'a list -> 'a list
 * Soustrait le polynome 1 au polynome 2
 * Paramètres poly1 : polynome 1
 *            poly2 : polynome 2
 * Précondition : Les deux polynomes doivent être du même degre maximal
 * Postcondition : La soustraction des deux polynomes en ayant comme terme du plus haut
 *                 degré un terme non nul
 *)
let minus poly1 poly2 = 
    retract(map2 poly1 poly2 (fun a b -> a-.b));;



(* TESTS *)

plus [1.;2.;3.] [5.;4.;6.];;
plus [1.] [5.;4.;6.];;

minus [1.;2.;3.] [5.;4.;6.];;
minus [1.] [5.;4.;6.];;




(* EXERCICE 11 *)




(* mult : 'a list -> 'a list -> 'a list
 * Multiplie le polynome 1 avec le polynome 2
 * Paramètres poly1 : polynome 1
 *            poly2 : polynome 2
 * Précondition : Les deux polynomes doivent être du même degre maximal
 * Postcondition : La multiplication des deux polynomes en ayant comme terme du plus haut
 *                 degré un terme non nul
 *)
let rec mult poly1 poly2 =
    match poly1 with
       |[]->[]
       |t::q -> plus (scal_mult poly2 t) (mult q(0.0::poly2));;

(* TESTS *)

mult [2.;1.0] [3.;1.0];;




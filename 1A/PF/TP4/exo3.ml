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

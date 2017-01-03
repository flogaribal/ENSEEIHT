(* pgcd : int->int->int
 * Calcule le pgcd de deux nombres fournis en paramètre en utilisant la méthode
 * d'euclide à savoir : pgcd(a,a) = a
 *                      pgcd(a,b) = |pgcd(a-b,b) si a>b
 *                                  |pgcd(a,b-a) si a<b
 * Paramètre a : entier > 0
 *           b : entier > 0 
 * Précondition : a et b > 0
 * Résultat : le pgcd de a et de b par la méthode d'euclide
 *)

let rec pgcd a b = 
    if a = b then a
    else
        if a>b then pgcd(a-b) b
        else pgcd a (b-a);;
            

 (* TESTS *) 
 pgcd 25 5 = 5;;
 pgcd 30 6 = 6;;
 pgcd 4 27 = 1;;

(* pgcd_relatif : int->int->int
 * Calcule le pgcd de deux nombres relatifs non nuls. Si un des deux nombres est
 * négatif on utilise sa valeur absolue pour calculer le pgcd
 * Paramètre a : entier <> 0
 *           b : entier <> 0 
 * Préconditions : a et b <> 0 
 * Résultats le pgcd de deux nombres entiers relatifs non nuls
 *)

let pgcd_relatif a b = 
    let abs x = if x<0 then -x else x in pgcd (abs a) (abs b) ;;

(* TESTS *) 
 pgcd_relatif (-25) 5 = 5;;
 pgcd_relatif 30 (-6) = 6;;
 pgcd_relatif (-4) 27 = 1;; 


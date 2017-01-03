(* EXO 7 *)
(* Parcours de tous les diviseurs du nombre demandé, si la liste des diviseurs
 * (modulo égal à 0) est composée que de 1 et de lui même alors le nombre est premier sinon il ne
 * l'est pas 
 *)


(* zero : (float->float)->(float*float)->float->float
 * Calcule le zéro d'une fonction continue sur intervalle [a,b] à e près
 * Paramètre f : la fonction à analyser
 *       (a,b) : borne inférieure et borne supérieure de l'intervalle
 *           e : précision souhaitée
 * Précondition : b>a
 *                f continue sur [a;b]
 *                f(a)*f(b)<0
 * Résultat : la valeur du 0 pour la fonction f
 *            type float
 *            a <= r <= b, Quelque soit x [r-e;r+e], f(x)=0
 *)
let rec zero f (a,b) e = 
    let milieu = (a+.b)/.2. in 
        if (b-.a)<e then 
           milieu
        else 
            if f a*.(f milieu)<0. then 
                zero f (a,milieu) e
            else 
                zero f (milieu,b) e;;
(* TESTS *)
let f x = x+.3.;;
let g x = x*.x*.x+.4.;;

zero f ((-5.),5.) 0.00001;;
zero g ((-10.),10.) 0.0001;;



(* racine_nieme : float->float->(float*float)->float->float
 * Calcule la racine nieme du nombre y sur l(intervalle [a,b] avec la
 * precision e
 * Paramètre y : le nombre dont on cherche la racine nieme
 *           n : le nombre de la racine
 *       (a,b) : l'intervalle de recherche
 *           e : la précision de la racine
 * Préconditions : 
 *           b>a
 *           f continue sur [a,b]
 *           f(a)*f(b)<0
 * Résultat : la racine de la fonction f sur l'intervalle 0
 *)
 let racine_nieme y n (a,b) e =
     let fct x = x**n-.y in 
         zero fct (a,b) e;;

(* TESTS *)
racine_nieme 2. 3. ((-5.),5.) 0.001;; 



(* inverse : (float->float)->(float*float)->float
 * Calcule la fonction inverse de la fonction f sur l'intervalle [a,b]
 * Paramètre f : la fonction
 *           x : la valeur dont on doit trouver l'inverse
 *       (a,b) : l'intervalle de calcul
 * Préconditions : 
 *           b>a
 *           f continue sur [a,b]
 *           f(a)*f(b)<0
 * Résultat : la fonction inverse de la fonction fournie en paramètre
 *)
 let inverse f x (a,b) =
     



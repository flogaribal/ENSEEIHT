open Bdd_base;;
open Pixel;;
open Memo;;

(* ************************************************************************* *)
(* FONCTIONS AVANCEES SUR LES BDD                                            *)
(* ************************************************************************* *)

(* conjonction : bdd -> bdd -> bdd;;					     *)
(* La fonction qui calcule la conjonction de deux BDD.                       *)
(* Paramètres:                                                               *)
(* - deux BDD quelconques.                                                   *)
(* Résultat:                                                                 *)
(* - le bdd représentant la conjonction.                                     *)
 
let conjonct_table = Memo.create();;

let rec conjonction_code bdd1 bdd2 = 
	
	match bdd1, bdd2 with
	|Bot, _ -> bot   (* Si l'un des deux bdd est égal à Bot alors la conjonction *)
	|_, Bot -> bot   (* des deux vaut Bot 					     *)
	|Top, _ -> bdd2  (* Si l'un des deux bdd est égal à Top alors la conjonction *)
	|_,Top -> bdd1   (* des deux dépend de l'autre membre *)
	|Node(f0,pix,f1), Node(g0,pix1,g1) -> (* Si les pixels des deux arbres sont égaux on fait une conjonction de leur sous arbres respectifs *)
						if pix = pix1 then  
						  node (conjonction f0 g0,pix,conjonction f1 g1)
		  			        else (* Sinon on fait la conjonction du sous arbre gauche avec un bdd comportant le pix et deux sous 
							arbre égaux à bdd2 et de même pour le sous arbre droit *)
					    	  node (conjonction f0 bdd2, pix, conjonction f1 bdd2)

and conjonction bdd1 bdd2 = Memo.apply conjonct_table conjonction_code bdd1 bdd2;;

(* TESTS *)

    (* Cas de base *)		     
conjonction bot bot = bot;;
conjonction top bot = bot;;
conjonction bot top = bot;;
let bdd = node (top, make 1 1, top) in
        conjonction top bdd = bdd;;
let bdd = node (top, make 1 1, top) in
        conjonction bdd top = bdd;;

    (* Cas de deux différent de top et bot *)

	(* Cas de deux bdd comportant aucun pixel commun *)

let bdd1 = node (bot,(make 1 2), top) in
	let bdd2 = node (bot,(make 1 3), top) in
		let bdd_result = node(bot,(make 1 2),node(bot,(make 1 3),top)) in      
			conjonction bdd1 bdd2 = bdd_result;;

	(* Cas de deux bdd comportant au moins un pixel commun *)
let bdd1 = node (node (bot,(make 1 3),top),(make 1 2), top) in
	let bdd2 = node (bot,(make 1 2), node (bot,(make 1 3),top)) in
		let bdd_result = node(bot,(make 1 2),node(bot,(make 1 3),top)) in
			conjonction bdd1 bdd2 = bdd_result;;

        


(* substitution : (Pixel.t * Pixel.couleur) list -> bdd -> bdd;;	     *)
(* La fonction qui calcule la substitution de variables par Top ou Bot       *)
(* dans un BDD. Permet de prendre en compte l'effet d'un pixel découvert     *)
(* dans les configurations possibles.                                        *)
(* Paramètres:                                                               *)
(* - une liste de paires (pixel, couleur) représentant les variables         *)
(*   à substituer. La couleur permet de savoir par quoi il faut substituer.  *)
(* - un bdd représentant un ensemble de configurations de pixels.            *)
(* Résultat:                                                                 *)
(* - le bdd représentant la substitution des variables par Top               *)
(*   si la couleur associée est Noir, ou par Bot si la couleur est Blanc.    *)

let substi_table = Memo.create();;

let rec substitution_code listPaire bdd =
	(* Parcours de la liste de paire *) 
	match listPaire with
	|[] -> bdd	(* Si liste vide on renvoi le bdd modifié *)
	|(pix,couleur)::q -> (* Fonction auxiliaire qui permet de parcourir le bdd pour trouver le pixel recherché  *)
			     let rec aux bdd (pix,coul) = 
					match bdd with
					|Top -> top
					|Bot -> bot
					|Node(f0,(pix1),f1) ->  if pix = pix1 then(* Si pixel trouvé *)
								     if coul = Blanc then  (* Si couleur blanc -> on renvoit le chemin direct au 
											      sous arbre gauche  *)
								  	    f0
								     else		   (* Si couleur noir -> on renvoit le chemin au sous arbre droit *)
									    f1	
							      	 else
								 (* Si pixel non trouvé -> application aux deux fils*)
								     (*   SOUS NOEUD BLANC        PIX      SOUS NOEUD NOIR  *)
								      node (aux f0 (pix,coul),(pix1) ,aux f1 (pix,coul))
                             in substitution q (aux bdd (pix,couleur))

and substitution listPaire bdd = Memo.apply2 substi_table substitution_code listPaire bdd;;

(* TESTS *)
    (* Cas de base *)
substitution [] (node (bot,(make 1 2),top)) = (node (bot,(make 1 2),top));;

    (* Cas comportant qu'un seul pixel dans l'arbre *)
substitution [((make 1 2),Noir)] (node (bot,(make 1 2),top)) = top;;

    (* Cas d'un bdd de 4 pixels avec un pixel à substituer *)
let bdd_depart = node (node (bot,(make 1 2),top),(make 1 1),node (bot,(make 1 3),node (bot,(make 1 4), top))) in
	let bdd_result = node (node (bot,(make 1 2),top),(make 1 1),node (bot,(make 1 4),top)) in 
		substitution [((make 1 3),Noir)] bdd_depart = bdd_result;;


let bdd_depart = node (node (bot,(make 1 2),top),(make 1 1),node (bot,(make 1 3),node (bot,(make 1 4), top))) in
	let bdd_result = node (node (bot,(make 1 2),top),(make 1 1),bot) in 
		substitution [((make 1 3),Blanc)] bdd_depart = bdd_result;;

    (* Cas d'un bdd de 4 pixels avec deux pixels à substituer *)
let bdd_depart = node (node (bot,(make 1 2),top),(make 1 1),node (bot,(make 1 3),node (bot,(make 1 4), top))) in
	let bdd_result = node (top,(make 1 1),node (bot,(make 1 3), bot)) in 
		substitution [((make 1 2),Noir);((make 1 4),Blanc)] bdd_depart = bdd_result;;
	


			

(* depuis_indication : int list -> Pixel.t list -> bdd;;		     *)
(* La fonction qui calcule un bdd représentant les combinaisons de pixels    *)
(* noirs, tirés dans un ensemble, à partir d'une indication.                 *)
(* Paramètres:                                                               *)
(* - une liste d'entiers [k_1;...;k_n], éventuellement vide, avec k_i > 0,   *)
(*   représentant les nombres de pixels noirs consécutifs à choisir.         *)
(* - une liste l de pixels, triée par ordre croissant, dans laquelle         *)
(*   on choisit les pixels noirs.                                            *)
(* Résultat:                                                                 *)
(* - le bdd représentant toutes les combinaisons possibles de pixels         *)
(*   de couleur noire dans l.                                                *)

let depuis_indication_table = Memo.create();;

let rec depuis_indication_code listInd listPixel = 
   
    match listInd,listPixel with 
    |[],[] | [0],[] -> top
    |_::_,[] -> bot
    |[],t::q -> node((depuis_indication [] q),t,bot)
    |currInd::qInd, t::q -> if currInd <> 0 then
                                node((depuis_indication listInd q), t, (depuis_indication ((currInd-1)::qInd) q))
                            else 
                                node((depuis_indication qInd q),t,bot)


and depuis_indication listInd listPixel = Memo.apply2 depuis_indication_table depuis_indication_code listInd listPixel;;



(* TESTS *)

depuis_indication [] [] = top;;
depuis_indication [] [] = top;;

let bdd = node(bot,(make 1 2),node(node(bot,(make 1 4),top),(make 1 3),bot)) in
        depuis_indication [1;1] [(make 1 2);(make 1 3);(make 1 4)] = bdd;;

let bdd1 = node (node (node (node (node (top,(make 1 6),bot),(make 1 5),bot),(make 1 4),bot),(make 1 3),bot),(make 1 2),bot) in
        depuis_indication [] [(make 1 2);(make 1 3);(make 1 4);(make 1 5);(make 1 6)] = bdd1;;

let bdd2 = node (bot,(make 1 1), node (bot,(make 1 2),node (node (bot,(make 1 4),top),(make 1 3), bot))) in
	depuis_indication [2;1] [(make 1 1);(make 1 2);(make 1 3);(make 1 4)] = bdd2;;


(* ************************************************************************* *)
(* TYPES + FONCTIONS GENERALES SUR LES CONFIGURATIONS                        *)
(* ************************************************************************* *)


(* Le type abstrait dont les valeurs représentent un ensemble                *)
(* de configurations du picross.                                             *)
(* Le type des configurations doit contenir:                                 *)
(* un bdd décrivant les couleurs possibles des pixels du dessin              *)
(* + toute autre information jugée nécessaire...                             *)
type configurations = bdd*int*int;;

(* indication : Pixel.couleur list -> int list;; 			     *)
(* Fonction qui calcule une indication de ligne/colonne en fonction          *)
(* de la liste de (couleurs de) pixels correspondante.                       *)
(* Paramètre:                                                                *)
(* - une ligne ou colonne de pixels sur laquelle calculer l'indication       *)
(* Résultat:                                                                 *)
(* - une indication, liste éventuellement vide d'entiers > 0                 *)

let indication liste =
	(* Parcours de la liste de couleur pixels *)
	(* La variable acc permet de compter le nombre de noir consécutifs *)
	let rec aux acc coulList = 
		match coulList with 
		|[] -> if acc <> 0 then 
                          [acc] 
                       else
                          []
		|Noir::q -> aux (acc+1) q
		|Blanc::q -> if acc <> 0 then
				acc::(aux 0 q)
		             else 
				aux 0 q
  	in aux 0 liste;;


(* TESTS *)
indication [Noir;Noir;Blanc;Noir;Blanc;Noir;Noir;Noir;Blanc;Blanc] = [2;1;3];;
indication [Blanc;Noir;Noir;Blanc;Noir;Blanc;Noir;Noir;Noir;Blanc;Blanc] = [2;1;3];;
indication [Noir;Noir;Blanc;Noir;Blanc;Noir;Noir;Noir;Blanc;Blanc;Noir] = [2;1;3;1];;
indication [Noir;Noir;Noir;Noir;Noir;Noir;Noir] = [7];;
indication [] = [];;


(* selection : Pixel.t * Pixel.couleur -> configurations -> configurations;; *)
(* Fonction qui force la couleur d'un pixel dans les configurations, let bdd2 = node (bot,(make 1 2), top) in
	let bdd3 = node (bot,(make 1 3), top) in
		let bdd_result = node(node(bot,(make 1 3),top),(make 1 2),node(bot,(make 1 3),top)) in
			conjonction bdd2 bdd3 = bdd_result;;        *)
(* réduisant leur nombre. Ce pixel ne sera plus ambigu (voir ambiguite).     *)
(* Paramètre:                                                                *)
(* - un paire (pixel, couleur)                                               *)
(* Résultat:                                                                 *)
(* - les configurations restantes où le pixel choisi a la bonne couleur      *)
let selection (pix,couleur) (bdd,nbPixelsFixes,taille) = 
    ((substitution [(pix,couleur)] bdd),nbPixelsFixes+1,taille);;


(* TESTS *)
    (* Cas comportant qu'un seul pixel dans l'arbre *)
selection ((make 1 2),Noir) ((node (bot,(make 1 2),top)),0,1) = (top,1, 1);;

    (* Cas d'un bdd de 4 pixels avec un pixel à substituer *)
let bdd_depart = node (node (bot,(make 1 2),top),(make 1 1),node (bot,(make 1 3),node (bot,(make 1 4), top))) in
	let bdd_result = node (node (bot,(make 1 2),top),(make 1 1),node (bot,(make 1 4),top)) in 
                selection ((make 1 3),Noir) (bdd_depart,0,4)  = (bdd_result,1, 4);;


let bdd_depart = node (node (bot,(make 1 2),top),(make 1 1),node (bot,(make 1 3),node (bot,(make 1 4), top))) in
	let bdd_result = node (node (bot,(make 1 2),top),(make 1 1),bot) in 
                selection ((make 1 3),Blanc) (bdd_depart,2,4) = (bdd_result,3,4);;

	

(* initialisation : (int list * Pixel.t list) list -> configurations;; 	     *)
(* La fonction qui calcule les configurations initiales possibles            *)
(* en fonction des indications de chaque ligne/colonne.                      *)
(* Paramètre:                                                                *)
(* - une liste de paires (indication, ligne/colonne de pixels)               *)
(* Résultat:                                                                 *)
(* - les configurations initiales possibles.                                 *)
let initialisation liste =
    match liste with 
    |[] -> failwith("Liste vide")
    |(_,pixList)::_ ->
        let nbPixels = List.length pixList in
                let configs = (List.fold_right (fun (intList,pixList) qt -> (conjonction (depuis_indication intList pixList) qt)) liste top) in 
                        (configs,0,nbPixels);; 	



(* singleton : configurations -> bool;;					     *)
(* Fonction qui teste si un ensemble de configurations est réduit à un seul  *)
(* élément. Teste la non-ambiguïté dans les configurations possibles, i.e.   *)
(* tous les pixels ont une couleur unique dans toutes les configurations.    *)
(* Paramètres:                                                               *)
(* - un ensemble de configurations possibles                                 *)
(* Résultat:                                                                 *)
(* - le booléen indiquant s'il y a une seule configuration possible, ou non  *)
let singleton (bdd,nbPixelsFixes,taille) = 
	let rec aux bdd  = 
		match bdd with
		|Top -> 1
		|Bot -> 0
		|Node(f0,pix,f1) -> (aux f0) + (aux f1)
        in (aux bdd) = 1;;


(* TESTS *)

let bdd_depart = node (node (bot,(make 1 2),top),(make 1 1),node (bot,(make 1 3),node (bot,(make 1 4), top))) in
        singleton (bdd_depart,[],4) = false;;

let bdd_depart = node (node (bot,(make 1 2),top),(make 1 1),node (bot,(make 1 3),node (bot,(make 1 4), bot))) in
        singleton (bdd_depart,[],4) = true;;






(* ambiguite : configurations -> Pixel.t;;				     *)
(* Fonction qui calcule une ambiguïté dans les configurations possibles,     *)
(* i.e. renvoie un pixel qui n'a pas de polarité, i.e. pas de couleur unique *)
(* dans toutes les configurations.                                           *)
(* Paramètres:                                                               *)
(* - un ensemble de configurations possibles ambiguës                        *)
(* Résultat:                                                                 *)
(* - un pixel ambigu                                                         *)
(* Erreur:                                                                   *)
(* - exception levée s'il n'y a pas de pixel ambigu, i.e. l'ensemble         *)
(*   des configurations est réduit à un élément                              *)
let rec ambiguite (bdd,nbPixelsFixes,taille) =
        
        match bdd with
        |Bot | Top -> failwith("Aucun pixel ambigu")
        |Node(Bot,pix,Top) -> failwith("Aucun pixel ambigu")
        |Node(Top,pix,Bot)-> failwith("Aucun pixel ambigu")
        |Node(Bot,pix,f0) -> ambiguite (f0,nbPixelsFixes,taille)
        |Node(f0,pix,Bot) -> ambiguite (f0,nbPixelsFixes,taille)
        |Node(Top,pix,_) -> pix
        |Node(_,pix,Top) -> pix
        |Node(fo,pix,f1) -> pix;;

(* TESTS *)
  
    (* Cas où le pixel ambigu est la racine du bdd *)


let bdd_depart = node (posvariable (make 1 2), (make 1 1), posvariable (make 1 3)) in
	ambiguite (bdd_depart,2,2) = make 1 1 ;;


let bdd_depart = node (node (bot,(make 1 2),top),(make 1 1),node (bot,(make 1 3),node (bot,(make 1 4), top))) in
	ambiguite  (bdd_depart,2,2) = (make 1 1);;

 



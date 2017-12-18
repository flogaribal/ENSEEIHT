let l1 = [2;3;4;5;6;1;7;8;9;-10;2];;
let l2 = [(1,2);(3,5);(1,5);(9,1);(1,6)];;


(* MINIMUM DE LISTE SANS ITERATEUR *)
let rec aux_min liste min = 
	match liste with 
	| [] -> min 
 	| t::q -> if t < min then
 					t
 			  else
 			  		aux_min q min;;	


let min liste = 
	match liste with 
	| [] -> -1
	| t::q -> aux_min q t;;

		
(* MINIMUM DE LISTE AVEC ITERATEUR *)

let min a b = 
	if a<b then
		a 
	else 
		b;;

let min_fold liste = 
	List.fold_right (fun currElt minimumPrecedent -> min currElt minimumPrecedent) (List.tl liste) (List.hd liste);;



(* COMPTE LE NOMBRE DE COUPLE AYANT LE MEME PREMIER ELEMENT QUE L'ARGUMENT FOURNI *)


let rec countNbTuples_aux listeTuples pattern acc = 
	match listeTuples with 
	| [] -> acc
	| (a,b)::q -> if a = pattern then 
						countNbTuples_aux q pattern (acc+1)
				  else
				  		countNbTuples_aux q pattern (acc);;

let countNbTuples listeTuples pattern = 
	match listeTuples with 
	| [] -> 0 
	| t::q -> countNbTuples_aux (t::q) pattern 0;;

let countNbTuples_iter listeTuples pattern = 
	List.fold_left (fun acc (a,b) -> if a = pattern then acc+1 else acc ) 0 listeTuples;;

(* __________________ CREATION DE GRAPH __________________*)

open Graph.Pack.Digraph;;

let graph_1 = Graph.Pack.Digraph.create();;
let s1 		= V.create(1);;
let s2 		= V.create(2);;
let s3 		= V.create(3);;
let s4 		= V.create(4);;


(* SOMMETS *)
add_vertex graph_1 s1;; 
add_vertex graph_1 s2;;
add_vertex graph_1 s3;;
add_vertex graph_1 s4;;

(* ARETES *)
add_edge graph_1 s1 s2;;
add_edge graph_1 s2 s3;;
add_edge graph_1 s3 s1;;

dot_output graph_1 "test_non_oriente.dot";;


open Graph.Pack.Digraph;;

let graph_2 = Graph.Pack.Digraph.create ();;

(* SOMMETS *)
Graph.Pack.Digraph.add_vertex graph_2 s1;; 
Graph.Pack.Digraph.add_vertex graph_2 s2;;
Graph.Pack.Digraph.add_vertex graph_2 s3;;
Graph.Pack.Digraph.add_vertex graph_2 s4;;

(* ARCS *)
Graph.Pack.Digraph.add_edge graph_2 s1 s2 ;;
Graph.Pack.Digraph.add_edge graph_2 s1 s3 ;;
Graph.Pack.Digraph.add_edge graph_2 s3 s1 ;;
Graph.Pack.Digraph.add_edge graph_2 s3 s2 ;;

Graph.Pack.Digraph.dot_output graph_2 "test_oriente.dot";;
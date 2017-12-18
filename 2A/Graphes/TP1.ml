(* Question a) *) 

	(* Vérif tous les sommets sont cochés *)
	let are_all_vertices_marked graph =
		fold_vertex (fun currVertex oldResult ->  oldResult && ((Mark.get currVertex) = 1)) graph true;;

	(* Récupère un sommet du graph *)
	let get_1_sommet graph = 
		List.hd (fold_vertex (fun currVertex oldListe ->   currVertex::oldListe) graph []);;	

	let rec est_connexe_aux graph listeSucc =
		match listeSucc with 
		|[] -> ()
		|t::q -> 	if ((Mark.get t) != 1) then 
						begin
							(Mark.set t 1); 
							(est_connexe_aux graph ((succ graph t)@q)) 
						end
					else 
						(est_connexe_aux graph q);;	



	let est_connexe graph = 
		let firstVertex = (get_1_sommet graph) in
			Mark.set firstVertex 1;
			est_connexe_aux graph (succ graph firstVertex); 
			are_all_vertices_marked graph;;



(* Question b) *) 
	let est_degre_pair vertex graph =
		(out_degree graph vertex) mod 2 = 0;;

(* Question c) *) 
	let est_eulerien graph = 
		(est_connexe graph) && (fold_vertex (fun currVertex oldResult -> oldResult && (est_degre_pair currVertex graph)) graph true);;
	 	
	let est_semi_eulerien graph = 	
		(est_connexe graph) && ((fold_vertex (fun currVertex nbSommetsImpair -> if not (est_degre_pair currVertex graph) then nbSommetsImpair + 1 else nbSommetsImpair) graph 0) = 2);;


(* TP2 *)

(* get_cycle_eulérien *)

	let concat_path path1 path2 = 
		let rec concat_path_aux path1 path2 final_path= 
			let hd2 = List.hd path2 in
				match path1 with 
				| [] -> final_path
				| t::q ->  if t = hd2 then
								(* Si cycle eulérien 2 fois le même élément *)
						   		final_path@(path2@q)
						   else
								concat_path_aux q path2 (final_path@[t])
		in concat_path_aux path1 path2 [];;





	let get_chemin_eulerien graph = 
		let cpy_graph = copy graph in 
			let depart = get_1_sommet graph in 

				let rec get_chemin_eulerien_aux currVertex graph chemin =
					let succcessors = succ graph currVertex in
						match succcessors with 
						|[] -> chemin
						|t::q -> remove_edge graph currVertex t;
	  						     get_chemin_eulerien_aux t graph chemin@[t]

				in get_chemin_eulerien_aux depart cpy_graph [];;
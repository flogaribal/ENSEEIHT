(* -------------------Fonction Print -------------------*)

(* affiche_v : t -> unit *)
(* affiche les aretes d'un graphe *)
let affiche_edges g =
begin
	iter_edges (fun v1 v2-> (Format.printf "%i, %i " (Graph.V.label v1) (Graph.V.label v2))) g;
	Format.printf "\n"
end
;;

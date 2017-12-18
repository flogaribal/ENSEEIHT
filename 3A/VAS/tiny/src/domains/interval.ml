(* Template to write your own non relational abstract domain. *)

(* To implement your own non relational abstract domain,
 * first give the type of its elements, *)
type t = Bot | Itv of int option * int option


(* Extension de <= `a Z U {-oo}. *)
let leq_minf x y = 	match x, y with
										| None, _ 				-> true (* -oo <= y *)
										| _, None 				-> false (* x > -oo (x != -oo) *)
										| Some x, Some y 	-> x <= y

(* Extension de <= `a Z U {+oo}. *)
let leq_pinf x y = 	match x, y with
										| _, None 				-> true (* x <= +oo *)
										| None, _ 				-> false (* +oo > y (y != +oo) *)
										| Some x, Some y 	-> x <= y

let mk_itv o1 o2 = 	match o1, o2 with
										| None, _ | _, None -> Itv (o1, o2)
										| Some n1, Some n2 	-> 	if n1 > n2 then 
																							Bot 
																						else 
																							Itv (o1, o2)


(* a printing function (useful for debuging), *)
let fprint ff = function
							  | Bot 	 										-> Format.fprintf ff "Bottom"
							  | Itv (None),(None) 				-> Format.fprintf ff "]-00 ; +00["
							  | Itv (None),(Some i1) 			-> Format.fprintf ff "]-00 ; %i]" i1
							  | Itv (Some i1),(None) 			-> Format.fprintf ff "]%i ; +00[" i1
							  | Itv (Some i1),(Some i2) 	-> Format.fprintf ff "[%i ; %i]" i1 i2

(* the order of the lattice. *)
let order x y = match x, y with
								| Bot, _ 										-> true
								| _, Bot 		 								-> false
								| _, Itv (None, None)				-> true
								| Itv (x1, y1), Itv (x2,y2)	-> (leq_minf x2 x1) && (leq_pinf y1 y2) 

(* 

								| Itv (None, None), _					-> false

								| Itv (Some i1, None), Itv (Some i2, None) -> i1 >= i2
								| Itv (None, Some i1), Itv (Some i2, None) -> false
								
								| Itv (Some i1, None), Itv (None, Some i2) -> false
								| Itv (None, Some i1), Itv (None, Some i2) -> i1 <= i2
								
								| Itv (None, Some i1), Itv (Some i2, Some i3) -> false
								| Itv (Some i1, None), Itv (Some i2, Some i3) -> false

								| Itv (Some i1, Some i2), Itv (None, Some i3) -> i2 <= i3
								| Itv (Some i1, Some i2), Itv (Some i3, None) -> i1 >= i3
								
								| Itv (Some i1, Some i2), Itv (Some i3, Some i4) -> i1 >= i3 && i2 <= i4 *)


(* and infimums of the lattice. *)
let top = ()
let bottom = Bot

(* All the functions below are safe overapproximations.
 * You can keep them as this in a first implementation,
 * then refine them only when you need it to improve
 * the precision of your analyses. *)

let join x y = 	match x, y with
								| Bot, _ 										-> Bot
								| _, Bot 		 								-> Bot
								| _, Itv (None, None)				-> mk_itv None None
								| Itv (None, None), _				-> mk_itv None None
								| Itv (x1, y1), Itv (x2,y2)	-> 	match (leq_minf x2 x1), (leq_pinf y1 y2) with
																								| true, true		-> mk_itv x2 y2 
																								| true, false 	-> mk_itv x2 y1
																								| false, true		-> mk_itv x1 y2
																								| false, false 	-> mk_itv x1 y1



let meet x y = 	match x, y with
								| Bot, _ 										-> Bot
								| _, Bot 		 								-> Bot
								| _, Itv (None, None)				-> mk_itv None None
								| Itv (None, None), _				-> mk_itv None None
								| Itv (x1, y1), Itv (x2,y2)	-> 	match (leq_minf x2 x1), (leq_pinf y1 y2) with
																								| true, true		-> mk_itv x1 y1 
																								| true, false 	-> mk_itv x1 y2
																								| false, true		-> mk_itv x2 y1
																								| false, false 	-> mk_itv x2 y2


let widening = join  (* Ok, maybe you'll need to implement this one if your
                      * lattice has infinite ascending chains and you want
                      * your analyses to terminate. *)

let sem_itv n1 n2 = mk_itv n1 n2

let sem_plus x y = 	match x, y with
										| Bot, _ 	-> Bot
										| _, Bot 	-> Bot
										| Itv (None, None), _						-> mk_itv None None
										| Itv (None, _), Itv (_, None) 	-> mk_itv None None
										| Itv (_, None), Itv (None, _) 	-> mk_itv None None

										| Itv (Some i1, None), Itv (Some i2, _) -> mk_itv (Some (i1+i2)) None
										
										| Itv (None, Some i1), Itv (_, Some i2) -> mk_itv None (Some (i1+i2)) 
										
										| Itv (_, Some i2), Itv (None, Some i3) -> mk_itv None (Some (i2+i3)) 
										| Itv (Some i1, _), Itv (Some i3, None) -> mk_itv (Some (i1+i3)) None
										
										| Itv (Some i1, Some i2), Itv (Some i3, Some i4) -> mk_itv (Some (i1+i3)) (Some (i2+i4))


(* Inverser les bornes tel que [a,b] - [c,d] = [a,b] + (-[c,d]) = [a,b] + [-d,-c] *)
let sem_minus x y = match y with
										| Bot 							-> Bot
										| Itv (None, None)	-> mk_itv None None
										| Itv (None, y) 		-> sem_plus x (mk_itv y None)
										| Itv (x, None) 		-> sem_plus x (mk_itv None x)

										| Itv (Some i1, None), Itv (Some i2, _) -> mk_itv (Some (i1+i2)) None
										
										| Itv (None, Some i1), Itv (_, Some i2) -> mk_itv None (Some (i1+i2)) 
										
										| Itv (_, Some i2), Itv (None, Some i3) -> mk_itv None (Some (i2+i3)) 
										| Itv (Some i1, _), Itv (Some i3, None) -> mk_itv (Some (i1+i3)) None
										
										| Itv (Some i1, Some i2), Itv (Some i3, Some i4) -> mk_itv (Some (i1+i3)) (Some (i2+i4))



let sem_times x y = top
let sem_div x y = top

let sem_guard x = meet x (Itv (Some 1, None))

let backsem_plus x y r = (meet x (sem_minus r y))
let backsem_minus x y r = x, y
let backsem_times x y r = x, y
let backsem_div x y r = x, y

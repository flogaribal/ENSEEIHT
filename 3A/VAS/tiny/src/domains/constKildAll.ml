(* Template to write your own non relational abstract domain. *)

(* To implement your own non relational abstract domain,
 * first give the type of its elements, *)
type t = Top | Int of InfInt.t | Bottom

(* a printing function (useful for debuging), *)
let fprint ff = function
							  | Top 			-> Format.fprintf ff "Top"
							  | Bottom		-> Format.fprintf ff "Bottom"
							  | Int value -> Format.fprintf ff "%s" (InfInt.to_string value)


(* the order of the lattice. *)
let order x y = match x,y with
								| Int i1, Int i2	-> InfInt.eq i1 i2
								| Bottom, _ 			-> true
								| _, Top 					-> true
								| _, Bottom 			-> false
								| Top, _ 					-> false
								| _ -> false


(* and infimums of the lattice. *)
let top = Top

let bottom = Bottom

(* All the functions below are safe overapproximations.
 * You can keep them as this in a first implementation,
 * then refine them only when you need it to improve
 * the precision of your analyses. *)

let join x y = 	match (order x y),(order y x) with
								| true, false 	-> y 
								| false, true 	-> x  
								| false, false	-> Top
								| true, true 		-> x

let meet x y = 	match (order x y),(order y x) with
								| true, false 	-> x 
								| false, true 	-> y  
								| false, false	-> Bottom
								| true, true 		-> x

let widening = join  (* Ok, maybe you'll need to implement this one if your
                      * lattice has infinite ascending chains and you want
                      * your analyses to terminate. *)

let sem_itv n1 n2 = if n1 > n2 then
											Bottom
										else if n1 == n2 then
											Int (InfInt.fin n1)
										else 
											Top

let sem_plus x y =	match x,y with
										| Bottom, _ 			-> Bottom
										| _, Bottom 			-> Bottom
										| Top, _ 					-> Top
										| _, Top 					-> Top
										| Int i1, Int i2 	-> Int (InfInt.add_lb i1 i2)


let sem_minus x y = match x,y with
										| Bottom, _ 			-> Bottom
										| _, Bottom 			-> Bottom
										| Top, Top 				-> Top
										| Top, Int i1 		-> if (InfInt.eq i1 (InfInt.fin 0)) then Int (InfInt.fin 0) else Top
										| Int i1, Top			-> if (InfInt.eq i1 (InfInt.fin 0)) then Int (InfInt.fin 0) else Top
										| Int i1, Int i2 	-> Int (InfInt.sub_lb i1 i2)

let sem_times x y = match x,y with
										| Bottom, _ 			-> Bottom
										| _, Bottom 			-> Bottom
										| Top, Top 				-> Top
										| Top, Int i1			-> if (InfInt.eq i1 (InfInt.fin 0)) then Int (InfInt.fin 0) else Top
										| Int i1, Top			-> if (InfInt.eq i1 (InfInt.fin 0)) then Int (InfInt.fin 0) else Top
										| Int i1, Int i2 	-> 	if (not (InfInt.eq i2 (InfInt.fin 0))) then 
																						Int (InfInt.mul_lb i1 i2)
																					else 
																						Bottom

let sem_div x y = match x,y with
										| Bottom, _ 			-> Bottom
										| _, Bottom 			-> Bottom
										| Top, Top				-> Top
										| Top, Int i1			-> if (InfInt.eq i1 (InfInt.fin 0)) then Bottom else Top
										| Int i1, Top			-> if (InfInt.eq i1 (InfInt.fin 0)) then Int (InfInt.fin 0) else Top
										| Int i1, Int i2 	-> 	if (InfInt.eq i2 (InfInt.fin 0)) then
																						Bottom 
																					else 
																						Int (InfInt.div_lb i1 i2)

let sem_guard = function
							  | Top 		-> Top
							  | Bottom 	-> Bottom 
							  | Int i1 	-> 	if (not (InfInt.order i1 (InfInt.fin 0))) then
							  								Int i1
							  							else
							  								Bottom

let backsem_plus x y r = x, y
let backsem_minus x y r = x, y
let backsem_times x y r = x, y
let backsem_div x y r = x, y

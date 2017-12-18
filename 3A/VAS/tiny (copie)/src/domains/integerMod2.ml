(* Template to write your own non relational abstract domain. *)

(* To implement your own non relational abstract domain,
 * first give the type of its elements, *)
type t = Pair | Impair | Top | Bottom

(* a printing function (useful for debuging), *)
let fprint ff = function
							  | Top 		-> Format.fprintf ff "Top"
							  | Bottom 	-> Format.fprintf ff "Bottom"
							  | Pair 		-> Format.fprintf ff "Pair"
							  | Impair 	-> Format.fprintf ff "Impair"

(* the order of the lattice. *)
let order x y =	match x, y with
								| Bottom, _ 			-> true
								| _, Bottom 			-> false
								| Top, _ 					-> false
								| _, Top 					-> true
								| Pair, Pair 			-> true
								| Impair, Impair 	-> true 
  							| _, _						-> false 

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

let sem_itv n1 n2 = if (n1 == n2) then 
											if (n1 mod 2 == 0)then 
												Pair
											else 
												Impair
										else
											Top


let sem_plus x y = 	match x,y with
										| Bottom, _ 			-> Bottom
										| _, Bottom 			-> Bottom
										| Top, _ 					-> Top
										| _, Top 					-> Top
										| Pair, Pair 			-> Pair
										| Impair, Impair 	-> Pair
										| Pair, Impair 		-> Impair
										| Impair, Pair 		-> Impair


let sem_minus x y = match x,y with
										| Bottom, _ 			-> Bottom
										| _, Bottom 			-> Bottom
										| Top, _ 					-> Top
										| _, Top 					-> Top
										| Pair, Pair 			-> Pair
										| Impair, Impair 	-> Pair
										| Pair, Impair 		-> Impair
										| Impair, Pair 		-> Impair


let sem_times x y = match x,y with
										| Bottom, _ 			-> Bottom
										| _, Bottom 			-> Bottom
										| Top, _ 					-> Top
										| _, Top 					-> Top
										| Impair, Impair 	-> Impair
										| Pair, Impair 		-> Impair
										| Impair, Pair 		-> Impair
										| _ 							-> Pair


let sem_div x y = match x,y with
									| Bottom, _ 			-> Bottom
									| _, Bottom 			-> Bottom
									| Top, _ 					-> Top
									| _, Top 					-> Top
									| _							 	-> Top

let sem_guard = function
 								| Top 		-> Top
							  | Bottom 	-> Bottom 
							  | Pair 	 	-> Pair
							  | Impair 	-> Impair

let backsem_plus x y r = x, y
let backsem_minus x y r = x, y
let backsem_times x y r = x, y
let backsem_div x y r = x, y

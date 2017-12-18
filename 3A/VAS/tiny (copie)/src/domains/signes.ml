(******************************************************************************)
(*                                                                            *)
(* Domaine des signes :                                                       *)
(*                                                                            *)
(*       STop                                                                 *)
(*      / | \                                                                 *)
(*     /  |  \                                                                *)
(*    /  SN0  \                                                               *)
(* SLe0 /   \ SGe0                                                            *)
(*   |\/     \/|                                                              *)
(*   |/\     /\|                                                              *)
(* SLt0 \   / SGt0                                                            *)
(*    \  SE0  /                                                               *)
(*     \  |  /                                                                *)
(*      \ | /                                                                 *)
(*       SBot                                                                 *)
(*                                                                            *)
(* avec pour fonction de concrétisation gamma :                               *)
(* STop |-> Z                                                                 *)
(* SN0  |-> { n \in Z | n /= 0 }                                              *)
(* SLe0 |-> { n \in Z | n <= 0 }                                              *)
(* SGe0 |-> { n \in Z | n >= 0 }                                              *)
(* SLt0 |-> { n \in Z | n < 0 }                                               *)
(* SGt0 |-> { n \in Z | n > 0 }                                               *)
(* SE0  |-> { 0 }                                                             *)
(* SBot |-> \emptyset                                                         *)
(*                                                                            *)
(******************************************************************************)

(* Le treillis est un produit de 3 treillis à deux valeurs, i.e. des booléens *)
(* Chaque booléen représente une direction différente dans ce treillis,       *)
(* en partant de Bot. Tout élément abstrait est défini par un triplet         *)
(* de booléens (tn, t0, tp) qui représentent respectivement:                  *)
(* tn: la présence des nombres négatifs dans la concrétisation                *)
(* t0: la présence du nombre 0 dans la concrétisation                         *)
(* tp: la présence des nombres positifs dans la concrétisation                *)
type t = bool * bool * bool


(******************************************************************************)
(* CHANGEZ LA TAILLE DES TAB A 2 POUR UNE MEILLEURE LECTURE *)
(******************************************************************************)


let fprint ff t = Format.fprintf ff "%s"
  (match t with
    | (false, false, false) -> "⊥"
    | (true, false, false)  -> "< 0"
    | (true, true, false)   -> "<= 0"
    | (false, true, false)  -> "= 0"
    | (false, true, true)   -> ">= 0"
    | (false, false, true)  -> "> 0"
    | (true, false, true)   -> "!= 0"
    | (true, true, true)    -> "⊤")

let order x y = match x, y with
                | (false, false, false), _  -> true
                | _, (false, false, false)  -> false

                | _, (true, true, true)     -> true
                | (true, true, true), _     -> false

                (*      <= 0                    < 0          *)
                | (true, true, false), (true, false, false) -> false

                (*      <= 0                    = 0          *)
                | (true, true, false), (false, true, false) -> false

                (*      != 0                    < 0          *)
                | (true, false, true), (true, false, false) -> false 

                (*      != 0                    > 0          *)
                | (true, false, true), (false, false, true) -> false 

                (*      >= 0                    = 0          *)
                | (false, true, true), (false, true, false) -> false 

                (*      >= 0                    > 0          *)
                | (false, true, true), (false, false, true) -> false 




                (*      < 0                    <= 0          *)
                | (true, false, false), (true, true, false) -> true

                (*      = 0                    <= 0          *)
                | (false, true, false), (true, true, false) -> true

                (*      < 0                    != 0          *)
                | (true, false, false), (true, false, true) -> true 

                (*      > 0                    != 0          *)
                | (false, false, true), (true, false, true) -> true 

                (*      = 0                    >= 0          *)
                | (false, true, false), (false, true, true) -> true 

                (*      > 0                    >= 0          *)
                | (false, false, true), (false, true, true) -> true 


                | _ -> false

let top     = (true, true, true)
let bottom  = (false, false, false)

(* borne supérieure : plus petit des majorants de {x, y} *)
let join x y =  match x, y with
                | (false, false, false), x  -> x
                | x, (false, false, false)  -> x

                | _, (true, true, true)     -> top
                | (true, true, true), _     -> top

                (* FACTORISATION POSSIBLE PAR top *)
                (* ____________________ <= 0 ________________ *)
                (*      <= 0                    > 0          *)
                | (true, true, false), (false, false, true) -> top

                (*      <= 0                    != 0          *)
                | (true, true, false), (true, false, true)  -> top

                (*      <= 0                    >= 0          *)
                | (true, true, false), (false, true, true)  -> top

                (*      <= 0                    <= 0 / < 0 / = 0          *)
                | (true, true, false), _                    -> (true, true, false)


                (* ____________________ >= 0 _______________ *)

                (*      >= 0                    < 0          *)
                | (false, true, true), (true, false, false) -> top

                (*      >= 0                    != 0          *)
                | (false, true, true), (true, false, true)  -> top

                (*      >= 0                    <= 0          *)
                | (false, true, true), (true, true, false)  -> top

                (*      >= 0                    >= 0 / = 0 / > 0           *)
                | (false, true, true), _                    -> (false, true, true)



                (* ____________________ != 0 _______________ *)
                (*      != 0                    = 0          *)
                | (true, false, true), (false, true, false) -> top 

                (*      != 0                    >= 0          *)
                | (true, false, true), (false, true, true)  -> top 

                (*      != 0                    <= 0          *)
                | (true, false, true), (true, true, false)  -> top 

                (*      != 0                    != 0 / < 0 / > 0          *)
                | (true, false, true), _                    -> (true, false, true) 


                (* ____________________ = 0 _______________ *)
                (*      = 0                    != 0          *)
                | (false, true, false), (true, false, true)   -> top

                (*      = 0                    = 0          *)
                | (false, true, false), (false, true, false)  -> (false, true, false) 
                
                (*      = 0                    < 0 / <= 0          *)
                | (false, true, false), (true, _, false)      -> (true,true,false)

                (*      = 0                    > 0 / >= 0         *)
                | (false, true, false), (false, _, true)      -> (false,true,true)
                
                
                (* ____________________ < 0 _______________ *)
                (*      < 0                    >= 0          *)
                | (true, false, false), (false, true, true)   -> top
                
                (*      < 0                    < 0          *)
                | (true, false, false), (true, false, false)  -> (true, false, false)

                (*      < 0                    != 0 / > 0          *)
                | (true, false, false), (_, false, true)      -> (true, false, true)

                (*      < 0                    = 0 / <= 0      *)
                | (true, false, false), (_, true, false)      -> (true, true, false)
                

                (* ____________________ > 0 _______________ *)
                (*      > 0                    <= 0          *)
                | (false, false, true), (true, true, false)   -> top               

                (*      > 0                    > 0          *)
                | (false, false, true), (false, false, true)  -> (false, false, true) 

                (*      > 0                    >= 0 / = 0          *)
                | (false, false, true), (false, true, _)      -> (false, true, true)

                (*      > 0                    < 0 / != 0          *)
                | (false, false, true), (true, false, _)      -> (true, false, true) 


                (*  TOUS LES CAS POSSIBLES AVANT "FACTORISATION" *)
                (* (*      <= 0                    <= 0          *)
                | (true, true, false), (true, true, false) -> (true, true, false)
                (*      <= 0                    < 0          *)
                | (true, true, false), (true, false, false) -> (true, true, false)
                (*      <= 0                    = 0          *)
                | (true, true, false), (false, true, false) -> (true, true, false) *)



                (* (*      >= 0                    >= 0          *)
                | (false, true, true), (false, true, true) -> (false, true, true)

                (*      >= 0                    = 0          *)
                | (false, true, true), (false, true, false) -> (false, true, true) 

                (*      >= 0                    > 0          *)
                | (false, true, true), (false, false, true) -> (false, true, true) *)



                (* (*      != 0                    != 0          *)
                | (true, false, true), (true, false, true) -> (true, false, true) 

                (*      != 0                    < 0          *)
                | (true, false, true), (true, false, false) -> (true, false, true) 

                (*      != 0                    > 0          *)
                | (true, false, true), (false, false, true) -> (true, false, true)  *)



                (* (*      = 0                    < 0          *)
                | (false, true, false), (true, false, false) -> (true,true,false)

                (*      = 0                    <= 0          *)
                | (false, true, false), (true, true, false) ->  (true, true, false) *)

                (* (*      = 0                    > 0          *)
                | (false, true, false), (false, false, true) -> (false,true,true)

                (*      = 0                    >= 0          *)
                | (false, true, false), (false, true, true) ->  (false, true, true) *)



                (* (*      < 0                    != 0          *)
                | (true, false, false), (true, false, true) -> (true, false, true)

                (*      < 0                    > 0          *)
                | (true, false, false), (false, false, true) -> (true, false, true) *)

                (* (*      < 0                    = 0          *)
                | (true, false, false), (false, true, false) -> (true, true, false)

                (*      < 0                    <= 0          *)
                | (true, false, false), (true, true, false) -> (true, true, false) *)


                (* (*      > 0                    >= 0          *)
                | (false, false, true), (false, true, true) -> (false, true, true) 

                (*      > 0                    = 0          *)
                | (false, false, true), (false, true, false) -> (false, true, true)  *)

                (* (*      > 0                    < 0          *)
                | (false, false, true), (true, false, false) -> (true, false, true) 

                (*      > 0                    != 0          *)
                | (false, false, true), (true, false, true) -> (true, false, true)  *)













(* borne supérieure : plus grand des minorants de {x, y} *)
let meet x y =  match x, y with
                | (false, false, false), _  -> (false,false,false)
                | _, (false, false, false)  -> (false,false,false)

                | x, (true, true, true)     -> x
                | (true, true, true), x     -> x


                (* FACTORISATION POSSIBLE PAR bottom *)
                (* ____________________ <= 0 ________________ *)
                (*      <= 0                    > 0          *)
                | (true, true, false), (false, false, true) -> bottom

                (*      <= 0                    <= 0          *)
                | (true, true, false), (true, true, false) -> (true, true, false)

                (*      <= 0                    < 0 / != 0          *)
                | (true, true, false), (true, false, _)     -> (true, false, false)

                (*      <= 0                    = 0 / >= 0         *)
                | (true, true, false), (false, true, _)     -> (false, true, false)



                (* ____________________ >= 0 _______________ *)

                (*      >= 0                    < 0          *)
                | (false, true, true), (true, false, false) -> bottom

                (*      >= 0                    >= 0          *)
                | (false, true, true), (false, true, true)  ->  (false, true, true)

                (*      >= 0                    != 0 / > 0          *)
                | (false, true, true), (_, false, true)  -> (false, false, true) 

                (*      >= 0                    = 0 / <= 0         *)
                | (false, true, true), (_, true, false)     -> (false, true, false)


                (* ____________________ != 0 _______________ *)
                (*      != 0                    = 0          *)
                | (true, false, true), (false, true, false) -> bottom

                (*      != 0                    != 0          *)
                | (true, false, true), (true, false, true)  -> (true, false, true)

                (*      != 0                    < 0 / <= 0          *)
                | (true, false, true), (true, _, false)     -> (true, false, false)

                (*      != 0                    > 0 / >= 0          *)
                | (true, false, true), (false, _, true) -> (false, false, true)


                (* ____________________ = 0 _______________ *)
                (*      = 0                    != 0          *)
                | (false, true, false), (true, false, true)   -> bottom

                (*      = 0                    < 0          *)
                | (false, true, false), (true, false, false)  -> bottom 

                (*      = 0                    > 0          *)
                | (false, true, false), (false, false, true)  -> bottom

                (*      = 0                    = 0          *)
                | (false, true, false), (false, true, false)  -> (false, true, false)

                (*      = 0                    <= 0          *)
                | (false, true, false), (true, true, false)   -> (false, true, false)

                (*      = 0                    >= 0          *)
                | (false, true, false), (false, true, true)   ->  (false, true, false)
                
                
                (* ____________________ < 0 _______________ *)
                (*      < 0                    >= 0          *)
                | (true, false, false), (false, true, true)   -> bottom

                (*      < 0                    > 0          *)
                | (true, false, false), (false, false, true) -> bottom

                (*      < 0                    = 0          *)
                | (true, false, false), (false, true, false) -> bottom
                
                (*      < 0                    < 0          *)
                | (true, false, false), (true, false, false)  -> (true, false, false)

                (*      < 0                    != 0          *)
                | (true, false, false), (true, false, true)   -> (true, false, false)

                (*      < 0                    <= 0          *)
                | (true, false, false), (true, true, false) -> (true, false, false)
                

                (* ____________________ > 0 _______________ *)
                (*      > 0                    <= 0          *)
                | (false, false, true), (true, true, false)   -> bottom             

                (*      > 0                    = 0          *)
                | (false, false, true), (false, true, false)  -> bottom

                (*      > 0                    < 0          *)
                | (false, false, true), (true, false, false)  -> bottom 

                (*      > 0                    > 0          *)
                | (false, false, true), (false, false, true)  -> (false, false, true)

                (*      > 0                    >= 0          *)
                | (false, false, true), (false, true, true)   -> (false, false, true)

                (*      > 0                    != 0          *)
                | (false, false, true), (true, false, true)   -> (false, false, true) 


(* Le treillis n'a pas de chaine strictement croissante infinie,
 * donc il suffit d'utiliser l'union comme élargissement. *)
let widening = join

let sem_itv n1 n2 =
  if n1 == n2 then
    match n1 with
    | x when x < 0  -> (true, false, false)        (* < 0 *)
    | x when x > 0  -> (false, false, true)        (* > 0 *)
    | 0             -> (false,true,false)          (* = 0 *)
    | _             -> bottom

  else
    let x = min n1 n2 in
      let y = max n1 n2 in 
        match x,y with 
        | 0,x when x > 0          -> (false, true, true)   (* >= 0 *)
        | x,0 when x < 0          -> (true, true, false)   (* <= 0 *)
        | x,y when x < 0 && y > 0 -> (true, false, true)   (* != 0 *)
        | x,y when x < 0 && y < 0 -> (true, false, false)  (* < 0  *)
        | x,y when x > 0 && y > 0 -> (false, false, true)  (* > 0  *)
        | _                       -> bottom 




(* ================================= ADDITION =================================== *)
let sem_plus x y =  match x, y with
                    | (true,true,true), _                       -> top
                    | _ , (true,true,true)                      -> top
                    | (false,false,false), _                    -> bottom
                    | _, (false,false,false)                    -> bottom

                    (* Positif + positif ou nul = positif (et inversement) *)
                    | (false, true, true), (false, false, true) -> (false,false,true)
                    | (false, false, true), (false, true, true) -> (false,false,true)

                    (* Positif + Positif = Positif *)
                    | (false,false,true), (false,false,true)    -> (false,false,true)

                    (* Nul + nul = Nul *)
                    | (false,true,false), (false,true,false)    -> (false, true, false)

                    (* Egal à zéro + Positif = Positif *)
                    | (false, true, false), (false, false, true)-> (false,false,true)
                    | (false, false, true), (false, true, false)-> (false,false,true)

                    (* Egal à zéro + Négatif = Négatif *)
                    | (false, true, false), (true, false, false)-> (true,false,false)
                    | (true, false, false), (false, true, false)-> (true,false,false)

                    (* Impossible de définir les résultats où <= 0, >=0  et != 0 *)
                    | _                                         -> top  

                  

(* ================================= SOUSTRACTION =================================== *)
let sem_minus x y = match x, y with
                    | (true,true,true), _                       -> top
                    | _ , (true,true,true)                      -> top
                    | (false,false,false), _                    -> bottom
                    | _, (false,false,false)                    -> bottom

                    (* Négatif - Positif ou nul = Négatif *)
                    | (true, false, false), (false, true, true) -> (true,false,false)

                    (* Négatif - Positif = Négatif *)
                    | (true, false, false), (false, false, true) -> (true,false,false)

                    (* Négatif - Nul = Nul (et inversement) *)
                    | (true, false, false), (false, true, false) -> (true,false,false)                    

                    (* Nul - Négatif = positif  *)
                    | (false, true, false), (true, false, false) -> (false,false,true)                    

                    (* Nul - Positif = Négatif  *)
                    | (false, true, false), (false, false, true) -> (true,false,false)                    

                    (* Nul - nul = Nul *)
                    | (false,true,false), (false,true,false)     -> (false, true, false)

                    (* Impossible de définir les résultats où <= 0, >=0  *)
                    | _                                         -> top  
(* ================================= MULTIPLICATION =================================== *)
let sem_times x y = match x, y with
                    | (true,true,true), _                         -> top
                    | _ , (true,true,true)                        -> top
                    | (false,false,false), _                      -> bottom
                    | _, (false,false,false)                      -> bottom

                    (* Nimporte quoi * 0 = 0 et inversement *)
                    | _, (false,true,false)                       -> (false, true, false)
                    | (false,true,false), _                       -> (false, true, false)

                    (* Différent de 0 * Différent de 0 = Différent de 0 *)
                    |  (true, false, true), (true, false, true)   -> (true, false, true)

                    (* Différent de 0 * tout sauf 0 = Différent de 0 *)
                    |  (true, false, true), _                     -> (true, false, true) 

                    (* Positif * positif = Positif *)
                    | (false, false, true), (false, false, true)  -> (false,false,true)

                    (* Négatif*Négatif = Positif *)
                    | (true, false, false), (true, false, false)  -> (true,false,false)

                    (* Positif * Négatif = Négatif (et inversement) *)
                    | (false, false, true), (true, false, false)  -> (true, false, false)
                    | (true, false, false), (false, false, true)  -> (true, false, false)



                    (* Impossible de définir les résultats où <= 0, >=0  *)
                    | _                                           -> top  


(* ================================= DIVISION =================================== *)
let sem_div x y = match x, y with
                  | (false,false,false), _                      -> bottom
                  | _, (false,false,false)                      -> bottom

                  (* N'importe quoi par zéro = Bottom *)
                  | _, (false, true, false)                     -> bottom 

                  (* Négatif/Négatif = Négatif *)
                  | (true, false,false), (true,false,false)     -> (true,false,false)

                  (* Positif/Positif = Positif *)
                  | (false, false, true), (false, false, true)  -> (false, false, true)

                  (* Négatif / Positif = Négatif (et inversement) *)
                  | (true, false, false), (false, false, true)  -> (true, false, false)
                  | (false, false, true), (true, false, false)  -> (true, false, false)
                  
                  | _                                           -> top                            


(* ================================= GARDE =================================== *)
let sem_guard t = match t with
                  | (false, false, true)  -> (false, false, true)   (* > 0 *)
                  | _                     -> bottom                 (* < 0, <= 0, != 0, = 0, >= 0 *)

let backsem_plus x y r =  match x, y, r with
                          | (false,false,false), _ , _ | _, (false,false,false), _ | _, _ , (false,false,false) -> bottom,bottom
                          | (true,true,true), (true,true,true), _ | _,_,(true,true,true)                        -> x, y
                          | _                                                                                   -> x,y

let backsem_minus x y r = match x, y, r with
                          | (false,false,false), _ , _ | _, (false,false,false), _ | _, _ , (false,false,false) -> bottom,bottom
                          | (true,true,true), (true,true,true), _ | _,_,(true,true,true)                        -> x, y
                          | _                                                                                   -> x,y

let backsem_times x y r = match x, y, r with
                          | (false,false,false), _ , _ | _, (false,false,false), _ | _, _ , (false,false,false) -> bottom,bottom
                          | (true,true,true), (true,true,true), _ | _,_,(true,true,true)                        -> x, y
                          | _                                                                                   -> x,y

let backsem_div x y r = match x, y, r with
                        | (false,false,false), _ , _ | _, (false,false,false), _ | _, _ , (false,false,false) -> bottom,bottom
                        | (true,true,true), (true,true,true), _ | _,_,(true,true,true)                        -> x, y
                        | _                                                                                   -> x,y

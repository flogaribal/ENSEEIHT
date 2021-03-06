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

let fprint ff t = Format.fprintf ff "%s"
  (match t with
    | (false, false, false) -> "⊥"
    (* À compléter en affichant les bons éléments du treillis       *)
    (* ...                                                          *)
    | (true, true, true)    -> "⊤")

let order x y = match x, y with
  (* À compléter avec l'ordre correspondant au diagramme ci dessus. *)
  (* ...                                                            *)
  | _ -> false

let top = (true, true, true)
let bottom = (false, false, false)

(* borne supérieure : plus petit des majorants de {x, y} *)
let join x y = match x, y with
  (* À compléter. *)
  (* ...          *)
  | _             -> assert false

(* borne supérieure : plus grand des minorants de {x, y} *)
let meet x y = match x, y with
  (* À compléter. *)
  (* ...          *)
  | _             -> assert false

(* Le treillis n'a pas de chaine strictement croissante infinie,
 * donc il suffit d'utiliser l'union comme élargissement. *)
let widening = join

let sem_itv n1 n2 =
  assert false  (* À faire. *)

let sem_plus x y = match x, y with
  (* À compléter. *)
  (* ...          *)
  | _             -> assert false

let sem_minus x y = match x, y with
  (* À compléter. *)
  (* ...          *)
  | _            -> assert false

let sem_times x y = match x, y with
  (* À compléter. *)
  (* ...          *)
  | _            -> assert false

let sem_div x y = match x, y with
  (* À compléter. *)
  (* ...          *)
  | _            -> assert false

let sem_guard t = match t with
  (* À compléter. *)
  (* ...          *)
  | _            -> assert false

let backsem_plus x y r = match x, y, r with
  (* À compléter. *)
  (* ...          *)
  | _            -> (x, y)

let backsem_minus x y r = match x, y, r with
  (* À compléter. *)
  (* ...          *)
  | _            -> (x, y)

let backsem_times x y r = match x, y, r with
  (* À compléter. *)
  (* ...          *)
  | _            -> (x, y)

let backsem_div x y r = match x, y, r with
  (* À compléter. *)
  (* ...          *)
  | _            -> (x, y)

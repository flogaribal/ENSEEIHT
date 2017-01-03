(* This file is generated by Why3's Coq driver *)
(* Beware! Only edit allowed sections below    *)
Require Import BuiltIn.
Require BuiltIn.
Require int.Int.

(* Why3 assumption *)
Definition unit := unit.

Axiom qtmark : Type.
Parameter qtmark_WhyType : WhyType qtmark.
Existing Instance qtmark_WhyType.

Parameter fact: Z -> Z.

Axiom fact0 : ((fact 0%Z) = 1%Z).

Axiom factn : forall (n:Z), (1%Z <= n)%Z ->
  ((fact n) = (n * (fact (n - 1%Z)%Z))%Z).

(* Why3 assumption *)
Inductive ref (a:Type) :=
  | mk_ref : a -> ref a.
Axiom ref_WhyType : forall (a:Type) {a_WT:WhyType a}, WhyType (ref a).
Existing Instance ref_WhyType.
Implicit Arguments mk_ref [[a]].

(* Why3 assumption *)
Definition contents {a:Type} {a_WT:WhyType a} (v:(ref a)): a :=
  match v with
  | (mk_ref x) => x
  end.

(* Why3 goal *)
Theorem WP_parameter_factorielle : forall (n:Z), (0%Z <= n)%Z -> forall (r:Z)
  (i:Z), ((r = (fact i)) /\ ((0%Z <= i)%Z /\ (i <= n)%Z)) -> ((i < n)%Z ->
  forall (i1:Z), (i1 = (i + 1%Z)%Z) -> forall (r1:Z), (r1 = (i1 * r)%Z) ->
  ((r1 = (fact i1)) /\ ((0%Z <= i1)%Z /\ (i1 <= n)%Z))).
(* Why3 intros n h1 r i (h2,(h3,h4)) h5 i1 h6 r1 h7. *)
intros n h1 r i (h2,(h3,h4)) h5 i1 h6 r1 h7.
intuition.
rewrite factn.
rewrite h7.
rewrite h6.
rewrite h2.
cut (i= i +1-1)%Z.
intros .
rewrite <- H.
trivial.
intuition.
omega.

Qed.

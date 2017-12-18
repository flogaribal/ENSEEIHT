---------------- MODULE allocateur1 ----------------
\* Time-stamp: <30 mar 2016 10:24 queinnec@enseeiht.fr>

(* Version concrète de l'allocation de ressources. *)

EXTENDS Naturals

CONSTANT
   M,    \* nbre de ressources
   N     \* nbre de processus

VARIABLES
  nbDispo,
  demande,
  satisfait

vars == << nbDispo, demande, satisfait >>

TypeInvariant ==
  [] (/\ nbDispo \in 0..M
      /\ demande \in [ 0..N-1 -> 0..M ]
      /\ satisfait \in [ 0..N-1 -> BOOLEAN ])

(* Calcule la somme des demandes pour les processus contenus dans S *)
SommeDemande[S \in SUBSET (0..N-1) ] ==
  IF S = {} THEN 0
  ELSE LET e == CHOOSE x \in S : TRUE
       IN demande[e] + SommeDemande[S \ {e}]

setSatisfait == 
    { i \in DOMAIN satisfait : satisfait[i] }


(* XXXX Autres propriétés temporelles de sûreté ??? *)
Surete == SommeDemande[setSatisfait] + nbDispo = M

(* XXXX Autres propriétés temporelles de vivacité ??? *)
VivaciteIndiv == \A i \in DOMAIN demande : demande[i] > 0 ~> satisfait[i] = TRUE
VivaciteGlobale == \E i \in DOMAIN demande : demande[i] > 0  ~> \E j \in satisfait : i /= j /\ satisfait[j] = TRUE


----------------------------------------------------------------

Init ==
   /\ nbDispo = M
   /\ demande = [ i \in 0..N-1 |-> 0 ]
   /\ satisfait = [ i \in 0..N-1 |-> FALSE ]

demander(i,p) == /\ demande[i] = 0
                 /\ satisfait[i] = FALSE
                 /\ p <= M
                 /\ p > 0
                 /\ demande'= [demande EXCEPT ![i] = p]
                 /\ UNCHANGED satisfait
                 /\ UNCHANGED nbDispo

obtenir(i) == /\ demande[i] <= nbDispo
              /\ satisfait[i] = FALSE 
              /\ satisfait' = [satisfait EXCEPT ![i] = TRUE]
              /\ nbDispo' = nbDispo - demande[i]
              /\ UNCHANGED demande

liberer(i,q) == /\ satisfait[i] = TRUE
                /\ q = demande[i]
                /\ demande' = [demande EXCEPT ![i] = 0]
                /\ satisfait'= [satisfait EXCEPT ![i] = FALSE]
                /\ nbDispo' = nbDispo + q

Next ==
 \E i \in 0..N-1 : \E p \in 1..M :
    \/ demander(i,p)
    \/ obtenir(i)
    \/ liberer(i,p)

Fairness == \A i \in demande:  \A j \in 0..M:
                    /\ SF_<<demande, satisfait>> (demander(i,j))
                    /\ SF_<<demande, satisfait>> (obtenir(i))
                    /\ SF_<<demande, satisfait>> (liberer(i,j))

Spec ==
 /\ Init
 /\ [] [ Next ]_vars
 /\ Fairness

================================================================

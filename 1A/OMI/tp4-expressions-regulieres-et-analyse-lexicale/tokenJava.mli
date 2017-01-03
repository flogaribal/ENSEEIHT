(* Type déclarent les différentes unités lexicales possibles *)

type token =
  | IDENT of string
  | TYPEIDENT of string
  | INT
  | FLOAT
  | BOOL
  | CHAR
  | VOID
  | STRING
  | ACCOUV
  | ACCFER
  | PTVIRG
  | VIRG
  | PAROUV
  | PARFER
  | CROOUV
  | CROFER
  | SI
  | SINON
  | TANTQUE
  | RETOUR
  | ENTIER of int
  | FLOTTANT of float
  | BOOLEEN of bool
  | CARACTERE of char
  | CHAINE of string
  | VIDE
  | NOUVEAU
  | ASSIGN
  | OPNONEG
  | OPEG
  | OPSUPEG
  | OPINFEG
  | OPSUP
  | OPINF
  | OPOU
  | OPMOINS
  | OPPLUS
  | OPET
  | OPDIV
  | OPMOD
  | OPMULT
  | OPNON
  | OPPT
  | FIN ;;


(* Fonction d'affichage d'une unité lexicale *)
val printToken : token -> unit;;

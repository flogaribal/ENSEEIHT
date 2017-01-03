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

let printToken t =
  (print_endline
     (match t with
      
       (* Structure de contrôle *)
       | TANTQUE -> "struct while"
       | SI -> "struct if"
       | SINON -> "struct else"
       | RETOUR -> "struct return"

       (* Instructions *)
       | NOUVEAU -> "instr new"
       | VIDE -> "instr null"

       (* Operateur *)
       | OPINF -> "op <"
       | OPSUP -> "op >"
       | OPINFEG -> "op <="
       | OPSUPEG -> "op >="
       | OPEG -> "op =="
       | OPNONEG -> "op !="
       | OPPLUS -> "op +"
       | OPMOINS -> "op -"
       | OPDIV -> "op /"
       | OPMULT -> "op *"
       | OPMOD -> "op %"
       | OPET -> "op &&"
       | OPOU -> "op ||"
       | OPNON -> "op !"
       | ASSIGN -> "op ="
       | OPPT -> " op ."

       (* Types *)
       | INT -> "type int"
       | VOID -> "type void"
       | FLOAT -> "type float"
       | BOOL -> "type bool"
       | CHAR -> "type char"
       | STRING -> "type String"

       (* Parenthèses *)
       | PAROUV -> "par ("
       | PARFER -> "par )"
       | CROOUV -> "cro ["
       | CROFER -> "cro ]"
       | ACCOUV -> "acc {"
       | ACCFER -> "acc }"
 
        (* Séparateurs *)       
       | VIRG -> "virg"
       | PTVIRG -> "pointVirg"

       (* Identifiants *)
       | IDENT(i) -> "ident "^i
       | TYPEIDENT(i) -> "Type ident "^i
       

       (* Constantes *)
       | BOOLEEN(b)-> if b then "bool true" else "bool false"
             
       (* Commentaires *)
       (*| COMMENT(t) -> "Comment "^t*)

       (* Chaine *)
       | CHAINE(t) -> "chaine "^t
       
       | _ -> "TBC"));;

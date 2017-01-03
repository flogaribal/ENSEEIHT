{

  open TokenJava
  exception LexicalError

}

let chiffre = ['0'-'9']
let alpha = ['a'-'z' 'A'-'Z']
let minAlpha = ['a'-'z']
let alphanum = alpha | chiffre | '_'
let tousCaract = [^'\n']

rule lexer = parse
  | ['\n' '\t' ' ']+	{ lexer lexbuf }
  (* Structure de contrôle *)
  | "if"                { SI }
  | "else"              { SINON }
  | "while"             { TANTQUE }
  | "return"            { RETOUR }  
 
  (* Commentaires *)
  | "//" tousCaract* '\n'  { lexer lexbuf }
  | "/*" tousCaract* "*/"  { lexer lexbuf }

  (* Instructions *)
  | "new"               { NOUVEAU }
  | "null"              { VIDE }

  (* Operateur *)
  | "<"                 { OPINF }
  | ">"                 { OPSUP }
  | "<="                { OPINFEG }
  | ">="                { OPSUPEG }
  | "=="                { OPEG }
  | "!="                { OPNONEG }
  | "+"                 { OPPLUS }
  | "-"                 { OPMOINS }
  | "/"                 { OPDIV }
  | "*"                 { OPMULT }
  | "%"                 { OPMOD }
  | "&&"                { OPET }
  | "||"                { OPOU }
  | "!"                 { OPNON }
  | "="                 { ASSIGN }
  | "."                 { OPPT }

  (* Types *)
  | "int"		{ INT }
  | "void"              { VOID }
  | "float"             { FLOAT }
  | "bool"              { BOOL }
  | "char"              { CHAR }
  | "String"            { STRING }

  (* Parenthèses *)
  | "("                 { PAROUV }
  | ")"                 { PARFER }
  | "["                 { CROOUV }
  | "]"                 { CROFER }
  | "{"                 { ACCOUV }
  | "}"                 { ACCFER }

  (* Séparateurs *)
  | ","   		{ VIRG }
  | ";"                 { PTVIRG }

  (* Constantes *)
  | "true"              { BOOLEEN true}
  | "false"             { BOOLEEN false}


  (* Identifiants *)
  |minAlpha+ alphanum* as i { IDENT i}
  |alphanum* as i       { TYPEIDENT i}
  

  (* Entier *)
  | chiffre+ as texte	{ ENTIER (int_of_string texte) }

  (* Chaine *)
  | "\"" [^'"']* "\"" as t { CHAINE t }

  (* Caractère *)
  | "'" [^'\''] "'" as t { CHAINE t }
  

  | eof                 { FIN }
  | _           	{ raise LexicalError }

{

}

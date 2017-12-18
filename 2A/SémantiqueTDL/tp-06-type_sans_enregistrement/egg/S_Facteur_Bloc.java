package egg;
import java.util.*;
import fr.n7.stl.block.ast.*;
import fr.n7.stl.block.ast.impl.*;
import fr.n7.stl.util.*;
import mg.egg.eggc.runtime.libjava.lex.*;
import mg.egg.eggc.runtime.libjava.*;
import mg.egg.eggc.runtime.libjava.messages.*;
import mg.egg.eggc.runtime.libjava.problem.IProblem;
import java.util.Vector;
public class S_Facteur_Bloc {
LEX_Bloc scanner;
  S_Facteur_Bloc() {
	}
  S_Facteur_Bloc(LEX_Bloc scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  Expression att_ast;
  LEX_Bloc att_scanner;
  private void regle46() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	S_Facteur_Bloc x_3 = new S_Facteur_Bloc(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_46(x_3);
	x_2.analyser(LEX_Bloc.token_negation);
	x_3.analyser() ;
if  (att_eval)	  action_ast_46(x_3);
  }
  private void regle27() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	//appel
	x_2.analyser(LEX_Bloc.token_identificateur);
if  (att_eval)	  action_ast_27(x_2);
  }
  private void regle26() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	S_Expression_Bloc x_3 = new S_Expression_Bloc(scanner,att_eval) ;
	T_Bloc x_4 = new T_Bloc(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_26(x_3);
	x_2.analyser(LEX_Bloc.token_parenthese_ouvrante);
	x_3.analyser() ;
	x_4.analyser(LEX_Bloc.token_parenthese_fermante);
if  (att_eval)	  action_ast_26(x_3);
  }
  private void regle29() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	S_Facteur_Bloc x_3 = new S_Facteur_Bloc(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_29(x_3);
	x_2.analyser(LEX_Bloc.token_second);
	x_3.analyser() ;
if  (att_eval)	  action_ast_29(x_3);
  }
  private void regle28() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	S_Facteur_Bloc x_3 = new S_Facteur_Bloc(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_28(x_3);
	x_2.analyser(LEX_Bloc.token_premier);
	x_3.analyser() ;
if  (att_eval)	  action_ast_28(x_3);
  }
  private void regle31() throws Exception {

	//declaration
	S_Valeur_Bloc x_2 = new S_Valeur_Bloc(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_31(x_2);
	x_2.analyser() ;
if  (att_eval)	  action_ast_31(x_2);
  }
  private void regle45() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	S_Facteur_Bloc x_3 = new S_Facteur_Bloc(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_45(x_3);
	x_2.analyser(LEX_Bloc.token_soustraction);
	x_3.analyser() ;
if  (att_eval)	  action_ast_45(x_3);
  }
private void action_auto_inh_26(S_Expression_Bloc x_3) throws Exception {
try {
// instructions
x_3.att_factory=this.att_factory;
x_3.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Facteur -> parenthese_ouvrante Expression parenthese_fermante #ast ;", e });
}
  }
private void action_auto_inh_28(S_Facteur_Bloc x_3) throws Exception {
try {
// instructions
x_3.att_factory=this.att_factory;
x_3.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Facteur -> premier Facteur1 #ast ;", e });
}
  }
private void action_auto_inh_29(S_Facteur_Bloc x_3) throws Exception {
try {
// instructions
x_3.att_factory=this.att_factory;
x_3.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Facteur -> second Facteur1 #ast ;", e });
}
  }
private void action_ast_31(S_Valeur_Bloc x_2) throws Exception {
try {
// instructions
this.att_ast=x_2.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","Facteur -> Valeur #ast ;", e });
}
  }
private void action_ast_45(S_Facteur_Bloc x_3) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createUnaryExpression(UnaryOperator.Opposite, x_3.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","Facteur -> soustraction Facteur1 #ast ;", e });
}
  }
private void action_ast_46(S_Facteur_Bloc x_3) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createUnaryExpression(UnaryOperator.Negate, x_3.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","Facteur -> negation Facteur1 #ast ;", e });
}
  }
private void action_ast_26(S_Expression_Bloc x_3) throws Exception {
try {
// instructions
this.att_ast=x_3.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","Facteur -> parenthese_ouvrante Expression parenthese_fermante #ast ;", e });
}
  }
private void action_ast_27(T_Bloc x_2) throws Exception {
try {
// locales
Optional<Declaration> loc_varReturned;
Declaration loc_tmp;
// instructions
loc_varReturned=null;
if (this.att_tds.knows(x_2.att_txt)){
loc_varReturned=this.att_tds.get(x_2.att_txt);
loc_tmp=loc_varReturned.get();
if (loc_tmp instanceof VariableDeclaration ){
this.att_ast=this.att_factory.createVariableUse(((VariableDeclaration)loc_tmp));
}
else if (loc_tmp instanceof ConstantDeclaration ){
this.att_ast=((ConstantDeclaration)loc_tmp).getValue();
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IBlocMessages.id_Bloc_unexpected_token, BlocMessages.Bloc_unexpected_token,new Object[]{""+x_2.att_txt});


}
}

}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","Facteur -> identificateur #ast ;", e });
}
  }
private void action_auto_inh_31(S_Valeur_Bloc x_2) throws Exception {
try {
// instructions
x_2.att_factory=this.att_factory;
x_2.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Facteur -> Valeur #ast ;", e });
}
  }
private void action_ast_28(S_Facteur_Bloc x_3) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createFirst(x_3.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","Facteur -> premier Facteur1 #ast ;", e });
}
  }
private void action_ast_29(S_Facteur_Bloc x_3) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createSecond(x_3.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","Facteur -> second Facteur1 #ast ;", e });
}
  }
private void action_auto_inh_45(S_Facteur_Bloc x_3) throws Exception {
try {
// instructions
x_3.att_factory=this.att_factory;
x_3.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Facteur -> soustraction Facteur1 #ast ;", e });
}
  }
private void action_auto_inh_46(S_Facteur_Bloc x_3) throws Exception {
try {
// instructions
x_3.att_factory=this.att_factory;
x_3.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Facteur -> negation Facteur1 #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_Bloc.token_parenthese_ouvrante : // 24
        regle26 () ;
      break ;
      case LEX_Bloc.token_identificateur : // 58
        regle27 () ;
      break ;
      case LEX_Bloc.token_premier : // 50
        regle28 () ;
      break ;
      case LEX_Bloc.token_second : // 51
        regle29 () ;
      break ;
      case LEX_Bloc.token_entier : // 57
        regle31 () ;
      break ;
      case LEX_Bloc.token_vrai : // 44
        regle31 () ;
      break ;
      case LEX_Bloc.token_faux : // 45
        regle31 () ;
      break ;
      case LEX_Bloc.token_soustraction : // 37
        regle45 () ;
      break ;
      case LEX_Bloc.token_negation : // 42
        regle46 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IBlocMessages.id_Bloc_unexpected_token,BlocMessages.Bloc_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }

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
public class S_Instruction_Bloc {
LEX_Bloc scanner;
  S_Instruction_Bloc() {
	}
  S_Instruction_Bloc(LEX_Bloc scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  Instruction att_inst;
  LEX_Bloc att_scanner;
  private void regle12() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	T_Bloc x_3 = new T_Bloc(scanner ) ;
	S_Expression_Bloc x_4 = new S_Expression_Bloc(scanner,att_eval) ;
	T_Bloc x_5 = new T_Bloc(scanner ) ;
	S_Bloc_Bloc x_6 = new S_Bloc_Bloc(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_12(x_4, x_6);
	x_2.analyser(LEX_Bloc.token_tant_que);
	x_3.analyser(LEX_Bloc.token_parenthese_ouvrante);
	x_4.analyser() ;
	x_5.analyser(LEX_Bloc.token_parenthese_fermante);
	x_6.analyser() ;
if  (att_eval)	  action_inst_12(x_4, x_6);
  }
  private void regle31() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	S_Type_Bloc x_3 = new S_Type_Bloc(scanner,att_eval) ;
	T_Bloc x_4 = new T_Bloc(scanner ) ;
	T_Bloc x_5 = new T_Bloc(scanner ) ;
	S_Valeur_Bloc x_6 = new S_Valeur_Bloc(scanner,att_eval) ;
	T_Bloc x_7 = new T_Bloc(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_31(x_3, x_4, x_6);
	x_2.analyser(LEX_Bloc.token_constante);
	x_3.analyser() ;
	x_4.analyser(LEX_Bloc.token_identificateur);
	x_5.analyser(LEX_Bloc.token_affectation);
	x_6.analyser() ;
	x_7.analyser(LEX_Bloc.token_point_virgule);
if  (att_eval)	  action_inst_31(x_3, x_4, x_6);
  }
  private void regle9() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	T_Bloc x_3 = new T_Bloc(scanner ) ;
	S_Expression_Bloc x_4 = new S_Expression_Bloc(scanner,att_eval) ;
	T_Bloc x_5 = new T_Bloc(scanner ) ;
	S_Bloc_Bloc x_6 = new S_Bloc_Bloc(scanner,att_eval) ;
	S_SuiteConditionnelle_Bloc x_7 = new S_SuiteConditionnelle_Bloc(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_9(x_4, x_6, x_7);
	x_2.analyser(LEX_Bloc.token_si);
	x_3.analyser(LEX_Bloc.token_parenthese_ouvrante);
	x_4.analyser() ;
	x_5.analyser(LEX_Bloc.token_parenthese_fermante);
	x_6.analyser() ;
	x_7.analyser() ;
if  (att_eval)	  action_inst_9(x_4, x_6, x_7);
  }
  private void regle8() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	T_Bloc x_3 = new T_Bloc(scanner ) ;
	S_Expression_Bloc x_4 = new S_Expression_Bloc(scanner,att_eval) ;
	T_Bloc x_5 = new T_Bloc(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_8(x_2, x_4);
	x_2.analyser(LEX_Bloc.token_identificateur);
	x_3.analyser(LEX_Bloc.token_affectation);
	x_4.analyser() ;
	x_5.analyser(LEX_Bloc.token_point_virgule);
if  (att_eval)	  action_inst_8(x_2, x_4);
  }
  private void regle7() throws Exception {

	//declaration
	S_Type_Bloc x_2 = new S_Type_Bloc(scanner,att_eval) ;
	T_Bloc x_3 = new T_Bloc(scanner ) ;
	T_Bloc x_4 = new T_Bloc(scanner ) ;
	S_Expression_Bloc x_5 = new S_Expression_Bloc(scanner,att_eval) ;
	T_Bloc x_6 = new T_Bloc(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_7(x_2, x_3, x_5);
	x_2.analyser() ;
	x_3.analyser(LEX_Bloc.token_identificateur);
	x_4.analyser(LEX_Bloc.token_affectation);
	x_5.analyser() ;
	x_6.analyser(LEX_Bloc.token_point_virgule);
if  (att_eval)	  action_inst_7(x_2, x_3, x_5);
  }
  private void regle13() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	T_Bloc x_3 = new T_Bloc(scanner ) ;
	S_Expression_Bloc x_4 = new S_Expression_Bloc(scanner,att_eval) ;
	T_Bloc x_5 = new T_Bloc(scanner ) ;
	T_Bloc x_6 = new T_Bloc(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_13(x_4);
	x_2.analyser(LEX_Bloc.token_afficher);
	x_3.analyser(LEX_Bloc.token_parenthese_ouvrante);
	x_4.analyser() ;
	x_5.analyser(LEX_Bloc.token_parenthese_fermante);
	x_6.analyser(LEX_Bloc.token_point_virgule);
if  (att_eval)	  action_inst_13(x_4);
  }
private void action_inst_9(S_Expression_Bloc x_4, S_Bloc_Bloc x_6, S_SuiteConditionnelle_Bloc x_7) throws Exception {
try {
// instructions
if ((x_7.att_ast!=null)){
this.att_inst=this.att_factory.createConditional(x_4.att_ast, x_6.att_ast, x_7.att_ast);
}
else {
this.att_inst=this.att_factory.createConditional(x_4.att_ast, x_6.att_ast);
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#inst","Instruction -> si parenthese_ouvrante Expression parenthese_fermante Bloc SuiteConditionnelle #inst ;"});
}
  }
private void action_auto_inh_8(T_Bloc x_2, S_Expression_Bloc x_4) throws Exception {
try {
// instructions
x_4.att_factory=this.att_factory;
x_4.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Instruction -> identificateur affectation Expression point_virgule #inst ;"});
}
  }
private void action_auto_inh_31(S_Type_Bloc x_3, T_Bloc x_4, S_Valeur_Bloc x_6) throws Exception {
try {
// instructions
x_3.att_factory=this.att_factory;
x_6.att_factory=this.att_factory;
x_6.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Instruction -> constante Type identificateur affectation Valeur point_virgule #inst ;"});
}
  }
private void action_auto_inh_9(S_Expression_Bloc x_4, S_Bloc_Bloc x_6, S_SuiteConditionnelle_Bloc x_7) throws Exception {
try {
// instructions
x_4.att_factory=this.att_factory;
x_6.att_factory=this.att_factory;
x_7.att_factory=this.att_factory;
x_4.att_tds=this.att_tds;
x_6.att_tds=this.att_tds;
x_7.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Instruction -> si parenthese_ouvrante Expression parenthese_fermante Bloc SuiteConditionnelle #inst ;"});
}
  }
private void action_inst_12(S_Expression_Bloc x_4, S_Bloc_Bloc x_6) throws Exception {
try {
// instructions
this.att_inst=this.att_factory.createRepetition(x_4.att_ast, x_6.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#inst","Instruction -> tant_que parenthese_ouvrante Expression parenthese_fermante Bloc #inst ;"});
}
  }
private void action_auto_inh_7(S_Type_Bloc x_2, T_Bloc x_3, S_Expression_Bloc x_5) throws Exception {
try {
// instructions
x_2.att_factory=this.att_factory;
x_5.att_factory=this.att_factory;
x_5.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Instruction -> Type identificateur affectation Expression point_virgule #inst ;"});
}
  }
private void action_auto_inh_12(S_Expression_Bloc x_4, S_Bloc_Bloc x_6) throws Exception {
try {
// instructions
x_4.att_factory=this.att_factory;
x_6.att_factory=this.att_factory;
x_4.att_tds=this.att_tds;
x_6.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Instruction -> tant_que parenthese_ouvrante Expression parenthese_fermante Bloc #inst ;"});
}
  }
private void action_inst_13(S_Expression_Bloc x_4) throws Exception {
try {
// instructions
this.att_inst=this.att_factory.createPrinter(x_4.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#inst","Instruction -> afficher parenthese_ouvrante Expression parenthese_fermante point_virgule #inst ;"});
}
  }
private void action_auto_inh_13(S_Expression_Bloc x_4) throws Exception {
try {
// instructions
x_4.att_factory=this.att_factory;
x_4.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Instruction -> afficher parenthese_ouvrante Expression parenthese_fermante point_virgule #inst ;"});
}
  }
private void action_inst_31(S_Type_Bloc x_3, T_Bloc x_4, S_Valeur_Bloc x_6) throws Exception {
try {
// locales
ConstantDeclaration loc_tmp;
// instructions
if (!(this.att_tds.knows(x_4.att_txt))){
loc_tmp=this.att_factory.createConstantDeclaration(x_4.att_txt, x_3.att_ast, x_6.att_ast);
this.att_inst=loc_tmp;
this.att_tds.register(loc_tmp);
}

}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#inst","Instruction -> constante Type identificateur affectation Valeur point_virgule #inst ;"});
}
  }
private void action_inst_7(S_Type_Bloc x_2, T_Bloc x_3, S_Expression_Bloc x_5) throws Exception {
try {
// locales
VariableDeclaration loc_tmp;
// instructions
if (!(this.att_tds.knows(x_3.att_txt))){
loc_tmp=this.att_factory.createVariableDeclaration(x_3.att_txt, x_2.att_ast, x_5.att_ast);
this.att_inst=loc_tmp;
this.att_tds.register(loc_tmp);
}

}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#inst","Instruction -> Type identificateur affectation Expression point_virgule #inst ;"});
}
  }
private void action_inst_8(T_Bloc x_2, S_Expression_Bloc x_4) throws Exception {
try {
// locales
Declaration loc_tmp;
Optional<Declaration> loc_varReturned;
// instructions
loc_varReturned=null;
if (this.att_tds.knows(x_2.att_txt)){
loc_varReturned=this.att_tds.get(x_2.att_txt);
loc_tmp=loc_varReturned.get();
if (loc_tmp instanceof VariableDeclaration ){
this.att_inst=this.att_factory.createAssignment(((VariableDeclaration)loc_tmp), x_4.att_ast);
}
else if (loc_tmp instanceof ConstantDeclaration ){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IBlocMessages.id_Constant_unexpected, BlocMessages.Constant_unexpected,new Object[]{""+x_2.att_txt});

}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IBlocMessages.id_Bloc_unexpected_token, BlocMessages.Bloc_unexpected_token,new Object[]{""+x_2.att_txt});


}
}

}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#inst","Instruction -> identificateur affectation Expression point_virgule #inst ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_Bloc.token_type_bool : // 52
        regle7 () ;
      break ;
      case LEX_Bloc.token_type_int : // 51
        regle7 () ;
      break ;
      case LEX_Bloc.token_inferieur : // 26
        regle7 () ;
      break ;
      case LEX_Bloc.token_identificateur : // 56
        regle8 () ;
      break ;
      case LEX_Bloc.token_si : // 45
        regle9 () ;
      break ;
      case LEX_Bloc.token_tant_que : // 48
        regle12 () ;
      break ;
      case LEX_Bloc.token_afficher : // 47
        regle13 () ;
      break ;
      case LEX_Bloc.token_constante : // 54
        regle31 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IBlocMessages.id_Bloc_unexpected_token,BlocMessages.Bloc_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }

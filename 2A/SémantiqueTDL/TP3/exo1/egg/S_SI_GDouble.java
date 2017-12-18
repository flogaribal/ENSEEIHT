package egg;
import java.util.*;
import mg.egg.eggc.runtime.libjava.lex.*;
import mg.egg.eggc.runtime.libjava.*;
import mg.egg.eggc.runtime.libjava.messages.*;
import mg.egg.eggc.runtime.libjava.problem.IProblem;
import java.util.Vector;
public class S_SI_GDouble {
LEX_GDouble scanner;
  S_SI_GDouble() {
	}
  S_SI_GDouble(LEX_GDouble scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  double att_val;
  boolean att_eval;
  LEX_GDouble att_scanner;
  double att_power;
  private void regle3() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_valPower_3();
  }
  private void regle2() throws Exception {

	//declaration
	T_GDouble x_2 = new T_GDouble(scanner ) ;
	S_SI_GDouble x_3 = new S_SI_GDouble(scanner,att_eval) ;
	//appel
	x_2.analyser(LEX_GDouble.token_chiffre);
	x_3.analyser() ;
if  (att_eval)	  action_valPower_2(x_2, x_3);
  }
private void action_valPower_2(T_GDouble x_2, S_SI_GDouble x_3) throws Exception {
try {
// locales
// instructions
this.att_power=(x_3.att_power+1);
this.att_val=((Double.parseDouble(x_2.att_txt)*Math.pow(10, x_3.att_power))+x_3.att_val);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "GDouble", "#valPower","SI -> chiffre SI1 #valPower ;"});
}
  }
private void action_valPower_3() throws Exception {
try {
// locales
// instructions
this.att_power=0;
this.att_val=0;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "GDouble", "#valPower","SI -> #valPower ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_GDouble.token_chiffre : // 5
        regle2 () ;
      break ;
      case LEX_GDouble.token_point : // 4
        regle3 () ;
      break ;
      case LEX_GDouble.EOF :
        regle3 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IGDoubleMessages.id_GDouble_unexpected_token,GDoubleMessages.GDouble_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }

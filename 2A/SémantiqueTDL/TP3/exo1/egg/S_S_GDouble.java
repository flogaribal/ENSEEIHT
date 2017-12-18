package egg;
import java.util.*;
import mg.egg.eggc.runtime.libjava.lex.*;
import mg.egg.eggc.runtime.libjava.*;
import mg.egg.eggc.runtime.libjava.messages.*;
import mg.egg.eggc.runtime.libjava.problem.IProblem;
import java.util.Vector;
public class S_S_GDouble {
LEX_GDouble scanner;
  S_S_GDouble() {
	}
  S_S_GDouble(LEX_GDouble scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  double att_val;
  boolean att_eval;
  LEX_GDouble att_scanner;
  private void regle0() throws Exception {

	//declaration
	S_I_GDouble x_2 = new S_I_GDouble(scanner,att_eval) ;
	T_GDouble x_3 = new T_GDouble(scanner ) ;
	S_I_GDouble x_4 = new S_I_GDouble(scanner,att_eval) ;
	//appel
	x_2.analyser() ;
	x_3.analyser(LEX_GDouble.token_point);
	x_4.analyser() ;
if  (att_eval)	  action_val_0(x_2, x_4);
  }
private void action_val_0(S_I_GDouble x_2, S_I_GDouble x_4) throws Exception {
try {
// locales
// instructions
this.att_val=(x_2.att_val+(x_4.att_val*Math.pow(10, -(x_4.att_power))));
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "GDouble", "#val","S -> I point I1 #val ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_GDouble.token_chiffre : // 5
        regle0 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IGDoubleMessages.id_GDouble_unexpected_token,GDoubleMessages.GDouble_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }

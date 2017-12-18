package egg;
import java.util.*;
import mg.egg.eggc.runtime.libjava.EGGException;
import mg.egg.eggc.runtime.libjava.ISourceUnit;
import mg.egg.eggc.runtime.libjava.lex.LEX_CONTEXTE;
import mg.egg.eggc.runtime.libjava.problem.IProblemReporter;
import mg.egg.eggc.runtime.libjava.problem.IProblem;
import mg.egg.eggc.runtime.libjava.problem.ProblemSeverities;
import mg.egg.eggc.runtime.libjava.messages.NLS;
public class GDouble {
  LEX_GDouble scanner;
  protected IProblemReporter problemReporter;
	private S_S_GDouble axiome ;
	public  S_S_GDouble getAxiom(){return axiome;}
  public GDouble(IProblemReporter pr){
	   this.problemReporter = pr;
  }
  public void compile(ISourceUnit cu) throws Exception {
	try{
	  System.err.println("GDouble Version 0.0.1");
	  LEX_CONTEXTE contexte;
	  contexte = new LEX_CONTEXTE(cu);
	  scanner = new LEX_GDouble(problemReporter, contexte, 1);
	  scanner.analyseur.fromContext(contexte);
	  att_scanner = scanner;
	  axiome = new S_S_GDouble(scanner,att_eval);
	  axiome.att_scanner = this.att_scanner ;
	  axiome.att_eval = this.att_eval ;
	  axiome.analyser() ;
	  this.att_val = axiome.att_val ;
	  scanner.accepter_fds() ;
	}catch (EGGException e){
	  problemReporter.handle(e.getCategory(), e.getCode(),0, NLS.bind(e.getId(),e.getArgs()),ProblemSeverities.Error,0,0,e.getArgs());
	}
	}
  double att_val;
  public void set_val(double a_val){
	att_val = a_val;
  }
  public double get_val(){
	return att_val;
  }
  boolean att_eval;
  public void set_eval(boolean a_eval){
	att_eval = a_eval;
  }
  public boolean get_eval(){
	return att_eval;
  }
  LEX_GDouble att_scanner;
  public void set_scanner(LEX_GDouble a_scanner){
	att_scanner = a_scanner;
  }
  public LEX_GDouble get_scanner(){
	return att_scanner;
  }
  }

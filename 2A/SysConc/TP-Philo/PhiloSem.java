// Time-stamp: <08 déc 2009 08:30 queinnec@enseeiht.fr>

import java.util.concurrent.Semaphore;

public class PhiloSem implements StrategiePhilo {

    /****************************************************************/
	private Semaphore[] fourchette;
	private Semaphore table;	
	
    public PhiloSem (int nbPhilosophes) {
    	fourchette = new Semaphore[nbPhilosophes];
    	for (int i=0; i<fourchette.length; i++) {
    		fourchette[i] = new Semaphore(1);
    	}
    	table = new Semaphore(nbPhilosophes-1);
    }

    /** Le philosophe no demande les fourchettes.
     *  Précondition : il n'en possède aucune.
     *  Postcondition : quand cette méthode retourne, il possède les deux fourchettes adjacentes à son assiette. */
    public void demanderFourchettes (int no) throws InterruptedException {
    	int numFourchetteGauche = Main.FourchetteGauche(no);
    	int numFourchetteDroite = Main.FourchetteDroite(no);
    	
    	table.acquire();
    	
    	fourchette[numFourchetteDroite].acquire();
    	IHMPhilo.poser(numFourchetteDroite, EtatFourchette.AssietteGauche);
    	
    	Thread.sleep(1000);
    	
    	fourchette[numFourchetteGauche].acquire();
    	IHMPhilo.poser(numFourchetteGauche, EtatFourchette.AssietteDroite);
    	
    	table.release();
    	
    }

    /** Le philosophe no rend les fourchettes.
     *  Précondition : il possède les deux fourchettes adjacentes à son assiette.
     *  Postcondition : il n'en possède aucune. Les fourchettes peuvent être libres ou réattribuées à un autre philosophe. */
    public void libererFourchettes (int no) {
    	int numFourchetteGauche = Main.FourchetteGauche(no);
    	int numFourchetteDroite = Main.FourchetteDroite(no);
    	
    	fourchette[numFourchetteDroite].release();
    	IHMPhilo.poser(numFourchetteDroite, EtatFourchette.Table);
    	
    	fourchette[numFourchetteGauche].release();
    	IHMPhilo.poser(numFourchetteGauche, EtatFourchette.Table);
    }

    /** Nom de cette stratégie (pour la fenêtre d'affichage). */
    public String nom() {
        return "Stratégie classique, fourchette droite puis gauche";
    }

}


// Time-stamp: <08 déc 2009 08:30 queinnec@enseeiht.fr>

import java.util.concurrent.Semaphore;

public class PhiloSem2 implements StrategiePhilo {

    /****************************************************************/
	private Semaphore protect;
	private Semaphore[] semPhilo;
	private EtatPhilosophe[] etatPhilo;
	
    public PhiloSem2 (int nbPhilosophes) {
    	etatPhilo = new EtatPhilosophe[nbPhilosophes];
    	semPhilo = new Semaphore[nbPhilosophes];
    	
    	// Init etat Philo -> tous Penseurs
    	// Init semaphore privé à 1 
    	for (int i=0; i<nbPhilosophes; i++) {
    		etatPhilo[i] = EtatPhilosophe.Pense;
    		semPhilo[i] = new Semaphore(1);
    	}
   
    	protect = new Semaphore(1);
    }
    
    
    private boolean peutManger(int no) {
    	return (etatPhilo[no] == EtatPhilosophe.Demande) &&
    			(etatPhilo[Main.PhiloGauche(no)] != EtatPhilosophe.Mange) && 
    			 (etatPhilo[Main.PhiloDroite(no)] != EtatPhilosophe.Mange);
    }
   
    
    
    /** Le philosophe no demande les fourchettes.
     *  Précondition : il n'en possède aucune.
     *  Postcondition : quand cette méthode retourne, il possède les deux fourchettes adjacentes à son assiette. */
    public void demanderFourchettes (int no) throws InterruptedException {
    	int numFourchetteGauche = Main.FourchetteGauche(no);
    	int numFourchetteDroite = Main.FourchetteDroite(no);
    	
    	protect.acquire();
    	
    	if (peutManger(no)) {
    		
    		// Récupération des 2 fourchettes
        	IHMPhilo.poser(numFourchetteDroite, EtatFourchette.AssietteGauche);
        	IHMPhilo.poser(numFourchetteGauche, EtatFourchette.AssietteDroite);
        	
    		// Changement d'état du philo courant -> MANGE
    		etatPhilo[no] = EtatPhilosophe.Mange;
    		    		
    		semPhilo[no].release();
    	} else {
    		
    		// Changement d'état du philo courant -> DEMANDE
    		etatPhilo[no] = EtatPhilosophe.Demande;	
    	}

    	protect.release();
    	semPhilo[no].acquire();
    }

    /** Le philosophe no rend les fourchettes.
     *  Précondition : il possède les deux fourchettes adjacentes à son assiette.
     *  Postcondition : il n'en possède aucune. Les fourchettes peuvent être libres ou réattribuées à un autre philosophe. */
    public void libererFourchettes (int no) {
    	int numFourchetteGauche = Main.FourchetteGauche(no);
    	int numFourchetteDroite = Main.FourchetteDroite(no);
    	
    	try {
			protect.acquire();
			
			// Changement d'état -> PENSE
			etatPhilo[no] = EtatPhilosophe.Pense;
			
			// Si le philo droit veut manger et que son voisin de droite ne mange pas -> lui donner la fourchette
			if (peutManger(Main.PhiloDroite(no))) {
				
				IHMPhilo.poser(numFourchetteDroite, EtatFourchette.Table);
				
				etatPhilo[Main.PhiloDroite(no)] = EtatPhilosophe.Mange;
				
				semPhilo[Main.PhiloDroite(no)].release();   	
			}
			
			// Si le philo gauche veut manger et que son voisin de gauche ne mange pas -> lui donner la fourchette			
			if (peutManger(Main.PhiloGauche(no))) {
				
	        	IHMPhilo.poser(numFourchetteGauche, EtatFourchette.Table);
	        
	        	etatPhilo[Main.PhiloGauche(no)] = EtatPhilosophe.Mange;
	        	
	        	semPhilo[Main.PhiloGauche(no)].release();
	        }
			
			protect.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }

    /** Nom de cette stratégie (pour la fenêtre d'affichage). */
    public String nom() {
        return "Stratégie classique, Synchro";
    }

}


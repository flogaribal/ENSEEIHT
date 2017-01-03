/** Un ensemble d'entiers implanté en utilisant un tableau.
  * Les nouveaux éléments sont ajoutés à la fin du tableau sauf dans le cas où
  * ils sont déjà présents dans l'ensemble (donc dans le tableau).
  * @author	Xavier Crégut	(cregut@enseeiht.fr)
  * @version	$Revision: 1.7 $
  */
public class EnsembleTab implements Ensemble {
	// Remarque : Un invariant peut être défini « private ».  Il doit
	// l'être s'il porte sur des éléments private de la classe.  Il ne
	// peut alors pas être vérifié par un utilisateur de l'ensemble.
	// Il traduit donc un choix d'implantation et non une
	// spécification de l'ensemble !

	//@ private invariant elements != null;	// le tableau existe
	//@ private invariant cardinal() == nbElements;	// nb est le cardinal

	// Tous les éléments compris dans les indices [0..cardinal()[
	// du tableau sont dans l'ensemble.
	// -------------------------------------------------------------
	//@ private invariant (\forall int i;
	//@	0 <= i && i < cardinal(); contient(elements[i]));

	// Deux éléments a des indices différents sont différents (les
	// doubles ne sont pas stockés !).
	// -----------------------------------------------------------
	//@ private invariant (\forall int i; 0 <= i && i < cardinal();
	//@	(\forall int j; 0 <= j && j < i;
	//@		elements[i] != elements[j]));

	// Définition du min (vérifiable par JML)
	// --------------------------------------
	//@ private invariant !estVide() ==>
	//@	getMin() == (\min int i;
	//@		0 <= i && i < cardinal(); elements[i]);

	private int[] elements;	// stockage des éléments de l'ensemble
	private int nbElements;	// taille effective de elements

	/** Construction d'un ensemble avec une capacité initiale.
	  * @param capaciteInitiale capacité initiale de l'ensemble */
	//@ requires capaciteInitiale > 0;
	//@ ensures cardinal() == 0;
	public EnsembleTab(int capaciteInitiale) {
		elements = new int[capaciteInitiale];
		nbElements = 0;
	}

	public int cardinal() {
		return nbElements;
	}

	public boolean estVide() {
		return nbElements == 0;
	}
	

	public boolean contient(int x) {
		boolean contient = false;
		int i = 0;
		
		while (!contient && i < nbElements){
			if(elements[i] == x){
				contient = true;
			}
			i++;
		}		
		
		return contient;
	}
	
	public void supprimer(int x) {
		int i = 0;
		
		if(nbElements > 0 && elements[nbElements-1] == x){   // Cas où l'élément à supprimer est le dernier du tableau
			nbElements--;
		}else{							// Autres cas
			
			// Parcours jusqu'à que l'on trouve l'élément à supprimer
			while(i < nbElements && elements[i] != x){
				i++;
			};
			
			if(i == nbElements){ // Element non trouvé
			
			}else{
				
				while(i < nbElements-1){
					elements[i] = elements[i+1];
					i++;
				}
				nbElements--;
			
			}			
		}
		
	}

	public void ajouter(int x) {
		if(!contient(x)){
			
			if(nbElements == elements.length){ // Tableau plein
				int[] newTab = new int[elements.length+1];
				
				for(int i=0;i<nbElements;i++){  // Recopie de l'ancien tableau
					newTab[i] = elements[i];
				}
				elements = newTab;
			}
			
			elements[nbElements] = x; // Ajout de l'élément en fin de tableau
			nbElements++;
		}
	}

	
	public int getMin() {
		int min = elements[0];
		
		for(int i=1; i<nbElements;i++){
			if(elements[i] < min){
				min = elements[i];
			}
		}
		return min;
	}

}

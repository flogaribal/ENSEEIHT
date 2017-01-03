/** Définition d'un ensemble d'entier.
 * @author	Xavier Crégut (cregut@enseeiht.fr)
 * @version	$Revision: 1.1 $
 */
public interface Ensemble {
	// Remarque : Certains invariants pourraient être exprimés sous
	// la forme de postconditions sur des méthodes (par exemple
	// getMin() ou cardinal()) mais elles ne seraient alors
	// dynamiquement vérifiées que lors de l'utilisation de ces
	// méthodes (getMin() ou cardinal()).  En tant qu'invariant,
	// elles le sont après toute application d'une méthode de
	// l'ensemble.

	//@ public invariant estVide() <==> cardinal() == 0;
	//@ public invariant 0 <= cardinal();

	// Caractérisation du min (quand il existe !)
	// ------------------------------------------
	//@ public invariant ! estVide() ==> contient(getMin());
	//@ public invariant ! estVide() ==>
	//@		getMin() == (\min int x; contient(x); x);
	// Remarque : la propriété ci-dessus n'est pas instrumentée par
	// JML car les bornes de variation de x n'ont pas été contraintes.

	/** Obtenir le nombre d'éléments dans l'ensemble.
	 * @return nombre d'éléments dans l'ensemble.  */
	/*@ pure @*/ int cardinal();

	/** Savoir si l'ensemble est vide.
	 * @return Est-ce que l'ensemble est vide ? */
	/*@ pure @*/ boolean estVide();

	/** Savoir si un élément est présent dans l'ensemble.
	  * @param x l'élément cherché
	  * @return x est dans l'ensemble */
	/*@ pure @*/ boolean contient(int x);

	/** Ajouter un élément dans l'ensemble.
	 * @param x l'élément à ajouter */
	//@ ensures		// élément ajouté
	//@		contient(x);
	//@ ensures		// cardianalité augmentée
	//@		! \old(contient(x)) ==>
	//@			cardinal() == \old(cardinal()) + 1;
	//@ ensures		// ou cardinalité inchangée
	//@		\old(contient(x)) ==>
	//@			cardinal() == \old(cardinal());
	void ajouter(int x);

	/** Enlever un élément de l'ensemble.
	  * @param x l'élément à supprimer */
	//@ ensures		// élément supprimé
	//@		! contient(x);
	//@ ensures		// cardinalité diminuée
	//@		\old(contient(x)) ==>
	//@			cardinal() == \old(cardinal()) - 1;
	//@ ensures		// ou cardinalité inchangée
	//@		! \old(contient(x)) ==>
	//@			cardinal() == \old(cardinal());
	void supprimer(int x);

	/**  Obtenir le minimum de l'ensemble.
	 * @return le plus petit élément de l'ensemble  */
	//@ requires !estVide();
	/*@ pure @*/ int getMin();

}

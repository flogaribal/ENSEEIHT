/** Le crible d'Ératosthène.  Il calcule les nombres premiers suivant
 * l'algorithme dit du crible d'Ératosthène.  Les entiers sont
 * stockés dans un ensemble.
 * @author Xavier Crégut (cregut@enseeiht.fr)
 * @version $Revision: 1.6 $
 */
public class Crible {

	//@ private invariant nombres.estVide();

	/** L'ensemble utilisé par le crible */
	private Ensemble nombres;

	/** Fournir l'ensemble ens à utiliser
	 * @param ens l'ensemble à utiliser
	 */
	//@ requires ens.estVide();
	public Crible(Ensemble ens) {
		this.nombres = ens;
	}

	/** Cribler les entiers de 2 à max par l'algorithme d'Ératosthène.
	 * Les nombres premiers sont affichés à l'écran.
	 * L'ensemble nombres est utilisé pour conserver les entiers.
	 * @param max borne supérieure de l'intervalle
	 */
	//@ requires max >= 2;
	public void cribler(int max) {
		// construire l'ensemble des nombres entiers de 1 à max
		for(int entier = 2; entier <= max; entier++) {
			this.nombres.ajouter(entier);
		}

		// afficher les nombres premiers
		System.out.print("Nombres premiers : ");
		int nb = 0;	// nombre de nombres premiers affichés
		while (!this.nombres.estVide()) {
			// déterminer le nombre premier suivant
			int premier = this.nombres.getMin();

			// afficher le nombre premier
			if (nb > 0) {
				System.out.print(", ");
			}
			System.out.print(premier);
			nb++;
			System.out.flush();	// forcer l'affichage

			// supprimer les multiples de premier
			for(int multiple = premier; multiple <= max; multiple += premier) {
				this.nombres.supprimer(multiple);
			}
		}
		System.out.println();
	}

}

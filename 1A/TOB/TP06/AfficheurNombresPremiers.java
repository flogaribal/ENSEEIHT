/** affiche les nombres premiers suivant l'algorithme dit du crible
 *  d'Ératosthène.  Les entiers sont stockés dans un ensemble.
 *  @author	Xavier Crégut (cregut@enseeiht.fr)
 *  @version	$Revision: 1.3 $
 */
public class AfficheurNombresPremiers {

	/** Programme qui calcule les nombres premiers de 2 à l'entier passé en
	  * paramètre.  L'ensemble utilisé est EnsembleTab.
	  */
	public static void main (String args []) {
		try {
			if (args.length != 2) {
				System.out.println("Usage : java AfficheurNombresPremiers <Classe Ensemble> <MAX>");
			} else {
				String nomClasse = args[0];
				final int MAX = Integer.parseInt(args[1]);
				Ensemble ens = FabriqueEnsemble.newObjetEnsembleDepuis(nomClasse, MAX-1);
				new Crible(ens).cribler(MAX);
			}
		}
		catch (NumberFormatException e) {
			System.out.println("Le deuxième argument doit être un entier !");
		} catch (ClassNotFoundException e) {
			System.out.println("Impossible de trouver la classe : "
					+ e.getMessage());
		} catch (NoSuchMethodException e) {
			String name = args[0];
			System.out.println("La classe " + name + " doit définir :");
			System.out.println("\t- soit " + name + "(), constructeur par défaut");
			System.out.println("\t- soit " + name + "(int)");
		} catch (java.lang.reflect.InvocationTargetException e) {
			Throwable aSignaler = e.getCause() == null ? e : e.getCause();
			aSignaler.printStackTrace();
		} catch (Exception e) {
			System.out.println("Erreur lors de l'exécution : " + e.getMessage());
			e.printStackTrace();
		}
	}

}
// vi: sw=4 ts=4

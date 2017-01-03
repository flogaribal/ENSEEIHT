import java.lang.reflect.*;

/** Permet de créer un ensemble à partir de son type (nécessairement une classe
 * concère réalisation Ensemble).
  * @author	Xavier Crégut
  * @version	$Revision$
  */
public class FabriqueEnsemble {

	/** Obtenir un objet de type Ensemble à partir de la classe
	 * nomClasse.  L'objet est initialisé soit avec le constructeur par défaut,
	 * soit avec le constructeur qui prend un int en paramètre.
	 * @param nomClasse	nom de la classe qui permettra de créer l'objet
	 * @param param paramètre à fournir au constructeur de la classe
	 * @return l'objet Ensemble créé
	 */
	public static Ensemble newObjetEnsembleDepuis(String nomClasse, int param)
			throws InstantiationException, NoSuchMethodException,
					IllegalAccessException, ClassNotFoundException,
					InvocationTargetException
	{
		// Attention : ce code s'appuie sur des notions non encore vues :
		//	- les exceptions
		//	- la réflexivité, avec une partie introspection (retrouver les
		//	  information du programme pendant son exécution, par exemple
		//	  une classe à partir de son nom, un constructeur de cette
		//	  classe grâce à sa signature...) et une partie intercession qui
		//	  permet de modifier l'état du programme à partir des
		//	  information obtenues par introspection (créer une nouvelle
		//	  instance, appeler une méthode).
		Ensemble objet = null;	// poignée sur l'objet à créer
		Class<?> classe =  Class.forName(nomClasse);
		if (classe.isInterface()) {
			throw new RuntimeException(classe.getName() + " est une interface !\n"
					+ "Il faut fournir une classe concrète.");
		}
		try {
			// essayer le constructeur par défaut
			objet = (Ensemble) classe.newInstance();
		} catch (InstantiationException e) {
			// il doit y avoir un constructeur avec un entier en
			// paramètre
			Constructor<?> constructeur = classe.getConstructor(int.class);
			objet = (Ensemble) constructeur.newInstance(param);
		}
		return objet;
	}

}
// vi: sw=4 ts=4

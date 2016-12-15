import java.util.ArrayList;
import java.util.List;

public class Exemple1 {
	
	public static void main(String[] args) {
		String gameName = "Exemple 1";
		Player playerName = new Player("404");
		Place enigme = new Place("Enigme");
		Place succes = new Place("Succès");
		Place echec = new Place("Echec");
		List<Place> endPlaces = new ArrayList<Place>();
		endPlaces.add(echec);
		endPlaces.add(succes);
		
		
		Item tentative = new Item("Tentative", true, 10);		
		Path path_succes = new Path("Succes", false, true, true, succes);
		Path path_echec = new Path("Echec", false, true, true, echec);
		Knowledge reussite = new Knowledge("Réussite", true);
		
		List<Item> itemsDiff = new ArrayList<Item>();
		itemsDiff.add(tentative);
		itemsDiff.add(tentative);
		itemsDiff.add(tentative);
		
		Difficulty level = new Difficulty(0, 30, new ArrayList<Knowledge>(), itemsDiff);
		Game game = new Game(gameName, playerName, level, enigme, endPlaces);

		
		Condition conditionSuccesVisible = new Condition("Condition succès", game.getPlayer());
		conditionSuccesVisible.addKnowledgeCondition(reussite);
		path_succes.addVisibleCondition(conditionSuccesVisible);
		
		Condition conditionEchecVisible = new Condition("Condition échec", game.getPlayer());
		conditionEchecVisible.addItemCondition(new ItemInCondition(tentative, 0, true));
		path_echec.addVisibleCondition(conditionEchecVisible);
		
		Condition resteTentative = new Condition("Reste tentatives", game.getPlayer());
		resteTentative.addItemCondition(new ItemInCondition(tentative, 1, false));
		
		Interaction interaction_sphinx = new Interaction("Question");
		
		interaction_sphinx.addConditionBegin(resteTentative);
		
		
		Action mauvaisChoix = new Action(game, Actions.CONSUME_ITEM, "Perds 1 tentative");
		mauvaisChoix.addItemToConsume(tentative);
		Action bonChoix = new Action(game, Actions.LEARN_KNOWLEDGE, "Apprends Réussite");
		bonChoix.addKnowledgeToLearn(reussite);
		
		Proposition choix1 = new Proposition(mauvaisChoix, "Réponse 1");
		Proposition choix2 = new Proposition(mauvaisChoix, "Réponse 2");
		Proposition choix3 = new Proposition(bonChoix, "Réponse 3");
		Proposition choix4 = new Proposition(mauvaisChoix, "Réponse 4");
		interaction_sphinx.addProposition(choix1);
		interaction_sphinx.addProposition(choix2);
		interaction_sphinx.addProposition(choix3);
		interaction_sphinx.addProposition(choix4);
		
		People sphinx = new People("Sphinx", true, true, interaction_sphinx, new ArrayList<Condition>(),new ArrayList<Condition>());
		enigme.addPeople(sphinx);
		enigme.addPath(path_succes);
		enigme.addPath(path_echec);
		
		game.initGame();
		
		game.play();
	}
	
}

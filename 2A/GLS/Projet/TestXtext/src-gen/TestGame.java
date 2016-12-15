
import java.util.ArrayList;
import java.util.List;
 
public class TestGame {

	public static void main (String[] args) {
		String gameName   = "testGame";
		Player player_test = new Player("test");


		List<Place> allPlaces = new ArrayList<Place>();
			Place Enigme = new Place("Enigme");
			allPlaces.add(Enigme);
			Place Success = new Place("Success");
			allPlaces.add(Success);
			Place Echec = new Place("Echec");
			allPlaces.add(Echec);
		

			Item it_Tentative = new Item("Tentative", 1==1, 10);

			Knowledge kn_Reussite = new Knowledge("Reussite", 1==1);
		
				Path path_enigmeToSuccess = new Path("enigmeToSuccess", 0==1, 1==1, 1==1, Success);
			
					Condition cond_enigmeToSuccess_visible = new Condition("enigmeToSuccess_visible", player_test);
					
			
							cond_enigmeToSuccess_visible.addKnowledgeCondition(kn_Reussite);
							path_enigmeToSuccess.addVisibleCondition(cond_enigmeToSuccess_visible);
			
			
			
			
				Path path_enigmeToEchec = new Path("enigmeToEchec", 0==1, 1==1, 1==1, Echec);
			
					Condition cond_enigmeToEchec_visible = new Condition("enigmeToEchec_visible", player_test);
					
			
			
							ItemInCondition it_cond_Tentative = new ItemInCondition(it_Tentative,0,1==1);
							cond_enigmeToEchec_visible.addItemCondition(it_cond_Tentative);
							path_enigmeToEchec.addVisibleCondition(cond_enigmeToEchec_visible);
			
			
				

		
		List<Place> endPlaces = new ArrayList<Place>();
			endPlaces.add(Echec);
			endPlaces.add(Success);



		List<Item> itemsDiff1 = new ArrayList<Item>();
		List<Knowledge> knowledgesDiff1 = new ArrayList<Knowledge>();
	
			itemsDiff1.add(it_Tentative);


		Difficulty Diff_1 = new Difficulty(1, 3,knowledgesDiff1,itemsDiff1);



		Game testGame = new Game(gameName,player_test,Diff_1,Enigme, endPlaces,allPlaces);
				 
				
			
			
					Interaction inter_Sphinx_interSphinx = new Interaction("interSphinx");
				
						Action  act_action1 = new Action(testGame,Actions.LEARN_KNOWLEDGE,"action1");
				
						Proposition prop_BonneReponse1 = new Proposition(act_action1,"BonneReponse1");
				
						inter_Sphinx_interSphinx.addProposition(prop_BonneReponse1);
						
				
						Action  act_action2 = new Action(testGame,Actions.CONSUME_ITEM,"action2");
				
						Proposition prop_MauvaiseReponse1 = new Proposition(act_action2,"MauvaiseReponse1");
				
						inter_Sphinx_interSphinx.addProposition(prop_MauvaiseReponse1);
						
				
				
						Condition condBegin_reste_tentative = new Condition("reste_tentative", player_test);
						
				
								ItemInCondition it_condBegin_Tentative = new ItemInCondition(it_Tentative,1,0==1);
								condBegin_reste_tentative.addItemInCondition(it_condBegin_Tentative);
						inter_Sphinx_interSphinx.addConditionBegin(condBegin_reste_tentative);		
				
				
				
				
				
			
			
				List<Condition> condIsVisible = new ArrayList<Condition>();  
			
			
			
				List<Condition> condActive = new ArrayList<Condition>();  
			
				People Sphinx = new People("Sphinx", 1==1, 1==1, inter_Sphinx_interSphinx ,condIsVisible, condActive);

		
				Enigme.addPeople(Sphinx);
				Enigme.addPath(path_enigmeToEchec);
				Enigme.addPath(path_enigmeToSuccess);

		testGame.initGame();		
		testGame.play();


	}

}



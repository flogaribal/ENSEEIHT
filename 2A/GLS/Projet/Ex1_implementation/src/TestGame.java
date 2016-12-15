
import java.util.ArrayList;
import java.util.List;
 
public class TestGame {

	public static void main (String[] args) {
		String gameName   = "testGame";
		Player playerName = new Player ("test");

		
			Place Enigme = new Place("Enigme");
			Place Success = new Place("Success");
			Place Echec = new Place("Echec");
			Player test = new Player("test");

			Item it_Tentative = new Item("Tentative", 1==1, 1);

			Knowledge kn_Reussite = new Knowledge("Reussite", 1==1);
		
				Path path_enigmeToSuccess = new Path("enigmeToSuccess", 0==1, 1==1, 1==1, Success);
			
					Condition cond_path_visible = new Condition("path_visible", test);
					
			
							cond_path_visible.addKnowledgeCondition(kn_Reussite);
			
			
			
				Path path_enigmeToEchec = new Path("enigmeToEchec", 0==1, 1==1, 1==1, Echec);
			
					Condition cond_path_visible1 = new Condition("path_visible", test);
					
			
			
							ItemInCondition it_cond_Tentative = new ItemInCondition(it_Tentative,0,1==1);
							cond_path_visible.addItemCondition(it_cond_Tentative);
			
			
				

		
		List<Place> endPlaces = new ArrayList<Place>();
			endPlaces.add(Echec);
			endPlaces.add(Success);
		List<Item> itemsDiff1 = new ArrayList<Item>();
		List<Knowledge> knowledgesDiff1 = new ArrayList<Knowledge>();
	
			itemsDiff1.add(it_Tentative);


		Difficulty Diff_1 = new Difficulty(1, 3,knowledgesDiff1,itemsDiff1);



		Game testGame = new Game(gameName,playerName,Diff_1,Enigme, endPlaces);
		
		
		 
				
				
			
					Interaction inter_Sphinx_interSphinx = new Interaction("interSphinx");
				
						Action  act_action1 = new Action(testGame,Actions.LEARN_KNOWLEDGE,"action1");
				
						Proposition prop_BonneReponse1 = new Proposition(act_action1,"BonneReponse1");
				
						inter_Sphinx_interSphinx.addProposition(prop_BonneReponse1);
						
				
						Action  act_action2 = new Action(testGame,Actions.CONSUME_ITEM,"action2");
				
						Proposition prop_MauvaiseReponse1 = new Proposition(act_action1,"MauvaiseReponse1");
				
						inter_Sphinx_interSphinx.addProposition(prop_MauvaiseReponse1);

				
			
			
				List<Condition> condIsVisible = new ArrayList<Condition>(); 
			
				List<Condition> condActive = new ArrayList<Condition>(); 
				
				People Sphinx = new People("Sphinx", true,true,inter_Sphinx_interSphinx,condIsVisible, condActive);
			

		
		
				Enigme.addPeople(Sphinx);
				Enigme.addPath(path_enigmeToEchec);
				Enigme.addPath(path_enigmeToSuccess);

		testGame.initGame();		
		testGame.play();


	}

}



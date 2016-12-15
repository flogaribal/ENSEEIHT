import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

	/* ATTRIBUTES */
	private String gameName; 
	private List<Action> actions;
	private List<Place> places;
	private Place startPlace;
	private List<Place> endPlace;
	private Place currentPlace;
	private Difficulty level;
	private Player player;
	private Scanner sc;
	
	public Game (String name, Player playerName, Difficulty lvl, Place stPlace, List<Place> edPlace) {
		gameName = name;
		
		actions = new ArrayList<Action>();
		
		startPlace = stPlace;
		endPlace = edPlace;
		currentPlace = startPlace;
		
		level = lvl;
		
		player = playerName;
		sc = new Scanner(System.in);
	}
	
	public void play() {
		while(!endPlace.contains(currentPlace)) {
			System.out.println("In place " + currentPlace.getName());
			doMandatoryAction();
			Place oldPlace = currentPlace;
			while (oldPlace == currentPlace && !openPathMandatory()) {
				askWhatToDo();
			}
			if (openPathMandatory()) {
				takeMandatoryPath();
			}
		}
		sc.close();
		System.out.println("Game ended");
	}

	/**
	 * Get the current game Name 
	 * @return game name : String
	 */
    public String getName() {
    	return gameName;
    }

    /**
     * Get the current game Difficulty
     * @return difficulty : Difficulty
     */
    public Difficulty getDifficulte() {
    	return level;
    }

    
    /**
     * Set the game difficulty to difficulty given
     * @param dif : Difficulty
     */
    public void setDifficulte(Difficulty dif) {
    	level = dif;
    }

    public void takePath(Path p) {
    	if (p.isOpen() && p.isVisible()) {
    		currentPlace = p.getEndPlace();
    		System.out.println("Moving to " + currentPlace.getName());
    		doMandatoryAction();
    	}
    }

    public void doMandatoryAction() {
    	Place current = this.currentPlace;
    	List<People> people = current.getVisiplePeople();
    	for (People p : people) {
    		if (p.isMandatory()) {
    			System.out.println("Interaction with " + p.getDescription());
    			this.doInteraction(p.getInteraction());
    		}
    		// If the last action made the player move
    		if (this.currentPlace != current) {
    			break;
    		}
    	}
    	if (currentPlace == current) {
    		for (Path p : currentPlace.getVisibleOpenPaths())
    		{
    			if (p.isMandatory()) {
    				takePath(p);
    			}
    		}
    	}
    	
    }

    public void doInteraction(Interaction i) {
    	System.out.println(i.getName());
		Proposition choice = askPropositions(i);
		System.out.println("Doing action : " + choice.getAction().getName());
		choice.getAction().doAction();
		doNext(choice.getAction());
    }
    
    public void doNext(Action a) {
    	if (a.getNextInteraction() != null) {
			doInteraction(a.getNextInteraction());
		}
    }
    
    public Proposition askPropositions(Interaction i) {
    	Integer cpt = 1;
    	for (Proposition p : i.getPropositions()) {
    		System.out.println(cpt.toString() + " : " + p.getValue());
    		cpt ++;
    	}
    	System.out.print("Your choice : ");
    	int choice;
    	do {
    		choice = sc.nextInt();
    	} while(choice < 1 && choice > i.getPropositions().size());
    	return i.getPropositions().get(choice - 1);
    }
    
    public void askWhatToDo() {
    	List<People> people = currentPlace.getVisiplePeople();
    	List<Item> items = currentPlace.getVisibleItems();
    	List<Knowledge> knowledge = currentPlace.getVisibleKnowledge();
    	List<Path> paths = currentPlace.getVisibleOpenPaths();
    	int choice = -1;
    	
    	if (people.size() + items.size() + knowledge.size() + paths.size() == 1) {
    		choice = 0;
    	} else if (people.size() > 0 || items.size() > 0 || knowledge.size() > 0 || paths.size() > 0) {
    		int cpt = 1;
    		System.out.println("What do you want to do now ?");
    		for (People p : people) {
    			if (p.canInteract()) {
    				System.out.println(Integer.toString(cpt) + " Interract with " + p.getDescription());
    				cpt ++;
    			}
    		}
    		for (Item i : items) {
    			System.out.println(Integer.toString(cpt) + " Take " + i.getDescription());
    			cpt ++;
    		}
    		for (Knowledge k : knowledge) {
    			System.out.println(Integer.toString(cpt) + " Learn" + k.getDescription());
    			cpt ++;
    		}
    		for (Path p : paths) {
    			System.out.println(Integer.toString(cpt) + " Go to " + p.getEndPlace().getName());
    			cpt ++;
    		}
    		
    		while (choice < 0 && choice >= people.size() + items.size() + knowledge.size() + paths.size()){
    			System.out.print("Your choice : ");
    			choice = sc.nextInt();
    			choice -= 1;
    		}
    	}
    	
    	if (choice < people.size() && people.size() > 0) {
			doInteraction(people.get(choice).getInteraction());
		} else if (choice < people.size() + items.size() && items.size() > 0) {
			player.takeObject(items.get(choice - people.size()));
		} else if (choice < people.size() + items.size() + knowledge.size() && knowledge.size() > 0) {
			player.learnKnowledge(knowledge.get(choice - people.size() - items.size()));
		} else {
			takePath(paths.get(choice- people.size() - items.size() - knowledge.size()));
		}
    }
    
    private boolean openPathMandatory() {
		boolean result = false;
		for (Path p : currentPlace.getVisibleOpenPaths()) {
			result |= p.isMandatory();
		}
		return result;
	}
    
	private void takeMandatoryPath() {
		Path mandatory = null;
		for (Path p : currentPlace.getVisibleOpenPaths()) {
			if (p.isMandatory()) {
				mandatory = p;
				break;
			}
		}
		takePath(mandatory);
	}
    
    public Player getPlayer() {
    	return player;
    }
    
    /**
     * Init the game
     * Give to the player the initial knowledge and items according to the difficulty choosen
     */
    public void initGame() {
    	player.addAllItems(level.getItemsAtBeginning());
    	player.addKnowledge(level.getKnowledgesAtBeginning());
    }
}

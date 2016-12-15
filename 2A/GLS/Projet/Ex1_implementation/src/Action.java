import java.util.ArrayList;
import java.util.List;

public class Action {
	
	private Interaction nextInteraction;
	private List<Knowledge> knowledgeToLearn;
	private Path pathToFollow;
	private List<Item> itemToTake;
	private List<Item> itemToConsume;
	private Actions action;
	private Game game;
	private List<Condition> conditionActionAvailabe;
	private String name;
	
	public Action(Game game, Actions a, String name) {
		this.name = name;
		this.action = a;
		this.game = game;
		this.itemToConsume = new ArrayList<Item>();
		this.itemToTake = new ArrayList<Item>();
		this.knowledgeToLearn = new ArrayList<Knowledge>();
		this.conditionActionAvailabe = new ArrayList<Condition>();
	}
	
	/**
	 * Do the action it is supposed to do
	 */
	public void doAction() {
		boolean available = true;
		for (Condition c : conditionActionAvailabe) {
			available &= c.isTrue();
		}
		if (available) {
			Player player = game.getPlayer();
			switch(action) {
				case TAKE_PATH:
					game.takePath(pathToFollow);
					break;
				case TAKE_ITEM:
					for (Item i : itemToTake) {
						player.takeObject(i);
					}
					break;
				case CONSUME_ITEM:
					for (Item i : itemToConsume) {
						player.useObject(i);
					}
					break;
				case LEARN_KNOWLEDGE:
					for (Knowledge k : knowledgeToLearn) {
						player.getConnaissances().add(k);
					}
					break;
			}
		}
	}
	
	/**
	 * Gets the name
	 * @return name : String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the action
	 * @return action : Actions
	 */
	public Actions getAction() {
		return action;
	}
	
	/**
	 * Setter of the path to follow
	 */
	public void setPath(Path p) {
		pathToFollow = p;
	}

	
	/**
	 * adds an item to take
	 */
	public void addItemToTake(Item i) {
		itemToTake.add(i);
	}
	
	/**
	 * adds an item to consume
	 */
	public void addItemToConsume(Item i) {
		itemToConsume.add(i);
	}
	
	/**
	 * adds a knowledge to learn
	 */
	public void addKnowledgeToLearn(Knowledge k) {
		knowledgeToLearn.add(k);
	}

	/**
	 * Adds a condition to the conditions of availability
	 * @param c
	 */
	public void addCondition(Condition c) {
		conditionActionAvailabe.add(c);
	}
	
	/**
	 * @return nextInteraction : Interaction
	 */
	public Interaction getNextInteraction() {
		return nextInteraction;
	}

	public void setNextInteraction(Interaction nextInteraction) {
		this.nextInteraction = nextInteraction;
	}
	
}
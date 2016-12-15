import java.util.ArrayList;
import java.util.List;


/**
 * Path 
 * @author fgaribal
 *
 */
public class Path extends GameElement {

	/* ATTRIBUTE */ 
	private boolean isOpen;
	private List<Condition> openningCondition;
	
	private boolean isMandatory;
	
	private Place endPlace;
	private List<Condition> visibleConditions;
	private List<Item> itemsGiven;
	private List<Knowledge> knowledgeGiven;
	
	private List<Item> itemsConsumed;
	
	public Path(String desc, boolean isVis, boolean isOp, boolean isMandat, Place endPla) {
		super(desc, isVis);
		
		isOpen = isOp;
		isMandatory = isMandat;
		endPlace = endPla;
		
		openningCondition = new ArrayList<Condition>();
		visibleConditions = new ArrayList<Condition>();
		itemsGiven = new ArrayList<Item>();
		knowledgeGiven = new ArrayList<Knowledge>();
		itemsConsumed = new ArrayList<Item>();
	}	
	
	public void updateStats() {
		boolean open = true;
		for (Condition c : openningCondition) {
			open &= c.isTrue();
		}
		setOpen(open);
		
		boolean visible = true;
		for (Condition c : visibleConditions) {
			visible &= c.isTrue();
		}
		setVisible(visible);
	}
	
	/**
	 * Return true if the path is open
	 * @return isOpen : Boolean
	 */
	public boolean isOpen() {
		return isOpen;
	}
	
	/**
	 * Set isOpen to b
	 * @param b : Boolean
	 */
	public void setOpen (Boolean b) {
		isOpen = b;
	}
	
	/**
	 * Return true if the path is mandatory 
	 * @return isMandatory : Open
	 */
	public boolean isMandatory() {
		return isMandatory;
	}
	
	/**
	 * Set isMandatory to b
	 * @param b
	 */
	public void setMandatory (Boolean b) {
		isMandatory = b;
	}


	/**
	 * @return the openningCondition
	 */
	public List<Condition> getOpenningCondition() {
		return openningCondition;
	}
	
	/**
	 * Add a new openning condition
	 * @param c
	 */
	public void addOpenningCondition(Condition c){
		openningCondition.add(c);
	}


	/**
	 * @return the visible conditions of the path
	 */
	public List<Condition> getVisibleConditions() {
		return visibleConditions;
	}
	
	/**
	 * Add a new visible condition
	 * @param c : Condition
	 */
	public void addVisibleCondition (Condition c){
		visibleConditions.add(c);
	}


	/**
	 * @return the itemsGiven
	 */
	public List<Item> getItemsGiven() {
		return itemsGiven;
	}

	/**
	 * Add a given Item to the player when goes through this path
	 * @param i : Item
	 */
	public void addItemGiven(Item i){
		itemsGiven.add(i);
	}

	/**
	 * @return the knowledgeGiven
	 */
	public List<Knowledge> getKnowledgeGiven() {
		return knowledgeGiven;
	}
	
	/**
	 * Add a give knowledge to the player when he goes through this path
	 * @param k : Knowledge
	 */
	public void addKnowledgeGiven(Knowledge k) {
		knowledgeGiven.add(k);
	}


	/**
	 * @return the itemsConsumed
	 */
	public List<Item> getItemsConsumed() {
		return itemsConsumed;
	}
	
	/**
	 * Add a consumed item to this path
	 * @param i : Item
	 */
	public void addItemConsumed(Item i){
		itemsConsumed.add(i);
	}


	public Place getEndPlace() {
		return endPlace;
	}
		
	
}
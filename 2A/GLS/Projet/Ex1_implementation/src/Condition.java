import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Condition {
	
	private String name;
	private List<Knowledge> knowledges;
	private List<ItemInCondition> itemsConditions;
	private Player player;
	
	public Condition(String n, Player p){
		player = p;
		name = n;
		knowledges = new ArrayList<Knowledge>();
		itemsConditions = new ArrayList<ItemInCondition>();
	}
	
	public boolean isTrue() {
		boolean result = true;
		for (Knowledge k : knowledges) {
			result &= player.getConnaissances().contains(k);
		}
		if (result) {
			for (ItemInCondition i : itemsConditions) {
				if(i.getExactQuantity()) {
					result &= Collections.frequency(player.getItems(), i.getItem()) == i.getQuantity();
				} else {
					result &= Collections.frequency(player.getItems(), i.getItem()) >= i.getQuantity();
				}
			}
		}
		
		return result;
	}
	
	/**
	 * Adds a ItemInCondition to the List
	 * @param iCondition : ItemInCondition
	 */
	public void addItemCondition(ItemInCondition iCondition) {
		itemsConditions.add(iCondition);
	}
	
	/**
	 * Adds a knowledge to the condition
	 * @param k : Knowledge
	 */
	public void addKnowledgeCondition(Knowledge k) {
		knowledges.add(k);
	}
	
	/**
	 * Returns the name of the condition
	 * @return name : String
	 */
	public String getName() {
		return name;
	}
}
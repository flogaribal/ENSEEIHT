import java.util.List;

/**
 * Game difficulty definition
 * @author fgaribal
 */
public class Difficulty {
	
	/* ATTRIBUTE */
	private int level;
	private int weightMax;
	private List<Knowledge> knowledgesAtBeginning;
	private List<Item> itemsAtBeginning;
	
	public Difficulty(int lvl, int wMax, List<Knowledge> k, List<Item> i) {
		level = lvl;
		weightMax = wMax;
		knowledgesAtBeginning = k;
		itemsAtBeginning = i;
	}

	/**
	 * Get the level
	 * @return level : int
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Set the level to int given
	 * @param level : int
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * Get the max Item weight   
	 * @return weightMax : int
	 */
	public int getWeightMax() {
		return weightMax;
	}

	/**
	 * Set the max items weight
	 * @param weighMax : int
	 */
	public void setWeightMax(int weighMax) {
		this.weightMax = weighMax;
	}

	/**
	 * Get the list of knowledges at the beginning
	 * @return knowledgesAtBeginning : List<Knowledge>
	 */
	public List<Knowledge> getKnowledgesAtBeginning() {
		return knowledgesAtBeginning;
	}

	/**
	 * Set the list of knowledges at the beginning
	 * @param knowledgesAtBeginning : List<Knowledge>
	 */
	public void setKnowledgesAtBeginning(List<Knowledge> knowledgesAtBeginning) {
		this.knowledgesAtBeginning = knowledgesAtBeginning;
	}

	/**
	 * Get the list of Items at the beginning
	 * @return itemsAtBeginning : List<Item>
	 */
	public List<Item> getItemsAtBeginning() {
		return itemsAtBeginning;
	}

	/**
	 * Set the list of items at the beginning
	 * @return itemsAtBeginning : List<Item>
	 */
	public void setItemsAtBeginning(List<Item> itemsAtBeginning) {
		this.itemsAtBeginning = itemsAtBeginning;
	}
	
	
		
}
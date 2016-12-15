import java.util.List;

public class Recipe {
	
	private List<Item> itemsUsed;
	private List<Item> itemsMade;
	private Condition condition;
	
	public Recipe(List<Item> itemsToTransform, List<Item> itemsResult)
	{
		this.itemsUsed = itemsToTransform;
		this.itemsMade = itemsResult;
	}
	
	public List<Item> transform(List<Item> itemsToTransform) {
		boolean transform = false;
		if (condition.isTrue()) {
			if (itemsToTransform.equals(itemsUsed)) {
				transform = true;
			}
		}
		
		if (transform) {
			return itemsMade;
		} else {
			return null;
		}
	}
}
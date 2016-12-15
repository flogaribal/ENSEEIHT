
public class ItemInCondition {
	
	private Item item;
	private int quantity;
	private boolean exactQuantity;
	
	public ItemInCondition(Item item, int quantity, boolean exact) {
		this.item = item;
		this.quantity = quantity;
		this.exactQuantity = exact;
	}
	
	/**
	 * @return item : Item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * @return quantity : int
	 */
	public int getQuantity() {
		return quantity;
	}

	public boolean getExactQuantity() {
		return exactQuantity;
	}
}

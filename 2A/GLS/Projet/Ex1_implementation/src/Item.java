
public class Item extends GameElement {
	private int size;

    public Item(String desc, boolean isVisible, int size) {
    	super(desc, isVisible);
    	this.size = size;
    }

    /**
     * @return the object size
     */
    public int getSize() {
        return size;
    }
}

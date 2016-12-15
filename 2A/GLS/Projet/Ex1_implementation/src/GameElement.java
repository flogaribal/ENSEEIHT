/**
 * Game Element
 * @author fgaribal
 *
 */
public abstract class GameElement {
	
	/* ATTRIBUTES */
	private String description;
	private boolean isVisible;
	
	public GameElement (String desc, boolean isVis) {
		description = desc;
		isVisible = isVis;
	}

	/**
	 * Get the game element description
	 * @return description : String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the game element description
	 * @param description : String
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Return true if the game element is visible
	 * @return isVisible : boolean
	 */
	public boolean isVisible() {
		return isVisible;
	}

	/**
	 * Set the visibility of the game element
	 * @param isVisible
	 */
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
}
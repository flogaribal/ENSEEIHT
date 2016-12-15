public class Proposition {
	
	private Action action;
	private String value;
	
	public Proposition(Action a, String value) {
		this.action = a;
		this.value = value;
	}
	
	/**
	 * Returns the value
	 * @return value : String
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @return true if the action is exiting the game
	 */
	public boolean isFin() {
		return action.getAction() == Actions.QUIT;
	}
	
	/**
	 * @return the action
	 */
	public Action getAction() {
		return action;
	}
	
	/**
	 * @param acion l'acion de la proposition
	 */
	public void setAction(Action action) {
		this.action = action;
	}
	
}
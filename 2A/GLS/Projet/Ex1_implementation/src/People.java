import java.util.List;

public class People extends GameElement{

	/* ATTRIBUTE */
	private Interaction interaction;
	private boolean isMandatory;
	private List<Condition> conditionsVisible;
	private List<Condition> conditionsActiv;
	
	public People(String description, boolean isVisible, boolean isManda, Interaction inter,List<Condition> condVis, List<Condition> condActiv) {
		super(description, isVisible);
		isMandatory = isManda;
		interaction = inter;
		conditionsVisible = condVis;
		conditionsActiv = condActiv;
	}
	
	/**
	 * Returns the interaction for this character
	 * @return interaction : Interaction
	 */
	public Interaction getInteraction() {
		return interaction;
	}
	
	/**
	 * Returns true if the person is mandatory
	 * @return isMandatory : boolean
	 */
	public boolean isMandatory() {
		return isMandatory;
	}

	/**
	 * Sets the mandatory state of the person
	 * @param isMandatory
	 */
	public void setMandatory(boolean isMandatory) {
		this.isMandatory = isMandatory;
	}

	/**
	 * Returns true if the player can interact with the character
	 * @return boolean
	 */
	public boolean canInteract() {
		boolean result = true;
		for (Condition c : interaction.getConditionsBegin()) {
			result &= c.isTrue();
		}
		return result;
	}

	/**
	 * @return the conditionsVisible
	 */
	public List<Condition> getConditionsVisible() {
		return conditionsVisible;
	}

	/**
	 * @param conditionsVisible the conditionsVisible to set
	 */
	public void setConditionsVisible(List<Condition> conditionsVisible) {
		this.conditionsVisible = conditionsVisible;
	}
	
	public void addConditionsVisible(Condition conditionsVis) {
		this.conditionsVisible.add(conditionsVis);
	}

	/**
	 * @return the conditionsActiv
	 */
	public List<Condition> getConditionsActiv() {
		return conditionsActiv;
	}

	/**
	 * @param conditionsActiv the conditionsActiv to set
	 */
	public void setConditionsActiv(List<Condition> conditionsActiv) {
		this.conditionsActiv = conditionsActiv;
	}
	
	public void addConditionsActiv(Condition conditionsActiv) {
		this.conditionsActiv.add(conditionsActiv);
	}
	
}
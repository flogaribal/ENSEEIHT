import java.util.ArrayList;
import java.util.List;

public class Interaction {

	/* ATTRIBUTE */
	private String name;
	private List<Condition> conditionsBegin;
	private List<Condition> conditionsEnd;
	private List<Proposition> propositions;
	
	public Interaction(String n, List<Condition> condBegin, List<Condition> condEnd, List<Proposition> props){
		name = n;
		conditionsBegin = condBegin;
		conditionsEnd = condEnd;
		setPropositions(props);
	}
	
	public Interaction(String n) {
		name = n;
		conditionsBegin = new ArrayList<Condition>();
		conditionsEnd = new ArrayList<Condition>();
		setPropositions(new ArrayList<Proposition>());
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the conditionsBegin
	 */
	public List<Condition> getConditionsBegin() {
		return conditionsBegin;
	}

	/**
	 * @param conditionsBegin the conditionsBegin to set
	 */
	public void setConditionsBegin(List<Condition> conditionsBegin) {
		this.conditionsBegin = conditionsBegin;
	}
	
	/**
	 * Add begin condition 
	 * @param c
	 */
	public void addConditionBegin(Condition c) {
		this.conditionsBegin.add(c);
	}
	

	/**
	 * @return the conditionsEnd
	 */
	public List<Condition> getConditionsEnd() {
		return conditionsEnd;
	}

	/**
	 * @param conditionsEnd the conditionsEnd to set
	 */
	public void setConditionsEnd(List<Condition> conditionsEnd) {
		this.conditionsEnd = conditionsEnd;
	}
	
	/**
	 * Add end condition
	 * @param c
	 */
	public void addConditionEnd(Condition c) {
		this.conditionsEnd.add(c);
	}

	/**
	 * @return proposition : List<Proposition>
	 */
	public List<Proposition> getPropositions() {
		return propositions;
	}

	/**
	 * Sets the proposition list
	 * @param propositions
	 */
	public void setPropositions(List<Proposition> propositions) {
		this.propositions = propositions;
	}
	
	/**
	 * Adds a proposition to the list
	 * @param proposition : Proposition
	 */
	public void addProposition(Proposition p) {
		propositions.add(p);
	}
}
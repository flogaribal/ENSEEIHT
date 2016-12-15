import java.util.ArrayList;
import java.util.List;

public class Player {

	/* ATTRIBUTES */
    private String playerName;
    private List<Item> items;
    private List<Knowledge> knowledge;

    public Player(String name) {
    	playerName = name;
    	items = new ArrayList<Item>();
    	System.out.println("TT3"+items.size());
    	knowledge = new ArrayList<Knowledge>();
    }

    /**
     * Get the player name 
     * @return playerName : String
     */
    public String getNomJoueur() {
        return playerName;
    }
    
    /**
     * Adds a knowledge to the player
     * @param k : Knowledge
     */
    public void learnKnowledge(Knowledge k) {
    	knowledge.add(k);
    }

    /**
     * Get the list of items owned by the player
     * @return items : List<Item>
     */
    public List<Item> getItems() {
        return items;
    }
    
    /**
     * Add a list of items to the player
     * @param its
     */
    public void addAllItems(List<Item> its) {
    	items.addAll(its);
    }

    /**
     * Get the list of knowledges learned by the player
     * @return knowledges : List<Knowledge>
     */
    public List<Knowledge> getConnaissances() {
        return knowledge;
    }
    
    /**
     * Add a list of knowledge to the player
     * @param kn
     */
    public void addKnowledge(List<Knowledge> kn){
    	knowledge.addAll(kn);
    }

    /**
     * @param o : Item to take
     */
    public void takeObject(Item o) {
    	items.add(o);
    }

    /**
     * Drops the object on the current place
     * @param currentPlace : Place
     * @param o : Item to drop
     */
    public void dropObject(Item o, Place currentPlace) {
  		items.remove(o);
  		currentPlace.addItem(o);
    }

    /**
     * @param o : Item to use
     */
    public void useObject(Item o) {
    	items.remove(o);
    }
}

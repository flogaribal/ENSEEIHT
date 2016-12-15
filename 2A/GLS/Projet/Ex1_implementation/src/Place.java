import java.util.ArrayList;
import java.util.List;

public class Place {
	
	private String name;
	private List<Item> items;
	private List<Knowledge> knowledges;
	private List<Path> paths;
	private List<People> people;
	
	public Place(String n) {
		name = n;
		items = new ArrayList<Item>();
		knowledges = new ArrayList<Knowledge>();
		paths = new ArrayList<Path>();
		people = new ArrayList<People>();
	}
	
	/**
	 * @return name : String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns only visible paths
	 * @return visible_paths : List<Path>
	 */
	public List<Path> getVisiblePaths() {
		List<Path> result = new ArrayList<Path>();
		for (Path p : paths) {
			p.updateStats();
			if (p.isVisible()) {
				result.add(p);
			}
		}
		return result;
	}
	
	/**
	 * Returns only visible people
	 * @return visible_people : List<People>
	 */
	public List<People> getVisiplePeople() {
		List<People> result = new ArrayList<People>();
		for (People p : people) {
			if (p.isVisible()) {
				result.add(p);
			}
		}
		return result;
	}
	
	/**
	 * Returns only visible knowledges
	 * @return visible_knowledges : List<Knowledges>
	 */
	public List<Knowledge> getVisibleKnowledge() {
		List<Knowledge> result = new ArrayList<Knowledge>();
		for (Knowledge k : knowledges) {
			if (k.isVisible()) {
				result.add(k);
			}
		}
		return result;
	}
	
	/**
	 * Returns only visible items
	 * @return visible_items : List<Item>
	 */
	public List<Item> getVisibleItems() {
		List<Item> result = new ArrayList<Item>();
		for (Item i : items) {
			if (i.isVisible()) {
				result.add(i);
			}
		}
		return result;
	}
	
	
	/**
	 * Adds a path to a place
	 * @param p path to add
	 */
	public void addPath(Path p) {
		paths.add(p);
	}
	
	/**
	 * Adds knowledge to a place
	 * @param k knowledge to add
	 */
	public void addKnowledge(Knowledge k) {
		knowledges.add(k);
	}
	
	/**
	 * Adds a person to a place
	 * @param p people to add
	 */
	public void addPeople(People p) {
		people.add(p);
	}
	
	/**
	 * Add an item to a place
	 * @param i item to add
	 */
	public void addItem(Item i) {
		items.add(i);
	}

	public List<Path> getVisibleOpenPaths() {
		List<Path> result = new ArrayList<Path>();
		for (Path p : paths) {
			p.updateStats();
			if (p.isVisible() && p.isOpen()) {
				result.add(p);
			}
		}
		return result;
	}
}
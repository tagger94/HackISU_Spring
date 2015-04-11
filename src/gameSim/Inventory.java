package gameSim;

/**
 * Class designed to track an inventory
 * 
 * @author Brennyn Hawbaker
 *
 */
public class Inventory {

	private String title;
	private int size;

	// Statistics vars
	private int takeCalled = 0;
	private int numTaken = 0;
	private int giveCalled = 0;
	private int numGiven = 0;

	/**
	 * Default constructor
	 */
	public Inventory() {
		title = "Inventory";
		size = 0;
	}

	/**
	 * Constructor with set size, -1 for "infinite" size
	 * @param size
	 *  -number of beginning tokens
	 */
	public Inventory(int size) {
		title = "Inventory";
		if (size < -1)
			throw new IllegalStateException();
		if (size == -1)
			this.size = Integer.MAX_VALUE;
		else
			this.size = size;
	}

	/**
	 * Constructor with set size and title, -1 for "infinite" size
	 * @param title
	 *  -Name of inventory
	 * @param size
	 *  -Number of beginning tokens
	 */
	public Inventory(String title, int size) {
		this.title = title;
		if (size < -1)
			throw new IllegalStateException();
		this.size = size;
	}

	/**
	 * Subtract from the inventory
	 * @param num
	 *  -Number taken from intentory
	 */
	public int take(int num) {
		takeCalled++;
		if (num > size || num < -1)
			throw new IllegalStateException();
		if (size != -1)
			size -= num;
		numTaken += num;
		return num;
	}

	/**
	 * Subtract from the inventory with printed report
	 * @param num
	 *  -Number taken from inventory
	 */
	public int take_Report(int num) {
		this.take(num);
		System.out.println(title + " amount changed: -" + num);
		return num;
	}

	/**
	 * Add to inventory
	 * @param num
	 *  -Number given to inventory
	 */
	public int give(int num) {
		giveCalled++;
		if (size != -1)
			size += num;
		numGiven += num;
		return num;
	}

	/**
	 * Add to inventory with printed report
	 * @param num
	 *  -Number given to inventory
	 */
	public int give_Report(int num) {
		this.give(num);
		System.out.println(title + " amount changed: +" + num);
		return num;
	}

	/**
	 * Return takeCalled
	 * @return
	 *  -Number of times take method was called
	 */
	public int get_takeCalled() {
		return takeCalled;
	}

	/**
	 * Return numTaken
	 * @return
	 *  -Total number taken from inventory
	 */
	public int get_numTaken() {
		return numTaken;
	}

	/**
	 * Return giveCalled
	 * @return
	 *  -Number of times give was called
	 */
	public int get_giveCalled() {
		return giveCalled;
	}

	/**
	 * Return numGiven
	 * @return
	 *  -Total number given to the inventory
	 */
	public int get_numGiven() {
		return numGiven;
	}

	/**
	 * Return all stats
	 * @return
	 *  -String containing all stat variables
	 */
	public String getReport() {
		String report = "";
		report += "Take called: " + takeCalled + "\n";
		report += "Number taken: " + numTaken + "\n";
		report += "Give called: " + giveCalled + "\n";
		report += "Number given: " + numGiven + "\n";
		return report;
	}
	
	/**
	 * Returns name of inventory
	 * @return
	 *  -Title
	 */
	@Override
	public String toString(){
		return title; 
	}
}

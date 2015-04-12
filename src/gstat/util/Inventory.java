package gstat.util;

/**
 * A class to track an inventory of items in a game. Often used for money tokens
 * or chits.
 * 
 * @author Brennyn Hawbaker
 *
 */
public class Inventory {

	private String title;
	private int size;

	// Statistics vars
	private int takeCalled;
	private int numTaken;
	private int giveCalled;
	private int numGiven;

	/**
	 * Creates an empty inventory.
	 */
	public Inventory() {
		title = "Inventory";
		size = 0;
		takeCalled = 0;
		numTaken = 0;
		giveCalled = 0;
		numGiven = 0;
	}

	/**
	 * Creates an inventory of user defined size. Use -1 for "infinite" size.
	 * 
	 * @param size
	 *            Number of beginning tokens
	 */
	public Inventory(int size) {
		title = "Inventory";
		if (size < -1)
			throw new IllegalStateException();
		if (size == -1)
			this.size = Integer.MAX_VALUE;
		else
			this.size = size;
		takeCalled = 0;
		numTaken = 0;
		giveCalled = 0;
		numGiven = 0;
	}

	/**
	 * Creates an inventory with user defined size and title. Use -1 for
	 * "infinite" size.
	 * 
	 * @param title
	 *            Name of inventory
	 * @param size
	 *            Number of beginning tokens
	 */
	public Inventory(String title, int size) {
		this.title = title;
		if (size < -1)
			throw new IllegalStateException();
		this.size = size;
		takeCalled = 0;
		numTaken = 0;
		giveCalled = 0;
		numGiven = 0;
	}

	/**
	 * Removes specified number of items from the inventory.
	 * 
	 * @param num
	 *            Number taken from inventory
	 * 
	 * @return Number of pieces taken
	 */
	public int take(int num) {
		takeCalled++;
		if ((num > size && size > 0) || num < -1)
			throw new IllegalStateException();
		if (size != -1)
			size -= num;
		numTaken += num;
		return num;
	}

	/**
	 * Removes specified number of items from the inventory. Generates report.
	 * 
	 * @param num
	 *            Number taken from inventory
	 * 
	 * @return Number of pieces taken
	 */
	public int take_Report(int num) {
		this.take(num);
		Reporter.printReport(title + " amount changed: -" + num);
		return num;
	}

	/**
	 * Adds the specified number of items into the inventory.
	 * 
	 * @param num
	 *            Number given to inventory
	 * 
	 * @return Number of tokens given
	 */
	public int giveTo(int num) {
		giveCalled++;
		if (size != -1)
			size += num;
		numGiven += num;
		return num;
	}

	/**
	 * Adds the specified number of items into the inventory. Generates report.
	 * 
	 * @param num
	 *            Number given to inventory
	 * 
	 * @return Number of tokens given
	 */
	public int giveTo_Report(int num) {
		this.giveTo(num);
		Reporter.printReport(title + " amount changed: +" + num);
		return num;
	}

	/**
	 * Returns how many times the take method was called.
	 * 
	 * @return Number of times take method was called
	 */
	public int get_takeCalled() {
		return takeCalled;
	}

	/**
	 * Returns the total number of items taken from this inventory.
	 * 
	 * @return Total number taken from inventory
	 */
	public int get_numTaken() {
		return numTaken;
	}

	/**
	 * Returns how many times the giveTo method was called.
	 * 
	 * @return Number of times giveTo was called
	 */
	public int get_giveCalled() {
		return giveCalled;
	}

	/**
	 * Return Returns the total number of items given to this inventory.
	 * 
	 * @return Total number given to the inventory
	 */
	public int get_numGiven() {
		return numGiven;
	}

	/**
	 * Generates report of lifetime statistics of this inventory.
	 */
	public void getFullReport() {
		String report = "";
		report += "Take called: " + takeCalled + "\n";
		report += "Number taken: " + numTaken + "\n";
		report += "Give called: " + giveCalled + "\n";
		report += "Number given: " + numGiven + "\n";
		Reporter.printReport(report);
	}

	/**
	 * Returns title of the inventory
	 * 
	 * @return Title
	 */
	@Override
	public String toString() {
		return title;
	}
}

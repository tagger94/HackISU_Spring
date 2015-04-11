package gameSim;

public class Inventory {

	private String title;
	private int size;

	// Statistics vars
	private int takeCalled = 0;
	private int numTaken = 0;
	private int giveCalled = 0;
	private int numGiven = 0;

	// Default constructor
	public Inventory() {
		title = "Inventory";
		size = 0;
	}

	// Constructor with set size, -1 for "infinite" size
	public Inventory(int size) {
		title = "Inventory";
		if (size < -1)
			throw new IllegalStateException();
		if (size == -1)
			this.size = Integer.MAX_VALUE;
		else
			this.size = size;
	}

	// Constructor with set size and title, -1 for "infinite" size
	public Inventory(String title, int size) {
		this.title = title;
		if (size < -1)
			throw new IllegalStateException();
		this.size = size;
	}

	// Subtract from the inventory
	public void take(int num) {
		takeCalled++;
		if (num > size || num < -1)
			throw new IllegalStateException();
		if (size != -1)
			size -= num;
		numTaken += num;
	}

	// Subtract from the inventory with printed report
	public void take_Report(int num) {
		this.take(num);
		System.out.println(title + " amount changed: -" + num);
	}
	
	//Add to inventory
	public void give(int num){
		giveCalled++;
		if (size != -1)
			size += num;
		numGiven += num;
	}
	
	//Add to inventory with printed report
	public void give_Report(int num){
		this.give(num);
		System.out.println(title + " amount changed: +" + num);
	}
	
	//Return takeCalled
	public int get_takeCalled(){
		return takeCalled;
	}
	
	//Return numTaken
	public int get_numTaken(){
		return numTaken;
	}
	
	//Return giveCalled
	public int get_giveCalled(){
		return giveCalled;
	}
	
	//Return numGiven
	public int get_numGiven(){
		return numGiven;
	}
	
	//Return all stats
	public String getReport(){
		String report = "";
		report += "Take called: " + takeCalled + "\n";
		report += "Number taken: " + numTaken + "\n";
		report += "Give called: " + giveCalled + "\n";
		report += "Number given: " + numGiven + "\n";
		return report;
	}
	
}

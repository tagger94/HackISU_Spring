package gameSim;

import java.util.Random;

/**
 * The die simulator. Self contained random number generator
 * 
 * @author Alex Berns
 * 
 */
public class Dice {

	private int DIE_SIZE;

	private Random rand;

	private int report_Roll;
	private int report_LastRoll;
	private int last_Roll;

	/**
	 * Constructs a die with specific number of sides.
	 * 
	 * @param sides Number of sides on die
	 */
	public Dice(int sides) {
		DIE_SIZE = sides;
		rand = new Random();
		last_Roll = 0;
		report_LastRoll = 0;
		report_Roll = 0;
	}

	/**
	 * Generates a random die roll
	 * 
	 * @return Random integer between 1 and die size
	 */
	public int roll() {
		report_Roll++;
		last_Roll = rand.nextInt(DIE_SIZE) + 1;
		return last_Roll;
	}

	/**
	 * Generates a random die roll. Generates report.
	 * 
	 * @return A random number between 1 and die size
	 */
	public int roll_Report() {
		this.roll();
		Reporter.printReport("Die Rolled: " + last_Roll);
		return last_Roll;
	}

	/**
	 * Returns previous die value rolled
	 * 
	 * @return Previous die value
	 */
	public int getLastRoll() {
		report_LastRoll++;
		return last_Roll;
	}
	
	/**
	 * Returns previous die value rolled. Generates report.
	 * 
	 * @return Previous die value
	 */
	public int getLastRoll_Report() {
		Reporter.printReport("Last Roll: " + last_Roll);
		return getLastRoll();
	}

	/**
	 * Returns the size of the die used
	 * 
	 * @return The size of die as int
	 */
	public int get_DieSize() {
		return DIE_SIZE;
	}

	/**
	 * Returns the size of the die used as a String
	 * 
	 * @return The size of die as String
	 */
	public String dieSize_Report() {
		return "Die Size: " + DIE_SIZE;
	}

	/**
	 * Returns the number of times the die has been rolled
	 * 
	 * @return Number of rolls as Int
	 */
	public int get_NumOfRolls() {
		return report_Roll;
	}

	/**
	 * Returns the number of times the die has been rolled
	 * 
	 * @return Number of rolls as String
	 */
	public String numOfRolls_Report() {
		return "Number of Rolls: " + report_Roll;
	}

	/**
	 * Generates full report
	 * 
	 * @return Die size and number of times rolled
	 */
	public String getReport() {
		return "Die Size: " + DIE_SIZE + "/nNumber of Rolls: " + report_Roll;
	}
}

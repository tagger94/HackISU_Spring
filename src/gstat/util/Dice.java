package gstat.util;

import java.util.Random;

/**
 * The die simulator. Self contained random number generator
 * 
 * @author Alex
 * 
 */
public class Dice {

	private int DIE_SIZE;

	private Random rand;

	private int report_Roll;
	private int report_LastRoll;
	private int last_Roll;

	/**
	 * Give the number of sides for that die to use
	 * 
	 * @param sides
	 *            Number of sides on this die
	 */
	public Dice(int sides) {
		DIE_SIZE = sides;
		rand = new Random();
		last_Roll = 0;
		report_LastRoll = 0;
		report_Roll = 0;
	}

	/**
	 * Generates a random number of the die
	 * 
	 * @return A random number between 1 and die size
	 */
	public int roll() {
		report_Roll++;
		last_Roll = rand.nextInt(DIE_SIZE) + 1;
		return last_Roll;
	}

	/**
	 * Generates a random number of the die and reports to file
	 * 
	 * @return A random number between 1 and die size
	 */
	public int roll_Report() {
		this.roll();
		Reporter.printReport("Die Rolled: " + last_Roll);
		return last_Roll;
	}

	public int getLastRoll() {
		report_LastRoll++;
		return last_Roll;
	}

	public int getLastRoll_Report() {
		Reporter.printReport("Last Roll: " + last_Roll);
		return getLastRoll();
	}

	/**
	 * Gives the size of the die used
	 * 
	 * @return The size of die as int
	 */
	public int get_DieSize() {
		return DIE_SIZE;
	}

	/**
	 * Gives the size of the die used as a String
	 * 
	 * @return The size of die as String
	 */
	public String dieSize_Report() {
		return "Die Size: " + DIE_SIZE;
	}

	/**
	 * Gives the number of times the die has been rolled
	 * 
	 * @return Number of rolls as Int
	 */
	public int get_NumOfRolls() {
		return report_Roll;
	}

	/**
	 * Gives the number of times the die has been rolled
	 * 
	 * @return Number of rolls as String
	 */
	public String numOfRolls_Report() {
		return "Number of Rolls: " + report_Roll;
	}

	/**
	 * Generates report of another final report to use
	 * 
	 * @return Die size and number of times rolled
	 */
	public String getReport() {
		return "Die Size: " + DIE_SIZE + "/nNumber of Rolls: " + report_Roll;
	}
}

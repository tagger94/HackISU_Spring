package yahtzeeTestGame;

import java.util.ArrayList;

/**
 * Implementation of a player for yahtzee.
 * 
 * @author Mike Onyszczak
 *
 */

public class Player {
	private int points;
	private String name;
	private ArrayList<Boolean> rollsCompleted;

	public Player(String name) {
		this.name = name;
		points = 0;
		rollsCompleted = new ArrayList<Boolean>();
	}

	/**
	 * Add points to the score
	 * 
	 * @param score
	 *            Number of points to be added to score.
	 */
	public void addPoints(int score) {
		points += score;
	}

	/**
	 * Adds points to score and generates report
	 * 
	 * @param score
	 *            Number of points to be added to score.
	 */
	public void addPoints_Report(int score) {
		points += score;
		System.out.println(name + " added " + score + " points for a score of "
				+ points);
	}

	/**
	 * Marks one of the rolls needed as complete
	 * @param rollNum
	 */
	public void completeRoll(int rollNum) {
		if (rollsCompleted.set(rollNum, true))
			throw new IllegalStateException("Roll Already Completed");

		rollsCompleted.set(rollNum, true);
	}

	public void completeRoll_Report(int rollNum) {
		if (rollsCompleted.set(rollNum, true)) {
			System.out.println(name + " attempted to repeat a roll");
			throw new IllegalStateException("Roll Already Completed");
		}

		rollsCompleted.set(rollNum, true);
		System.out.println(name + " completed roll number " + rollNum);
	}

	public String getReport() {
		int count = 0;
		for (boolean i : rollsCompleted) {
			if (i)
				count++;
		}

		return name + " has " + points + " points and has completed " + count
				+ " rolls.\n";
	}

	public String getPlayerName() {
		return name;
	}

	public int getPoints() {
		return points;
	}
}

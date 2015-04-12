package shutTheBox;

import java.io.IOException;
import gameSim.Dice;
import gameSim.Reporter;

/**
 * Simulation of the game Shut The Box. A player rolls two dice and flips over
 * numbered tiles ranging 1 to 9 equal to the dice roll. The game ends when the
 * player flips all tiles or cannot flip anymore tokens.
 * 
 * @author Mike Onyszczak
 *
 */

public class shutTheBox {
	private static Dice die1 = new Dice(6);
	private static Dice die2 = new Dice(6);

	// condition of game 0 if ongoing.
	// 1 if won -1 if lost
	private static int winState = 0;
	// List of tiles
	private static boolean[] tiles;
	public static int turns;

	/**
	 * Call this to run the game
	 * 
	 * @return 1 if victory 0 if loss
	 */
	public static int play() {
		winState = 0;
		tiles = new boolean[9];
		turns = 0;
		while (winState == 0) {
			die1.roll();
			die2.roll();

			System.out.println(die1.getLastRoll() + " and "
					+ die2.getLastRoll() + " were rolled");

			Reporter.printReport(die1.getLastRoll() + " and "
					+ die2.getLastRoll() + " were rolled\n");

			// Change to flop to change playStyle
			flip();
			System.out.println(printTiles() + "\n");
			Reporter.printReport(printTiles() + "\n\n");
			turns++;
			hasWon();
		}

		if (winState == 1) {
			System.out.println("You won in " + turns);
			Reporter.printReport("You won in " + turns + "\n");
			return 1;
		} else {
			System.out.println("You lost in " + turns);
			Reporter.printReport("You lost in " + turns + "\n");
			System.out.println(printTiles());
			Reporter.printReport(printTiles() + "\n");
			return 0;
		}
	}

	/**
	 * Call this to run the game without report prompts.
	 * 
	 * @return 1 if victory 0 if loss
	 */
	public static int playSilent() {
		winState = 0;
		tiles = new boolean[9];
		turns = 0;
		while (winState == 0) {
			die1.roll();
			die2.roll();

			// Change to flop to change playStyle
			flip();
			turns++;
			hasWon();
		}

		if (winState == 1) {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * Default AI for the game. Attempts to flip the highest number or
	 * combination of numbers. Changes tile to true if tile is used. Will set
	 * winState to -1 if no tiles can be flipped.
	 */
	public static void flip() {
		int sum = die1.getLastRoll() + die2.getLastRoll();

		if (sum == 2) {
			if (!tiles[1]) {
				tiles[1] = true;
				return;
			} else {
				winState = -1;
				return;
			}
		}
		if (sum == 3) {
			if (!tiles[2]) {
				tiles[2] = true;
				return;
			} else if (!tiles[0] && !tiles[1]) {
				tiles[0] = true;
				tiles[1] = true;
				return;
			} else {
				winState = -1;
				return;
			}
		}
		if (sum == 4) {
			if (!tiles[3]) {
				tiles[3] = true;
				return;
			} else if (!tiles[2] && !tiles[0]) {
				tiles[0] = true;
				tiles[2] = true;
				return;
			} else {
				winState = -1;
				return;
			}
		}
		if (sum == 5) {
			if (!tiles[4]) {
				tiles[4] = true;
				return;
			} else if (!tiles[3] && !tiles[0]) {
				tiles[3] = true;
				tiles[0] = true;
				return;
			} else if (!tiles[2] && !tiles[1]) {
				tiles[2] = true;
				tiles[1] = true;
				return;
			} else {
				winState = -1;
				return;
			}
		}
		if (sum == 6) {
			if (!tiles[5]) {
				tiles[5] = true;
				return;
			} else if (!tiles[4] && !tiles[0]) {
				tiles[4] = true;
				tiles[0] = true;
				return;
			} else if (!tiles[3] && !tiles[1]) {
				tiles[3] = true;
				tiles[1] = true;
				return;
			} else if (!tiles[0] && !tiles[1] && !tiles[2]) {
				tiles[0] = true;
				tiles[1] = true;
				tiles[2] = true;
				return;
			} else {
				winState = -1;
				return;
			}
		}
		if (sum == 7) {
			if (!tiles[6]) {
				tiles[6] = true;
				return;
			} else if (!tiles[5] && !tiles[0]) {
				tiles[5] = true;
				tiles[0] = true;
				return;
			} else if (!tiles[3] && !tiles[2]) {
				tiles[3] = true;
				tiles[2] = true;
				return;
			} else if (!tiles[0] && !tiles[1] && !tiles[3]) {
				tiles[0] = true;
				tiles[1] = true;
				tiles[3] = true;
				return;
			} else {
				winState = -1;
				return;
			}
		}
		if (sum == 8) {
			if (!tiles[7]) {
				tiles[7] = true;
				return;
			} else if (!tiles[6] && !tiles[0]) {
				tiles[6] = true;
				tiles[0] = true;
				return;
			} else if (!tiles[5] && !tiles[1]) {
				tiles[5] = true;
				tiles[1] = true;
				return;
			} else if (!tiles[4] && !tiles[2]) {
				tiles[4] = true;
				tiles[2] = true;
				return;
			} else if (!tiles[4] && !tiles[1] && !tiles[0]) {
				tiles[4] = true;
				tiles[1] = true;
				tiles[0] = true;
				return;
			} else if (!tiles[3] && !tiles[2] && !tiles[0]) {
				tiles[3] = true;
				tiles[2] = true;
				tiles[0] = true;
				return;
			} else {
				winState = -1;
				return;
			}
		}
		if (sum == 9) {
			if (!tiles[8]) {
				tiles[8] = true;
				return;
			} else if (!tiles[7] && !tiles[0]) {
				tiles[7] = true;
				tiles[0] = true;
				return;
			} else if (!tiles[6] && !tiles[1]) {
				tiles[6] = true;
				tiles[1] = true;
				return;
			} else if (!tiles[5] && !tiles[2]) {
				tiles[5] = true;
				tiles[1] = true;
				return;
			} else if (!tiles[5] && !tiles[1] && !tiles[0]) {
				tiles[5] = true;
				tiles[1] = true;
				tiles[0] = true;
				return;
			} else if (!tiles[4] && !tiles[3]) {
				tiles[4] = true;
				tiles[3] = true;
				return;
			} else if (!tiles[4] && !tiles[2] && !tiles[0]) {
				tiles[4] = true;
				tiles[2] = true;
				tiles[0] = true;
				return;
			} else if (!tiles[3] && !tiles[2] && !tiles[1]) {
				tiles[3] = true;
				tiles[2] = true;
				tiles[1] = true;
				return;
			} else {
				winState = -1;
				return;
			}
		}
		if (sum == 10) {
			if (!tiles[8] && !tiles[0]) {
				tiles[8] = true;
				tiles[0] = true;
				return;
			} else if (!tiles[7] && !tiles[1]) {
				tiles[7] = true;
				tiles[1] = true;
				return;
			} else if (!tiles[6] && !tiles[2]) {
				tiles[6] = true;
				tiles[2] = true;
				return;
			} else if (!tiles[6] && !tiles[1] && !tiles[0]) {
				tiles[6] = true;
				tiles[1] = true;
				tiles[0] = true;
				return;
			} else if (!tiles[5] && !tiles[3]) {
				tiles[5] = true;
				tiles[3] = true;
				return;
			} else if (!tiles[5] && !tiles[2] && !tiles[0]) {
				tiles[5] = true;
				tiles[2] = true;
				tiles[0] = true;
				return;
			} else if (!tiles[4] && !tiles[3] && !tiles[0]) {
				tiles[4] = true;
				tiles[3] = true;
				tiles[0] = true;
				return;
			} else if (!tiles[4] && !tiles[2] && !tiles[1]) {
				tiles[4] = true;
				tiles[2] = true;
				tiles[1] = true;
				return;
			} else if (!tiles[3] && !tiles[2] && !tiles[1] && !tiles[0]) {
				tiles[3] = true;
				tiles[2] = true;
				tiles[1] = true;
				tiles[0] = true;
				return;
			} else {
				winState = -1;
				return;
			}
		}
		if (sum == 11) {
			if (!tiles[8] && !tiles[1]) {
				tiles[8] = true;
				tiles[1] = true;
				return;
			} else if (!tiles[7] && !tiles[2]) {
				tiles[7] = true;
				tiles[2] = true;
				return;
			} else if (!tiles[7] && !tiles[1] && !tiles[0]) {
				tiles[7] = true;
				tiles[1] = true;
				tiles[0] = true;
				return;
			} else if (!tiles[6] && !tiles[3]) {
				tiles[6] = true;
				tiles[3] = true;
				return;
			} else if (!tiles[6] && !tiles[2] && !tiles[0]) {
				tiles[6] = true;
				tiles[2] = true;
				tiles[0] = true;
				return;
			} else if (!tiles[5] && !tiles[4]) {
				tiles[5] = true;
				tiles[4] = true;
				return;
			} else if (!tiles[5] && !tiles[3] && !tiles[0]) {
				tiles[5] = true;
				tiles[3] = true;
				tiles[0] = true;
				return;
			} else if (!tiles[5] && !tiles[2] && !tiles[1]) {
				tiles[5] = true;
				tiles[2] = true;
				tiles[1] = true;
				return;
			} else if (!tiles[4] && !tiles[3] && !tiles[1]) {
				tiles[4] = true;
				tiles[3] = true;
				tiles[1] = true;
				return;
			} else if (!tiles[4] && !tiles[2] && !tiles[1] && !tiles[0]) {
				tiles[4] = true;
				tiles[2] = true;
				tiles[1] = true;
				tiles[0] = true;
				return;
			} else {
				winState = -1;
				return;
			}
		}
		if (sum == 12) {
			if (!tiles[8] && !tiles[2]) {
				tiles[8] = true;
				tiles[2] = true;
				return;
			} else if (!tiles[8] && !tiles[2] && !tiles[0]) {
				tiles[8] = true;
				tiles[2] = true;
				tiles[0] = true;
				return;
			} else if (!tiles[7] && !tiles[3]) {
				tiles[7] = true;
				tiles[3] = true;
				return;
			} else if (!tiles[7] && !tiles[2] && !tiles[0]) {
				tiles[7] = true;
				tiles[2] = true;
				tiles[0] = true;
				return;
			} else if (!tiles[6] && !tiles[4]) {
				tiles[6] = true;
				tiles[4] = true;
				return;
			} else if (!tiles[6] && !tiles[3] && !tiles[0]) {
				tiles[6] = true;
				tiles[3] = true;
				tiles[0] = true;
				return;
			} else if (!tiles[6] && !tiles[2] && !tiles[1]) {
				tiles[6] = true;
				tiles[2] = true;
				tiles[1] = true;
				return;
			} else if (!tiles[5] && !tiles[4] && !tiles[0]) {
				tiles[5] = true;
				tiles[4] = true;
				tiles[0] = true;
				return;
			} else if (!tiles[5] && !tiles[3] && !tiles[1]) {
				tiles[5] = true;
				tiles[3] = true;
				tiles[1] = true;
				return;
			} else if (!tiles[5] && !tiles[2] && !tiles[1] && !tiles[0]) {
				tiles[5] = true;
				tiles[2] = true;
				tiles[1] = true;
				tiles[0] = true;
				return;
			} else if (!tiles[4] && !tiles[3] && !tiles[2]) {
				tiles[4] = true;
				tiles[3] = true;
				tiles[2] = true;
				return;
			} else if (!tiles[4] && !tiles[3] && !tiles[1] && !tiles[0]) {
				tiles[4] = true;
				tiles[3] = true;
				tiles[1] = true;
				tiles[0] = true;
				return;
			} else {
				winState = -1;
				return;
			}
		}
	}

	/**
	 * Optional AI for game based on a simple strategy of try to create high
	 * numbers and use single dice. Loses often. Win Rate < 1%. Changes tile to
	 * true if tile is used. Will set winState to -1 if no tiles can be flipped.
	 * 
	 * Implement by changing flip() to flop() in play or playSilent.
	 */
	public static void flop() {
		int sum = die1.getLastRoll() + die2.getLastRoll();

		if (sum == 7 && !tiles[6]) {
			tiles[6] = true;
			return;
		} else if (sum == 8 && !tiles[7]) {
			tiles[7] = true;
			return;
		} else if (sum == 9 && !tiles[8]) {
			tiles[8] = true;
			return;
		} else if (die1.getLastRoll() == 1 && !tiles[0]
				&& !tiles[die2.getLastRoll() - 1]) {
			tiles[0] = true;
			tiles[die2.getLastRoll() - 1] = true;
			return;
		} else if (die1.getLastRoll() == 2 && !tiles[1]
				&& !tiles[die2.getLastRoll() - 1]) {
			tiles[1] = true;
			tiles[die2.getLastRoll() - 1] = true;
			return;
		} else if (die1.getLastRoll() == 3 && !tiles[2]
				&& !tiles[die2.getLastRoll() - 1]) {
			tiles[2] = true;
			tiles[die2.getLastRoll() - 1] = true;
			return;
		} else if (die1.getLastRoll() == 4 && !tiles[3]
				&& !tiles[die2.getLastRoll() - 1]) {
			tiles[3] = true;
			tiles[die2.getLastRoll() - 1] = true;
			return;
		} else if (die1.getLastRoll() == 5 && !tiles[4]
				&& !tiles[die2.getLastRoll() - 1]) {
			tiles[4] = true;
			tiles[die2.getLastRoll() - 1] = true;
			return;
		} else if (die1.getLastRoll() == 6 && !tiles[5]
				&& !tiles[die2.getLastRoll() - 1]) {
			tiles[5] = true;
			tiles[die2.getLastRoll() - 1] = true;
			return;
		} else if (die2.getLastRoll() == 1 && !tiles[0]
				&& !tiles[die1.getLastRoll() - 1]) {
			tiles[0] = true;
			tiles[die1.getLastRoll() - 1] = true;
			return;
		} else if (die2.getLastRoll() == 2 && !tiles[1]
				&& !tiles[die1.getLastRoll() - 1]) {
			tiles[1] = true;
			tiles[die1.getLastRoll() - 1] = true;
			return;
		} else if (die2.getLastRoll() == 3 && !tiles[2]
				&& !tiles[die1.getLastRoll() - 1]) {
			tiles[2] = true;
			tiles[die1.getLastRoll() - 1] = true;
			return;
		} else if (die2.getLastRoll() == 4 && !tiles[3]
				&& !tiles[die1.getLastRoll() - 1]) {
			tiles[3] = true;
			tiles[die1.getLastRoll() - 1] = true;
			return;
		} else if (die2.getLastRoll() == 5 && !tiles[4]
				&& !tiles[die1.getLastRoll() - 1]) {
			tiles[4] = true;
			tiles[die1.getLastRoll() - 1] = true;
			return;
		} else if (die2.getLastRoll() == 6 && !tiles[5]
				&& !tiles[die1.getLastRoll() - 1]) {
			tiles[5] = true;
			tiles[die1.getLastRoll() - 1] = true;
			return;
		} else if (sum < 10 && !tiles[sum - 1]) {
			tiles[sum - 1] = true;
			return;
		} else {
			winState = -1;
			return;
		}
	}

	/**
	 * Checks to see if all tiles are flipped meaning the player has won. Will
	 * change winState to 1 to signify win, or will not change anything if game
	 * is ongoing.
	 */
	public static void hasWon() {
		for (int i = 0; i < tiles.length; i++) {
			if (!tiles[i]) {
				return;
			}
		}
		winState = 1;
	}

	/**
	 * Prints the game board at the current time with "X" to represent flipped
	 * tiles.
	 * 
	 * @return Game board at time of printing.
	 */
	public static String printTiles() {
		String result = "";
		for (int i = 0; i < tiles.length; i++) {
			if (tiles[i]) {
				result += ("X\t");
			} else
				result += (i + 1 + "\t");
		}
		return result;
	}

	/**
	 * Main method that gathers statistics on one million games and generates
	 * data file names "ShutTheBox.dat"
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {
		int win = 0;
		int totalWinningTurns = 0;
		int totalLosingTurns = 0;
		int totalTurns = 0;
		for (int i = 0; i < 1000000; i++) {
			if (playSilent() == 1) {
				win++;
				totalWinningTurns += turns;
			} else
				totalLosingTurns += turns;
			totalTurns += turns;
		}
		System.out.println((win * 100.0) / 1000000 + "% Win Rate");
		System.out.println((totalWinningTurns * 1.0) / win
				+ " Average turns per winning game");
		System.out.println((totalLosingTurns * 1.0) / (1000000 - win)
				+ " Average turns per losing game");
		System.out.println((totalTurns * 1.0) / 1000000
				+ " Average turns per game");

		Reporter.printReport((win * 100.0) / 1000000 + "% Win Rate\n");
		Reporter.printReport((totalWinningTurns * 1.0) / win
				+ " Average turns per winning game\n");
		Reporter.printReport((totalLosingTurns * 1.0) / (1000000 - win)
				+ " Average turns per losing game\n");
		Reporter.printReport((totalTurns * 1.0) / 1000000
				+ " Average turns per game\n");

		// Sanity Check
		win = 0;
		for (int i = 0; i < 1000000; i++) {
			int total = 0;
			while (total < 45) {
				total += die1.roll() + die2.roll();
			}
			if (total == 45)
				win++;
		}
		System.out.println((win * 100.0) / 1000000 + "% Theoretical Win Rate");
		Reporter.printReport((win * 100.0) / 1000000
				+ "% Theoretical Win Rate\n");
	}
}

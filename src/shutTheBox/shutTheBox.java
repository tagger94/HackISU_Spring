package shutTheBox;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import gameSim.Dice;

public class ShutTheBox {
	private static Dice die1 = new Dice(6);
	private static Dice die2 = new Dice(6);
	private static int winState = 0;
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

			flip();
			System.out.println(printTiles() + "\n");
			turns++;
			tilesRemain();
		}

		if (winState == 1) {
			System.out.println("You won in " + turns);
			return 1;
		} else {
			System.out.println("You lost in " + turns);
			System.out.println(printTiles());
			return 0;
		}
	}

	public static int playSilent() {
		winState = 0;
		tiles = new boolean[9];
		turns = 0;
		while (winState == 0) {
			die1.roll();
			die2.roll();

			flip();
			turns++;
			tilesRemain();
		}

		if (winState == 1) {
			return 1;
		} else {
			return 0;
		}
	}

	private static void flip() {
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
	 * Checks to see if tiles remain
	 */
	private static void tilesRemain() {
		for (int i = 0; i < tiles.length; i++) {
			if (!tiles[i]) {
				return;
			}
		}
		winState = 1;
	}

	private static String printTiles() {
		String result = "";
		for (int i = 0; i < tiles.length; i++) {
			if (tiles[i]) {
				result += ("X\t");
			} else
				result += (i + 1 + "\t");
		}
		return result;
	}

	public static void main(String args[]) throws IOException {
		int win = 0;
		int totalWinningTurns = 0;
		int totalLosingTurns = 0;
		int totalTurns = 0;
		FileWriter write = new FileWriter(new File("ShutTheBox.dat"));
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

		write.write((win * 100.0) / 1000000 + "% Win Rate\n");
		write.write((totalWinningTurns * 1.0) / win
				+ " Average turns per winning game\n");
		write.write((totalLosingTurns * 1.0) / (1000000 - win)
				+ " Average turns per losing game\n");
		write.write((totalTurns * 1.0) / 1000000 + " Average turns per game\n");

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
		write.write((win * 100.0) / 1000000 + "% Theoretical Win Rate");
		write.close();
	}
}

package shutTheBox;

import gameSim.Dice;

public class ShutTheBox {
	private static boolean[] tiles = new boolean[9];
	private static Dice die1 = new Dice(6);
	private static Dice die2 = new Dice(6);
	private static int winState = 0;

	private static int turns;

	public static void play() {
		while (winState == 0) {
			die1.roll_Report();
			die2.roll_Report();

			flip();
			turns++;
			tilesRemain();
		}

		if (winState == 1) {
			System.out.println("You won in " + turns);
		} else {
			System.out.println("You lost in " + turns);
			System.out.println(printTiles());
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
			}
			if (!tiles[0] && !tiles[1]) {
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
			}
			if (!tiles[2] && !tiles[0]) {
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
			}
			if (!tiles[3] && !tiles[0]) {
				tiles[3] = true;
				tiles[0] = true;
				return;
			}
			if (!tiles[2] && !tiles[1]) {
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
			}
			if (!tiles[4] && !tiles[0]) {
				tiles[4] = true;
				tiles[0] = true;
				return;
			}
			if (!tiles[3] && !tiles[1]) {
				tiles[3] = true;
				tiles[1] = true;
				return;
			}
			if (!tiles[0] && !tiles[1] && !tiles[2]) {
				tiles[0] = true;
				tiles[1] = true;
				tiles[2] = true;
				return;
			}
		}
		if (sum == 7) {
			if (!tiles[6]) {
				tiles[6] = true;
				return;
			}
			if (!tiles[5] && !tiles[0]) {
				tiles[5] = true;
				tiles[0] = true;
				return;
			}
			if (!tiles[3] && !tiles[2]) {
				tiles[3] = true;
				tiles[2] = true;
				return;
			}
			if (!tiles[0] && !tiles[1] && !tiles[3]) {
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
			}
			if (!tiles[6] && !tiles[0]) {
				tiles[6] = true;
				tiles[0] = true;
				return;
			}
			if (!tiles[5] && !tiles[1]) {
				tiles[5] = true;
				tiles[1] = true;
				return;
			}
			if (!tiles[4] && !tiles[2]) {
				tiles[4] = true;
				tiles[2] = true;
				return;
			}
			if (!tiles[4] && !tiles[1] && !tiles[0]) {
				tiles[4] = true;
				tiles[1] = true;
				tiles[0] = true;
				return;
			}
			if (!tiles[3] && !tiles[2] && !tiles[0]) {
				tiles[3] = true;
				tiles[2] = true;
				tiles[0] = true;
				return;
			} else {
				winState = -1;
				return;
			}
		}
	}

	private static boolean tilesRemain() {
		for (int i = 0; i < tiles.length; i++) {
			if (!tiles[i]) {
				return tiles[i];
			}
		}
		winState = 1;
		return true;
	}

	private static String printTiles() {
		String result = "";
		for (int i = 0; i < tiles.length; i++) {
			if (tiles[i]) {
				result += ("X\t");
			} else
				result += (i+1 + "\t");
		}
		return result;
	}

	public static void main(String args[]) {
		ShutTheBox.play();
	}
}

package yahtzeeTestGame;

import gameSim.Dice;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * Simulation of the dice game Yahtzee.
 * 
 * @author Mike Onyszczak
 *
 */
public class Yahtzee {
	private Dice[] dice = { new Dice(6), new Dice(6), new Dice(6), new Dice(6),
			new Dice(6) };
	private Player player;
	private int rollsTaken;

	public Yahtzee(String name) {
		player = new Player(name);
		rollsTaken = 0;
	}

	public void roll() {
		dice[0].roll_Report();
		dice[1].roll_Report();
		dice[2].roll_Report();
		dice[3].roll_Report();
		dice[4].roll_Report();
	}

	private void roll(ArrayList<Dice> selectedDice) {
		for (int i = 0; i < selectedDice.size(); i++)
			selectedDice.get(i).roll_Report();
	}

	private ArrayList<Dice> choseDice() {

		double[] prob = getProb();
		ArrayList<Dice> result = new ArrayList<Dice>();
		int maxIndex = -1;
		double max = -1;

		for (int i = 0; i < prob.length; i++) {
			if (prob[i] > max) {
				max = prob[i];
				maxIndex = i;
			}
		}

		if (maxIndex == 0 || maxIndex == 1 || maxIndex == 5) {
			int[] results = new int[5];

			for (int i = 0; i < 5; i++) {
				if (dice[i].getLastRoll() == 1)
					results[0]++;
				if (dice[i].getLastRoll() == 2)
					results[1]++;
				if (dice[i].getLastRoll() == 3)
					results[2]++;
				if (dice[i].getLastRoll() == 4)
					results[3]++;
				if (dice[i].getLastRoll() == 5)
					results[4]++;
				if (dice[i].getLastRoll() == 6)
					results[5]++;
			}

			int maxNum = 0;
			for (int i = 0; i < 6; i++) {
				if (results[i] >= maxNum)
					maxNum = i;
			}

			for (int i = 0; i < 5; i++) {
				if (dice[i].getLastRoll() != maxNum)
					result.add(dice[i]);
			}
		}
		return result;
	}

	private double[] getProb() {
		double[] prob = new double[6];

		prob[0] = getProb3OfAKind();
		prob[1] = getProb4OfAKind();
		prob[2] = getProbFullHouse();
		prob[3] = getProbSmStraight();
		prob[4] = getProbLgStraight();
		prob[5] = getProbYahtzee();

		return prob;
	}

	private double getProbYahtzee() {
		// TODO Auto-generated method stub
		return 0;
	}

	private double getProbLgStraight() {
		// TODO Auto-generated method stub
		return 0;
	}

	private double getProbSmStraight() {
		// TODO Auto-generated method stub
		return 0;
	}

	private double getProbFullHouse() {
		// TODO Auto-generated method stub
		return 0;
	}

	private double getProb4OfAKind() {
		// TODO Auto-generated method stub
		return 0;
	}

	private double getProb3OfAKind() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void takeTurn() {
		boolean pointsClaimed = false;
		while (rollsTaken < 3 && !pointsClaimed) {
			roll(choseDice());
			pointsClaimed = optionalClaimPoints();
			rollsTaken++;
		}

		claimPoints();
	}

	private void claimPoints() {
		// TODO Auto-generated method stub

	}

	private boolean optionalClaimPoints() {
		// TODO Auto-generated method stub
		return false;
	}
}

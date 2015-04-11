package yahtzeeTestGame;

import gameSim.Dice;

import java.util.ArrayList;

/**
 * Simulation of the dice game Yahtzee.
 * 
 * @author Mike Onyszczak
 *
 */
public class Yahtzee {
	private Dice dice1 = new Dice(6);
	private Dice dice2 = new Dice(6);
	private Dice dice3 = new Dice(6);
	private Dice dice4 = new Dice(6);
	private Dice dice5 = new Dice(6);
	private Dice dice6 = new Dice(6);
	private Player player;
	private int rollsTaken;

	public Yahtzee(String name) {
		player = new Player(name);
		rollsTaken = 0;
	}

	public void roll() {
		dice1.roll_Report();
		dice2.roll_Report();
		dice3.roll_Report();
		dice4.roll_Report();
		dice5.roll_Report();
		dice6.roll_Report();
	}

	private void roll(ArrayList<Dice> selectedDice) {
		for(int i = 0; i< selectedDice.size(); i++)
			selectedDice.get(i).roll_Report();	
	}
	
	private ArrayList<Dice> choseDice() {
		// TODO Auto-generated method stub
		return null;
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

package warTestGame;

import gameSim.Reporter;

/**
 * Runs War games, currently prints statistics.
 * 
 * @author Brennyn Hawbaker
 *
 */
public class WarRun {
	
	public static void main(String args[]){
		for(int a = 0; a < 50; a++){
			War game = new War();
			game.playGame();
		}
		Reporter.printReport("Player 1 won: " + War.get_p1W());
		Reporter.printReport("Player 2 won: " + War.get_p2W());
		Reporter.printReport("Average rounds per game: " + (War.totRounds*1.0)/War.games);
		Reporter.printReport((War.get_p1W()*1.0/(War.get_p1W()+War.get_p2W())*100) + "% games Player 1 won.");
	}
	
}

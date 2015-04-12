package warTestGame;

import java.util.ArrayList;

import exampleClasses.StandardPlayingCard;
import gameSim.Deck;

/**
 * Example War simulation setup
 * 
 * @author Brennyn Hawbaker
 *
 */
public class War {


	private ArrayList<StandardPlayingCard> down;
	WarPlayer player_1;
	WarPlayer player_2;
	
	/**
	 * Statistic variables
	 */
	static int p1_wins;
	static int p2_wins;
	static int rounds;
	static int totRounds;
	static int games;

	/**
	 * Default new game constructor
	 */
	public War() {
		player_1 = new WarPlayer("Player_1");
		player_2 = new WarPlayer("Player_2");
		
		Deck<StandardPlayingCard> deck = new Deck<StandardPlayingCard>(StandardPlayingCard.makeDeck());
		deck.shuffle();
		for(int a = 0; a < 26; a++){
			player_1.takeCard(deck.draw());
			player_2.takeCard(deck.draw());
		}
		down = new ArrayList<>();
	}
	
	/**
	 * Runs one turn of the game
	 */
	public void playTurn(){
		down = new ArrayList<>();
		down.add(player_1.playCard());
		down.add(player_2.playCard());
		int win = makeAction(down.get(0), down.get(1));
		if(win == -1){
			player_1.winRound(down);
			checkEndGame();
		} else if(win == -2){
			checkEndGame();
		} else {
			player_2.winRound(down);
			checkEndGame();
		}
	}
	
	/**
	 * Runs one full game of War
	 */
	public void playGame(){
		rounds = 0;
		while(WarPlayer.haveWinner(player_1, player_2) == 0){
			playTurn();
			//System.out.println(count);
			rounds++;
		}
		//System.out.println("Game over.");
		totRounds += rounds;
		games++;
	}
	
	/**
	 * Applies War rules to determine the "winner" of the two cards
	 * @param Player 1's card
	 * @param Player 2's card
	 * @return Integer representing winner
	 */
	public int makeAction(StandardPlayingCard c1, StandardPlayingCard c2){
		if(c1 == null)
			return 1;
		if(c2 == null)
			return -1;
		int comp = c1.compareToIgnoreSuit(c2);
		if(comp < 0) //c1 bigger
			return -1;
		if(comp > 0) //c2 bigger
			return 1;
		return splitTie(c1, c2);
	}
	
	/**
	 * Splits ties during rounds
	 * @param Player 1's card
	 * @param Player s'2 card
	 * @return Integer representing winner
	 */
	public int splitTie(StandardPlayingCard c1, StandardPlayingCard c2){
		for(int a = 0; a < 3; a++){
			try{
				down.add(player_1.playCard());
				down.add(player_2.playCard());
			} catch(IllegalStateException b){
				return -2;
			}
		}
		return makeAction(player_1.playCard(), player_2.playCard());
	}
	
	/**
	 * Ends game and declares a winner
	 */
	public void checkEndGame(){
		if(WarPlayer.haveWinner(player_1, player_2) == -1){
			//System.out.print("Player one wins! ");
			p1_wins++;
		}
		if(WarPlayer.haveWinner(player_1, player_2) == 1){
			//System.out.print("Player two wins! ");
			p2_wins++;
		}
	}
	
	/**
	 * Returns number of games player 1 won
	 * @return number of games won
	 */
	public static int get_p1W(){
		return p1_wins;
	}
	
	/**
	 * Returns number of games player 2 won
	 * @return number of games won
	 */
	public static int get_p2W(){
		return p2_wins;
	}


}

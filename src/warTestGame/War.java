package warTestGame;

import exampleClasses.StandardPlayingCard;
import gameSim.Card;
import gameSim.Deck;

public class War {

	private Deck<Card> deck;
	WarPlayer player_1;
	WarPlayer player_2;

	/**
	 * Default new game constructor
	 */

	public War() {
		player_1 = new WarPlayer("Player_1");
		player_2 = new WarPlayer("Player_2");
		deck = new Deck<Card>(StandardPlayingCard.makeDeck());
		deck.shuffle();
		
		for(int a = 0; a < 26; a++){
			
		}
	}
	
	/**
	 * Runs one turn of the game
	 */
	public void playTurn(){
		player_1.playCard();
	}
	
	/**
	 * Runs one full game of War
	 */
	public void playGame(){
		
	}

}

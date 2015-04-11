package warTestGame;

import exampleClasses.StandardPlayingCard;
import gameSim.Card;
import gameSim.Deck;

public class War {

	private Deck<Card> deck;

	/**
	 * Default new game constructor
	 */

	public War() {
		WarPlayer player_1 = new WarPlayer("Player_1");
		WarPlayer player_2 = new WarPlayer("Player_2");
		deck = new Deck<Card>(StandardPlayingCard.makeDeck());
		deck.shuffle();
		
		for(int a = 0; a < 26; a++){
			player_1.drawCard(deck.draw());
			player_2.drawCard(deck.draw());
		}
		
		
		
	}

}

package testGames;

import java.util.ArrayList;

import gameSim.*;

public class BlackJack {
	private Suit suit;

	private StandardPlayingCard deckMaker = new StandardPlayingCard(1,
			suit.SPADES);
	private Deck deck = new Deck(deckMaker.makeDeck());
	private Hand hand1 = new Hand();

	private void startRound() {

		deck.shuffle_Report();
	}

	private void takeTurn(Player p) {
		
		
		//Check for Splits
		
		//Check for Aces
		
		//Find Hand Value
		
		//Determine Bet
		
		//
	}

	public void runGame() {
		ArrayList<ExamplePlayer> p = new ArrayList<ExamplePlayer>();
		for(int i = 0; i < 4; i++) {
			p.add(new ExamplePlayer("Player " + i));
		}
		while (true) {
			startRound();
			takeTurn();
		}
	}

}
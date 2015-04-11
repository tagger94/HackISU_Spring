package testGames;

import java.util.ArrayList;

import gameSim.Card;
import gameSim.Hand;
import gameSim.Deck;
import gameSim.StandardPlayingCard;
import gameSim.Suit;

public class BlackJack {
	private Suit suit;

	private StandardPlayingCard deckMaker = new StandardPlayingCard(1,
			suit.SPADES);
	private Deck deck = new Deck(deckMaker.makeDeck());
	private Hand hand1 = new Hand();

	private void startRound() {

		deck.shuffle_Report();
	}

	private void takeTurn(Hand hand) {
		int handValue = 0;
		hand.drawCard_Report(deck.draw_Report());
		hand.drawCard_Report(deck.draw_Report());
		
		StandardPlayingCard card_1 = (StandardPlayingCard) hand.hand.get(0);
		StandardPlayingCard card_2 = (StandardPlayingCard) hand.hand.get(1);
		
		//Check for Splits
		
		//Check for Aces
		
		//Find Hand Value
		
		//
	}

	public void runGame() {
		while (true) {
			startRound();
			takeTurn(hand1);
		}
	}

}
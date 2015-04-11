package blackJackTestGame;

import java.util.ArrayList;

import exampleClasses.ExamplePlayer;
import exampleClasses.StandardPlayingCard;
import exampleClasses.Suit;
import gameSim.*;

public class BlackJack {
	private Suit suit;

	private StandardPlayingCard deckMaker = new StandardPlayingCard(1,
			suit.SPADES);
	private Deck deck = new Deck(deckMaker.makeDeck());
	
	private BlackJackDealerAI dealer = new BlackJackDealerAI("Dealer");
	
	private ArrayList<BlackJackPlayer> players = new ArrayList<BlackJackPlayer>();

	private void startRound() {

		deck.shuffle_Report();
		
		for(BlackJackPlayer h : players) {
			h.hand.drawCard_Report(deck.draw_Report());
			h.hand.drawCard_Report(deck.draw_Report());
		}
		
		dealer.hand.drawCard_Report(deck.draw_Report());
		dealer.hand.drawCard_Report(deck.draw_Report());
		
	}

	private void takeTurn(BlackJackAI p) {
		
		Boolean hit = false;

		// Determine Bet
		p.determineBet();
		// Hit or Not
		while(p.doHit()) {}
		
	}
	

	public void runGame() {
		Inventory chips = new Inventory("Chips", -1);
		
		
		while (true) {
			startRound();
			
			for(BlackJackPlayer p : players) {
				takeTurn((BlackJackAI) p);
			}
			
			takeTurn(dealer);
		}
	}

}
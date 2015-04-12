package gstat.premade.war;

import java.util.ArrayList;

import gstat.premade.playingcard.StandardPlayingCard;
import gstat.util.Deck;

/**
 * Player design for War with a name, hand, and discard pile
 * 
 * @author Brennyn Hawbaker
 *
 */
public class WarPlayer {

	private String name;
	private Deck<StandardPlayingCard> hand;
	private Deck<StandardPlayingCard> discard;

	/**
	 * Constructs a war player with default name "Player" and empty decks.
	 */
	public WarPlayer() {
		name = "Player";
		hand = new Deck<StandardPlayingCard>("hand");
		discard = new Deck<StandardPlayingCard>("discard");
	}

	/**
	 * Constructs a war player with given name and empty decks.
	 * 
	 * @param name
	 *            Name of player
	 */
	public WarPlayer(String name) {
		this.name = name;
		hand = new Deck<StandardPlayingCard>("hand");
		discard = new Deck<StandardPlayingCard>("discard");
	}

	/**
	 * Plays first card from player's hand, if empty, attempts to take discard
	 * pile.
	 * 
	 * @return Card to be played, null if no card to play
	 */
	public StandardPlayingCard playCard() {
		try{
			return hand.draw();
		}
		catch (IllegalStateException b){
			takeDiscard();
			try{
				return hand.draw();
			}
			catch (IllegalStateException c){
				return null;
			}
		}
	}

	/**
	 * Adds card to player's hand.
	 * 
	 * @param card
	 *            card to be added
	 * 
	 * @return added card
	 */
	public StandardPlayingCard takeCard(StandardPlayingCard card) {
		hand.giveToBottom(card);
		return card;
	}

	/**
	 * Adds multiple cards to player's hand.
	 * 
	 * @param card
	 *            card to add to hand
	 * 
	 * @return list of added cards
	 */
	public ArrayList<StandardPlayingCard> takeMultiple(ArrayList<StandardPlayingCard> card) {
		hand.giveMultiple(card);
		return card;
	}

	/**
	 * Move all cards from discard to hand.
	 */
	public void takeDiscard() {
		discard.shuffle();
		hand.giveMultiple(discard.drawAll());
	}

	/**
	 * Move cards from play into discard pile.
	 * 
	 * @param winnings
	 *            cards from last round of play
	 */
	public void winRound(ArrayList<StandardPlayingCard> winnings) {
		discard.giveMultiple(winnings);
	}

	/**
	 * Checks if there is a winner (other player has no cards).
	 * 
	 * @param p1
	 *            player 1
	 * @param p2
	 *            Player 2
	 * @return Integer representing winner
	 */
	public static int haveWinner(WarPlayer p1, WarPlayer p2) {
		if (p2.noCards())
			return -1;
		if (p1.noCards())
			return 1;
		return 0;
	}

	private boolean noCards() {
		if (hand.getNumCards() == 0 && discard.getNumCards() == 0)
			return true;
		return false;
	}

	/**
	 * Returns name of player.
	 * 
	 * @return name of player
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set name of player
	 * 
	 * @param name
	 *            of player
	 */
	public void setName(String name) {
		this.name = name;
	}

}

package warTestGame;

import java.util.ArrayList;

import exampleClasses.StandardPlayingCard;
import gameSim.Deck;

/**
 * Player design for War with a name, hand, and discard pile
 * 
 * @author Brennyn Hawbaker
 *
 */
public class WarPlayer {

	private String title;
	private Deck<StandardPlayingCard> hand;
	private Deck<StandardPlayingCard> discard;

	/**
	 * Default constructor
	 */
	public WarPlayer() {
		title = "Player";
		hand = new Deck<StandardPlayingCard>("hand");
		discard = new Deck<StandardPlayingCard>("discard");
	}

	/**
	 * Constructor with name
	 * 
	 * @param Name
	 *            of player
	 */
	public WarPlayer(String title) {
		this.title = title;
		hand = new Deck<StandardPlayingCard>("hand");
		discard = new Deck<StandardPlayingCard>("discard");
	}

	/**
	 * Plays first card from player's hand, if empty, attempts to take discard pile
	 * 
	 * @return Card to be played, null if no card to play
	 */
	public StandardPlayingCard playCard() {
		try {
			return hand.draw();
		} catch (IllegalStateException b) {
			takeDiscard();
			try {
				return hand.draw();
			} catch (IllegalStateException c) {
				return null;
			}
		}
	}

	/**
	 * Adds card to player's hand
	 * 
	 * @param Card
	 *            to be added
	 */
	public void takeCard(StandardPlayingCard card) {
		hand.giveBottom(card);
	}

	/**
	 * Adds multiple cards to player's hand
	 * 
	 * @param Cards
	 *            to add to hand
	 */
	public void takeMulti(ArrayList<StandardPlayingCard> card) {
		hand.giveMulti(card);
	}

	/**
	 * Move all cards from discard to hand
	 */
	public void takeDiscard() {
		discard.shuffle();
		hand.giveMulti(discard.drawAll());
	}

	/**
	 * Put cards in play into discard pile
	 * 
	 * @param Cards
	 *            from last round of play
	 */
	public void winRound(ArrayList<StandardPlayingCard> winnings) {
		discard.giveMulti(winnings);
	}

	/**
	 * Checks if there is a winner (other player has no cards)
	 * 
	 * @param Player
	 *            1
	 * @param Player
	 *            2
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
		if (hand.get_NumCards() == 0 && discard.get_NumCards() == 0)
			return true;
		return false;
	}

	/**
	 * Returns title of player
	 * 
	 * @return Title of player
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set title of player
	 * 
	 * @param title
	 *            of player
	 */
	public void setTitle(String title) {
		this.title = title;
	}

}

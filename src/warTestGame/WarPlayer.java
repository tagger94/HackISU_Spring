package warTestGame;

import gameSim.Card;
import gameSim.Deck;
import gameSim.Hand;

/**
 * Designs player for War with a name, hand, and discard pile
 * 
 * @author Brennyn Hawbaker
 *
 */
public class WarPlayer {

	private String title;
	private Hand<Card> hand;
	private Deck<Card> discard;

	/**
	 * Default constructor
	 */
	public WarPlayer() {
		title = "Player";
		hand = new Hand<Card>();
		discard = new Deck<Card>();
	}

	/**
	 * Constructor with name
	 * 
	 * @param Name of player
	 */
	public WarPlayer(String title) {
		this.title = title;
		hand = new Hand<Card>();
		discard = new Deck<Card>();
	}
	
	/**
	 * Adds card to player's hand
	 */
	public void drawCard(Card card){
		
	}
	
	
	
	//All getters and setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Hand<Card> getHand() {
		return hand;
	}

	public void setHand(Hand<Card> hand) {
		this.hand = hand;
	}

	public Deck<Card> getDiscard() {
		return discard;
	}

	public void setDiscard(Deck<Card> discard) {
		this.discard = discard;
	}
	
	
	
}

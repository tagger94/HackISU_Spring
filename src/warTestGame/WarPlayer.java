package warTestGame;

import java.util.ArrayList;

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
	private Deck<Card> hand;
	private Deck<Card> discard;

	/**
	 * Default constructor
	 */
	public WarPlayer() {
		title = "Player";
		hand = new Deck<Card>();
		discard = new Deck<Card>();
	}

	/**
	 * Constructor with name
	 * 
	 * @param Name of player
	 */
	public WarPlayer(String title) {
		this.title = title;
		hand = new Deck<Card>();
		discard = new Deck<Card>();
	}
	
	/**
	 * Plays first card from player's hand
	 * 
	 * @param Card to be discarded
	 */
	public Card playCard(){
		return hand.draw();
	}
	
	/**
	 * Adds card to bottom of player's hand
	 * 
	 * @param Card to be added
	 */
	public void takeCard(Card card){
		ArrayList<Card> tmp = hand.drawAll();
		hand.give(card);
		hand.giveMulti(tmp);
	}
	
	/**
	 * Adds multiple cards to bottom of player's hand
	 * 
	 * @param Cards to add to hand
	 */
	public void takeMulti(ArrayList<Card> card){
		
	}
	
	public void takeDiscard(){
		ArrayList<Card> temp = discard.drawAll();
		for(int a = 0; a < discard.get_NumCards(); a++){
			discard.draw();
		}
	}
	
	
	
	//All getters and setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Deck<Card> getHand() {
		return hand;
	}

	public void setHand(Deck<Card> hand) {
		this.hand = hand;
	}

	public Deck<Card> getDiscard() {
		return discard;
	}

	public void setDiscard(Deck<Card> discard) {
		this.discard = discard;
	}
	
	
	
}

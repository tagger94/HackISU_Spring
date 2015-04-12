package warTestGame;

import java.util.ArrayList;

import exampleClasses.StandardPlayingCard;
import gameSim.Deck;

/**
 * Designs player for War with a name, hand, and discard pile
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
	 * @param Name of player
	 */
	public WarPlayer(String title) {
		this.title = title;
		hand = new Deck<StandardPlayingCard>("hand");
		discard = new Deck<StandardPlayingCard>("discard");
	}
	
	/**
	 * Plays first card from player's hand
	 * 
	 * @param Card to be discarded
	 */
	public StandardPlayingCard playCard(){
		try{
			return hand.draw();
		} catch(IllegalStateException b){
			takeDiscard();
			return hand.draw();
		}
	}
	
	/**
	 * Adds card to player's hand
	 * 
	 * @param Card to be added
	 */
	public void takeCard(StandardPlayingCard card){
		hand.give(card);
		hand.shuffle();
	}
	
	/**
	 * Adds multiple cards of player's hand
	 * 
	 * @param Cards to add to hand
	 */
	public void takeMulti(ArrayList<StandardPlayingCard> card){
		hand.giveMulti(card);
		hand.shuffle();
	}
	
	/**
	 * Move all cards from discard to hand
	 */
	public void takeDiscard(){
		discard.shuffle();
		hand.giveMulti(discard.drawAll());
	}
	
	/**
	 * Put cards in play into discard pile
	 * 
	 * @param Cards from last round of play
	 */
	public void winRound(ArrayList<StandardPlayingCard> winnings){
		discard.giveMulti(winnings);
	}
	
	public static int haveWinner(WarPlayer p1, WarPlayer p2, ArrayList<StandardPlayingCard> board){
		if(p2.noCards())
			return -1;
		if(p1.noCards())
			return 1;
		return 0;
	}
	
	private boolean noCards(){
		if(hand.equals(null) && discard.equals(null))
			return true;
		return false;
	}
	
	
	
	//All getters and setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Deck<StandardPlayingCard> getHand() {
		return hand;
	}

	public void setHand(Deck<StandardPlayingCard> hand) {
		this.hand = hand;
	}

	public Deck<StandardPlayingCard> getDiscard() {
		return discard;
	}

	public void setDiscard(Deck<StandardPlayingCard> discard) {
		this.discard = discard;
	}
	
	
	
}

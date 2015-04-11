package gameSim;

import java.util.ArrayList;

/**
 * 
 * This class is meant to be extended by a player class
 * and can use this class to keep a hand of cards. 
 * 
 * @author Camden Voigt
 *
 */

public class Hand {
	
	private ArrayList<Card> hand;
	private int cardsDrawn;
	private int cardsDiscarded; 
	
	/**
	 * Sets counters for reporting statistics to zero.
	 * 
	 */
	public Hand(){
		cardsDrawn = 0;
		cardsDiscarded = 0; 
	}
	
	/**
	 * Adds the given card to the hand.
	 * 
	 * @param c
	 */
	public void drawCard(Card c){
		hand.add(c);
		cardsDrawn++; 
	}
	  
	/**
	 * Adds the given card to the hand and 
	 * gives a string representation of the card that was added.
	 * 
	 * @param c
	 */
	public void drawCard_Report(Card c){
		drawCard(c); 
		System.out.println(c.toString() + " was add to the hand.\n"); 
	}
	
	/**
	 * Finds the given card and removes it from the hand.
	 * 
	 * @param c
	 */
	public void discardCard(Card c){
		for(int i = 0; i < hand.size(); i++){
			if(hand.get(i).equals(c)){
				hand.remove(i);
				cardsDiscarded++; 
			}
		}
	}
	
	/**
	 * Finds given card and removes it from the hand and
	 * gives a string representation of the card that was removed. 
	 * 
	 * @param c
	 */
	public void discardCard_Report(Card c){
		System.out.println(c.toString() + " was remove from the hand.\n");
		discardCard(c); 
	}
	
	/**
	 * Returns raw value of the number of cards drawn.
	 * 
	 * @return cardsDrawn
	 */
	public int getCardsDrawn(){
		return cardsDrawn;
	}
	
	/**
	 * Returns a string representation of the amount of cards drawn.
	 * 
	 * @return
	 */
	public String getCardsDrawn_Report(){
		return cardsDrawn + " have been drawn."; 
	}
	
	/**
	 * Returns raw value of the number of cards discarded.
	 * 
	 * @return cardsDiscarded
	 */
	public int getCardsDiscarded(){
		return cardsDiscarded;
	}
	
	/**
	 * Returns string representation of the amount of cards discarded. 
	 * 
	 * @return
	 */
	public String getCardsDiscarded_Report(){
		return cardsDiscarded + " have been discarded"; 
	}
	
	/**
	 * Returns a string representation of the amount of cards drawn and discarded. 
	 * 
	 * @return
	 */
	public String getReport(){
		String report = cardsDrawn + "were given to the hand and " + cardsDiscarded + "were taken from the hand.";
		return report;
	}
}

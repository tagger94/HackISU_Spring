package gstat.util;

import java.util.ArrayList;

/**
 * 
 * This class is meant to be extended by a player class and can use this class
 * to keep a hand of cards.
 * 
 * @author Camden Voigt
 * 
 */

public class Hand<C extends Card> {

	public ArrayList<C> hand;
	private int cardsDrawn;
	private int cardsDiscarded;
	private int maxHandSize;
	private int minHandSize;

	/**
	 * Creates an empty hand with no maximum or minimum size limits.
	 */
	public Hand() {
		cardsDrawn = 0;
		cardsDiscarded = 0;
		minHandSize = 0;
		maxHandSize = Integer.MAX_VALUE;
		hand = new ArrayList<C>();
	}

	/**
	 * Creates an empty hand with specified size limits.
	 * 
	 * @param max
	 *            Max number of cards in a hand at one time
	 * @param min
	 *            Min number of cards in a hand at one time
	 */
	public Hand(int max, int min) {
		cardsDrawn = 0;
		cardsDiscarded = 0;
		maxHandSize = max;
		minHandSize = min;
		hand = new ArrayList<C>();
	}

	/**
	 * Adds the given card to the hand.
	 * 
	 * @param c
	 *            Card to be add to hand
	 * 
	 * @return Card that was added to hand
	 */
	public C drawCard(C c) {
		if (hand.size() < maxHandSize){
			hand.add(c);
			cardsDrawn++;
			return c;
		}
		return null;
	}

	/**
	 * Adds the given card to the hand. Generates report.
	 * 
	 * @param c
	 *            Card to be add to hand
	 * 
	 * @return Card that was added to hand
	 */
	public C drawCard_Report(C c) {
		if (hand.size() < maxHandSize){
			drawCard(c);
			System.out.println(c.toString() + " was added to the hand.\n");
			return c;
		}
		return null;
	}

	/**
	 * Finds the given card and removes it from the hand.
	 * 
	 * @param c
	 *            Card to remove from hand
	 * 
	 * @return Card that was discarded
	 */
	public C discardCard(C c) {
		if (hand.size() > minHandSize){
			for(int i = 0; i < hand.size(); i++){
				if (hand.get(i).equals(c)){
					C temp = hand.get(i);
					hand.remove(i);
					cardsDiscarded++;
					return temp;
				}
			}
		}
		return null;
	}

	/**
	 * Finds the given card and removes it from the hand. Generates report.
	 * 
	 * @param c
	 *            Card to remove from hand
	 * 
	 * @return Card that was discarded
	 */
	public C discardCard_Report(C c) {
		if (hand.size() > minHandSize){
			System.out.println(c.toString() + " was removed from the hand.\n");
			discardCard(c);
			return c;
		}
		return null;
	}

	/**
	 * Removes all cards from hand.
	 * 
	 * @return List of cards removed from hand.
	 */
	public ArrayList<C> discardHand() {
		ArrayList<C> tempList = new ArrayList<C>();
		for(int i = 0; i < hand.size(); i++){
			tempList.add(hand.get(i));
			hand.remove(i);
		}
		return tempList;
	}

	public ArrayList<C> discardHand_Report() {
		ArrayList<C> tempList = discardHand();
		Reporter.printReport("Hand was discarded\n");
		return tempList;
	}

	/**
	 * Returns raw value of the number of cards drawn.
	 * 
	 * @return Number of cards drawn
	 */
	public int getCardsDrawn() {
		return cardsDrawn;
	}

	/**
	 * Returns raw value of the number of cards drawn. Generates report.
	 * 
	 * @return Number of cards drawn
	 */
	public String getCardsDrawn_Report() {
		Reporter.printReport(cardsDrawn + " have been drawn.\n");
		return cardsDrawn + " have been drawn.\n";
	}

	/**
	 * Returns the number of cards discarded.
	 * 
	 * @return Number of cards discarded
	 */
	public int getNumCardsDiscarded() {
		return cardsDiscarded;
	}

	/**
	 * Returns the number of cards discarded. Generates report.
	 * 
	 * @return Number of cards discarded
	 */
	public String getNumCardsDiscarded_Report() {
		Reporter.printReport(cardsDiscarded + " have been discarded\n");
		return cardsDiscarded + " have been discarded\n";
	}

	/**
	 * Generates report of number of cards drawn and discarded.
	 * 
	 */
	public void getFullReport() {
		String report = cardsDrawn + "were given to the hand and " + cardsDiscarded + "were taken from the hand.\n";
		report += "The minimum hand size was " + minHandSize + " and the maximum hand size was " + maxHandSize + ".\n";

		Reporter.printReport(report);
	}

	/**
	 * Returns a String representation of the contents of hand.
	 * 
	 * @return String String representation of this hand
	 */
	public String toString() {
		String report = "";
		for(int i = 0; i < hand.size(); i++){
			report += hand.get(i).toString() + ", ";
		}
		return report;
	}
}

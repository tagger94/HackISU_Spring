package gstat.util;

import java.util.ArrayList;
import java.util.Random;

/**
 * Simulates a deck of cards. Supports various functions that a deck would allow
 * such as drawing, peeking and discarding. Can also function as a discard pile
 * by using the default constructor.
 * 
 * @author Mike Onyszczak
 *
 * @param <C>
 *            This requires that any cards to be used with Deck must implement
 *            the Card interface
 */
public class Deck<C extends Card> {

	private int timesShuffled;
	private int numCards;
	private int numDraws;
	private String name;
	private ArrayList<C> deck;

	/**
	 * Create empty deck with default name "deck". Typically a discard deck.
	 */
	public Deck() {
		numCards = 0;
		deck = new ArrayList<C>();
		timesShuffled = 0;
		numDraws = 0;
		name = "deck";
	}

	/**
	 * Creates an empty deck with a user-defined name. Typically a discard deck.
	 * 
	 * @param name
	 *            Name of the deck
	 */
	public Deck(String name) {
		this.name = name;
		deck = new ArrayList<C>();
		numCards = 0;
		numDraws = 0;
		timesShuffled = 0;
	}

	/**
	 * Creates a fully stocked deck with default name "deck".
	 * 
	 * @param deck
	 *            Initial list of cards in the deck
	 */
	public Deck(ArrayList<C> deck) {
		this.deck = deck;
		name = "deck";
		timesShuffled = 0;
		numCards = deck.size();
		numDraws = 0;
	}

	/**
	 * 
	 * Creates a fully stocked deck with user-defined name.
	 * 
	 * @param deck
	 *            Initial list of cards in the deck
	 * @param name
	 *            Name of the deck
	 */
	public Deck(ArrayList<C> deck, String name) {
		this.deck = deck;
		this.name = name;
		numDraws = 0;
		numCards = deck.size();
		timesShuffled = 0;
	}

	/**
	 * Peek at the top card of the deck. Does not remove the card.
	 * 
	 * @return Card that was at top of the deck
	 */
	public C peekTop() {
		if (numCards == 0)
			throw new IllegalStateException(name + " is empty.");
		return deck.get(0);
	}

	/**
	 * Peek at the top card of the deck. Does not the remove card. Generates
	 * report.
	 * 
	 * @return Card that was at top of the deck
	 */
	public C peekTop_Report() {
		C result = peekTop();
		Reporter.printReport("The top of" + name + " was looked at.\n" + result + " was on top.");
		return result;
	}

	/**
	 * Peek at the card at the bottom of the deck. Does not remove the card.
	 * 
	 * @return Card that was at bottom of the deck
	 */
	public C peekBottom() {
		if (numCards == 0)
			throw new IllegalStateException(name + " is empty.");
		return deck.get(numCards);
	}

	/**
	 * Peek at the card at the bottom of the deck. Does not remove the card.
	 * Generates report.
	 * 
	 * @return Card that was at bottom of the deck
	 */
	public C peekBottom_Report() {
		C result = peekBottom();
		Reporter.printReport("The bottom of" + name + " was looked at.\n" + result + " was on the bottom.");
		return result;
	}

	/**
	 * Draws and removes the top card of the deck.
	 * 
	 * @return Card that was on top of the deck
	 */
	public C draw() {
		if (numCards == 0)
			throw new IllegalStateException(name + " is empty.");
		numCards--;
		return deck.remove(0);
	}

	/**
	 * 
	 * Draws and removes the top card of the deck. Generates report.
	 * 
	 * @return Card that was on top of the deck
	 */
	public C draw_Report() {
		C result = draw();
		Reporter.printReport("A card was drawn from " + name + ".\n" + result + " was drawn");
		return result;
	}

	/**
	 * Draws top number of cards from deck.
	 * 
	 * @param num
	 *            Number of cards to be drawn
	 * 
	 * @return Lists cards drawn and removed from the deck
	 */
	public ArrayList<C> drawMultiple(int num) {
		if (num > numCards)
			throw new IllegalStateException("Not enough cards to draw from" + name + ".");
		ArrayList<C> hold = new ArrayList<>();
		for(int a = 0; a < num; a++){
			hold.add(draw());
		}
		return hold;
	}

	/**
	 * Draws top number of cards from deck. Generates report.
	 * 
	 * @param num
	 *            Number of cards to draw
	 * @return Lists cards drawn and removed from the deck
	 */
	public ArrayList<C> drawMultiple_Report(int num) {
		ArrayList<C> temp = drawMultiple(num);
		Reporter.printReport(num + " cards were drawn from" + name + ".\n");
		return temp;
	}

	/**
	 * Draws and removes all cards from the deck.
	 * 
	 * @return List of all cards drawn from the deck
	 */
	public ArrayList<C> drawAll() {
		ArrayList<C> temp = drawMultiple(numCards);
		return temp;
	}

	/**
	 * Draws and removes all cards from the deck. Generates report.
	 * 
	 * @return List of all cards drawn from the deck
	 */
	public ArrayList<C> drawAll_Report() {
		ArrayList<C> temp = drawMultiple_Report(numCards);
		return temp;
	}

	/**
	 * Retrieves and removes a specific card from the deck if the card is
	 * available.
	 * 
	 * @param card
	 *            Card requested from the deck.
	 * 
	 * @return The card requested or null if not found
	 */
	public C retrieveCard(C card) {
		if (numCards == 0)
			return null;

		int pos = 0;

		for(C current : deck){
			if (current.equals(card)){
				numCards--;
				return deck.remove(pos);
			}
			pos++;
		}

		return null;
	}

	/**
	 * Retrieves and removes a specific card from the deck if the card is
	 * available. Generates report.
	 * 
	 * @param card
	 *            Card requested from the deck
	 * 
	 * @return The card requested or null if not found
	 */
	public C retrieveCard_Report(C card) {
		C result = retrieveCard(card);
		Reporter.printReport(result + " was retrieved from the deck.\n");

		return result;
	}

	/**
	 * Find the specified card in the deck. Does not remove the card.
	 * 
	 * @param card
	 *            Card requested from the deck
	 * @return The card requested or null if not found
	 */
	public C findCard(C card) {
		if (numCards == 0)
			return null;

		for(C current : deck){
			if (current.equals(card)){
				return current;
			}
		}

		return null;
	}

	/**
	 * Find the specified card in the deck. Does not remove the card. Generates
	 * report.
	 * 
	 * @param card
	 *            Card requested from the deck
	 * @return The card requested or null if not found
	 */
	public C findCard_Report(C card) {
		C result = findCard(card);
		Reporter.printReport(result + " was found in the deck.\n");

		return result;
	}

	/**
	 * Generates list of all cards in the deck. Does not change the state of the
	 * deck.
	 * 
	 * @return List of all Cards currently in the deck.
	 */
	public ArrayList<C> getContents() {
		ArrayList<C> result = new ArrayList<C>();
		for(C item : deck){
			result.add(item);
		}

		return result;
	}

	/**
	 * Returns every card printed on its own line.
	 * 
	 * @return Textual representation of deck
	 */
	@Override
	public String toString() {
		String result = "";
		for(C card : deck){
			result += card.toString() + "\n";
		}
		return result;
	}

	/**
	 * Shuffle all the cards in the deck.
	 * 
	 * @return True if the deck was shuffled. False if the deck could not be
	 *         shuffled.
	 */
	public boolean shuffle() {
		if (deck == null || numCards == 0)
			return false;
		Random random = new Random();
		ArrayList<C> result = new ArrayList<C>();

		int count = numCards;
		while (count != 0){
			result.add(deck.remove(random.nextInt(count)));
			count--;
		}

		deck = result;
		timesShuffled++;
		return true;
	}

	/**
	 * Shuffles all the cards in the deck. Generates Report.
	 * 
	 * @return True if the deck was shuffled. False if the deck could not be
	 *         shuffled.
	 */
	public boolean shuffle_Report() {
		boolean result = shuffle();
		Reporter.printReport("shuffled for the " + timesShuffled + " time\n");
		return result;
	}

	/**
	 * Adds a card to the top of the deck.
	 * 
	 * @param card
	 *            Card to be added to the top of the deck
	 * 
	 * @return The card that was inserted
	 */
	public C giveToTop(C card) {
		deck.add(0, card);
		numCards++;
		return card;
	}

	/**
	 * Adds a card to the top of the deck. Generates report.
	 * 
	 * @param card
	 *            Card to be added to the top of the deck
	 * 
	 * @return The card that was inserted
	 */
	public C giveToTop_Report(C card) {
		giveToTop(card);
		Reporter.printReport(card + " was added to the top of " + name + ".\n");
		return card;
	}

	/**
	 * Adds a card to the bottom of the deck.
	 * 
	 * @param card
	 *            Card to be added to the bottom of the deck
	 * @return The card that was inserted
	 */
	public C giveToBottom(C card) {
		deck.add(card);
		numCards++;
		return card;

	}

	/**
	 * Adds a card to the bottom of the deck. Generates report.
	 * 
	 * @param card
	 *            Card to be added to the bottom of the deck
	 * @return The card that was inserted
	 */
	public C giveToBottom_Report(C card) {
		giveToBottom(card);
		Reporter.printReport(card + " was added to the bottom of " + name + ".\n");
		return card;
	}

	/**
	 * Adds several cards to the deck.
	 * 
	 * @param cards
	 *            Cards to add to the deck
	 */
	public void giveMultiple(ArrayList<C> cards) {
		for(C card : cards)
			giveToTop(card);
	}

	/**
	 * Adds several cards to the deck. Generates report.
	 * 
	 * @param cards
	 *            Cards to add to the deck
	 */
	public void giveMultiple_Report(ArrayList<C> cards) {
		for(C card : cards)
			giveToTop_Report(card);
	}

	/**
	 * Generates report of all actions that have occurred in this deck.
	 */
	public void getFullReport() {
		Reporter.printReport("The deck was shuffled " + timesShuffled + ". There were " + numDraws + " draws.\n");
	}

	/**
	 * Returns how many cards have been drawn.
	 * 
	 * @return Number of draws that have occurred
	 */
	public int getNumDraws() {
		return numDraws;
	}

	/**
	 * Returns how many shuffles have occurred.
	 * 
	 * @return Number of shuffles that have been performed on this deck
	 */
	public int getTimesShuffled() {
		return timesShuffled;
	}

	/**
	 * Returns how many cards have been drawn. Generates report.
	 * 
	 * @return Number of cards drawn from this deck
	 */
	public int getNumDraws_Report() {
		Reporter.printReport("There were " + numDraws + " draws\n");
		return numDraws;
	}

	/**
	 * Returns how many shuffles have occurred. Generates report.
	 * 
	 * @return Number of shuffles that have been performed on this deck
	 */
	public int timesShuffled_Report() {
		Reporter.printReport("The deck was shuffled " + timesShuffled + " times\n");
		return timesShuffled;
	}

	/**
	 * Returns how many cards are currently in the deck.
	 * 
	 * @return Number of cards in the deck
	 */
	public int getNumCards() {
		return numCards;
	}

	/**
	 * States how many cards are currently in the deck. Generates report.
	 * 
	 * @return number of cards in the deck
	 */
	public int getNumCards_Report() {
		Reporter.printReport("There are " + numCards + " cards in the deck\n");
		return numCards;
	}

}

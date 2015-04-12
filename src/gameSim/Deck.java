package gameSim;

import java.util.ArrayList;
import java.util.Random;

/**
 * Simulates a deck of cards. Supports various function that a deck would allow
 * such as drawing, peeking and discarding. Can also function as a discard pile
 * by using the default constructor
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

	// By default deck refers to standard card deck
	private ArrayList<C> deck;

	/**
	 * Create empty deck with default name "deck", Typically a discard deck
	 */
	public Deck() {
		numCards = 0;
		deck = new ArrayList<C>();
		timesShuffled = 0;
		numDraws = 0;
		name = "deck";
	}

	/**
	 * Creates an empty deck, Typically a discard deck, with a user-defined name
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
	 * Creates a fully stocked deck with default name "deck"
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
	 * Creates a fully stocked deck with user-defined name
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
	 * Peek at the top card of the deck. Does not remove card
	 * 
	 * @return Card that was at top of the deck
	 */
	public C peekTop() {
		if (numCards == 0)
			throw new IllegalStateException(name + " is empty.");
		return deck.get(0);
	}

	/**
	 * Peek at the top card of the deck. Does not remove card. Generates report.
	 * 
	 * @return Card that was at top of the deck
	 */
	public C peekTopReport() {
		C result = peekTop();
		Reporter.printReport("The top of" + name + " was looked at.\n" + result
				+ " was on top.");
		return result;
	}

	/**
	 * Peek at the card at the bottom of the deck. Does not remove card
	 * 
	 * @return Card that was at bottom of the deck
	 */
	public C peekBottom() {
		if (numCards == 0)
			throw new IllegalStateException(name + " is empty.");
		return deck.get(numCards);
	}

	/**
	 * Peek at the card at the bottom of the deck. Does not remove card
	 * Generates report
	 * 
	 * @return Card that was at bottom of the deck
	 */
	public C peekBottomReport() {
		C result = peekBottom();
		Reporter.printReport("The bottom of" + name + " was looked at.\n"
				+ result + " was on the bottom.");
		return result;
	}

	/**
	 * Draws the top card of the deck
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
	 * Draws the top card of the deck. Generates report
	 * 
	 * @return Card that was on top of the deck
	 */
	public C draw_Report() {
		C result = draw();
		Reporter.printReport("A card was drawn from " + name + ".\n" + result
				+ " was drawn");
		return result;
	}

	/**
	 * Draws top number of cards from deck
	 * 
	 * @param Number
	 *            Number of cards to be drawn
	 * 
	 * @return First number of cards on the deck
	 */
	public ArrayList<C> drawMulti(int num) {
		if (num > numCards)
			throw new IllegalStateException("Not enough cards to draw from"
					+ name + ".");
		ArrayList<C> hold = new ArrayList<>();
		for (int a = 0; a < num; a++) {
			hold.add(draw());
		}
		return hold;
	}

	/**
	 * Draws top number of cards from deck. Prints report
	 * 
	 * @param Number
	 *            Number of cards to draw
	 * @return First number of cards from deck
	 */
	public ArrayList<C> drawMulti_Report(int num) {
		ArrayList<C> temp = drawMulti(num);
		Reporter.printReport(num + " cards were drawn from" + name + ".\n");
		return temp;
	}

	/**
	 * Empties the deck.
	 * 
	 * @return All cards that were previously in deck
	 */
	public ArrayList<C> drawAll() {
		ArrayList<C> temp = drawMulti(numCards);
		return temp;
	}

	/**
	 * Empties the deck. Generates report
	 * 
	 * @return All cards that were previously in the deck
	 */
	public ArrayList<C> drawAll_Report() {
		ArrayList<C> temp = drawMulti_Report(numCards);
		return temp;
	}

	/**
	 * Gets a specific card from the deck if available
	 * 
	 * @param card
	 *            Card requested from the deck.
	 * 
	 * @return The card requested or null if not found
	 */
	public C get(C card) {
		if (numCards == 0)
			return null;

		int pos = 0;

		for (C current : deck) {
			if (current.equals(card)) {
				numCards--;
				return deck.remove(pos);
			}
			pos++;
		}

		return null;
	}

	/**
	 * Gets specified card from deck. Generates report
	 * 
	 * @param card
	 *            Card requested from the deck
	 * 
	 * @return The card requested or null if not found
	 */
	public C get_Report(C card) {
		C result = get(card);
		Reporter.printReport("Get Card was called. " + result
				+ " was returned to the deck.");

		return result;
	}

	/**
	 * Gives the deck in its current state. Does not change the state of the
	 * deck
	 * 
	 * @return Current deck
	 */
	public ArrayList<C> getContents() {
		return deck;
	}

	/**
	 * Gives every card printed on its own line
	 * 
	 * @return Textual representation of deck
	 */
	public String printDeck() {
		String result = "";
		for (C card : deck) {
			result += card.toString() + "\n";
		}
		return result;
	}

	/**
	 * Shuffle all the cards in the deck
	 */
	public void shuffle() {
		Random random = new Random();
		ArrayList<C> result = new ArrayList<C>();

		int count = numCards;
		while (count != 0) {
			result.add(deck.remove(random.nextInt(count)));
			count--;
		}

		deck = result;
		timesShuffled++;
	}

	/**
	 * Shuffles the deck and returns report that deck was shuffled along with
	 * how many times the deck has been shuffled in total
	 */
	public void shuffle_Report() {
		shuffle();
		Reporter.printReport("shuffled for the " + timesShuffled + " time\n");
	}

	/**
	 * Adds a card to the deck
	 * 
	 * @param card
	 *            Card to be added to deck
	 * 
	 * @return Confirmation of the card that was inserted
	 */
	public C giveTop(C card) {
		deck.add(0, card);
		numCards++;
		return card;
	}

	/**
	 * Adds a card to the deck. Generates report
	 * 
	 * @param card
	 *            Card to be added to deck
	 * 
	 * @return Confirmation of the card that was inserted
	 */
	public C giveTop_Report(C card) {
		giveTop(card);
		Reporter.printReport(card + " was added to the top of " + name + ".\n");
		return card;
	}

	/**
	 * Adds a card to the bottom of the deck
	 * 
	 * @param card
	 *            Card to be added to the bottom of the deck
	 * @return Confirmation of the card that was inserted
	 */
	public C giveBottom(C card) {
		deck.add(card);
		numCards++;
		return card; 

	}

	/**
	 * Adds a card to the bottom of the deck. Generates report
	 * 
	 * @param card
	 *            Card to be added to the bottom of the deck
	 * @return Confirmation of the card that was inserted
	 */
	public C giveBottom_Report(C card) {
		giveBottom(card);
		Reporter.printReport(card + " was added to the bottom of " + name
				+ ".\n");
		return card;
	}

	/**
	 * Adds several cards to the deck
	 * 
	 * @param cards
	 *            Cards to add to the deck
	 */
	public void giveMulti(ArrayList<C> cards) {
		for (C card : cards)
			giveTop(card);
	}

	/**
	 * Adds several cards to the deck
	 * 
	 * @param cards
	 *            Cards to add to the deck
	 */
	public void give_Report(ArrayList<C> cards) {
		for (C card : cards)
			giveTop_Report(card);
	}

	/**
	 * Returns report of all action that has occurred in this deck
	 * 
	 * @return Actions occurred in this deck.
	 */
	public String getReport() {
		return "The deck was shuffled " + timesShuffled + ". There were "
				+ numDraws + " draws.\n";
	}

	/**
	 * States how many cards have been drawn have occurred
	 * 
	 * @return Number of draws that have occurred
	 */
	public int get_NumDraws() {
		return numDraws;
	}

	/**
	 * States how many shuffles have occurred
	 * 
	 * @return Number of shuffles that have been performed on this deck
	 */
	public int get_TimesShuffled() {
		return timesShuffled;
	}

	/**
	 * States how many cards have been drawn. Generates report
	 * 
	 * @return Number of cards drawn from this deck
	 */
	public String numDraws_Report() {
		Reporter.printReport("There were " + numDraws + " draws\n");
		return "There were " + numDraws + " draws";
	}

	/**
	 * States how many shuffles have occurred. Generates report
	 * 
	 * @return Number of shuffles that have been performed on this deck
	 */
	public String timesShuffled_Report() {
		Reporter.printReport("The deck was shuffled " + timesShuffled
				+ " times\n");
		return "The deck was shuffled " + timesShuffled + " times";
	}

	/**
	 * States how many cards are currently in the deck
	 * 
	 * @return number of cards in the deck
	 */
	public int get_NumCards() {
		return numCards;
	}

	/**
	 * States how many cards are currently in the deck. Generates report
	 * 
	 * @return number of cards in the deck
	 */
	public int numCards_Report() {
		Reporter.printReport("There are " + numCards + " cards in the deck\n");
		return numCards;
	}

}

package gameSim;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

	private int timesShuffled;
	private int numCards;
	private int numDraws;

	// By default deck refers to standard card deck
	private ArrayList<Card> deck;

	/**
	 * Create empty deck. Typically discard deck
	 */
	public Deck() {
		numCards = 0;
		deck = null;
		timesShuffled = 0;
		numDraws = 0;
	}

	/**
	 * Creates fully stocked deck
	 * 
	 * @param deck
	 *            Initial list of cards in the deck
	 */
	public Deck(ArrayList<Card> deck) {
		this.deck = deck;
		timesShuffled = 0;
		numCards = deck.size();
		numDraws = 0;
	}

	/**
	 * Peek at the top card of the deck. Does not remove card
	 * 
	 * @return Card that was at top of the deck
	 */
	public Card peekTop() {
		return deck.get(0);
	}

	/**
	 * Peek at the top card of the deck. Does not remove card. Generates report.
	 * 
	 * @return Card that was at top of the deck
	 */
	public Card peekTopReport() {
		Card result = peekTop();
		System.out.println("The top of the deck was looked at. " + result
				+ " was on top.");
		return result;
	}

	/**
	 * Peek at the card at the bottom of the deck. Does not remove card
	 * 
	 * @return Card that was at bottom of the deck
	 */
	public Card peekBottom() {
		return deck.get(numCards);
	}

	/**
	 * Peek at the card at the bottom of the deck. Does not remove card.
	 * Generates report.
	 * 
	 * @return Card that was at bottom of the deck
	 */
	public Card peekBottomReport() {
		Card result = peekBottom();
		System.out.println("The bottom of the deck was looked at. " + result
				+ " was on the bottom.");
		return result;
	}

	/**
	 * Draws the top card of the deck
	 * 
	 * @return Card that was on top of the deck
	 */
	public Card draw() {
		numCards--;
		return deck.remove(0);
	}

	/**
	 * Draws the top card of the deck. Generates Report
	 * 
	 * @return Card that was on top of the deck
	 */
	public Card draw_Report() {
		Card result = draw();
		System.out.println("A card was drawn. " + result + " was drawn");
		return result;
	}

	/**
	 * Gets a specific card from the deck if available
	 * 
	 * @param card
	 *            Card requested from the deck.
	 * 
	 * @return The card request or null if not found.
	 */
	public Card get(Card card) {
		if (numCards == 0)
			return null;

		int pos = 0;

		for (Card current : deck) {
			if (current.equals(card)) {
				numCards--;
				return deck.remove(pos);
			}
			pos++;
		}

		return null;
	}

	/**
	 * Gets specified card from deck. Generated report
	 * 
	 * @param card
	 *            Card requested from the deck.
	 * 
	 * @return The card request or null if not found.
	 */
	public Card get_Report(Card card) {
		Card result = get(card);
		System.out.println("Get Card was called. " + result + " was returned");
		return result;
	}

	/**
	 * Gives the deck in its current state
	 * 
	 * @return Current deck
	 */
	public ArrayList<Card> getContents() {
		return deck;
	}

	/**
	 * Gives every card printed on its own line
	 * 
	 * @return Textual representation of deck
	 */
	public String printDeck() {
		String result = "";
		for (Card card : deck) {
			result += card.toString() + "\n";
		}
		return result;
	}

	/**
	 * Shuffle the cards within the deck
	 */
	public void shuffle() {
		Random random = new Random();
		ArrayList<Card> result = new ArrayList<Card>();

		while (numCards != 0) {
			result.add(deck.remove(random.nextInt(numCards)));
		}

		numCards = result.size();
		deck = result;
		timesShuffled++;
	}

	/**
	 * Shuffles deck and returns report that deck was shuffled along with how
	 * many times in total
	 */
	public void shuffle_Report() {
		shuffle();
		System.out.println("shuffled for the " + timesShuffled + " time");
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

	public int get_NumDraws() {
		return numDraws;
	}

	public int get_TimesShuffled() {
		return timesShuffled;
	}

	public String numDraws_Report() {
		return "There were " + numDraws + " draws";
	}

	public String timesShuffled_Report() {
		return "The deck was shuffled " + timesShuffled + " times";
	}

}

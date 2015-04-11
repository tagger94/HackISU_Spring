package gameSim;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

	private int numCards;

	// By default deck refers to standard card deck
	private ArrayList<Card> deck;

	/**
	 * Create empty deck. Typically discard deck
	 */
	public Deck() {
		numCards = 0;
		deck = null;
	}

	/**
	 * Creates fully stocked deck
	 * 
	 * @param deck
	 *            Initial list of cards in the deck
	 */
	public Deck(ArrayList<Card> deck) {
		this.deck = deck;
		numCards = deck.size();
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
	 * Peek at the card at the bottom of the deck. Does not remove card
	 * 
	 * @return Card that was at bottom of the deck
	 */
	public Card peekBottom() {
		return deck.get(numCards);
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

	public void shuffle() {
		Random random = new Random();
		ArrayList<Card> result = new ArrayList<Card>();

		while (numCards != 0) {
			result.add(deck.remove(random.nextInt(numCards)));
		}

		numCards = result.size();
		deck = result;
	}
}

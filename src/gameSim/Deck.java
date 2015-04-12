package gameSim;

import java.util.ArrayList;
import java.util.Random;

public class Deck<C extends Card> {

	private int timesShuffled;
	private int numCards;
	private int numDraws;
	private String name; 

	// By default deck refers to standard card deck
	private ArrayList<C> deck;

	/**
	 * Create empty deck, Typically a discard deck
	 */
	public Deck() {
		numCards = 0;
		deck = new ArrayList<C>();
		timesShuffled = 0;
		numDraws = 0;
		name = "deck";
	}
	
	/**
	 * Creates an empty deck, Typically a discard deck,
	 * with a name; 
	 * 
	 * @param name
	 * 		name of the deck
	 */
	public Deck(String name){
		this.name = name;
		deck = new ArrayList<C>();
		numCards = 0;
		numDraws = 0; 
		timesShuffled = 0;
	}

	/**
	 * Creates a fully stocked deck
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
	 * Creates a fully stocked deck
	 * 
	 * @param deck
	 * 			Initial list of cards in the deck
	 * @param name
	 * 			name of the deck
	 */
	public Deck(ArrayList<C> deck, String name){
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
	 * Peek at the card at the bottom of the deck. Does not remove card.
	 * Generates report.
	 * 
	 * @return Card that was at bottom of the deck
	 */
	public C peekBottomReport() {
		C result = peekBottom();
		Reporter.printReport("The bottom of" + name + " was looked at.\n" + result
				+ " was on the bottom.");
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
	 * Draws the top card of the deck. Generates Report
	 * 
	 * @return Card that was on top of the deck
	 */
	public C draw_Report() {
		C result = draw();
		Reporter.printReport("A card was drawn from " + name + ".\n" + result + " was drawn");
		return result;
	}
	
	/**
	 * Draws top number of cards from deck
	 * 
	 * @param Number to draw
	 * @return First number of cards on the deck
	 */
	public ArrayList<C> drawMulti(int num){
		if(num > numCards)
			throw new IllegalStateException("Not enough cards to draw from" + name + ".");
		ArrayList<C> hold = new ArrayList<>();
		for(int a = 0; a < num; a++){
			hold.add(draw());
		}
		return hold;
	}
	
	/**
	 * Draws top number of cards from deck. Prints report.
	 * 
	 * @param Number to draw
	 * @return First number of cards from deck
	 */
	public ArrayList<C> drawMulti_Report(int num){
		ArrayList<C> temp = drawMulti(num);
		Reporter.printReport(num + " cards were drawn from" + name + ".\n");
		return temp;
	}
	
	/**
	 * Empties the deck.
	 * 
	 * @return All cards in deck.
	 */
	public ArrayList<C> drawAll(){
		ArrayList<C> temp = drawMulti(numCards);
		return temp;
	}
	

	/**
	 * Gets a specific card from the deck if available
	 * 
	 * @param card
	 *            Card requested from the deck.
	 * 
	 * @return The card request or null if not found.
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
	 * Gets specified card from deck. Generated report
	 * 
	 * @param card
	 *            Card requested from the deck.
	 * 
	 * @return The card request or null if not found.
	 */
	public C get_Report(C card) {
		C result = get(card);
		Reporter.printReport("Get Card was called. " + result + " was returned to the deck.");

		return result;
	}

	/**
	 * Gives the deck in its current state
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
	 * Shuffle the cards within the deck
	 */
	public void shuffle() {
		Random random = new Random();
		ArrayList<C> result = new ArrayList<C>();

		while (numCards != 0) {
			result.add(deck.remove(random.nextInt(numCards)));
			numCards--; 
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
		Reporter.printReport("shuffled for the " + timesShuffled + " time");
	}

	/**
	 * Adds a card to the deck
	 * 
	 * @param card
	 *            Card to be added to deck.
	 */
	public C giveTop(C card) {
		deck.add(0, card);
		numCards++;
		return card; 
	}
	
	/**
	 * Adds a card to the deck. Generates report of action
	 * 
	 * @param card
	 *            Card to be added to deck.
	 */
	public C giveTop_Report(C card) {
		giveTop(card); 
		Reporter.printReport(card + " was added to the top of " + name + ".\n");
		return card; 
	}
	
	public C giveBottom(C card){
		deck.add(card);
		return card; 
	}
	
	public C giveBottom_Report(C card){
		giveBottom(card);
		Reporter.printReport(card + " was added to the bottom of " + name + ".\n");
		return card;
	}

	/**
	 * Adds several cards to the deck.
	 * 
	 * @param cards
	 *            Cards to add to the deck.
	 */
	public void giveMulti(ArrayList<C> cards) {
		for (C card : cards)
			giveTop(card);
	}

	/**
	 * Adds several cards to the deck.
	 * 
	 * @param cards
	 *            Cards to add to the deck.
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

	public int get_NumCards() {
		return numCards;
	}

}

package gstat.premade.uno;

import java.util.ArrayList;
import gstat.util.Deck;

/**
 * This project will run a simulation on the game of UNO! This is a card game.
 * The goal is for a player to lose all the cards in their hand. This is
 * accomplished by playing cards of the same color or number as the card in
 * play. There are also special cards that allow the player to play on any card,
 * skip players turn, and reverse turn order.
 * 
 * 
 * @author Camden Voigt
 *
 */

public class Uno {

	/**
	 * These variables are used to find statistics.
	 */
	private static int aliceWins, bobWins, totalTurnsTaken, numUnos;
	private static double aveTurns, aliceWinPercentage, bobWinPercentage, aveUno;

	/**
	 * This is the number of UNO! games to be simulated.
	 */
	private static int games = 10000;

	/**
	 * This is the main method used to call any number of games.
	 * 
	 * @param args
	 *            System Arguments
	 */
	public static void main(String[] args) {

		for(int i = 0; i < games; i++){
			// System.out.println("\n\nGame " + i + "\n\n");
			playSilent();
		}
		statistics();
	}

	/**
	 * Creates a List to store cards to populate the UNO deck.
	 * 
	 * @param d
	 *            A temporary ArrayList to store cards
	 */
	public static void createCards(ArrayList<UnoCard> d) {

		UnoCard red;
		UnoCard blue;
		UnoCard green;
		UnoCard yellow;

		for(int i = 0; i < 9; i++){
			red = new UnoCard(Color.RED, i);
			blue = new UnoCard(Color.BLUE, i);
			green = new UnoCard(Color.GREEN, i);
			yellow = new UnoCard(Color.YELLOW, i);

			if (i == 0){
				d.add(red);
				d.add(blue);
				d.add(green);
				d.add(yellow);
			}
			else{
				for(int j = 1; j < 3; j++){
					d.add(red);
					d.add(blue);
					d.add(green);
					d.add(yellow);
				}
			}
		}
	}

	/**
	 * This method will play one game of UNO and print a log of the actions
	 * taken to the console and a file called log.txt.
	 */
	public static void play() {
		UnoPlayerAI Bob = new UnoPlayerAI("Bob");
		UnoPlayerAI Alice = new UnoPlayerAI("Alice");

		ArrayList<UnoCard> tempD = new ArrayList<UnoCard>();
		createCards(tempD);
		Deck<UnoCard> playDeck = new Deck<UnoCard>(tempD, "Play Deck");
		playDeck.shuffle();
		Deck<UnoCard> discardDeck = new Deck<UnoCard>("Discard Deck");

		System.out.println("Drawing Cards\n\n");
		for(int i = 1; i < 8; i++){
			Bob.playerHand.drawCard_Report(playDeck.draw_Report());
			Alice.playerHand.drawCard_Report(playDeck.draw_Report());
		}
		System.out.println("\nFlipping First Card\n\n");
		UnoCard currentTop = playDeck.draw_Report();
		discardDeck.giveToTop_Report(currentTop);

		System.out.println("\n\nThe game begins\n\n");
		int flag = 0;
		int turnsTaken = 0;
		int tempSize = 0;
		UnoCard temp = new UnoCard();
		while (flag == 0){
			turnsTaken++;
			System.out.println("Its turn " + turnsTaken);
			System.out.println("Its Bob's Turn");
			tempSize = Bob.playerHand.hand.size();
			if (playDeck.getNumCards() == 0){
				reshuffle(playDeck, discardDeck);
			}
			temp = Bob.playCard(currentTop, playDeck);
			if (Bob.playerHand.hand.size() < tempSize){
				discardDeck.giveToTop_Report(temp);
				currentTop = discardDeck.peekTop();
			}
			if (Bob.playerHand.hand.size() == 0){
				System.out.println("Bob Won!");
				flag = 1;
				break;
			}

			System.out.println("It's Alice's Turn");
			tempSize = Alice.playerHand.hand.size();
			if (playDeck.getNumCards() == 0){
				reshuffle(playDeck, discardDeck);
			}
			temp = Alice.playCard(currentTop, playDeck);
			if (Alice.playerHand.hand.size() < tempSize){
				discardDeck.giveToTop_Report(temp);
				currentTop = discardDeck.peekTop();
			}
			if (Alice.playerHand.hand.size() == 0){
				System.out.println("Alice Won!");
				flag = 2;
				break;
			}
		}

		if (flag == 1){
			bobWins++;
		}
		else{
			aliceWins++;
		}
		totalTurnsTaken += turnsTaken;
		numUnos += Bob.getNumUno() + Alice.getNumUno();
	}

	/**
	 * This method will play one game of UNO and will not print a log of the
	 * actions taken to the console and a file called log.txt.
	 */
	public static void playSilent() {
		SilentUnoPlayerAI Bob = new SilentUnoPlayerAI("Bob");
		SilentUnoPlayerAI Alice = new SilentUnoPlayerAI("Alice");

		ArrayList<UnoCard> tempD = new ArrayList<UnoCard>();
		createCards(tempD);
		Deck<UnoCard> playDeck = new Deck<UnoCard>(tempD, "Play Deck");
		playDeck.shuffle();
		Deck<UnoCard> discardDeck = new Deck<UnoCard>("Discard Deck");

		for(int i = 1; i < 8; i++){
			Bob.playerHand.drawCard(playDeck.draw());
			Alice.playerHand.drawCard(playDeck.draw());
		}

		UnoCard currentTop = playDeck.draw();
		discardDeck.giveToTop(currentTop);

		int flag = 0;
		int turnsTaken = 0;
		int tempSize = 0;
		UnoCard temp = new UnoCard();
		while (flag == 0){
			turnsTaken++;
			tempSize = Bob.playerHand.hand.size();
			if (playDeck.getNumCards() == 0){
				reshuffle(playDeck, discardDeck);
			}
			temp = Bob.playCard(currentTop, playDeck);
			if (Bob.playerHand.hand.size() < tempSize){
				discardDeck.giveToTop(temp);
				currentTop = discardDeck.peekTop();
			}
			if (Bob.playerHand.hand.size() == 0){
				flag = 1;
				break;
			}

			tempSize = Alice.playerHand.hand.size();
			if (playDeck.getNumCards() == 0){
				reshuffle(playDeck, discardDeck);
			}
			temp = Alice.playCard(currentTop, playDeck);
			if (Alice.playerHand.hand.size() < tempSize){
				discardDeck.giveToTop(temp);
				currentTop = discardDeck.peekTop();
			}
			if (Alice.playerHand.hand.size() == 0){
				flag = 2;
				break;
			}
		}

		if (flag == 1){
			bobWins++;
		}
		else{
			aliceWins++;
		}
		totalTurnsTaken += turnsTaken;
		numUnos += Bob.getNumUno() + Alice.getNumUno();
	}

	/**
	 * Repopulates and reshuffles the play deck using the contents of the
	 * discard deck.
	 * 
	 * @param playDeck
	 *            Empty deck of cards to be drawn
	 * @param discardDeck
	 *            Empty deck of cards that have been discarded
	 */
	public static void reshuffle(Deck<UnoCard> playDeck, Deck<UnoCard> discardDeck) {
		UnoCard temp1 = discardDeck.draw();
		playDeck.giveMultiple(discardDeck.drawAll());
		playDeck.shuffle();
		discardDeck.giveToTop(temp1);
	}

	/**
	 * This method uses the global counters to calculate statistics of all the
	 * games.
	 */
	public static void statistics() {
		aveTurns = (double) totalTurnsTaken / games;
		bobWinPercentage = (double) bobWins / games;
		aliceWinPercentage = (double) aliceWins / games;
		aveUno = (double) numUnos / games;

		System.out.println("\n\n\n\tFinal Report");
		System.out.println("\t------------");
		System.out.println("Number of games Alice won: " + aliceWins);
		System.out.println("Number of games Bob won: " + bobWins);
		System.out.println("Percentage wins for Alice over " + games + " games: " + aliceWinPercentage);
		System.out.println("Percentage wins for Bob over " + games + " games: " + bobWinPercentage);
		System.out.println("\nNumber of turns taken over all games: " + totalTurnsTaken);
		System.out.println("The average turns over " + games + " games: " + aveTurns);
		System.out.println("\nNumber of Unos over all games: " + numUnos);
		System.out.println("The average Unos over " + games + " games: " + aveUno);
	}
}

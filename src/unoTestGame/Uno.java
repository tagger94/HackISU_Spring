package unoTestGame;

import java.util.ArrayList;
import gameSim.*;

public class Uno {

	private static int aliceWins, bobWins, totalTurnsTaken, numUnos;
	private static double aveTurns, aliceWinPercentage, bobWinPercentage, aveUno;
	private static int games = 10000;

	public static void main(String[] args) {

		for(int i = 0; i < games; i++){
			//System.out.println("\n\nGame " + i + "\n\n");
			playSilent();
		}
		
		statistics(); 
	}

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
		discardDeck.giveTop_Report(currentTop);

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
			if (playDeck.get_NumCards() == 0){
				reshuffle(playDeck, discardDeck);
			}
			temp = Bob.playCard(currentTop, playDeck);
			if (Bob.playerHand.hand.size() < tempSize){
				discardDeck.giveTop_Report(temp);
				currentTop = discardDeck.peekTop();
			}
			if (Bob.playerHand.hand.size() == 0){
				System.out.println("Bob Won!");
				flag = 1;
				break;
			}

			System.out.println("It's Alice's Turn");
			tempSize = Alice.playerHand.hand.size();
			if (playDeck.get_NumCards() == 0){
				reshuffle(playDeck, discardDeck);
			}
			temp = Alice.playCard(currentTop, playDeck);
			if (Alice.playerHand.hand.size() < tempSize){
				discardDeck.giveTop_Report(temp);
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
		discardDeck.giveTop(currentTop);

		int flag = 0;
		int turnsTaken = 0;
		int tempSize = 0;
		UnoCard temp = new UnoCard();
		while (flag == 0){
			turnsTaken++;
			tempSize = Bob.playerHand.hand.size();
			if (playDeck.get_NumCards() == 0){
				reshuffle(playDeck, discardDeck);
			}
			temp = Bob.playCard(currentTop, playDeck);
			if (Bob.playerHand.hand.size() < tempSize){
				discardDeck.giveTop(temp);
				currentTop = discardDeck.peekTop();
			}
			if (Bob.playerHand.hand.size() == 0){
				flag = 1;
				break;
			}

			tempSize = Alice.playerHand.hand.size();
			if (playDeck.get_NumCards() == 0){
				reshuffle(playDeck, discardDeck);
			}
			temp = Alice.playCard(currentTop, playDeck);
			if (Alice.playerHand.hand.size() < tempSize){
				discardDeck.giveTop(temp);
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

	public static void reshuffle(Deck<UnoCard> playDeck, Deck<UnoCard> discardDeck) {
		UnoCard temp1 = discardDeck.draw(); 
		playDeck.giveMulti(discardDeck.drawAll());
		playDeck.shuffle();
		discardDeck.giveTop(temp1);
	}

	public static void statistics(){
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

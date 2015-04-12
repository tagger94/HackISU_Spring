package unoTestGame;

import java.util.ArrayList;
import gameSim.*; 

public class Uno {

	public static void main(String[] args) {
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
		boolean flag = false;
		int turnsTaken = 0;
		int tempSize = 0;
		UnoCard temp = new UnoCard(); 
		while(!flag){
			turnsTaken++; 
			System.out.println("Its turn " + turnsTaken);
			System.out.println("Its Bob's Turn");
			tempSize = Bob.playerHand.hand.size();
			temp = Bob.playCard(currentTop, playDeck);
			if(Bob.playerHand.hand.size() < tempSize){
				discardDeck.giveTop_Report(temp);
				currentTop = discardDeck.peekTop(); 
			}
			if(Bob.playerHand.hand.size() == 0){
				System.out.println("Bob Won!");
				flag = true; 
				break;
			}
			
			System.out.println("It's Alice's Turn");
			tempSize = Alice.playerHand.hand.size();
			temp = Alice.playCard(currentTop, playDeck); 
			if(Alice.playerHand.hand.size() < tempSize){
				discardDeck.giveTop_Report(temp);
				currentTop = discardDeck.peekTop(); 
			}
			if(Alice.playerHand.hand.size() == 0){
				System.out.println("Alice Won!");
				flag = true; 
				break;
			}
		}
	}
	
	public static void createCards(ArrayList<UnoCard> d){
		
		UnoCard red;
		UnoCard blue;
		UnoCard green; 
		UnoCard yellow;
		
		for(int i = 0; i < 9; i++){
			red = new UnoCard(Color.RED, i);
			blue = new UnoCard(Color.BLUE, i);
			green = new UnoCard(Color.GREEN, i);
			yellow = new UnoCard(Color.YELLOW, i);
			
			if(i == 0){
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
}

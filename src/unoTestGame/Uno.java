package unoTestGame;

import java.util.ArrayList;
import gameSim.*; 

public class Uno {

	public static void main(String[] args) {
		UnoPlayerAI Bob = new UnoPlayerAI("Bob");
		UnoPlayerAI Alice = new UnoPlayerAI("Alice");
		
		ArrayList<UnoCard> tempD = new ArrayList<UnoCard>();
		createCards(tempD); 
		Deck<UnoCard> playDeck = new Deck<UnoCard>(tempD);
		playDeck.shuffle(); 
		Deck<UnoCard> discardDeck = new Deck<UnoCard>(); 
		
		System.out.println("Drawing Cards\n\n");
		for(int i = 1; i < 8; i++){ 
			Bob.playerHand.drawCard_Report(playDeck.draw_Report());
			Alice.playerHand.drawCard_Report(playDeck.draw_Report()); 
		}
		
		UnoCard currentTop = playDeck.draw_Report();
		discardDeck.give_Report(currentTop);
		
		System.out.println("\n\nThe game begins\n\n"); 
		for(int j = 0; j < 10; j++){
			discardDeck.give_Report(Bob.playCard(currentTop, playDeck));
			currentTop = discardDeck.peekTop(); 
			if(Bob.playerHand.hand.size() == 0){
				System.out.println("Bob Won!"); 
				break;
			}
			discardDeck.give_Report(Alice.playCard(currentTop, playDeck));
			currentTop = discardDeck.peekTop(); 
			if(Alice.playerHand.hand.size() == 0){
				System.out.println("Alice Won!"); 
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

package unoTestGame;

import java.util.ArrayList;
import gameSim.*; 

public class Uno {

	public static void main(String[] args) {
		UnoPlayerAI Bob = new UnoPlayerAI("Bob");
		UnoPlayerAI Alice = new UnoPlayerAI("Alice");
		
		ArrayList<UnoCard> tempD = new ArrayList<UnoCard>();
		createCards(tempD); 
		Deck<UnoCard> deck = new Deck(tempD); 

		
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

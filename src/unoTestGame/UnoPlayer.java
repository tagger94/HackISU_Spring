package unoTestGame;

import gameSim.*; 

public class UnoPlayer {

	public Hand<UnoCard> playerHand;
	private String name; 
	
	public UnoPlayer(){
		name = "Alice";
		playerHand = new Hand<UnoCard>();
	}
	
	public UnoPlayer(String name){
		this.name = name;
		playerHand = new Hand<UnoCard>(); 
	}
	
	public String getName(){
		return name; 
	}
	
	public int findNumRed(){
		int numRed = 0;
		UnoCard red = new UnoCard(Color.RED, 1); 
		for(int i = 0; i < playerHand.hand.size(); i++){
			if(playerHand.hand.get(i).equalColor(red)){
				numRed++; 
			}
		}
		return numRed;
	}
	
	public int findNumBlue(){
		int numBlue = 0;
		UnoCard blue = new UnoCard(Color.BLUE, 1); 
		for(int i = 0; i < playerHand.hand.size(); i++){
			if(playerHand.hand.get(i).equalColor(blue)){
				numBlue++; 
			}
		}
		return numBlue;
	}
	
	public int findNumGreen(){
		int numGreen = 0;
		UnoCard green = new UnoCard(Color.GREEN, 1); 
		for(int i = 0; i < playerHand.hand.size(); i++){
			if(playerHand.hand.get(i).equalColor(green)){
				numGreen++; 
			}
		}
		return numGreen;
	}
	
	public int findNumYellow(){
		int numYellow = 0;
		UnoCard yellow = new UnoCard(Color.YELLOW, 1); 
		for(int i = 0; i < playerHand.hand.size(); i++){
			if(playerHand.hand.get(i).equalColor(yellow)){
				numYellow++; 
			}
		}
		return numYellow;
	}
}

package unoTestGame;

import gameSim.*; 

public class UnoPlayer {

	public Hand playerHand;
	private String name; 
	
	public UnoPlayer(){
		name = "Alice";
		playerHand = new Hand();
	}
	
	public UnoPlayer(String name){
		this.name = name; 
	}
	
	public String getName(){
		return name; 
	}
}

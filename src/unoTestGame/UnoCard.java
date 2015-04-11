package unoTestGame;

import gameSim.Card;

public class UnoCard implements Card{
	
	private String name;
	private String color;
	private int number; 
	
	@Override
	public String toString(){
		return name;
	}
	
	@Override
	public boolean equals(Object other){
		if (other == null){
			return false; 
		}
		
		
	}
	
	
}

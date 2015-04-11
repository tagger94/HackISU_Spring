package unoTestGame;

import gameSim.Card;

public class UnoCard implements Card{
	
	private String name;
	private Color color;
	private int number; 
	
	public UnoCard(){
		name = "Red 1";
		color = Color.RED;
		number = 1; 
	}
	
	public UnoCard(Color color, int num){
		this.color = color;
		number = num;
		String tempColor = ""; 
		switch(color){
			case RED:
				tempColor = "Red";
				break;
			case BLUE:
				tempColor = "Blue"; 
				break;
			case GREEN:
				tempColor = "Green";
				break;
			case YELLOW:
				tempColor = "Yellow";
		}
		name = tempColor + num + ""; 
	}
	
	@Override
	public String toString(){
		return name;
	}
	
	@Override
	public boolean equals(Object other){
		if (other == null || other.getClass() != this.getClass()){
			return false; 
		}
		
		UnoCard c = (UnoCard) other; 
		
		if(c.color == this.color && c.number == this.number){
			return true; 
		}
		
		return false; 
	}
	
	public boolean equalColor(UnoCard c){
		if(this.color == c.color){
			return true; 
		}
		
		return false;
	}
	
	public boolean equalNumber(UnoCard c){
		if(this.number == c.number){
			return true; 
		}
		
		return false; 
	}
	
	public int getNumber(){
		return number; 
	}
	
	public Color getColor(){
		return color;
	}
}

package unoTestGame;

import java.util.ArrayList;

public class UnoPlayerAI extends UnoPlayer {

	public UnoPlayerAI(){
		super(); 
	}
	
	public UnoPlayerAI(String name){
		super(name);
	}
	
	public UnoCard playCard(UnoCard c){
		
		ArrayList<UnoCard> colorList = new ArrayList<UnoCard>();
		ArrayList<UnoCard> numberList = new ArrayList<UnoCard>(); 
		
		for(int i = 0; i < playerHand.hand.size(); i++){
			if(playerHand.hand.get(i).equalColor(c)){
				
			}
		}
		
		return null; 
	}
}

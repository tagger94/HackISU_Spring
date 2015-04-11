package unoTestGame;

import java.util.ArrayList;
import gameSim.*; 

public class UnoPlayerAI extends UnoPlayer {

	public UnoPlayerAI(){
		super(); 
	}
	
	public UnoPlayerAI(String name){
		super(name);
	}
	
	public UnoCard playCard(UnoCard c, Deck<UnoCard> d){
		
		ArrayList<UnoCard> colorList = new ArrayList<UnoCard>();
		ArrayList<UnoCard> numberList = new ArrayList<UnoCard>(); 
		
		for(int i = 0; i < playerHand.hand.size(); i++){
			if(playerHand.hand.get(i).equalColor(c)){
				colorList.add(playerHand.hand.get(i));
			}
			if(playerHand.hand.get(i).equalNumber(c)){
				numberList.add(playerHand.hand.get(i));
			}
		}
		
		if(colorList.size() == 0 && numberList.size() == 0){
			playerHand.drawCard_Report(d.draw());
		}
		
		if(colorList.size() != 0){
			playerHand.discardCard_Report(colorList.get(0));
			return colorList.get(0);
		}
		
		
		int numRed = findNumRed();
		int numBlue = findNumBlue();
		int numGreen = findNumGreen();
		int numYellow = findNumYellow(); 
		
		if(numRed > numBlue && numRed > && numRed > num)
		
		return null; 
	}
}

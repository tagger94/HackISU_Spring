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
			UnoCard temp = d.draw(); 
			playerHand.drawCard_Report(temp);
			return temp; 
		}
		
		if(colorList.size() != 0){
			playerHand.discardCard_Report(colorList.get(0));
			return colorList.get(0);
		}
		
		int[] maxNums = new int[4]; 
		maxNums[0] = findNumRed();
		maxNums[1] = findNumBlue();
		maxNums[2] = findNumGreen();
		maxNums[3] = findNumYellow(); 
		
		int max = maxNums[0];
		for(int i = 1; i < 4; i++){
			if (maxNums[i] > max) max = maxNums[i]; 
		}
		
		Color maxColor = Color.RED; 
		
		return null; 
	}
}

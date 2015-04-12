package gstat.premade.uno;

import java.util.ArrayList;
import gstat.util.Deck;

/**
 * This class is a subclass of UnoPlayer and an automatic UNO player for use in
 * simulations.
 * 
 * @author Camden Voigt
 *
 */

public class SilentUnoPlayerAI extends UnoPlayer {

	private int numUno = 0;

	/**
	 * Creates a UnoPlayerAI using super class UnoPlayer.
	 */
	public SilentUnoPlayerAI() {
		super();
	}

	/**
	 * Creates a UnoPlayerAI using super class UnoPlayer with a user specified
	 * name.
	 * 
	 * @param name
	 *            The name for the UnoPlayerAI
	 */
	public SilentUnoPlayerAI(String name) {
		super(name);
	}

	/**
	 * Chooses and plays a card from the hand based on the card in play.
	 * 
	 * @param c
	 *            UnoCard to be played on
	 * @param d
	 *            Deck to be drawn from
	 * 
	 * @return the UnoCard that is played or drawn
	 */
	public UnoCard playCard(UnoCard c, Deck<UnoCard> d) {

		ArrayList<UnoCard> colorList = new ArrayList<UnoCard>();
		ArrayList<UnoCard> numberList = new ArrayList<UnoCard>();

		for(int i = 0; i < playerHand.hand.size(); i++){
			if (playerHand.hand.get(i).equalColor(c)){
				colorList.add(playerHand.hand.get(i));
			}
			if (playerHand.hand.get(i).equalNumber(c)){
				numberList.add(playerHand.hand.get(i));
			}
		}

		if (colorList.size() == 0 && numberList.size() == 0){
			UnoCard temp = d.draw();
			playerHand.drawCard(temp);
			return temp;
		}

		if (colorList.size() != 0){
			playerHand.discardCard(colorList.get(0));
			if (playerHand.hand.size() == 1){
				numUno++;
			}
			return colorList.get(0);
		}

		if (numberList.size() != 0){
			int[] maxNums = new int[4];
			maxNums[0] = findNumRed();
			maxNums[1] = findNumBlue();
			maxNums[2] = findNumGreen();
			maxNums[3] = findNumYellow();

			int max = maxNums[0];
			for(int i = 1; i < 4; i++){
				if (maxNums[i] > max)
					max = maxNums[i];
			}

			Color maxColor = Color.RED;

			if (max == maxNums[0]){
				maxColor = Color.RED;
			}
			else if (max == maxNums[1]){
				maxColor = Color.BLUE;
			}
			else if (max == maxNums[2]){
				maxColor = Color.GREEN;
			}
			else if (max == maxNums[3]){
				maxColor = Color.YELLOW;
			}

			UnoCard temp = new UnoCard(maxColor, c.getNumber());
			for(int j = 0; j < numberList.size(); j++){
				if (numberList.get(j).equalColor(temp)){
					playerHand.discardCard(numberList.get(j));
					if (playerHand.hand.size() == 1){
						numUno++;
					}
					return numberList.get(j);
				}
			}
			playerHand.discardCard(numberList.get(0));
			if (playerHand.hand.size() == 1){
				numUno++;
			}
			return numberList.get(0);
		}

		return null;
	}

	/**
	 * Returns the number of times there has been an UNO.
	 * 
	 * @return number of times there has been an UNO
	 */
	public int getNumUno() {
		return numUno;
	}
}

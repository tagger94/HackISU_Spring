package unoTestGame;

import gameSim.Card;

/**
 * This class is a card for the game of UNO. It tells the color and number of
 * the Uno Card. It implements the card interface to it can be utilized by the
 * hand class.
 * 
 * @author Camden Voigt
 *
 */

public class UnoCard implements Card {

	private String name;
	private Color color;
	private int number;

	/**
	 * Creates a default card of color red and number 1
	 */
	public UnoCard() {
		name = "Red 1";
		color = Color.RED;
		number = 1;
	}

	/**
	 * Creates a card of the specified color and number
	 * 
	 * @param color
	 *            Color of the card
	 * @param num
	 *            Number of the card
	 */
	public UnoCard(Color color, int num) {
		this.color = color;
		number = num;
		String tempColor = "";
		switch (color) {
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

	/**
	 * This method gives the string representation of the card name
	 */
	@Override
	public String toString() {
		return name;
	}

	/**
	 * This method allows comparison of the cards number and color with the
	 * object sent to the method.
	 * 
	 * @param other
	 *            the object to be compared to
	 * @return True when the cards are eqaul
	 */
	@Override
	public boolean equals(Object other) {
		if (other == null || other.getClass() != this.getClass()){
			return false;
		}

		UnoCard c = (UnoCard) other;

		if (c.color == this.color && c.number == this.number){
			return true;
		}

		return false;
	}

	/**
	 * This method compares the color of the card and the card sent to it
	 * 
	 * @param c
	 *            Card to be compared to
	 * @return True when cards have the same color
	 */
	public boolean equalColor(UnoCard c) {
		if (this.color == c.color){
			return true;
		}

		return false;
	}

	/**
	 * This method compares the number of the card and the card sent to it
	 * 
	 * @param c
	 *            Card to be compared to
	 * @return True when cards have the same number
	 */
	public boolean equalNumber(UnoCard c) {
		if (this.number == c.number){
			return true;
		}

		return false;
	}

	/**
	 * Returns the number of the card
	 * 
	 * @return number of the card
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Returns the color of the card
	 * 
	 * @return Color of the card
	 */
	public Color getColor() {
		return color;
	}
}

package gameSim;
/**
 * A class to represent a playing card by taking in a Suit and Number to
 * represent it (Ace - 1, Jacks - 11, Queens - 12, King - 13)
 * 
 * @author bruckna
 * 
 */
public class Card {
	// Associative table for the GUI to identify the card
	private static final String[] identifier = {
			// Spade
			"SA", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "ST", "SJ", "SQ", "SK",
			// Heart
			"HA", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "HT", "HJ", "HQ", "HK",
			// Club
			"CA", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "CT", "CJ", "CQ", "CK",
			// Diamond
			"DA", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "DT", "DJ", "DQ", "DK" };
	private String id;

	public Card(String suit, int num) {
		int identity = 0;
		if (suit.toUpperCase().equals("HEART")) {
			identity = 13;
		} else if (suit.toUpperCase().equals("CLUB")) {
			identity = 26;
		} else if (suit.toUpperCase().equals("DIAMOND")) {
			identity = 39;
		}
		id = identifier[identity + num];
	}

	@Override
	public String toString() {
		return id;
	}
}
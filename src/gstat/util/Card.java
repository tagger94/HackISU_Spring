package gstat.util;

/**
 * 
 * @author Mike Onyszczak
 *
 *         There is not much here, but if you want to use a custom deck this
 *         interface is vital.
 *
 */
public interface Card {
	/**
	 * Compares this Card to another card.
	 * 
	 * @param other
	 *            Other card to be compared with
	 * 
	 * @return True if the cards are the same, False if the cards are different
	 */
	@Override
	public boolean equals(Object other);

	/**
	 * Returns the card as a string.
	 * 
	 * @return String representation of the card
	 */
	@Override
	public String toString();
}

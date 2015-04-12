package gstat.util;

public interface Player {

	/**
	 * Increases the number of a specified type of tokens in the player's
	 * inventory.
	 * 
	 * @param i
	 *            The specified inventory to take from
	 * @param num
	 *            Number of tokens to take
	 * 
	 * @return Number of tokens taken
	 */
	public int addTokens(Inventory i, int num);

	/**
	 * Decreases the number of a specified type of tokens in the player's
	 * inventory.
	 * 
	 * @param i
	 *            The specified inventory to give tokens to
	 * @param num
	 *            Number of tokens to give
	 * 
	 * @return Number of tokens given
	 */
	public int removeTokens(Inventory i, int num);

	/**
	 * Increases the number of a specified type of tokens in the player's
	 * inventory. Generates report.
	 * 
	 * @param i
	 *            The specified inventory to take from
	 * @param num
	 *            Number of tokens to take
	 * 
	 * @return Number of tokens taken
	 */
	public int addTokens_Report(Inventory i, int num);

	/**
	 * Decreases the number of a specified type of tokens in the player's
	 * inventory. Generates report.
	 * 
	 * @param i
	 *            The specified inventory to give tokens to
	 * @param num
	 *            Number of tokens to give
	 * 
	 * @return Number of tokens given
	 */
	public int removeTokens_Report(Inventory i, int num);
}

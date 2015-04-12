package gstat.util;

public interface Player {

	public int addTokens(Inventory i, int num);

	public int subTokens(Inventory i, int num);

	public int addTokens_Report(Inventory i, int num);

	public int subTokens_Report(Inventory i, int num);
}

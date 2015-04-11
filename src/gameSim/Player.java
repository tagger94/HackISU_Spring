package gameSim;

public interface Player {

	public void addTokens(Inventory i, int num);
	public void subTokens(Inventory i, int num); 
	public void addTokens_Report(Inventory i, int num);
	public void subTokens_Report(Inventory i, int num); 
}

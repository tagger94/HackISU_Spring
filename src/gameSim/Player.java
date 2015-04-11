package gameSim;

public interface Player {

	public void addToken(Inventory i, int num);
	public void subToken(Inventory i, int num); 
	public void addToken_Report(Inventory i, int num);
	public void subToken_Report(Inventory i, int num); 
}

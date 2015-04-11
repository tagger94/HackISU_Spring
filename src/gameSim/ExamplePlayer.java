package gameSim;

public class ExamplePlayer implements Player {

	public Hand hand;
	private String name; 
	private int numTokens;
	private int totalTokens;
	private int totalLostTokens;
	
	public ExamplePlayer(String name){
		this.name = name;
		hand = new Hand(); 
		numTokens = 0;
		totalTokens = 0;
		totalLostTokens = 0; 
	}
	
	public ExamplePlayer(String name, int numTokens){
		this.name = name; 
		hand = new Hand(); 
		this.numTokens = numTokens;
		totalTokens = numTokens;
		totalLostTokens = 0;
	}
	
	public void addTokens(Inventory i, int num){
		numTokens += num;
		totalTokens += num; 
		i.take(num);
	}
	
	public void addTokens_Report(Inventory i, int num){
		numTokens += num;
		i.take(num);
		System.out.println(num + " tokens were given to " + name + "\n");
		System.out.println(num + " tokens were take from inventory " + i.title + "\n"); 
	}
	
	public void subTokens(Inventory i, int num){
		numTokens -= num;
		totalLostTokens += num;
		i.give(num); 
	}
	
	public void subTokens_Report(Inventory i, int num){
		numTokens -= num;
		totalLostTokens += num;
		i.give(num);
		System.out.println(num + " tokens were taken from " + name + ".\n");
		System.out.println(num + " tokens were given to inventory " + i.title + ".\n");
	}
	
	public int getNumTokens(){
		return numTokens;
	}
	
	public String numTokens_Report(){
		System.out.println(name + " has " + numTokens);
		return name + " has " + numTokens;
	}
	
	public int getTotalTokens(){
		return totalTokens;
	}
	
	public String totalTokens_Report(){
		System.out.println(name + " has recieved" + totalTokens + "total.\n");
		return name + " has recieved" + totalTokens + "total.";
	}
	
	public int getTotalLostTokens(){
		return totalLostTokens; 
	}
	
	public String totalLostTokens_Report(){
		System.out.println(name + " has lost " + totalLostTokens + "total.\n");
		return name + " has lost " + totalLostTokens + "total.\n";
	}
}

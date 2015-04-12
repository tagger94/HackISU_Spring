package warTestGame;

public class WarRun {
	
	public static void main(String args[]){
		War game;
		for(int a = 0; a < 1000; a++){
			game = new War();
			game.playGame();
		}
		System.out.println("Player 1 won: " + War.get_p1W());
		System.out.println("Player 2 won: " + War.get_p2W());
	}
	
}

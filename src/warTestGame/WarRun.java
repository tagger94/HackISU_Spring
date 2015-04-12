package warTestGame;

public class WarRun {
	
	public static void main(String args[]){
		for(int a = 0; a < 10000; a++){
			War game = new War();
			game.playGame();
		}
		System.out.println("Player 1 won: " + War.get_p1W());
		System.out.println("Player 2 won: " + War.get_p2W());
		System.out.println("Average rounds per game: " + (War.totRounds*1.0)/War.games);
		
		System.out.println(War.get_p1W()*1.0/(War.get_p1W()+War.get_p2W()));
	}
	
}

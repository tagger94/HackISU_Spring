package warTestGame;

import java.util.ArrayList;

import exampleClasses.StandardPlayingCard;
import gameSim.Deck;

public class War {

	private Deck<StandardPlayingCard> deck;
	 private ArrayList<StandardPlayingCard> down;
	WarPlayer player_1;
	WarPlayer player_2;

	/**
	 * Default new game constructor
	 */

	public War() {
		player_1 = new WarPlayer("Player_1");
		player_2 = new WarPlayer("Player_2");
		
		deck = new Deck<StandardPlayingCard>(StandardPlayingCard.makeDeck());
		deck.shuffle();
		
		for(int a = 0; a < 26; a++){
			player_1.takeCard(deck.draw());
			player_2.takeCard(deck.draw());
		}
	}
	
	/**
	 * Runs one turn of the game
	 */
	public void playTurn(){
		down = new ArrayList<>();
		down.add(player_1.playCard());
		down.add(player_2.playCard());
		if(makeAction(down.get(0), down.get(1)) == -1){
			player_1.winRound(down);
		} else {
			player_2.winRound(down);
		}
	}
	
	/**
	 * Runs one full game of War
	 */
	public void playGame(){
		while(player_1.hasWon() == false && player_2.hasWon() == false){
			playTurn();
		}
		if(player_1.hasWon() == true)
			System.out.println("Player 1 wins!");
		else
			System.out.println("Player 2 wins!");
	}
	
	
	public int makeAction(StandardPlayingCard c1, StandardPlayingCard c2){
		int comp = c1.compareToIgnoreSuit(c2);
		if(comp < 0) //c1 bigger
			return -1;
		if(comp > 0) //c2 bigger
			return 1;
		return splitTie(c1, c2);
	}
	
	public int splitTie(StandardPlayingCard c1, StandardPlayingCard c2){
		for(int a = 0; a < 4; a++){
			down.add(player_1.playCard());
			down.add(player_2.playCard());
		}
		return makeAction(down.get(6), down.get(7));
	}
	

}

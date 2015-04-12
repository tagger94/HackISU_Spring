package gstat.premade.war;

import java.util.ArrayList;

import gstat.premade.playingcard.StandardPlayingCard;
import gstat.util.Deck;

/**
 * The game of war simulation setup. War is a game in which both players are
 * randomly given half a deck of standard playing cards. They each
 * simultaneously flip their cards and compare to see if they can take the other
 * players cards. First to gain all the cards wins.
 * 
 * @author Brennyn Hawbaker
 *
 */
public class War {

	private ArrayList<StandardPlayingCard> down;
	WarPlayer player_1;
	WarPlayer player_2;

	/**
	 * Statistic variables
	 */
	static int p1_wins;
	static int p2_wins;
	static int rounds;
	static int totRounds;
	static int games;

	/**
	 * Constructs a new game with two players.
	 */
	public War() {
		player_1 = new WarPlayer("Player_1");
		player_2 = new WarPlayer("Player_2");

		Deck<StandardPlayingCard> deck = new Deck<StandardPlayingCard>(StandardPlayingCard.makeDeck());
		deck.shuffle();
		for(int a = 0; a < 26; a++){
			player_1.takeCard(deck.draw());
			player_2.takeCard(deck.draw());
		}
		down = new ArrayList<>();
	}

	/**
	 * Runs one turn of the game.
	 */
	public void playTurn() {
		down = new ArrayList<>();
		down.add(player_1.playCard());
		down.add(player_2.playCard());
		int win = makeAction(down.get(0), down.get(1));
		if (win == -1){
			player_1.winRound(down);
			checkEndGame();
		}
		else if (win == -2){
			checkEndGame();
		}
		else{
			player_2.winRound(down);
			checkEndGame();
		}
	}

	/**
	 * Runs one full game of War. Tracks statistics.
	 */
	public void playGame() {
		rounds = 0;
		while (WarPlayer.haveWinner(player_1, player_2) == 0){
			playTurn();
			// System.out.println(count);
			rounds++;
		}
		// System.out.println("Game over.");
		totRounds += rounds;
		games++;
	}

	/**
	 * Compares two cards using war rules to determine a "winner".
	 * 
	 * @param c1
	 *            player 1's card
	 * @param c2
	 *            player 2's card
	 * @return -1 if player 1 wins, 1 if player 2 wins
	 */
	public int makeAction(StandardPlayingCard c1, StandardPlayingCard c2) {
		if (c1 == null)
			return 1;
		if (c2 == null)
			return -1;
		int comp = c1.compareToIgnoreSuit(c2);
		if (comp < 0) // c1 bigger
			return -1;
		if (comp > 0) // c2 bigger
			return 1;
		return splitTie(c1, c2);
	}

	/**
	 * Does the extra tie actions in war.
	 * 
	 * @param c1
	 *            player 1's card
	 * @param c2
	 *            player 2's card
	 * @return -1 if player 1 wins, 1 if player 2 wins, -2 if someone runs out
	 *         of cards
	 */
	public int splitTie(StandardPlayingCard c1, StandardPlayingCard c2) {
		for(int a = 0; a < 3; a++){
			try{
				down.add(player_1.playCard());
				down.add(player_2.playCard());
			}
			catch (IllegalStateException b){
				return -2;
			}
		}
		return makeAction(player_1.playCard(), player_2.playCard());
	}

	/**
	 * Checks if either player has won.
	 */
	public void checkEndGame() {
		if (WarPlayer.haveWinner(player_1, player_2) == -1){
			// System.out.print("Player one wins! ");
			p1_wins++;
		}
		if (WarPlayer.haveWinner(player_1, player_2) == 1){
			// System.out.print("Player two wins! ");
			p2_wins++;
		}
	}

	/**
	 * Returns number of games player 1 has won.
	 * 
	 * @return number of games won
	 */
	public static int get_p1W() {
		return p1_wins;
	}

	/**
	 * Returns number of games player 2 has won.
	 * 
	 * @return number of games won
	 */
	public static int get_p2W() {
		return p2_wins;
	}

}

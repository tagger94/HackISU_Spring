package gameSim;

import java.util.Random;

/**
 * The die simulator. Self contained random number generator
 * @author Alex
 *
 */
public class Dice {

		private int DIE_SIZE;
		
		private Random rand;
		
		private int report_counter;
		
		/**
		 * Give the number of sides for that die to use
		 * @param sides
		 */
		public Dice(int sides) {
			DIE_SIZE = sides;
			rand = new Random();
		}
		
		/**
		 * Generates a random number of the die
		 * @return A random number between 1 and die size
		 */
		public int roll() {
			report_counter++;
			return rand.nextInt(DIE_SIZE) + 1;
		}
		
		/**
		 * Generates a random number of the die and reports to file
		 * @return A random number between 1 and die size
		 */
		public int roll_report() {
			int num = this.roll();
			System.out.println("Die Rolled: " + num);
			return num;
		}
		
		/**
		 * Generates report of another final report to use
		 * @return Die size and number of times rolled
		 */
		public String getReport() {
			return "Die Size: " + DIE_SIZE + "/nNum of Rolls: " + report_counter;
		}
}

package gameSim;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Convient method to print to log file
 * @author Alex Berns
 *
 */
public class Reporter {
	
	/**
	 * File to print to
	 */
	private static File f = new File("log.txt");
	
	/**
	 * File Writter used
	 */
	private static FileWriter w;

	/**
	 * Writes to log.txt and prints to console
	 * @param s
	 */
	public static void printReport(String s) {
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (w == null){
			try{
			w = new FileWriter(f, true);
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		
		try {
			w.write(s + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(s);
	}
}

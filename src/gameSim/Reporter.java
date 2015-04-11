package gameSim;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Reporter {
	
	private static File f = new File("log.txt.");
	
	private static FileWriter w ;//= new FileWriter(f, true);

	public static void printReport(String s) {
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			w.write(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

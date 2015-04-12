package gameSim;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Reporter {
	
	private static File f = new File("log.txt");
	
	private static FileWriter w;

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

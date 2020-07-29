import java.lang.Math;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;

public class InputProcessor {
	public static File contains(String key, String delim, File in) {
		try {
			File out = new File("contains.out");
			out.createNewFile();
			FileWriter W = new FileWriter(out);
			Scanner S = new Scanner(in);
			String line;
			while(S.hasNextLine()) {
				line = S.nextLine();
				line.trim();
				for(String i : line.split(delim)) {
					if(i.equals(key)) {
						W.write(line + "\n");
						System.out.println(line);
					}
				}
			}
			W.close();
			return out;
		}
		catch(Exception e) { e.printStackTrace(); }
		return in;
	}
	public static File sort(int col, String delim, File in) {
		try {}
		catch(Exception e) { e.printStackTrace(); }
		return in;
	}
	public static void main(String[] args) {}
}

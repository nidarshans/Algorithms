import java.lang.Math;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;

public class InputProcessor {
	public static File contains(int start, String key, String delim, File in) {
		try {
			File out = new File("contains.out");
			out.createNewFile();
			FileWriter W = new FileWriter(out);
			Scanner S = new Scanner(in);
			String line = "";
			for(int x = 0; x < start - 1; x++) S.nextLine();
			while(S.hasNextLine()) {
				line = S.nextLine();
				line.trim();
				for(String i : line.split(delim)) {
					if(i.equals(key)) W.write(line + "\n");
				}
			}
			W.close();
			return out;
		}
		catch(Exception e) { e.printStackTrace(); }
		return in;
	}
	public static void main(String[] args) {}
}

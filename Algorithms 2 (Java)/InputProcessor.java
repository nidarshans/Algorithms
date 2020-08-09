import java.lang.Math;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;

public class InputProcessor {
	public static File contains(int start, int col, String key, String delim, File in) {
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
				String[] i = line.split(delim);
				for(int c = 0; c < i.length; c++) {
					if(col != 0) {
						if(i[col - 1].equals(key)) W.write(line + "\n");
						break;
					}
					if(col == 0) {
						if(i[c].equals(key)) W.write(line + "\n");
					}
				}
			}
			W.close();
			return out;
		}
		catch(Exception e) { e.printStackTrace(); }
		return in;
	}
	public static void main(String[] args) {
		File in = new File("10.in");
		contains(2,0,"6"," ",in);
	}
}

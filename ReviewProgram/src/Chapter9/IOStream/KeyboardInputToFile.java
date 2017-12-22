package Chapter9.IOStream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class KeyboardInputToFile {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String data = sc.nextLine();
		
		File f = new File("/Users/ryshen/Desktop/JavaTest.txt");
		
		if (f.exists()) {
			f.delete();
		}
		f.createNewFile();
		
		FileWriter os = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(os);
		
		bw.write(data);
		
		bw.flush();
		sc.close();
		bw.close();
		
	}

}

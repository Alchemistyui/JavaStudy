import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class ReadWriteFile extends Thread {
	
	public static void main(String[] args) throws Exception {
		File fr = new File("/Users/ryshen/Desktop/read.txt");
		File fw = new File("/Users/ryshen/Desktop/write.txt");
		
		if(!fr.exists()) {
			System.out.println("file doesn't exists!");
		}
		
		BufferedReader br = new BufferedReader(new FileReader(fr));
		BufferedWriter bw = new BufferedWriter(new FileWriter(fw));
		
		String str = null;
		while((str = br.readLine()) != null) {
			bw.write(str);
			bw.newLine();
			bw.flush();
		}
		
		br.close();
		bw.close();
	}
	

	

}


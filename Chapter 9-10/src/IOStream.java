import java.io.*;
import java.util.Scanner;

public class IOStream {
	
	
	static String keyboardIn () {
		System.out.println("请输入一些数据：");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		return in.nextLine();
	}

	public static void main(String[] args) throws IOException {
		
		File f = new File("/Users/ryshen/Desktop/JavaTest.txt");
		
		if ( f.exists() ) {
			f.delete();
		}
		
		f.createNewFile();
		
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
		
		
		String data;
		
		
		
		
		data = IOStream.keyboardIn();
		
		bw.write(data);
		
		bw.flush();
		bw.close();

	}

}


package Chapter10.Network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class UploadFileClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Socket socket = new Socket("127.0.0.1",8001);
		
		File f = new File("/Users/ryshen/Desktop/Client.txt");

		if (!f.exists()) {
			System.out.println("file doesn't exit.");
		}
		
		BufferedReader br = new BufferedReader(new FileReader(f));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		
		String str;
		while((str = br.readLine()) != null) {
			bw.write(str);
			bw.newLine();
			bw.flush();
		}
		
		br.close();
		bw.close();
		
	}

}

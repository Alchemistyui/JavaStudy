package Chapter10.Network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadFileServer {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ServerSocket server = new ServerSocket(8001);
		Socket socket = server.accept();
		
		File f = new File("/Users/ryshen/Desktop/Server.txt");
		
		if (f.exists()) {
			f.delete();
		}

		f.createNewFile();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		String str;
		while((str = br.readLine()) != null) {
			bw.write(str);
			bw.newLine();
			bw.flush();
		}
		bw.close();
		br.close();

	}

}

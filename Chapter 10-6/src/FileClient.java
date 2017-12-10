import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class FileClient {

	public static void main(String[] args) throws Exception {

		Socket socket = new Socket("127.0.0.1", 8001);

		OutputStream os = socket.getOutputStream();

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

		File f = new File("/Users/ryshen/Desktop/Client.txt");

		if (!f.exists()) {
			System.out.println("file doesn't exit.");
		}


		FileReader fw = new FileReader(f);
		BufferedReader br = new BufferedReader(fw);

		String str = null;
		while ((str = br.readLine()) != null) {
			bw.write(str);
			bw.newLine();
			
		}
		bw.flush();
		br.close();
		socket.close();

	}

}

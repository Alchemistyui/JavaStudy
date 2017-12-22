import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8001);
		Socket socket = server.accept();

		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		File f = new File("/Users/ryshen/Desktop/Server.txt");

		if (f.exists()) {
			f.delete();
		}

		f.createNewFile();

		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);

		String str = null;

		while ((str = br.readLine()) != null) {
			bw.write(str);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
		socket.close();
		server.close();
	}
}

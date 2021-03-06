import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

	ChatClient() throws Exception {
		Socket socket = new Socket("127.0.0.1", 8001);
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		InputAgent ia = new InputAgent(os);
		ServerAgent sa = new ServerAgent(is);
		ia.start();
		sa.start();
		socket.close();
	}

	public static void main(String args[]) throws Exception {
		new ChatClient();
	}

	class InputAgent extends Thread {
//		OutputStream os;
		BufferedWriter bw;
		boolean stop = false;
		Scanner sc = new Scanner(System.in);

		InputAgent(OutputStream os) {
//			this.os = os;
			bw = new BufferedWriter(new OutputStreamWriter(os));

		}

		public void run() {
			while (!stop) {
				String str = sc.nextLine();
				try {
					bw.write(str);
					bw.newLine();
					bw.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	class ServerAgent extends Thread {
//		InputStream is;
		BufferedReader br;
		boolean stop = false;

		ServerAgent(InputStream is) {
//			this.is = is;
			br = new BufferedReader(new InputStreamReader(is));
		}

		public void run() {
			while (!stop) {
				String str = "";
				try {
					str = br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(str);
			}
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

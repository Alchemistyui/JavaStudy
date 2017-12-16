package experiment4;

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
	boolean stop = false;
	
	ChatClient() throws IOException {
		Socket socket = new Socket("127.0.0.1", 8001);
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		
		InputAgent ia = new InputAgent(is);
		OutputAgent oa = new OutputAgent(os);
		ia.start();
		oa.start();
	}
	
	

	public static void main(String[] args) throws IOException {
		new ChatClient();

	}
	
	class InputAgent extends Thread {
		BufferedReader br;

		InputAgent(InputStream is) {
			br = new BufferedReader(new InputStreamReader(is));
		}

		public void run() {

			while (!stop) {
				try {
					String msg = br.readLine();
					System.out.println(msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	class OutputAgent extends Thread {
		BufferedWriter bw;
		Scanner sc = new Scanner(System.in);
		
		OutputAgent(OutputStream os) {
			bw = new BufferedWriter(new OutputStreamWriter(os));
		}
		
		public void run() {
		    while(!stop) {
		    	String str = sc.nextLine();
		    	try {
					bw.write(str);
					bw.newLine();
					bw.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		}
		
	}
}

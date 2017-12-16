package experiment4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

import ChatRoomServer.ClientAgent;

public class ChatServer {

	boolean stop = false;
	Set<ServerAgent> serverAgents = new HashSet<>();

	ChatServer() throws IOException {
		ServerSocket server = new ServerSocket(8001);
		Socket socket = server.accept();

	}

	public static void main(String[] args) throws IOException {
		new ChatServer();

	}

	class ServerAgent extends Thread {
		Socket socket;
		BufferedWriter bw;
		BufferedReader br;

		ServerAgent(Socket socket) throws IOException {
			this.socket = socket;
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		}

		public void run() {
			while (!stop) {
				try {
					String str = br.readLine();
					System.out.println("received string: \"" + str + "\" from " + socket.getInetAddress());
					if (str.equals("quit")) {
						stop = true;
					}
					for (ServerAgent ca : serverAgents) {
						if (ca.equals(this))
							continue;
						ca.bw.write(this.socket.getInetAddress() + ": " + str);
						ca.bw.newLine();
						ca.bw.flush();
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}

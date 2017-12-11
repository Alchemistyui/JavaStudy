import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ChatRoomServer {
	ChatRoomServer() throws Exception {
		ServerSocket server = new ServerSocket(8001);
		while (!stop) {
			Socket socket = server.accept();
			ClientAgent ca = new ClientAgent(socket);
			clientAgents.add(ca);
			ca.start();
		}
	}

	boolean stop = false;

	public static void main(String args[]) throws Exception {
		new ChatRoomServer();
	}

	Set<ClientAgent> clientAgents = new HashSet<>();

	class ClientAgent extends Thread {
		Socket socket;
		boolean stop = false;
		BufferedWriter bw;
		BufferedReader br;

		ClientAgent(Socket socket) throws IOException {
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
					for (ClientAgent ca : clientAgents) {
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

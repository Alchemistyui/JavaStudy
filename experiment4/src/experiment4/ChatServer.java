package experiment4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ChatServer  {
	
	boolean stop = false;
	Set<ServerAgent> clientAgents = new HashSet<>();
	
	ChatServer() throws IOException {
		ServerSocket server = new ServerSocket(8001);
		Socket socket = server.accept();


	}

	public static void main(String[] args) throws IOException {
		new ChatServer();

	}
	
	class ServerAgent extends Thread {
		BufferedWriter bw;
		BufferedReader br;
		
		ServerAgent(Socket socket) throws IOException {
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
		}
		
	}

}

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.PublicKey;
import java.util.Arrays;

public class Server {
	//Array of all OutputStreams.
	static ObjectOutputStream[] output_streams = new ObjectOutputStream[max_connections];
	
	public static void main(String[] args) {
		//Port server is running on.
		int port = 1738;
		//Max number of permitted connections.
		int max_connections = 10;
		//Socket server is running on.
		ServerSocket server_socket;
		
		for (int i = 0; i < max_connections; i++) {
			output_streams[i] = null;
		}

		//Tries to start server on given port.
		try {
			System.out.println("Starting Server");
			server_socket = new ServerSocket(port);
			System.out.println("Server started successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}

		//Represents a single user's connection to the server.
		Socket client_socket;
		//Number of online players.
	  	int online_players = 0;

		//Coninuously checks for new connections.
		while (true) {
			int index;
			try {
				client_socket = server_socket.accept();

				//Checks if server has enough room for new connection.
				if (online_players == max_connections) {
					System.out.println("Server full, a new user could not join.");
					client_socket.close();
					continue;
				}

				for (int i = 0; i < max_connections; i++) {
					if (output_streams[i] == null) {
						output_streams[i] = new ObjectOutputStream(client_socket.getOutputStream());
						index = i;
					}
				}

				online_players++;
				System.out.println("New player connected, " + online_players + " players are not online.");

				//Opens new thread for connection.
				Thread connections = new Thread(new Connections(client_socket, index));
				connections.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

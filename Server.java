import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.PublicKey;
import java.util.Arrays;

public class Server {
	//Port server is running on.
	private static int port;
	//Socket server is running on.
	private static ServerSocket server_socket;
  	//Array of ObjectOutputStreams for all clients.
	static ObjectOutputStream[] output_stream;

	public static void main(String[] args) {
		System.out.println("Starting Server");
		//Initializes "logins" matrix and "outputStream" array.
		output_stream = new ObjectOutputStream[maxConnections];

		try {
			server_socket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Server started successfully");

		newConnections();
	}

	private static void newConnections() {
		Socket client_socket;
		//Maximum possible connections to server.
		int max_connections = 10;
	  	//Number of users connected to the server at any given time.
	  	int online_players = 0;

		//Coninuously checks for new connections.
		while (true) {
			try {
				client_socket = server_socket.accept();

				//Checks if server has enough room for new connection.
				if (online_players == max_connections) {
					System.out.println("Server full, a new user could not join.");
					client_socket.close();
					continue;
				}

				System.out.println("New player connected.");
				online_players++;

				//Opens new thread for connection.
				Thread connections = new Thread(new Connections(client_socket));
				connections.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

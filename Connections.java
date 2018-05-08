import java.io.*;
import java.net.*;
import java.util.Arrays;

public class Connections extends Server implements Runnable {
	Socket new_socket;
	int my_index;
	ObjectInputStream input_stream;

	public Connections(Socket socket, int index) {
		my_index = index;
		//Initializes the input stream from the user.
		try {
			input_stream = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			try {
				//Insert code for interacting between the server and the user.
				
				//Format for reading and writing.
				//
				// DataType message;
				// message = (DataType) input_stream.readObject();

				//output_streams[my_index].writeObject(something);
				//output_streams[my_index].flush();

			} catch (IOException e) {
			    //IOException in this case essentially means the user has disconnected from the server.
				System.out.println("User disconnected");
				output_streams[my_index] = null;
				return;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}

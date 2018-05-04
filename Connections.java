import java.io.*;
import java.net.*;
import java.util.Arrays;
public class Connections extends Server implements Runnable {

	Socket new_socket;
	int[] stream_array = new int[maxConnections];
	ObjectInputStream input_stream;
	ObjectOutputStream temp_output;

	public Connections(Socket socket) {
		//Initializes the input stream from the user.
		try {
			temp_output = new ObjectOutputStream(socket.getOutputStream());
			input_stream = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			try {
				String confirmation;
				confirmation = (String) inputStream.readObject();
				System.out.println("New confirmation from user.");
				System.out.println("User sent: " + confirmation);


				//stream_array[number].writeObject(something);
				//stream_array[number].flush();

			} catch (IOException e) {
			    //IOException in this case essentially means the user has disconnected from the server.
				System.out.println("User disconnected");
				isOnline[myIndex] = false;
				onlineNumber--;
				outputStream[Integer.parseInt(logins[myIndex][2])] = null;
				return;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} // End while loop
	}

    public void readUnsent(String username) {
        try {
            File unsent;
            Transmission transmission;
            ObjectInputStream uis;
			int i = 0;

			while (true){
                unsent = new File("unsent/" + username + "-" + i + ".msg");
                if(!unsent.exists())
					break;

                uis = new ObjectInputStream(new FileInputStream(unsent));
                transmission = (Transmission) uis.readObject();

                outputStream[Integer.parseInt(logins[myIndex][2])].writeObject(transmission);
                outputStream[Integer.parseInt(logins[myIndex][2])].flush();

                unsent.delete();
				uis.close();
				i++;
            }
        } catch (IOException | ClassNotFoundException e) {
			isOnline[myIndex] = false;
			onlineNumber--;
			outputStream[Integer.parseInt(logins[myIndex][2])] = null;
        }
		System.out.println("Unread messages have been distributed");
    }

    //Code for sending the publicKeys array to all online users.
	public void keyRefresh() {
		int recipient;
		Transmission transmission = new Transmission();

		PublicKey[] keys = new PublicKey[publicKeys.length];

		for(int i = 0; i < keys.length; i++)
			keys[i] = publicKeys[i];

		for (int i = 0; i < numberOfUsers; i++) {
		    if(!isOnline[i])
		        continue;

            recipient = Integer.parseInt(logins[i][2]);
            try {
                transmission.setSender("SERVER");
                transmission.setType((byte) 2);
                transmission.setMessage(keys);

                outputStream[recipient].writeObject(transmission);
                outputStream[recipient].flush();
            } catch (IOException e) {
				isOnline[i] = false;
                onlineNumber--;
				outputStream[Integer.parseInt(logins[myIndex][2])] = null;
				System.out.println("User disconnected");
            }
		}
		System.out.println("New public keys have been distributed");
	}
	//Code for sending updates usernames array to all online users
	public void nameRefresh(){
		int recipient;
		Transmission transmission = new Transmission();
		String[] usernames = new String[maxConnections];

		for(int i = 0; i < usernames.length; i++)
			usernames[i] = logins[i][0];

		//Sends keys
		for (int i = 0; i < numberOfUsers; i++) {
			if(!isOnline[i])
			    continue;
            recipient = Integer.parseInt(logins[i][2]);
            try {
                transmission.setSender("SERVER");
                transmission.setType((byte) 9);
                transmission.setMessage(usernames);

                outputStream[recipient].writeObject(transmission);
                outputStream[recipient].flush();

            } catch (IOException e) {
				isOnline[i] = false;
                onlineNumber--;
				outputStream[Integer.parseInt(logins[myIndex][2])] = null;
            }
		}
		System.out.println("New usernames have been distributed");
	}
}

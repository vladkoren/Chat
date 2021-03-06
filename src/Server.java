import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static UsersList list = new UsersList();
	public static void main(String[] args) {
		int port;
		ServerSocket servSocket = null;
		System.out.println("Select port....");
		try {
			port = Integer.parseInt(reader.readLine());
			servSocket = new ServerSocket(port);
			System.out.println("Your port - " + port);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true){
			int nickname = 0;
			Socket client = null;
			while(client == null){
				try{
					client = servSocket.accept();
					System.out.println("Got a client");
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			new ClientThread("" + nickname, client);
			nickname++;
		}



	}
	public static UsersList getUserList() {
		return list;
	}

}

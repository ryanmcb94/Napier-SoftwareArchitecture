package eStore.client;

import java.io.*;
import java.net.*;

import eStore.*;

public class ConnectorClient {
	private static ConnectorClient cmd;
	private String serverIP = "localhost";
	private int serverPort = 1050;
	private User currentUser;
	private ObjectInputStream inStream;
	private ObjectOutputStream outStream;
	
	private ConnectorClient() {
		
	}
	
	
	public void connect(String ip,int num) {
		try {
			System.out.println("Connector: Connecting");
			Socket sock = new Socket("127.0.0.1",50);
			System.out.println("Connector: Connected Setting up streams");
			inStream = new ObjectInputStream(sock.getInputStream());
			outStream = new ObjectOutputStream(sock.getOutputStream());
			System.out.println("Connector: Stream setup complete.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public User Login(User user) {
		System.out.println("Connector: Begining Login");
		User loginUser=null;
		try {
			System.out.println("writing user to server. Username: " + user.getUsername());
			outStream.writeObject(user);
			
			while(loginUser == null) {
					Object in = inStream.readObject();
					
					if(in !=null) {
						if(in.getClass() == int.class) {
							System.out.println("Connector: User Failed to login");
							//Display Error
						} else {
							System.out.println("Connector: User Logged in.");
							loginUser = (User)in;
						}
					}
					
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return loginUser;
	}
	/*******
	 * Gets and Sets
	 *
	 **********/

	public static ConnectorClient getCommand() {
		if(cmd == null) {
			cmd = new ConnectorClient();
		}
		return cmd;
	}

	public String getServerIP() {
		return serverIP;
	}

	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}

	public int getServerPort() {
		return serverPort;
	}

	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	
	
	
	
		

}

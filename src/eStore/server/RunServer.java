package eStore.server;

import java.io.*;
import java.net.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import eStore.*;

public class RunServer {
	
	private static int portNumber = 57;
	private static ConnectorServer cnt;
	private static eStore estore;
	

	public static void main(String[] args) {


	try {
		System.out.println("Server Running.");
		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Port");
		String Port = userInput.readLine();
		int portNum = Integer.parseInt(Port);
		cnt = ConnectorServer.getConnector(portNum);
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		
		estore = eStore.geteStore();
		System.out.println("Ready for Input");
		while(true) {
			Object input = null;
			input = cnt.getDataFromNetwork();
			
			try {
				input = cnt.getInStream().readObject();
			} catch (Exception e) {
			}
			if(input !=null) {
				//Login.
				System.out.println("Recieved Input.");
				if(input.getClass() == User.class) {
					System.out.println("User Login in");
					User user = (User)input;
					user= estore.Login(user.getUsername(), user.getPassword());
					if(user == null) {
						int error = 0;
						try {
							cnt.getOutStream().writeObject(error);
						} catch (IOException e) {
							System.out.println("Error Sending Data Login Invalid");
							e.printStackTrace();
						}
					} else {
						try {
							cnt.getOutStream().writeObject(user);
							System.out.println("User Logged in Returning user.");
						} catch (IOException e) {
							System.out.println("Error Sending Data Login Valid.");
							e.printStackTrace();
						}
					}
				} //Login End.
				
				//Next 		
			}
		}
	} // Close Main
} // Close Class

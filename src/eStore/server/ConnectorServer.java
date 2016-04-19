package eStore.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectorServer {
	private static ConnectorServer cmd;
	private int serverPort = 4444;
	private ObjectOutputStream outStream;
	private ObjectInputStream inStream;
	private ServerSocket server;
	private Socket sock;
	
	private ConnectorServer() {	
		try {
			System.out.println("Starting");
			ServerSocket server = new ServerSocket(50);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Object getDataFromNetwork() {
		try {
			sock = server.accept();
			inStream = new ObjectInputStream(sock.getInputStream());
			Object obj = inStream.readObject();
			return obj;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return null;
		
	}
	
	public void writeToNetowrk(Object obj) {
		try {
		outStream = new ObjectOutputStream(sock.getOutputStream());
		outStream.writeObject(obj);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ConnectorServer getConnector(int Port) {
		if(cmd == null) {
			cmd = new ConnectorServer();
		}
		return cmd;
	}





	public int getServerPort() {
		return serverPort;
	}


	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}


	public ObjectOutputStream getOutStream() {
		return outStream;
	}


	public void setOutStream(ObjectOutputStream outStream) {
		this.outStream = outStream;
	}


	public ObjectInputStream getInStream() {
		return inStream;
	}


	public void setInStream(ObjectInputStream inStream) {
		this.inStream = inStream;
	}

	
}

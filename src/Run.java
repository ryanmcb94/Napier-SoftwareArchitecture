import java.io.BufferedReader;
import java.io.InputStreamReader;

import eStore.*;
import eStore.client.winLogin;
import eStore.server.RunServer;
public class Run {

	public static void main(String[] args) {
		try {
		BufferedReader input = new BufferedReader( new InputStreamReader(System.in));
		System.out.println("Enter IP of Server");
		String ip = input.readLine();
		String port = input.readLine();
		
		RunServer server = new RunServer();
		winLogin Client = new winLogin();
		} catch(Exception e) {
			
		}

	}

}

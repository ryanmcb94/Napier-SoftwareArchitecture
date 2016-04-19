package eStore.client;
import eStore.*;

public class Control {
	private static Control control;
	private ConnectorClient connect;
	private User user;
	
	/***********
	 * Methods
	 ***********/
	public void Login(User user)  {
		System.out.println("Control: Logining In.");
		User login = ConnectorClient.getCommand().Login(user);
		if(login !=null) {
			this.user = login;
			System.out.println("Control: User Logged in.");
		}
		
	}
	
	
	/*********
	 * gets and sets
	 */
	public static Control getControl() {
		if(control == null) {
			control = new Control();
		}
		return control;
	}
	public ConnectorClient getConnect() {
		return connect;
	}
	public void setConnect(ConnectorClient connect) {
		this.connect = connect;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}

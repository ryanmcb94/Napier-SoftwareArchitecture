package eStore;

public class Manager extends User {
	private String eMail;
	
	/**************
	 * Constructors
	 ***************/

	/****************
	 * 
	 * @param ID
	 * @param fName
	 * @param lName
	 * @param Password
	 * @param emil
	 */
	public Manager(String title, String fName, String lName,String username, String Password,String Position, String email) {
		super(title, fName, lName,username, Password,Position);
		seteMail(email);
	}


	/*****************
	 * Gets and Sets
	 ****************/
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	
	
}

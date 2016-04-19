package eStore;

public class User {
	private String title;
	private String fName;
	private String lName;
	private String username;
	private String password;
	private String position;
	
	public User(String title,String fName, String lName,String username, String Password,String position) {
		setTitle(title);
		setfName(fName);
		setlName(lName);
		setUsername(username);
		setPassword(Password);
		setPosition(position);
	}
	
	public User(String username, String password) {
		setUsername(username);
		setPassword(password);
		
	}

	/***********
	 * Methods
	 ***********/
		@Override
	public String toString() {
		return "User [title=" + title + ", fName=" + fName
				+ ", lName=" + lName + ", username=" + username + ", password="
				+ password + ", position=" + position + "]";
	}
	
	
	
	/****************
	 * Gets and Sets
	 ****************/

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	


}

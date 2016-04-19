package eStore.server;

import eStore.User;

public class eStore {
	private static eStore eStore;
	private Database Database;
	private String shopName = "The eShop";
	private String shopAddress = "15 eShop Lane, Edinburgh";

	
	/*****************
	 * Constructors
	 ****************/
	public eStore() {
	}
	
	public Database getDatabase() {
		return Database.getDatabase();
	}
	
	
	/*************
	 * Methods
	 ************/
	public User Login(String username, String password) {
		User user = null;
		user = this.getDatabase().Login(username, password);
		return user;
	}
	
	
	/****************
	 * Gets and Sets
	 *****************/
	public static eStore geteStore() {
		if(eStore == null) {
			eStore = new eStore();
		}
		return eStore;
	}
	public void seteStore(eStore eStore) {
		this.eStore = eStore;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopAddress() {
		return shopAddress;
	}
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public void setDatabase(Database database) {
		Database = database;
	}
	
	
	
	

}

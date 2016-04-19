package eStore.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import eStore.User;

public class Database {
	//Connection connection;
	static Database DB;
	String DBName = "eShop";
	final String DBUsername = "system";
	final String DBPassword = "Pa$$w0rd";
	final String DatabaseURL = "jdbc:oracle:thin:@52.28.47.59:1521/xe";
	eStore estore = eStore.geteStore();
	Connection con;
	
	private Database() {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

			this.con = DriverManager.getConnection(DatabaseURL,DBUsername,DBPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Database getDatabase() {
		if(DB == null) {
			DB = new Database();
		}
		return DB;
	}
	
	
	public User Login(String username, String pasword) {
		User user  =null;
		try {
			String sql = "SELECT s.StaffName.Title,s.StaffName.fName,s.StaffName.lName,s.StaffName.position,s.username, s.password FROM Staff s";
		
			System.out.println(sql);
			Statement query = con.createStatement();
			ResultSet result;
			result = query.executeQuery(sql);
			while(result.next()) {
				user = new User(result.getString("StaffName.Title"),result.getString("StaffName.fName"), result.getString("StaffName.lName"), result.getString("username"), result.getString("password"), result.getString("StaffName.position"));
				System.out.println(user.toString());
			}
			if(user == null) {
				System.out.println("Failed Login: " + username +" was not found");
			}
			else {
				if(user.getPassword() == pasword) {
					return user;
				}
				else {
					user = null;
				}
			}		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			System.out.println("User: " + username + " Failed to Login: Invalid Password");
			return null;

	}			
}


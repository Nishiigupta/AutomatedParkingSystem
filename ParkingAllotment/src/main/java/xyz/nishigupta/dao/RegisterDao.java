package xyz.nishigupta.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import xyz.nishigupta.entities.RegistrationDetails;

public class RegisterDao {
	
	private final String url;
	private final String uName;
	private final String pWord;
	private final String driverName;
	private boolean isEverythingOk = true;
	private Connection con;
	
	public RegisterDao() {
		this.url = "jdbc:mysql://localhost:3306/parking";
		this.uName = "root";
		this.pWord = "Bittu.22";
		this.driverName = "com.mysql.cj.jdbc.Driver"; 
		
		
		try {
			
			Class.forName(this.driverName);
			con = DriverManager.getConnection(url, uName, pWord);
			
		} catch(Exception e) {
			this.isEverythingOk = false;
		}
		
	}


	public boolean is_valid(final RegistrationDetails registerDetails, final String buyerOrSeller) {
		if(isEverythingOk == false) {
			return false;
		}
		
		final String sql = "SELECT * FROM " + buyerOrSeller + " WHERE username=? and password=?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, registerDetails.getUsername());
			st.setString(2, registerDetails.getPassword());
			
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return false;
			}
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

		
		return true;
	}
	
	public boolean save(final RegistrationDetails obj, final String buyerOrSeller) {
		if(isEverythingOk == false) {
			System.out.println("not into db");
			return false;
		}
		
		final String sql = "INSERT INTO " + buyerOrSeller + " (username, password, email, phone_number) VALUES(?, ?, ?, ?)";
		
		try {

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, obj.getUsername());
			st.setString(2, obj.getPassword());
			st.setString(3, obj.getEmail());
			st.setString(4, obj.getPhone_number());
			
			st.execute();
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}
	
	
}
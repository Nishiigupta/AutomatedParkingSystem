package xyz.nishigupta.entities;

public class RegistrationDetails {
	
	private String username;
	private String password;
	private String email;
	private String phone_number;
	
	public RegistrationDetails(String username, String password, String email, String phone_number) {
		setUsername(username);
		setPassword(password);
		setEmail(email);
		setPhone_number(phone_number);
	}
	
	public boolean is_valid() {
		
		if(getUsername().isBlank() || getPassword().isBlank() || getEmail().isBlank()) {
			return false;
		}
		
		return true;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
}
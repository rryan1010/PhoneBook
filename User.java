
public class User {
	private String userN;
	private String passW;
	private PhoneBookDirectory e = new PhoneBookDirectory();
	
	public User() {};
	
	public User(String user, String pw, PhoneBookDirectory entries){
		this.userN = user;
		this.passW = pw;
		this.e = entries;
	}
	

	public String getUsername(){
		return userN;
	}
	
	public void setUsername(String username){
		this.userN = username;
	} 
	

	public String getPassword(){
		return passW;
	}
	
	public void setPassword(String password){
		this.passW = password;
	} 
	

	public PhoneBookDirectory getEntries(){
		return e;
	}
	
	public void setEntries(PhoneBookDirectory entries){
		this.e = entries;
	} 
	

	public void PrintUserInfo(){
		System.out.println("Username: " + userN );
		System.out.println( "Password: " + passW);
	}

}

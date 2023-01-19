
public class PhoneBookEntry {

    //Default ID is -1, must be edited otherside after creation
	private int IDentry = -1; 
	private String firstN;
	private String lastN;
	private String email;
	private int zipcode;
	private String phoneN;
	

    //Default constructor
	public PhoneBookEntry(){} 

	public PhoneBookEntry(int ID, String fn, String ln, String eml, int zip, String pn){

		this.IDentry = ID;
		this.firstN = fn;
		this.lastN = ln;
		this.email = eml;
		this.zipcode = zip;
		this.phoneN = pn;
	}
	public PhoneBookEntry(String fn, String phone){ //constructor with only first name and phone parameters 

		this.firstN = fn;
		this.phoneN = phone;
	}

	// Getters and Setters with noted variables

	// IDentry
	public int getIDentry(){
		return IDentry;
	}
	public void setIDentry(int Ident){
		this.IDentry = Ident;
	}

	// First Name
	public String getfirstN(){
		return firstN;
	}
	public void setfirstN(String fname){
		this.firstN = fname;
	}
	
	// Last Name
	public String getlastN(){
		return lastN;
	}
	public void setlastN(String lname){
		this.lastN = lname;
	}

	// Email
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}

	// Zipcode
	public int getZipcode(){
		return zipcode;
	}
	public void setZipcode(int zipcode){
		this.zipcode = zipcode;
	}
	
	// Zipcode
	public String getphoneN(){
		return phoneN;
	}
	public void setphoneN(String phonenum){
		this.phoneN = phonenum;
	}



	// Prints Entry Inof
	public String PrintBookEntry(){
		return IDentry + ": " + firstN + " " + lastN + ", " + email + ", " + zipcode + ", " + phoneN;
	}

}

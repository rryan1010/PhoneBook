 
import java.util.Scanner;

public class PhoneBookAdmin extends User implements AInterface{

	private String email;
	
	public PhoneBookAdmin(){};
	
	public PhoneBookAdmin(String user, String pw, String email, PhoneBookDirectory a) {
		super(user, pw, a);
		setEmail(email);
	}


	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	

	public void PrintUserInfo(){
		super.PrintUserInfo();
		System.out.println("Email: " + email);
	} 

	
	public void addPhoneEntry(PhoneBookEntry e){
		getEntries().addEntry(e);
	}

	public void editEntry(){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter first name: ");
		String firstN = input.next();
		System.out.print("Enter last name: ");
		String lastN = input.next();

		getEntries().Edit(firstN, lastN);
	}
	
	public void deleteEntry(){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter first name: ");
		String firstN = input.next();
		System.out.print("Enter last name: ");
		String lastN = input.next();

		getEntries().match(firstN, lastN);
		if(getEntries().matchTrue(firstN, lastN) == true)
		{
			System.out.println("Enter the account ID number: ");
			getEntries().DeleteEntry(input.nextInt());
			System.out.println("Entry successfully been deleted!");			
		}
	}
	
	public void sortEntries(){
		getEntries().sortByID();
	}

	
	public void linearSearch(){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the account phone number: ");
		String num = input.next();

		if(getEntries().LinearSearchByPhoneNumber(num) == 1)
		{
			System.out.println("There is a match!");
		}
		else
		{
			System.out.println("No matches found. ");
		}
	}
	
	public void binarySearch(){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the account ID number: ");
		int id = input.nextInt();

		PhoneBookEntry e = getEntries().SearchbyIdBinarySearch(id);
		if(e == null)
		{
			System.out.println("No matches found.");
		}
		else
		{
			System.out.println("Match found: ");
			System.out.println(e.getIDentry() + ": " + e.getfirstN() + " " + e.getlastN() + ", " + e.getEmail() + ", " + e.getZipcode() + ", " + e.getphoneN());
		}
	}

	
	public void adminMenu(){
		Scanner input = new Scanner(System.in);
		int choice;
		do
		{
			System.out.println("Admin User Menu");
			System.out.println("1) Add phone entry");
			System.out.println("2) Edit phone entry");
			System.out.println("3) Delete phone entry");
			System.out.println("4) Sort the Directory");
			System.out.println("5) Search with Linear Search");
			System.out.println("6) Search with Binary Search");
			System.out.println("7) Print account info");
			System.out.println("8) Exit");
			choice = input.nextInt();
			
			if(choice == 1)
			{
				if(getEntries().full())
				{
					System.out.println("Unable to add entry, directory is full");
				}
				else
				{
					boolean unique = false;
					int id = 0;
					do {
						System.out.println("Enter ID: ");
						int tempId = input.nextInt();
						if(getEntries().idExist(tempId) == false)
						{
							id = tempId;
							unique = true;
						}
						else
						{
							System.out.println("This ID already exists, please try again. ");
						}
					} 
					while(unique == false);
					
					System.out.print("Enter first name: ");
					String firstN = input.next();
					System.out.print("Enter last name: ");
					String lastN = input.next();
					System.out.print("Enter email: ");
					String email = input.next();
					System.out.print("Enter zipcode: ");
					int zip = input.nextInt();
					System.out.print("Enter phone number: ");
					String phonenum = input.next();
					
					PhoneBookEntry e = new PhoneBookEntry(id, firstN, lastN, email, zip, phonenum);
					addPhoneEntry(e);
					System.out.println("This entry has been added!");
				}
			}
			else if(choice == 2)
			{
				editEntry();
			}
			else if(choice == 3)
			{
				deleteEntry();
			}
			else if(choice == 4)
			{
				sortEntries();
			}
			else if(choice == 5)
			{
				linearSearch();
			}
			else if(choice == 6)
			{
				binarySearch();
			}
			else if(choice == 7)
			{
				PrintUserInfo();
			}
			
		} 
		
		while(choice != 8);
		if(choice == 8)
		{
			System.out.println("Goodbye!");
		}
	}
	
}

import java.util.Scanner;

public class NormalUser extends User implements NUInterface
{
	Scanner input = new Scanner(System.in);
	private int ID;

	public NormalUser() {};

	
	public NormalUser(String userN, String passW, PhoneBookDirectory a, int ID){
		super(userN, passW, a);
		setID(ID);
	}


	public void PrintUserInfo(){
		super.PrintUserInfo();
		System.out.println("ID: " + ID);
	} 

	
	public int getID(){
		return ID;
	}
	
	public void setID(int ID){
		this.ID = ID;
	}

	
	public void addPhoneEntry(PhoneBookEntry e){
		getEntries().addEntry(e);
	}

	
	public void editEntry(){
		System.out.print("Enter first name: ");
		String fn = input.next();
		System.out.print("Enter last name: ");
		String ln = input.next();
		getEntries().Edit(fn, ln);
	}
	
	public void sortEntries(){
		getEntries().sortByID();
	}

	// Uses linear search with the phone number to confirm that a match exists 
	// Does NOT print all matches
	public void linearSearch(){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the phone number of your account: ");
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

	
	public void normalUserMenu(){
		Scanner input = new Scanner(System.in);
		int choice;
		do
		{
			System.out.println("1) Add phone entry");
			System.out.println("2) Edit phone entry");
			System.out.println("3) Sort the Directory");
			System.out.println("4) Search with linear search(Phone number)");
			System.out.println("5) Print user's info");
			System.out.println("6) Exit");
			choice = input.nextInt();

			if(choice == 1)
			{
				if(getEntries().full())
				{
					System.out.println("Unable to add entry, entry list is full");
				}
				else
				{
					boolean unique = false;
					int id = 0;
					do 
					{
						System.out.println("Enter ID: ");
						int tempID = input.nextInt();
						if(getEntries().idExist(tempID) == false)
						{
							id = tempID;
							unique = true;
						}
						else
						{
							System.out.println("This ID already exists, please try again. ");
						}
					} 
					while(unique == false);

					System.out.print("Enter first name: ");
					String fn = input.next();
					System.out.print("Enter last name: ");
					String ln = input.next();
					System.out.print("Enter email: ");
					String email = input.next();
					System.out.print("Enter zipcode: ");
					int zip = input.nextInt();
					System.out.print("Enter phone number: ");
					String phonenum = input.next();
					PhoneBookEntry e = new PhoneBookEntry(id, fn, ln, email, zip, phonenum);
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
				sortEntries();
			}
			else if(choice == 4)
			{
				linearSearch();
			}
			else if(choice == 5)
			{
				PrintUserInfo();
			}
		} 
		while(choice != 6);
		if(choice == 6)
		{
			System.out.println("Goodbye!");
		}
	}
}
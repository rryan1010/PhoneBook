
import java.util.Scanner;
public class PhoneBookDirectory {
	
	private PhoneBookEntry[] entries;
	private int count = 0;
	private int match = 0;
	
	public PhoneBookDirectory()
	{
		entries = new PhoneBookEntry[10];
		count = 0;
	}
	

	// Checks if Directory is full
	public boolean full(){
		return (count == 10);
	}
	
	// Checks if there is an entry with the ID
	public boolean idExist(int id){
		for(int i = 0; i < count; i++)
		{
			if(entries[i].getIDentry() == id)
			{
				return true;
			}
		}
		return false;
	}
	
	// Adds entry to directory, first makes sure that there is space in the directory
	public int addEntry(PhoneBookEntry entry){
		if(count == 10)
		{
			return 0;
		}
		else 
		{
			entries[count] = entry;
			count++;
			System.out.println(entries[count].PrintBookEntry());
			return 1;
		}
	}

	// Prints all entries
	public void printEntries(){
		System.out.println("Phonebook Entries: ");
		for(int i = 0; i < count; i++)
		{
			System.out.println(i + ") " + entries[i].PrintBookEntry());
		}
	}
	
	// Checks if there are any entries with the same first & last name, and prints the matches
	public void match(String fn, String ln){
		match = 0;
		for(int i = 0; i < count; i++)
		{
			if(entries[i].getfirstN().equalsIgnoreCase(fn) && entries[i].getlastN().equalsIgnoreCase(ln))
			{
				System.out.println(i + ") " + entries[i].PrintBookEntry());
				match++;
			}
		}
		if(match == 0)
		{
			System.out.println("No matches found");
		}
	}
	
	// Determines whether matches exist in the directory
	public boolean matchTrue(String fn, String ln){
		for(int i = 0; i < count; i++)
		{
			if(entries[i].getfirstN().equalsIgnoreCase(fn) && entries[i].getlastN().equalsIgnoreCase(ln))
			{
				System.out.println(entries[i].PrintBookEntry());
				return true;
			}
		}
		return false;
	}
		
	// Searches by Phone Number through linear search
	public int LinearSearchByPhoneNumber(String PhoneNumber){
		int result = 0;
		for(int i = 0; i < count; i++)
		{
			if(entries[i].getphoneN().equals(PhoneNumber))
			{
				System.out.println(entries[i].PrintBookEntry());
				result = 1;
			}
		}
		return result;
	}
	
	// Searches by ID through binary search
	public PhoneBookEntry SearchbyIdBinarySearch(int id){
		int start = 0;
		int end = count - 1;
		int middle;
		while(start <= end)
		{
			middle = (start + end) / 2;
			if(entries[middle].getIDentry() < id)
			{
				start = middle + 1;
			}
			else if(entries[middle].getIDentry() > id)
			{
				end = middle - 1;
			}
			else if(entries[middle].getIDentry() == id)
			{
				return entries[middle];
			}
		}
		return null; 
	}
	
	// Sorts Directory by ID 
	public void sortByID(){
		if(count > 1)
		{
			for(int i = 0; i < count - 1; i++)
			{
				int minimumN = i;
				for(int j = i + 1; j < count; j++)
				{
					if(entries[j].getIDentry() < entries[minimumN].getIDentry())
					{
						minimumN = j;
					}
				}
				if(minimumN != i)
				{
					PhoneBookEntry temp = entries[minimumN];
					entries[minimumN] = entries[i];
					entries[i] = temp;
				}
			}
			printEntries();
		}
		else
		{
			System.out.println("Directory already sorted.");
		}
	}

	//Edit menu
	public int Edit(String fn, String ln){
		Scanner input = new Scanner(System.in);
		for(int i = 0; i < count; i++)
		{
			if(entries[i].getfirstN().equalsIgnoreCase(fn) && entries[i].getlastN().equalsIgnoreCase(ln))
			{
				int choice;
				do
				{
					System.out.println(entries[i].PrintBookEntry());
					System.out.println("Edit Menu");
					System.out.println("1) Edit ID");
					System.out.println("2) Edit first name");
					System.out.println("3) Edit last name");
					System.out.println("4) Edit email");
					System.out.println("5) Edit zipcode");
					System.out.println("6) Edit phone number");
					System.out.println("7) Exit");
					choice = input.nextInt();
					
					if(choice == 1)
					{
						boolean unique = false;
						int id = 0;
						do 
						{
							System.out.print("Enter the new ID: ");
							int tempId = input.nextInt();
							if(idExist(tempId) == false)
							{
								id = tempId;
								unique = true;
							}
							else
							{ 
								System.out.println("ID already exists, please try again. ");
							}
						} 
						while(unique == false);

						entries[i].setIDentry(id);
						System.out.println("Success!");
						return 1;
					}
					else if(choice == 2)
					{
						System.out.print("Enter the new first name: ");
						entries[i].setfirstN(input.next());
						System.out.print("Great! The first name is now: " + input.next());
						return 1;
					}
					else if(choice == 3)
					{
						System.out.print("Enter the new last name: ");
						entries[i].setlastN(input.next());
						System.out.println("Great! The last name is now: " + input.next());
						return 1;
					}
					else if(choice == 4)
					{
						System.out.print("Enter the new email: ");
						entries[i].setEmail(input.next());
						System.out.println("Great! The email is now: " + input.next());
						return 1;
					}
					else if(choice == 5)
					{
						System.out.print("Enter the new zipcode: ");
						entries[i].setZipcode(input.nextInt());
						System.out.println("Great! The zipcode is now: " + input.next());
						return 1;
					}
					else if(choice == 6)
					{
						System.out.print("Enter the new phone number: ");
						entries[i].setphoneN(input.next());
						System.out.println("Great! The phone number is now: " + input.next());
						return 1;
					}
					else if(choice < 1 || choice > 6 && choice != 7)
					{
						System.out.println("Please choose again from the options below.");
					}
				}
				while(choice != 7);
			}
			if(i == count - 1)
			{
				System.out.println("No match found!");
				break;
			}
		}
		return 0;
	}

	// Deletes an entry
	public int DeleteEntry(int id){
		Scanner input = new Scanner(System.in);
		int IDResult = 0;
		
		if(count == 0)
		{
			System.out.println("Directory is empty!");
		}
		else
		{
			for(int i = 0; i < count; i++)
			{
				if(entries[i].getIDentry() == id)
				{
					entries[i] = null;
					IDResult = 1;
				}
			}
		}
		if(IDResult == 1) 
		{
			count--;
		}
		return IDResult;
	}
}
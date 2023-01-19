
// Libraries for Scanner and reading txt files 

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PhoneBookApplication {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		boolean correct =false;
		
		PhoneBookAdmin[] a = new PhoneBookAdmin[10]; 		// a is Admin Users
		NormalUser[] n = new NormalUser[10];				// n is Normal Users
		PhoneBookDirectory e = new PhoneBookDirectory();	// e is Directory
		
		
		do
		{
			System.out.print("Enter your username: ");
			String username = input.next();
			System.out.print("Enter your password: ");
			String password = input.next();
			System.out.print("Are you an Administrator? Enter true or false: ");
			boolean isAdmin = input.nextBoolean();

			// Normal User Login
			if(isAdmin == false) 
			{
				String [] id = new String[100];
				String [] user = new String[100];
				String [] pass = new String[100];
				int arrayIdx = 0;
				
				String NormalUserDatabase = "NormalUserDatabase.txt"; // Enter name of file that contains Normal User info
				// User Info Format
				
				String lineSplitOne = null;
				
					try 
					{
						
						FileReader fileReader = new FileReader(NormalUserDatabase);
						BufferedReader bufferedReader = new BufferedReader(fileReader);
						
						while((lineSplitOne = bufferedReader.readLine()) != null)
						{
							String[] splits = lineSplitOne.split(","); //separates text file by the commas and adds to array splits
							id[arrayIdx] = splits[0]; //fills array id with the id in each line of the text file
							user[arrayIdx] = splits[1];
							pass[arrayIdx] = splits[2];
							arrayIdx++;
						}
						bufferedReader.close();
					}
					catch(FileNotFoundException exFNF)
					{
						System.out.println("File not found");
					}
					catch(IOException exIO)
					{
						System.out.println("IO Exception");
						exIO.printStackTrace();	
					}
				
				// Sets NormalUser objects to NormalUser array
				for(int i = 0; i < arrayIdx; i++)
				{
					int num = Integer.parseInt(id[i]);
					n[i] = new NormalUser(user[i], pass[i], e, num);
				}
				
				// 
				for(int i = 0; i < arrayIdx; i++)
				{
					
					boolean normalUsername = n[i].getUsername().equals(username);
					boolean normalPassword = n[i].getPassword().equals(password);

					// Checks for correct username and password
					if(normalUsername == true && normalPassword == true) 
					{
						// Calls Normal User menu 
						correct = true;
						System.out.println("Welcome!");
						n[i].normalUserMenu(); 
					}
					
					if(i == arrayIdx - 1 && correct == false)
					{
						System.out.println("Incorrect username or password! Try again.");
					}
				}
			}

			// Admin User Login
			else if(isAdmin == true)
			{
				String [] email = new String[100];
				String [] user = new String[100];
				String [] pass = new String[100];
				int arrayIdx = 0;
			
				String AdminUserDatabase = "AdminUserDatabase.txt";
				
				String lineSplitTwo = null;
					
					try {
						
						FileReader fileReader = new FileReader(AdminUserDatabase);
						BufferedReader bufferedReader = new BufferedReader(fileReader);
						
						while((lineSplitTwo = bufferedReader.readLine())!=null)
						{
							
							String[] splits = lineSplitTwo.split(",");
							user[arrayIdx] = splits[0];
							pass[arrayIdx] = splits[1];
							email[arrayIdx] = splits[2];
							arrayIdx++;
							
						}
						
						bufferedReader.close();
					}
					catch(FileNotFoundException exFNF){
						
						System.out.println("File not found");
					}
					catch(IOException exIO)
					{
						
						System.out.println("IO Exception");
						exIO.printStackTrace();	
					}
				
					// Sets AdminUser objects to AdminUser array
					for(int i = 0; i < arrayIdx; i++)
					{
						a[i] = new PhoneBookAdmin(user[i], pass[i], email[i], e);
					}
					
					for(int i = 0; i < arrayIdx; i++)
					{
						
						boolean adminUsername = a[i].getUsername().equals(username);
						boolean adminPassword = a[i].getPassword().equals(password);

						// Checks for correct username and password
						if(adminUsername == true && adminPassword == true)
						{
							// Calls Admin User menu 
							correct = true;
							System.out.println("Welcome!");
							a[i].adminMenu();
						}
						
						if(i == arrayIdx - 1 && correct == false)
						{
							System.out.println("Incorrect username or password. Please try again.");
						}
					}
			}
		}
		while (correct == false);
		input.close();
	}
}

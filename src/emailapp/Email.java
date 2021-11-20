package emailapp;
import java.util.*;
import java.io.*;
public class Email {
	
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailBoxCapacity = 500;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "company.com";
	
	// constructor to receive the firstname & lastname
	
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
//		System.out.println("EMAIL CREATED " + this.firstName + " " + this.lastName);
		
		// call a method asking for the department - return the department
		
		this.department = setDepartment();
//		System.out.println("Department: " + this.department);
		
		// call a method that returns a random password
		
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your Password is: " + this.password); 
		
		// combine elements to generate email
		
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
//		System.out.println("Your email is: " + email);
	}
	
	// ask for the department
	
	private String setDepartment() {
		System.out.println("New worker: " + firstName + ". Department Codes\n 1 for Sales\n 2 for Development\n 3 for Accounting\n 0 for none\n Enter department code: ");
		
		Scanner sc = new Scanner(System.in);
		int depChoice = sc.nextInt();
		if(depChoice == 1) {
			return "sales";
		}
		else if(depChoice == 2) {
			return "dev";
		}
		else if(depChoice == 3) {
			return "acc";
		}
		else {
			return "";
		}
	}
	
	// generate a random password
	
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		
		for(int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		
		return new String(password);
	}
	
	// set the mailbox capacity
	
	public void setMailBoxCapacity(int capacity) {
		this.mailBoxCapacity = capacity;
	}
	
	// set the alternate email
	
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	// change the password
	
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailBoxCapacity() {
		return mailBoxCapacity;
	}
	
	public String getAlternateEmail() {
		return alternateEmail;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName + "\nCOMPANY EMAIL: " + email + "\nMAILBOX CAPACITY: " + mailBoxCapacity + "mb";
	}

}

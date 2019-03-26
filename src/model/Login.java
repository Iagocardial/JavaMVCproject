package model;
import java.util.Scanner;

public class Login extends Users{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

	    String username;
	    String password;

	    System.out.println("Log in:");
	    System.out.println("username: ");
	    username = input.next();

	    System.out.println("password: ");
	    password = input.next();
	    
	    if(username.equals("iago")) {
	    		System.out.println("ja era");
	    } else {
	    	System.out.println("nada");
	    }

		}
		} 

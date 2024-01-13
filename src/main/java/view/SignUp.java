package view;

import java.util.Scanner;

import dao.UserDao;
import entity_classes.User;

public class SignUp {
	static Scanner scan = new Scanner(System.in);
	public static void userSignUp() {
		System.out.println("Enter user name");
		String name = scan.next();
		System.out.println("Enter user email");
		String email = scan.next();
		System.out.println("Enter user password");
		String password = scan.next();
		System.out.println("Enter the role");
		String role = scan.next();
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setRole(role);
		
		new UserDao().saveUser(user);
		System.out.println("Sign up successful");
		System.out.println("************************************");
		System.out.println("Would you like to login. Yes/No");
		String choice = scan.next();
		if(choice.equalsIgnoreCase("yes")) {
			System.out.println("Redirecting back to login page");
			new Service().login();
		}
		
	}
}

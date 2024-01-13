package view;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import dao.UserDao;
import entity_classes.User;

public class Service {
	static String user_email=null;
	static Scanner scan = new Scanner(System.in);
	UserDao user_dao = new UserDao();
	public void login() {
		System.out.println("Enter user email");
		user_email = scan.next();
		System.out.println("Enter user password");
		String user_password = scan.next();
		
		UserDao user_dao = new UserDao();
		Query query = user_dao.em.createQuery("select s from User s where s.email = ?1");
		query.setParameter(1, user_email);
		List<User> rs =  query.getResultList();
		
		try {
			User u = rs.get(0);
			if(u.getPassword().equals(user_password) && u.getRole().equalsIgnoreCase("ADMIN")) {
				System.out.println("Login successful");
				System.out.println("Welcome admin: "+u.getName() );
				System.out.println("............................");
				boolean flag = true;
				while(flag) {
					System.out.println("Choose 1 to create branch\nChoose 2 to create manager\nChoose 3 to add food products\nChoose 4 to exit");
					int choice = scan.nextInt();
					switch(choice) {
						case 1: 
							CreateBranch.createBranch();
							break;
						case 2:
							SignUp.userSignUp();
							break;
						case 3:
							AddFoodProduct.addFoodProduct();
							break;
						case 4:
							System.exit(0);
					}
				}
				
			}
			else if((u.getPassword().equals(user_password) && u.getRole().equalsIgnoreCase("Manager"))){
				System.out.println("Login successful");
				System.out.println("Welcome Manager: "+u.getName() );
				System.out.println("............................");
				boolean flag = true;
				while(flag) {
					System.out.println("Choose 1 to create staff\nChoose 2 to create menu\nChoose 3 to exit");
					int choice = scan.nextInt();
					switch(choice) {
						case 1: 
							SignUp.userSignUp();
							break;
						case 2:
							CreateMenu.createMenu();
							break;
						case 3:
							System.exit(0);
					}
				}
				
			}
			else if((u.getPassword().equals(user_password) && u.getRole().equalsIgnoreCase("Staff"))){
				System.out.println("Here's the menu");
				
			}
			else {
				System.out.println("Wrong password!\nPlease login again !!");
				login();
			}
		}
		catch(Exception e){
			e.printStackTrace();
			new SignUp().userSignUp();
		}
		
	}
}

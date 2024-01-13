package view;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import dao.UserDao;
import entity_classes.FoodProduct;
import entity_classes.Menu;
import entity_classes.User;

public class DisplayMenu {
	static Scanner scan = new Scanner(System.in);
	public static void displayMenu() {
		UserDao userDao =  new UserDao();
		Query query = userDao.em.createQuery("select s from User s where s.role = 'MANAGER'");
		List<User> list1 = query.getResultList();	
		System.out.println("Choose manager by their id to display the menu");
		for(User user : list1) {
			System.out.println(user.getName()+"                "+user.getId());
		}
		
		System.out.println("Enter manager id");
		int manager_id = scan.nextInt();
		User u = null;
		for(User user : list1) {
			if(user.getId()==manager_id) {
				u = user;
			}
		}
		Menu menu = u.getMenu();
		System.out.println("Here's a list of items in the menu");
		System.out.println("----------------------------------");
		List<FoodProduct> list_fp = menu.getFoodProducts();
	}
}

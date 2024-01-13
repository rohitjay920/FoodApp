package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import dao.FoodProductDao;
import dao.MenuDao;
import dao.UserDao;
import entity_classes.FoodProduct;
import entity_classes.Menu;
import entity_classes.User;

public class CreateMenu {
	static Scanner scan = new Scanner(System.in);
	public static void createMenu() {
		
		Menu menu = new Menu();
		
		MenuDao menuDao =  new MenuDao();
		menuDao.saveMenu(menu);
		
		FoodProductDao fpd = new FoodProductDao();
		Query query = fpd.em.createQuery("select s from FoodProduct s");
		List<FoodProduct> list = query.getResultList();
		System.out.println("Here's the list of food products:");
		System.out.println("-----------------------------------");
		
		for(FoodProduct fp : list) {
			System.out.println(fp.getName()+"           "+fp.getId());
		}
		boolean flag =  true;
		List<FoodProduct> fp_list = new ArrayList();
		while(flag) {
			System.out.println();
			System.out.println("Choose 1 to add the food products into the menu by using their id\nChoose 2 to exit");
			int choice = scan.nextInt();
			switch(choice) {
				case 1:
					System.out.println();
					System.out.println("choose the food product by their id");
					int id = scan.nextInt();
					FoodProduct fp = fpd.findFoodProduct(id);
					fp_list.add(fp);
					break;
				case 2:
					flag=false;
			}
		}
		System.out.println("\n\n\n");
		
		
		
		
		menu.setFoodProducts(fp_list);
		
		UserDao userDao =  new UserDao();
		String u_email = Service.user_email;
		Query query2 = userDao.em.createQuery("select s from User s where s.email=?1");
		query2.setParameter(1, u_email);
		
		List<User> al = query2.getResultList();
		User u = al.get(0);
		u.setMenu(menu);
		
		userDao.updateUser(u);
		
		menu.setUser(u);
		
		for(FoodProduct f : fp_list) {
			f.setMenu(menu);
			fpd.updateFoodProduct(f);
		}
		
		
		
		menuDao.updateMenu(menu);
		
	}
}

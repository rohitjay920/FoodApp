package view;

import java.util.Scanner;

import dao.FoodProductDao;
import entity_classes.FoodProduct;

public class AddFoodProduct {
	static Scanner scan = new Scanner(System.in);
	public static void addFoodProduct() {
		System.out.println("Enter the name of food product");
		String name = scan.next();
		System.out.println("Enter the type of food product");
		String type = scan.next();
		scan.nextLine();
		System.out.println("Enter the description of the food");
		String about = scan.nextLine();
		System.out.println("Enter the availability of food product");
		boolean availability = scan.nextBoolean();
		System.out.println("Enter the price of food product");
		int price = scan.nextInt();
		
		FoodProduct foodProduct = new FoodProduct();
		foodProduct.setName(name);
		foodProduct.setType(type);
		foodProduct.setAbout(about);
		foodProduct.setAvailability(availability);
		foodProduct.setPrice(price);
		
		FoodProductDao fpd = new FoodProductDao();
		fpd.saveFoodProduct(foodProduct);
		
		System.out.println("Food Product added successfully");
		
	}
}

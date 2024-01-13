package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import dao.BranchDao;
import dao.UserDao;
import entity_classes.Branch;
import entity_classes.User;

public class CreateBranch {
	static Scanner scan = new Scanner(System.in);
	public static void createBranch() {
		System.out.println("Enter the name of the branch");
		String name = scan.next();
		System.out.println("Enter the branch address");
		String address = scan.next();
		System.out.println("Enter branch phone number");
		long phoneNumber = scan.nextLong();
		System.out.println("Enter branch email");
		String email =  scan.next();
		Branch b = new Branch();
		b.setName(name);
		b.setAddress(address);
		b.setPhoneNumber(phoneNumber);
		b.setEmail(email);
		//adding branch to the list to build relationship b/w user and branch
		List<Branch> al = new ArrayList();
		al.add(b);
		//saving the branch in database
		BranchDao branch = new BranchDao();
		branch.saveBranch(b);
		System.out.println("Branch has been successfully created");
		
		UserDao user_dao =  new UserDao();
		Query query = user_dao.em.createQuery("select s from User s where s.role = 'MANAGER'");
		List<User> list = query.getResultList();
		System.out.println("Please choose a manager by their ID to assign the branch");
		System.out.println();
		for(User u : list) {
			System.out.println(u.getName()+"        "+u.getId());
		}
		System.out.println("--------------------------------------------");
		System.out.println("Enter the respective manager ID to assign the branch");
		int id =  scan.nextInt();
		User user_manager = user_dao.findUser(id);
		//assigning branch to user
		user_manager.setBranch(al);
		user_dao.updateUser(user_manager);
		
		//assigning user to the branch
		b.setUser(user_manager);
		branch.updateBranch(b);
		
		System.out.println("Manager: "+user_manager.getName()+"     "+"ID: "+user_manager.getId()+" "+"has been assigned to the Branch: "+b.getName());
		
	}
}

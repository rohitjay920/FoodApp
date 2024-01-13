package view;

import java.util.Scanner;

public class Admin {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.err.println("************WELCOME*************");
		boolean flag = true;
		while(flag) {
			System.out.println("Choose 1 to login\nChoose 2 to exit");
			int choice = scan.nextInt();
			switch(choice) {
				case 1:
					Service s1 = new Service();
					s1.login();
					break;
				case 2:
					System.exit(0);
			}
		}
	}
}

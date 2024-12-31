package com.miniproject.pizzashop.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.miniproject.pizzashop.Dao.AdminDao;
import com.miniproject.pizzashop.Dao.CustomerDao;
import com.miniproject.pizzashop.entities.Admin;
import com.miniproject.pizzashop.entities.Customer;

public class MainMenu {

	// Registration
	private static void registerCustomer(Scanner sc) {
		Customer customer = new Customer();
		customer.customerAccept(sc);

		try (CustomerDao customerDao = new CustomerDao()) {
			customerDao.insertCustomer(customer);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Login Customer
	private static Customer loginCustomer(Scanner sc) {
		Customer customer = new Customer();
		try (CustomerDao customerDao = new CustomerDao()) {
			System.out.print("Enter the Email : ");
			String email = sc.next();

			System.out.print("Enter the Passwords : ");
			String password = sc.next();
			customer = customerDao.loginCustomer(email, password);
			if (customer != null) {
				System.out.println("Login successful. Welcome, " + customer.getName() + "!");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return customer;
	}

	// Login Admin
	private static Admin loginAdmin(Scanner sc) {
		Admin admin = new Admin();
		try (AdminDao adminDao = new AdminDao()) {
			System.out.print("Enter the Email : ");
			String email = sc.next();

			System.out.print("Enter the Passwords : ");
			String password = sc.next();

			admin = adminDao.loginAdmin(email, password);
			if (admin != null) {
				System.out.println("Login successful. Welcome, " + admin.getName() + "!");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return admin;
	}

	public static int mainMenu(Scanner sc) {
		System.out.println("0. Exit");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Admin");
		System.out.print("Enter your choice: ");
		return sc.nextInt();
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int choice;

		while ((choice = mainMenu(sc)) != 0) {
			switch (choice) {
			case 1:

				if (loginCustomer(sc) != null) {
					SubMenu.main1();

				} else {
					System.out.println("User Not Found...");
				}

				break;

			case 2:
				registerCustomer(sc);
				break;

			case 3:
				if (loginAdmin(sc) != null) {
					AdminSubMenu.main2();

				} else {
					System.out.println("User Not Found...");
				}

				break;
			}
		}
	}

}

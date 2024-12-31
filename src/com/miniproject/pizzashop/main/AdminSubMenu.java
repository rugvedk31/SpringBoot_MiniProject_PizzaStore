package com.miniproject.pizzashop.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.miniproject.pizzashop.Dao.CustomerDao;
import com.miniproject.pizzashop.Dao.PizzaDao;
import com.miniproject.pizzashop.entities.Admin;
import com.miniproject.pizzashop.entities.Customer;
import com.miniproject.pizzashop.entities.Pizza;

public class AdminSubMenu {

	// Display Pizza
	private static List<Pizza> displayMenu() {
		List<Pizza> pizzaList = new ArrayList<Pizza>();
		try (PizzaDao pizzaDao = new PizzaDao()) {
			pizzaList = pizzaDao.getAllPizza();
			System.out.println(
					"+------+----------------------+------------------------------------------------------------------------+--------+");
			System.out.println(
					"| mid  | name                 | description                                                            | price  |");
			System.out.println(
					"+------+----------------------+------------------------------------------------------------------------+--------+");
			pizzaList.forEach(p -> System.out.println(p));
			System.out.println(
					"+------+----------------------+------------------------------------------------------------------------+--------+");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pizzaList;
	}

	// Add
	public static void addPizza(Scanner sc, Pizza pizza) {
		pizza.accept();

		try (PizzaDao pizzaDao = new PizzaDao()) {
			pizzaDao.addPizza(pizza);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Display Customers
	public static void displayCustomers() {
		List<Customer> customerList = new ArrayList<>();
		try (CustomerDao customerDao = new CustomerDao()) {
			customerList = customerDao.getAllCustomer();
			customerList.forEach(c -> System.out.println(c));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Update Pizza
	public static void updatePizza(Scanner sc, Pizza pizza) {
		try (PizzaDao pizzaDao = new PizzaDao()) {
			System.out.print("Enter The Pizza Id : ");
			int mid = sc.nextInt();
			System.out.print("Enter the New Price of Pizza To set : ");
			String price = sc.next();

			pizzaDao.updatePizza(mid, price);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Delete Pizza
	public static void deletePizza(Scanner sc, Pizza pizza) {
		try (PizzaDao pizzaDao = new PizzaDao()) {
			System.out.print("Enter The Pizza Id : ");
			int mid = sc.nextInt();

			pizzaDao.deletePizza(mid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Bill
	public static void calculateTotalBillAndProfit() {
		double totalBill = 0.0;
		double totalProfit = 0.0;
		double profitMargin = 0.3; // note - 30% profit margin

		try (PizzaDao pizzaDao = new PizzaDao()) {
			List<Pizza> soldPizzas = pizzaDao.getSoldPizzas();

			for (Pizza pizza : soldPizzas) {
				double price = Double.parseDouble(pizza.getPrice());
				totalBill += price;
				totalProfit += price * profitMargin;
			}

			System.out.printf("Total Bill: %.2f\n", totalBill);
			System.out.printf("Total Profit: %.2f\n", totalProfit);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static int adminSubMenu(Scanner sc) {
		System.out.println("0.Logout");
		System.out.println("1.Pizza Menu");
		System.out.println("2.Add New Pizza");
		System.out.println("3.Update Pizza");
		System.out.println("4.Delete Pizza");
		System.out.println("5.Display All Customers");
		System.out.println("6.Calculate Total Profit");
		System.out.println("Enter the choice : ");
		return sc.nextInt();

	}

	public static void main2() {
		Scanner sc = new Scanner(System.in);
		int choice;

		Admin admin = new Admin();

		while ((choice = adminSubMenu(sc)) != 0) {
			switch (choice) {
			case 1:
				displayMenu();
				break;

			case 2:
				Pizza newPizza = new Pizza();
				addPizza(sc, newPizza);
				break;

			case 3:
				Pizza updatedPizza = new Pizza();
				updatePizza(sc, updatedPizza);
				break;

			case 4:
				Pizza deletedPizza = new Pizza();
				deletePizza(sc, deletedPizza);
				break;
			case 5:
				displayCustomers();
				break;

			case 6:
				calculateTotalBillAndProfit();
			}
		}
	}
}

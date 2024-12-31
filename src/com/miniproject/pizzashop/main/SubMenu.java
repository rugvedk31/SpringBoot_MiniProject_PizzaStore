package com.miniproject.pizzashop.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.miniproject.pizzashop.Dao.OrderDao;
import com.miniproject.pizzashop.Dao.PizzaDao;
import com.miniproject.pizzashop.entities.Customer;
import com.miniproject.pizzashop.entities.Order;
import com.miniproject.pizzashop.entities.Pizza;

public class SubMenu {

	// Menu Display
	private static List<Pizza> displayMenu() {
		List<Pizza> pizzaList = new ArrayList<Pizza>();
		try (PizzaDao pizzaDao = new PizzaDao()) {
			pizzaList = pizzaDao.getAllPizza();
			System.out.println(
					"+-----------------------------------------------Menu Card-------------------------------------------------------+");
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

	// Order
	private static void OrderPlaced(Scanner sc, Customer customer) {
		Order order = new Order();
		order.setCid(customer.getCid());
		System.out.println("Enter the Pizza Menu Id: ");
		int id = sc.nextInt();
		order.setMid(id);
		try (OrderDao orderDao = new OrderDao()) {
			orderDao.placeOrder(order);
			System.out.println("Order Success....");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Order History
	private static void orderHistory(Customer customer) {
		List<Pizza> pizzaList = new ArrayList<>();
		try (OrderDao orderDao = new OrderDao()) {
			pizzaList = orderDao.getAllOrder(customer.getCid());
			System.out.println(
					"+------------------------------------------Order History--------------------------------------------------------+");
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
			e.printStackTrace();
		}
	}

	public static int submenu(Scanner sc) {
		System.out.println("0.Logout");
		System.out.println("1.Pizza Menu");
		System.out.println("2.Order Pizza");
		System.out.println("3.Order History");
		System.out.println("Enter the choice : ");
		return sc.nextInt();

	}

	public static void main1() {
		Scanner sc = new Scanner(System.in);

		int choice;
		Customer customer = new Customer();
		customer.setCid(1);

		while ((choice = submenu(sc)) != 0) {
			switch (choice) {
			case 1:
				displayMenu();
				break;

			case 2:
				OrderPlaced(sc, customer);
				break;

			case 3:
				orderHistory(customer);
				break;

			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}

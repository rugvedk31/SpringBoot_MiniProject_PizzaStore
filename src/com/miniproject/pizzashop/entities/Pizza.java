package com.miniproject.pizzashop.entities;

import java.util.Scanner;

public class Pizza {
	// Keep the attribute name as same as present in databases.
	private int mid;
	private String name;
	private String description;
	private String price;

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void accept() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Name : ");
		name = sc.next();
		sc.nextLine();

		System.out.print("Enter the Description : ");
		description = sc.nextLine();
		sc.nextLine();

		System.out.print("Enter the Price : ");
		price = sc.next();
		sc.nextLine();

	}

	@Override
	public String toString() {
		return String.format("| %-4d | %-20s | %-70s | %-6s |", mid, name, description, price);
	}

}

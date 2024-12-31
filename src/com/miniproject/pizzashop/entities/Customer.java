package com.miniproject.pizzashop.entities;

import java.util.Scanner;

public class Customer {
	// Keep the attribute name as same as present in databases.
	private int cid;
	private String name;
	private String email;
	private String password;
	private String mobile;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void customerAccept(Scanner sc) {

		System.out.print("Enter the Name : ");
		name = sc.next();
		System.out.print("Enter the Email : ");
		email = sc.next();
		System.out.print("Enter the Password : ");
		password = sc.next();
		System.out.print("Enter the Number : ");
		mobile = sc.next();
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + ", email=" + email + ", pass=" + password + ", mobile="
				+ mobile + "]";
	}

}

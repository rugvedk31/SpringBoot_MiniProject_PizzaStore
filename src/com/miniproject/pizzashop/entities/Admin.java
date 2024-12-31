package com.miniproject.pizzashop.entities;

public class Admin {

	private String name;
	private String email;
	private String password;
	private String mobile;

	public Admin() {

	}

	public Admin(String name, String email, String password, String mobile) {
		super();

		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
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

	/*
	 * public void Accept() { Scanner sc = new Scanner(System.in);
	 * System.out.print("Enter the Name : "); name = sc.next(); sc.nextLine();
	 * 
	 * System.out.print("Enter the Email : "); email = sc.next(); sc.nextLine();
	 * 
	 * System.out.println("Enter the Passwrd : "); password = sc.next();
	 * sc.nextLine();
	 * 
	 * System.out.println("Enter the Mobile Number : "); mobile = sc.next();
	 * sc.nextLine(); }
	 * 
	 * @Override public String toString() { return "Admin [name=" + name +
	 * ", email=" + email + ", password=" + password + ", mobile=" + mobile + "]"; }
	 */

}

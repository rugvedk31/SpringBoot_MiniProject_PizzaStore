package com.miniproject.pizzashop.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.miniproject.pizzashop.entities.Customer;
import com.miniproject.pizzashop.util.DBUtil;

public class CustomerDao implements AutoCloseable {

	private Connection connection;

	public CustomerDao() throws SQLException {
		connection = DBUtil.getConnection();
	}

	public void close() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

	// Customer Insert
	public void insertCustomer(Customer customer) throws SQLException {
		String sql = "Insert into Customer(name,email,password,mobile) values (?,?,?,?)";

		try (PreparedStatement insertStatement = connection.prepareCall(sql)) {
			insertStatement.setString(1, customer.getName());
			insertStatement.setString(2, customer.getEmail());
			insertStatement.setString(3, customer.getPassword());
			insertStatement.setString(4, customer.getMobile());
			insertStatement.executeUpdate();
		}
	}

	// Login Customer
	public Customer loginCustomer(String email, String password) throws SQLException {

		Scanner sc = new Scanner(System.in);

		String sql = "Select * from customer where email = ? and password = ?";

		try (PreparedStatement loginCustomer = connection.prepareCall(sql)) {
			Customer customer = new Customer();
			loginCustomer.setString(1, email);
			loginCustomer.setString(2, password);

			ResultSet rs = loginCustomer.executeQuery();
			if (rs.next()) {
				customer.setCid(rs.getInt(1));
				customer.setName(rs.getString(2));
				customer.setEmail(email);
				customer.setPassword(password);
				customer.setMobile(rs.getString(5));
				return customer;

			}
			sc.close();
		}
		return null;

	}

	// Display All Customer
	public List<Customer> getAllCustomer() throws SQLException {
		List<Customer> customers = new ArrayList<>();
		String sql = "Select * from customer";

		try (PreparedStatement selectStatment = connection.prepareCall(sql)) {
			ResultSet rs = selectStatment.executeQuery();

			while (rs.next()) {

				Customer customer = new Customer();
				customer.setCid(rs.getInt(1));
				customer.setName(rs.getString(2));
				customer.setEmail(rs.getString(3));
				customer.setPassword(rs.getString(4));
				customer.setMobile(rs.getString(5));
				customers.add(customer);

			}
		}
		return customers;
	}

}

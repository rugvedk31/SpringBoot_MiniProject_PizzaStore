package com.miniproject.pizzashop.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.miniproject.pizzashop.entities.Admin;
import com.miniproject.pizzashop.util.DBUtil;

public class AdminDao implements AutoCloseable {

	private Connection connection;

	public AdminDao() throws SQLException {
		connection = DBUtil.getConnection();
	}

	public void close() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

	// Admin Login
	public Admin loginAdmin(String email, String password) throws SQLException {

		Scanner sc = new Scanner(System.in);

		String sql = "Select * from admin where email = ? and password = ?";

		try (PreparedStatement loginAdmin = connection.prepareCall(sql)) {
			Admin admin = new Admin();
			loginAdmin.setString(1, email);
			loginAdmin.setString(2, password);

			ResultSet rs = loginAdmin.executeQuery();
			if (rs.next()) {
				admin.setName(rs.getString(1));
				admin.setEmail(rs.getString(2));
				admin.setPassword(rs.getString(3));
				admin.setEmail(email);
				admin.setPassword(password);

				return admin;

			}
			sc.close();
		}
		return null;

	}
}

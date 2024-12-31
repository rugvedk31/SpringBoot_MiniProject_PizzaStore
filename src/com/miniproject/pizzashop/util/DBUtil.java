package com.miniproject.pizzashop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String URL = "jdbc:mysql://localhost:3306/pizzastore_db";
	private static final String User = "root";
	private static final String Pass = "root";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, User, Pass);
	}
}

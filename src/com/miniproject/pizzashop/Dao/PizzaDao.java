package com.miniproject.pizzashop.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.miniproject.pizzashop.entities.Pizza;
import com.miniproject.pizzashop.util.DBUtil;

public class PizzaDao implements AutoCloseable {

	private Connection connection;

	public PizzaDao() throws SQLException {
		connection = DBUtil.getConnection();
	}

	public void close() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

	// Display All Pizza
	public List<Pizza> getAllPizza() throws SQLException {
		List<Pizza> menu = new ArrayList<>();
		String sql = "Select * from menu";

		try (PreparedStatement selectStatment = connection.prepareCall(sql)) {
			ResultSet rs = selectStatment.executeQuery();

			while (rs.next()) {

				Pizza pizza = new Pizza();
				pizza.setMid(rs.getInt(1));
				pizza.setName(rs.getString(2));
				pizza.setDescription(rs.getString(3));
				pizza.setPrice(rs.getString(4));
				menu.add(pizza);
				// System.out.println("Pizza Menu");

			}
		}
		return menu;
	}

	// Adding New Pizza
	public void addPizza(Pizza pizza) throws SQLException {
		String sql = "Insert into menu(name ,description, price)values(?,?,?)";

		try (PreparedStatement insertStatement = connection.prepareCall(sql)) {
			insertStatement.setString(1, pizza.getName());
			insertStatement.setString(2, pizza.getDescription());
			insertStatement.setString(3, pizza.getPrice());
			insertStatement.executeUpdate();
			System.out.println("Pizze Added...");
		}
	}

	// Update Pizza
	public void updatePizza(int mid, String price) throws SQLException {
		String sql = "Update menu set price = ? where mid = ?";

		try (PreparedStatement updateStatement = connection.prepareCall(sql)) {

			updateStatement.setString(1, price);
			updateStatement.setInt(2, mid);
			updateStatement.executeUpdate();
			System.out.println("Pizza Updated...");
		}
	}

	// delete Pizza
	public void deletePizza(int mid) throws SQLException {
		String sql = "DELETE FROM menu WHERE mid = ?";

		try (PreparedStatement deleteStatement = connection.prepareCall(sql)) {

			deleteStatement.setInt(1, mid);
			deleteStatement.executeUpdate();
			System.out.println("Pizza Deleted...");

		}
	}

	// Total Bill
	public List<Pizza> getSoldPizzas() throws SQLException {
		String sql = "SELECT m.mid, m.name, m.description, m.price " + "FROM orders o "
				+ "JOIN menu m ON o.oid = m.mid";
		List<Pizza> soldPizzas = new ArrayList<>();

		try (PreparedStatement selectStatment = connection.prepareCall(sql)) {
			ResultSet rs = selectStatment.executeQuery();

			while (rs.next()) {
				Pizza pizza = new Pizza();
				pizza.setMid(rs.getInt("mid"));
				pizza.setName(rs.getString("name"));
				pizza.setDescription(rs.getString("description"));
				pizza.setPrice(rs.getString("price"));
				soldPizzas.add(pizza);
			}
		}
		return soldPizzas;
	}

}

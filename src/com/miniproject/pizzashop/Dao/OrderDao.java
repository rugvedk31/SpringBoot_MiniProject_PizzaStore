package com.miniproject.pizzashop.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.miniproject.pizzashop.entities.Order;
import com.miniproject.pizzashop.entities.Pizza;
import com.miniproject.pizzashop.util.DBUtil;

public class OrderDao implements AutoCloseable {

	private Connection connection;

	public OrderDao() throws SQLException {
		connection = DBUtil.getConnection();
	}

	@Override
	public void close() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

	// Ordering Pizza
	public void placeOrder(Order order) throws SQLException {
		String sql = "INSERT INTO Orders(cid, mid) VALUES (?, ?)";
		try (PreparedStatement insertStatement = connection.prepareStatement(sql)) {
			insertStatement.setInt(1, order.getCid());
			insertStatement.setInt(2, order.getMid());
			insertStatement.executeUpdate();
		}
	}

	// Order History
	public List<Pizza> getAllPizza(int cid) throws SQLException {
		List<Pizza> pizzaList = new ArrayList<>();
		String sql = "SELECT m.* FROM menu m INNER JOIN Orders o ON m.mid = o.mid WHERE o.cid = ?";

		try (PreparedStatement selectStatement = connection.prepareStatement(sql)) {
			selectStatement.setInt(1, cid);
			ResultSet rs = selectStatement.executeQuery();

			while (rs.next()) {
				Pizza pizza = new Pizza();
				pizza.setMid(rs.getInt(1));
				pizza.setName(rs.getString(2));
				pizza.setDescription(rs.getString(3));
				pizza.setPrice(rs.getString(4));
				pizzaList.add(pizza);
			}
		}
		return pizzaList;
	}

	public List<Pizza> getAllOrder(int cid) throws SQLException {
		List<Pizza> pizzaList = new ArrayList<>();
		String sql = "SELECT m.* FROM menu m INNER JOIN Orders o ON m.mid = o.mid WHERE o.cid = ?";

		try (PreparedStatement selectStatement = connection.prepareStatement(sql)) {
			selectStatement.setInt(1, cid);
			ResultSet rs = selectStatement.executeQuery();

			while (rs.next()) {
				Pizza pizza = new Pizza();
				pizza.setMid(rs.getInt(1));
				pizza.setName(rs.getString(2));
				pizza.setDescription(rs.getString(3));
				pizza.setPrice(rs.getString(4));
				pizzaList.add(pizza);
			}
		}

		return pizzaList;
	}
}

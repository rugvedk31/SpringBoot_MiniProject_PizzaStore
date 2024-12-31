# Miniproject PizzaStore🍕(Java/STS)
## 🚀📋 Project Overview

The **Pizza Shop** application is built using **Java SE 1.8** and follows a modular design pattern. It incorporates object-oriented programming (OOP) principles, providing hands-on experience with Java's powerful features like classes, interfaces, and packages. The project integrates a database to manage essential components of a pizza shop, such as customers, orders, pizzas, and admin functionalities.

## 🛠️ Features

### Customer Management:
- **Add, Update, View, and Delete** customer details. 🧑‍🤝‍🧑

### Order Management:
- Handle pizza orders seamlessly with **CRUD operations**. 📦

### Pizza Management:
- Maintain a list of pizzas with their details and availability. 🍕

### Admin Section:
- **Add New Pizza**: Add new pizzas to the menu.
- **Update Pizza Price**: Modify pizza prices.
- **Delete Pizza**: Remove pizzas from the menu.
- **Display All Customers**: View a list of all registered customers.
- **Display All Orders**: View a list of all pizza orders.
- **Calculate Total Profit**: Compute the total profit from all orders.

### Menu Navigation:
- Intuitive **menu-driven interface** for smooth user interaction. 🖥️

### Database Integration:
- Persistent storage of data using a **MySQL** database. 🗄️

## 📂 Project Structure

The project is organized into packages for better readability and maintainability:

### **com.miniproject.pizzashop.Dao**
- `AdminDao.java`: Handles all operations for store.
- `CustomerDao.java`: Handles database operations for customers.
- `OrderDao.java`: Manages CRUD operations for orders.
- `PizzaDao.java`: Deals with pizza-related database interactions.

### **com.miniproject.pizzashop.entities**
- `Admin.java`: Represents the admin entity.
- `Customer.java`: Represents the customer entity.
- `Order.java`: Represents the order entity.
- `Pizza.java`: Represents the pizza entity.

### **com.miniproject.pizzashop.main**
- `AdminSubMenu.java`: Offers sub-menu functionalities for specific operations.
- `MainMenu.java`: Provides the main navigation menu for the application.
- `SubMenu.java`: Offers sub-menu functionalities for specific operations.

### **com.miniproject.pizzashop.util**
- `DBUtil.java`: Handles database connectivity and utility functions.

## ⚙️ Technologies Used

- **Programming Language**: Java
- **Database**: MySQL
- **IDE**: Spring Tool Suite

## 🎯 Objectives

- Strengthen knowledge of **Core Java** and **OOP concepts**.
- Implement **CRUD operations** in a real-world scenario.
- Gain hands-on experience with **database connectivity**.

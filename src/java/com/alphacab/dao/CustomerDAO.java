package com.alphacab.dao;

import com.alphacab.models.Customer;
import com.alphacab.connection.Connect;
import com.alphacab.models.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDAO {

    public Customer getCustomerWithUsername(String username) {
        String query = "SELECT * FROM CUSTOMER WHERE USERNAME=?;";
        PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
        try {
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                Customer customer = new Customer();
                customer.setContactNumber(rs.getString("CONTACT_NO"));
                customer.setName(rs.getString("NAME"));
                customer.setEmail(rs.getString("EMAIL"));
                customer.setUsername(rs.getString("USERNAME"));
                customer.setPassword(rs.getString("PASSWORD"));
                customer.setAccessLevel(1);

                return customer;
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage() + " get customer.");
        }

        return null;
    }

    public List<Customer> getAll() {
        List<Customer> list = new ArrayList<>();
        String query = "SELECT * FROM CUSTOMER";
        PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
        try {
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Customer customer = new Customer();
                customer.setContactNumber(rs.getString("CONTACT_NO"));
                customer.setName(rs.getString("NAME"));
                customer.setEmail(rs.getString("EMAIL"));
                customer.setUsername(rs.getString("USERNAME"));
                System.out.println("username=" + customer.getUsername());
                customer.setPassword(rs.getString("PASSWORD"));
                customer.setAccessLevel(1);

                list.add(customer);
            }

        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage() + " in get all customers.");
        }

        return list;
    }

    public Customer updateCustomer(Customer customer, String oldUsername) {
        User user = new User(customer.getUsername(), customer.getPassword(), 1);
        UserDAO dao = new UserDAO();
        if (dao.updateUser(user, oldUsername) != null) {
            String query = "UPDATE CUSTOMER SET USERNAME=?, PASSWORD=?, NAME=?, CONTACT_NO=?, EMAIL=? WHERE USERNAME=?;";
            PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
            try {
                statement.setString(1, customer.getUsername());
                statement.setString(2, customer.getPassword());
                statement.setString(3, customer.getName());
                statement.setString(4, customer.getContactNumber());
                statement.setString(5, customer.getEmail());
                statement.setString(6, oldUsername);
                statement.executeUpdate();

                return customer;
            } catch (SQLException ex) {
                System.out.println("ERROR: " + ex.getMessage() + " in update customer.");
            }
        }
        return null;
    }

    public Customer insertCustomer(Customer customer) {
        User user = new User(customer.getUsername(), customer.getPassword(), 1);
        UserDAO dao = new UserDAO();
        if (dao.insertUser(user) != null) {
            String query = "INSERT INTO CUSTOMER(USERNAME, PASSWORD, NAME, CONTACT_NO, EMAIL) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
            try {
                statement.setString(1, customer.getUsername());
                statement.setString(2, customer.getPassword());
                statement.setString(3, customer.getName());
                statement.setString(4, customer.getContactNumber());
                statement.setString(5, customer.getEmail());
                statement.executeUpdate();
                return customer;
            } catch (SQLException ex) {
                System.out.println("ERROR: " + ex.getMessage() + " in inserting customer.");
            }

        }

        return null;
    }
}

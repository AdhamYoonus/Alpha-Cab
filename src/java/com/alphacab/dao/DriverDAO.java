package com.alphacab.dao;

import com.alphacab.connection.Connect;
import com.alphacab.models.Driver;
import com.alphacab.models.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverDAO {

    public Driver getDriverWithUsername(String username) {
        String query = "SELECT * FROM DRIVER WHERE username=?";
        PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
        try {
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Driver driver = new Driver();
                driver.setDriverName(rs.getString("DRIVER_NAME"));
                driver.setLicenseNumber(rs.getString("DRIVING_LICENSE"));
                driver.setPassword(rs.getString("PASSWORD"));
                driver.setUsername(username);
                driver.setCarType(rs.getString("CAR_TYPE"));
                driver.setCarModel(rs.getString("CAR_MODEL"));

                return driver;
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }

        return null;
    }

    public List<Driver> getAllDrivers() {
        List<Driver> list = new ArrayList<>();
        String query = "SELECT * FROM DRIVER;";
        PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
        try {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Driver driver = new Driver();
                driver.setDriverName(rs.getString("DRIVER_NAME"));
                driver.setLicenseNumber(rs.getString("DRIVING_LICENSE"));
                driver.setPassword(rs.getString("PASSWORD"));
                driver.setUsername(rs.getString("USERNAME"));
                driver.setCarType(rs.getString("CAR_TYPE"));
                driver.setCarModel(rs.getString("CAR_MODEL"));
                list.add(driver);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }

        return list;
    }

    public Driver insertDriver(Driver driver) {
        User user = new User();
        user.setAccessLevel(driver.getAccessLevel());
        user.setPassword(driver.getPassword());
        user.setUsername(driver.getUsername());
        UserDAO dao = new UserDAO();

        if (dao.insertUser(user) != null) {
            String query = "INSERT INTO DRIVER(DRIVER_NAME, DRIVING_LICENSE, CAR_TYPE, CAR_MODEL, USERNAME, PASSWORD) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
            try {
                statement.setString(1, driver.getDriverName());
                statement.setString(2, driver.getLicenseNumber());
                statement.setString(3, driver.getCarType());
                statement.setString(4, driver.getCarModel());
                statement.setString(5, driver.getUsername());
                statement.setString(6, driver.getPassword());
                statement.executeUpdate();

                return driver;
            } catch (SQLException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }

        }

        return null;
    }

    public Driver updateDriver(Driver driver, String oldUsername) {
        User user = new User();
        user.setAccessLevel(driver.getAccessLevel());
        user.setPassword(driver.getPassword());
        user.setUsername(driver.getUsername());
        UserDAO dao = new UserDAO();
        if (dao.updateUser(user, oldUsername) != null) {
            String query = "UPDATE DRIVER SET USERNAME=?, DRIVING_LICENSE=?, DRIVER_NAME=?, PASSWORD=?, CAR_TYPE=?, CAR_MODEL=? WHERE USERNAME=?";
            PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
            try {
                statement.setString(1, driver.getUsername());
                statement.setString(2, driver.getLicenseNumber());
                statement.setString(3, driver.getDriverName());
                statement.setString(4, driver.getPassword());
                statement.setString(5, driver.getCarType());
                statement.setString(6, driver.getCarModel());
                statement.setString(7, oldUsername);
                statement.executeUpdate();
                return driver;
            } catch (SQLException ex) {
                System.out.println("ERROR: " + ex.getMessage() + " in update driver dao");
            }

        }

        return null;
    }

    public boolean deleteDriver(String username) {
        if (new UserDAO().deleteUser(username)) {
            String query = "DELETE FROM DRIVER WHERE USERNAME=?;";
            PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
            try {
                System.out.println("STATEMENT EXECUTED");
                statement.setString(1, username);
                int executeUpdate = statement.executeUpdate();
                System.out.println("STATEMENT EXECUTED: " + executeUpdate);
                return true;
            } catch (SQLException ex) {
                System.out.println("ERROR: " + ex.getMessage() + " in deleting driver.");
            }
        }

        return false;
    }
}

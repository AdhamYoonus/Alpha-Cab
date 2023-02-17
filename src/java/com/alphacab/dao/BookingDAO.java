package com.alphacab.dao;

import java.sql.PreparedStatement;
import com.alphacab.connection.Connect;
import com.alphacab.models.Booking;
import com.alphacab.models.Time;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookingDAO {

    
    //Find all booking from DB
    public List<Booking> getAllBookings() {
        List<Booking> list = new ArrayList<>();
        String query = "SELECT * FROM BOOKING_REQUESTS;";
        PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
        try {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Booking booking = new Booking();
                booking.setAddress(rs.getString("ADDRESS"));
                booking.setCost(rs.getDouble("COST"));
                booking.setDate(rs.getDate("BOOKING_DATE"));
                booking.setDestinationAddress(rs.getString("DESTINATION_ADDRESS"));
                booking.setDistance(rs.getDouble("DISTANCE"));
                booking.setId(rs.getInt("id"));
                String[] strTime = rs.getString("BOOKING_TIME").split(":");
                Time t = new Time();
                t.setHour(Integer.parseInt(strTime[0]));
                t.setMinutes(Integer.parseInt(strTime[1]));
                System.out.println("Time=" + t);
                booking.setTime(t);
                booking.setStatus(rs.getInt("STATUS"));
                booking.setUsername(rs.getString("USERNAME"));
                booking.setDriverUsername(rs.getString("DRIVER_NAME"));
                list.add(booking);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage() + " in fetching all bookings.");
        }

        return list;
    }

    public List<Booking> getAllBookingsByUser(String username) {
        List<Booking> list = new ArrayList<>();
        String query = "SELECT * FROM BOOKING_REQUESTS WHERE USERNAME=?;";
        PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
        try {
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Booking booking = new Booking();
                booking.setAddress(rs.getString("ADDRESS"));
                booking.setCost(rs.getDouble("COST"));
                booking.setDate(rs.getDate("BOOKING_DATE"));
                booking.setDestinationAddress(rs.getString("DESTINATION_ADDRESS"));
                booking.setDistance(rs.getDouble("DISTANCE"));
                booking.setId(rs.getInt("id"));
                String[] strTime = rs.getString("BOOKING_TIME").split(":");
                Time t = new Time();
                t.setHour(Integer.parseInt(strTime[0]));
                t.setMinutes(Integer.parseInt(strTime[1]));
                booking.setStatus(rs.getInt("STATUS"));
                booking.setTime(t);
                booking.setUsername(rs.getString("USERNAME"));
                booking.setDriverUsername(rs.getString("DRIVER_NAME"));
                list.add(booking);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage() + " in fetching bookings of user");
        }

        return list;
    }

    public List<Booking> getAllBookingsAssignedToDriver(String driverUsername) {
        List<Booking> list = new ArrayList<>();
        String query = "SELECT * FROM BOOKING_REQUESTS WHERE DRIVER_NAME=?;";
        PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
        try {
            statement.setString(1, driverUsername);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Booking booking = new Booking();
                booking.setAddress(rs.getString("ADDRESS"));
                booking.setCost(rs.getDouble("COST"));
                booking.setDate(rs.getDate("BOOKING_DATE"));
                booking.setDestinationAddress(rs.getString("DESTINATION_ADDRESS"));
                booking.setDistance(rs.getDouble("DISTANCE"));
                booking.setId(rs.getInt("id"));
                String[] strTime = rs.getString("BOOKING_TIME").split(":");
                Time t = new Time();
                t.setHour(Integer.parseInt(strTime[0]));
                t.setMinutes(Integer.parseInt(strTime[1]));
                booking.setStatus(rs.getInt("STATUS"));
                booking.setTime(t);
                booking.setUsername(rs.getString("USERNAME"));
                booking.setDriverUsername(rs.getString("DRIVER_NAME"));
                list.add(booking);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage() + " in fetching bookings of user");
        }

        return list;
    }

    
     //Add bookings to DB
    public Booking insertBooking(Booking b) {
        String query = "INSERT INTO BOOKING_REQUESTS(ADDRESS, DESTINATION_ADDRESS, BOOKING_DATE, BOOKING_TIME"
                + ", DISTANCE, COST, USERNAME, STATUS) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
        try {
            statement.setString(1, b.getAddress());
            statement.setString(2, b.getDestinationAddress());
            statement.setDate(3, b.getDate());
            statement.setString(4, b.getTime().toString());
            statement.setDouble(5, b.getDistance());
            statement.setDouble(6, b.getCost());
            statement.setString(7, b.getUsername());
            statement.setInt(8, b.getStatus());
            statement.executeUpdate();
            return b;
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage() + " in inserting booking.");
        }
        return null;
    }

    public boolean assignBookingToDriver(int id, String username) {
        String query = "UPDATE BOOKING_REQUESTS SET DRIVER_NAME=?, STATUS=? WHERE ID =?";
        PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
        try {
            statement.setString(1, username);
            statement.setInt(2, 1);
            statement.setInt(3, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage() + " in assigning booking.");
        }
        return false;
    }

    public boolean markBookingComplete(int id) {
        String query = "UPDATE BOOKING_REQUESTS SET STATUS=? WHERE ID=?;";
        PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
        try {
            statement.setInt(1, 2);
            statement.setInt(2, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage() + " in completing booking.");
        }
        return false;
    }

    public List<Booking> getAllBookingsCompletedOnDate(Date date) {
        List<Booking> list = new ArrayList<>();
        String query = "SELECT * FROM BOOKING_REQUESTS WHERE BOOKING_DATE=? AND STATUS=2;";
        PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
        try {
            statement.setDate(1, date);
            System.out.println("Date=" + date);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Booking booking = new Booking();
                booking.setAddress(rs.getString("ADDRESS"));
                booking.setCost(rs.getDouble("COST"));
                booking.setDate(rs.getDate("BOOKING_DATE"));
                booking.setDestinationAddress(rs.getString("DESTINATION_ADDRESS"));
                booking.setDistance(rs.getDouble("DISTANCE"));
                booking.setId(rs.getInt("id"));
                String[] strTime = rs.getString("BOOKING_TIME").split(":");
                Time t = new Time();
                t.setHour(Integer.parseInt(strTime[0]));
                t.setMinutes(Integer.parseInt(strTime[1]));
                booking.setStatus(rs.getInt("STATUS"));
                booking.setTime(t);
                booking.setUsername(rs.getString("USERNAME"));
                booking.setDriverUsername(rs.getString("DRIVER_NAME"));
                System.out.println("ID=" + booking.getUsername());
                list.add(booking);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage() + " in fetching bookings of user");
        }

        return list;
    }

    public Booking getBookingById(int id) {
        String query = "SELECT * FROM BOOKING_REQUESTS WHERE id=?;";
        PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
        try {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Booking booking = new Booking();
                booking.setAddress(rs.getString("ADDRESS"));
                booking.setCost(rs.getDouble("COST"));
                booking.setDate(rs.getDate("BOOKING_DATE"));
                booking.setDestinationAddress(rs.getString("DESTINATION_ADDRESS"));
                booking.setDistance(rs.getDouble("DISTANCE"));
                booking.setId(rs.getInt("id"));
                String[] strTime = rs.getString("BOOKING_TIME").split(":");
                Time t = new Time();
                t.setHour(Integer.parseInt(strTime[0]));
                t.setMinutes(Integer.parseInt(strTime[1]));
                booking.setStatus(rs.getInt("STATUS"));
                booking.setTime(t);
                booking.setUsername(rs.getString("USERNAME"));
                booking.setDriverUsername(rs.getString("DRIVER_NAME"));
                System.out.println("ID=" + booking.getUsername());
                return booking;
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage() + " in fetching bookings of user");
        }

        return null;
    }

    public boolean updateBookingPrice(int id, double price) {
        String query = "UPDATE BOOKING_REQUESTS SET COST=? WHERE ID=?;";
        PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
        try {
            statement.setDouble(1, price);
            statement.setInt(2, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage() + " in updating the price.");
        }
        return false;
    }
}

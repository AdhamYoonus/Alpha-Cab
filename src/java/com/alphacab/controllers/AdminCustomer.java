package com.alphacab.controllers;

import com.alphacab.dao.BookingDAO;
import com.alphacab.dao.CustomerDAO;
import com.alphacab.models.Customer;
import com.alphacab.models.Booking;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Directs servlet to the URL /admin/customer
@WebServlet(name = "AdminCustomer", urlPatterns = {"/admin/customer"})
public class AdminCustomer {
    
}

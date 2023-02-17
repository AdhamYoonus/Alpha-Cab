package com.alphacab.controllers;

import com.alhpacab.dao.BookingDAO;
import com.alphacab.dao.PriceDAO;
import com.alphacab.models.Booking;
import com.alphacab.models.User;
import com.alphacab.models.Time;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

// Directs servlet to the URL /customer
@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet {
    
}

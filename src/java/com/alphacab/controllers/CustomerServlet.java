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
public class CustomerServlet extends HttpServlet 
{

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String action = request.getParameter("action");
        if(action == null)
            response.sendRedirect("/home");
        
        switch(action)
        {
            case "book":
                forwardRequest("customer/bookingRequest", request, response);
                break;
            case "list":
                forwardToListPage(request, response);
                break;
            case "invoice":
                List<Booking> list = new BookingDAO().getAllBookings();
                request.setAttribute("booking", list.get(list.size() - 1));
                forwardRequest("customer/invoice", request, response);
                break;
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String username = request.getParameter("username");
        String fromAddress = request.getParameter("address");
        String destinationAddress = request.getParameter("destAddress");
        /*
        I have to calculate the distance between source and destination address.
        For now distance is assumed to be 55KMs
        */
        String dateAndTime = request.getParameter("date");
        String[] dateTime = dateAndTime.split("T");
        Date date = Date.valueOf(dateTime[0]);
        String[] t = dateTime[1].split(":");
        int hour = Integer.parseInt(t[0]);
        int minutes = Integer.parseInt(t[1]);
        Time time = new Time(hour, minutes);
        
        double distance = (Double.parseDouble(request.getParameter("distance")) / 1000);
        Booking booking = new Booking();
        booking.setAddress(fromAddress);
        booking.setDestinationAddress(destinationAddress);
        booking.setDate(date);
        booking.setDistance(distance);
        booking.setTime(time);
        booking.setUsername(username);
        double price = new PriceDAO().getPrice();
        booking.setCost(booking.getDistance() * price);
        booking.setStatus(0);
        BookingDAO dao = new BookingDAO();
        dao.insertBooking(booking);
        response.sendRedirect("customer?action=invoice");
    }
    
    // forwards request to specified page by argument 'page'.
    private void forwardRequest(String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("/WEB-INF/jsp/view/" + page + ".jsp").forward(request, response);
    }
   
    // forwards to all bookings by customer page
    private void forwardToListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        User user = (User) request.getSession().getAttribute("user");
        List<Booking> list = new BookingDAO().getAllBookingsByUser(user.getUsername());
        System.out.println("List size=" + list.size());
        request.setAttribute("list", list);
        forwardRequest("customer/myBookings", request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

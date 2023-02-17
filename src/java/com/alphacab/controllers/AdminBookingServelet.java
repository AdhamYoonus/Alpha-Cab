package com.alphacab.controllers;

import com.alphacab.dao.BookingDAO;
import com.alphacab.dao.PriceDAO;
import com.alphacab.models.Booking;
import com.alphacab.models.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminBookingServlet", urlPatterns = {"/admin/booking"})
public class AdminBookingServlet extends HttpServlet 
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
            action = "list";
        
        switch(action)
        {
            case "list":
                forwardToListPage(request, response);
                break;
            case "assign":
                int id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("id", id);
                forwardRequest("/customer/assignBooking", request, response);
                break;
            case "update":
                int updateId = Integer.parseInt(request.getParameter("id"));
                BookingDAO dao = new BookingDAO();
                Booking b = dao.getBookingById(updateId);
                request.setAttribute("booking", b);
                forwardRequest("/customer/updateBookingPrice", request, response);
                break;
            case "price":
                double price = new PriceDAO().getPrice();
                request.setAttribute("price", price);
                forwardRequest("customer/updatePrice", request, response);
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
        int bookingId = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        BookingDAO dao = new BookingDAO();
        boolean assigned = dao.assignBookingToDriver(bookingId, username);
        System.out.println("Assigned=" + assigned);
        response.sendRedirect(request.getContextPath() + "/home");
    }
    
    private void forwardRequest(String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("/WEB-INF/jsp/view/" + page + ".jsp").forward(request, response);
    }
    
    private void forwardToListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        List<Booking> list = new BookingDAO().getAllBookings();
        System.out.println("List size=" + list.size());
        request.setAttribute("list", list);
        forwardRequest("customer/allBookings", request, response);
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

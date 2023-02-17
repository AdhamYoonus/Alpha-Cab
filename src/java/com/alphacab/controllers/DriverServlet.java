package com.alphacab.controllers;

import com.alphacab.dao.BookingDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alphacab.models.Booking;
import com.alphacab.models.User;

@WebServlet(name = "DriverServlet", urlPatterns = {"/driver"})
public class DriverServlet extends HttpServlet 
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
            case "complete":
                int id = Integer.parseInt(request.getParameter("id"));
                new BookingDAO().markBookingComplete(id);
                forwardToListPage(request, response);
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
    }
    
    private void forwardRequest(String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("/WEB-INF/jsp/view/" + page + ".jsp").forward(request, response);
    }
   
    private void forwardToListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        User user = (User) request.getSession().getAttribute("user");
        List<Booking> list = new BookingDAO().getAllBookingsAssignedToDriver(user.getUsername());
        request.setAttribute("list", list);
        forwardRequest("driver/myJobs", request, response);
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

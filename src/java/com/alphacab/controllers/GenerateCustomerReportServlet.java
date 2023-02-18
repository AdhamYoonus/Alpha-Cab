package com.alphacab.controllers;

import com.alphacab.dao.BookingDAO;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alphacab.models.Booking;

@WebServlet(name = "GenerateCustomerReportServlet", urlPatterns = {"/admin/customer-report"})
public class GenerateCustomerReportServlet extends HttpServlet {


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
            action = "report";
        if(action.equals("reportOnDate"))
        {
            BookingDAO dao = new BookingDAO();
            Date date = (Date) request.getSession().getAttribute("date");
            List<Booking> list = dao.getAllBookingsCompletedOnDate(date);
            request.setAttribute("list", list);
            request.getRequestDispatcher("/WEB-INF/jsp/view/customer/customerReport.jsp").forward(request, response);
        }
        if(action.equals("report"))
        {
            Date date = new Date(System.currentTimeMillis());
            
            request.getSession().setAttribute("date", date);
            List<Booking> list = new BookingDAO().getAllBookingsCompletedOnDate(date);
            request.setAttribute("list", list);
            request.getRequestDispatcher("/WEB-INF/jsp/view/customer/customerReport.jsp").forward(request, response);
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
        String dateAndTime = request.getParameter("date");
        String[] dateTime = dateAndTime.split("T");
        Date date = Date.valueOf(dateTime[0]);
        request.getSession().setAttribute("date", date);
        response.sendRedirect(request.getContextPath() + "/admin/customer-report?action=reportOnDate");
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

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

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

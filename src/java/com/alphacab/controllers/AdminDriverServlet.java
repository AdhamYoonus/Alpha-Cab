package com.alphacab.controllers;

import com.alphacab.dao.BookingDAO;
import com.alphacab.dao.DriverDAO;
import com.alphacab.models.Booking;
import com.alphacab.models.Driver;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminServlet", urlPatterns = {"/admin/driver"})
public class AdminDriverServlet extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String action = request.getParameter("action");
        
        switch(action)
        {
            case "register":
                forwardRequest("driver/register", request, response);
                break;
            case "update":
                String username = request.getParameter("username");
                Driver driver = new DriverDAO().getDriverWithUsername(username);
                request.setAttribute("driver", driver);
                forwardRequest("driver/update", request, response);
                break;
            case "list":
                forwardToListPage(request, response);
                break;
            case "delete":
                String driverUsername = request.getParameter("username");
                new DriverDAO().deleteDriver(driverUsername);
                response.sendRedirect(request.getContextPath() + "/admin/driver?action=list");
                break;
            case "jobs":
                List<Booking> list = new BookingDAO().getAllBookingsAssignedToDriver(request.getParameter("username"));
                request.setAttribute("list", list);
                forwardRequest("driver/driverJobs", request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String username = request.getParameter("username");
        String name = request.getParameter("driverName");
        String password = request.getParameter("password");
        String licenseNumber = request.getParameter("licenseNumber");
        String carType = request.getParameter("carType");
        String carModel = request.getParameter("carModel");
        
        int accessLevel = 2;
        
        Driver driver = new Driver(name, licenseNumber, carType, carModel, username, password, accessLevel);
        DriverDAO dao = new DriverDAO();
        if(dao.insertDriver(driver) != null)
        {
            System.out.println("Driver inserted...");
        }
        
        response.sendRedirect("driver?action=list");
        
    }
    
    private void forwardRequest(String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("/WEB-INF/jsp/view/" + page + ".jsp").forward(request, response);
    }
    
    private void forwardToListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        List<Driver> list = new DriverDAO().getAllDrivers();
        request.setAttribute("list", list);
        System.out.println("List Size in driver=" + list.size());
        forwardRequest("driver/list", request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
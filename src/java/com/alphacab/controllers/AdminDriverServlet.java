package com.alphacab.controllers;

import com.alphacab.dao.DriverDAO;
import com.alphacab.models.Driver;
import java.io.IOException;
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

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
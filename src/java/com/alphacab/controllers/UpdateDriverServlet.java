package com.alphacab.controllers;

import com.alphacab.dao.DriverDAO;
import com.alphacab.model.Driver;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UpdateDriverServlet", urlPatterns = {"/updateDriver"})
public class UpdateDriverServlet extends HttpServlet {


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
        String name = request.getParameter("driverName");
        String password = request.getParameter("password");
        String licenseNumber = request.getParameter("licenseNumber");
        String carType = request.getParameter("carType");
        String carModel = request.getParameter("carModel");
        String oldUsername = request.getParameter("oldusername");
        System.out.println("Old username=" + oldUsername);
        int accessLevel = 2;
        
        Driver driver = new Driver(name, licenseNumber, carType, carModel, username, password, accessLevel);
        DriverDAO dao = new DriverDAO();
        dao.updateDriver(driver, oldUsername);
        response.sendRedirect("admin/driver?action=list");
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


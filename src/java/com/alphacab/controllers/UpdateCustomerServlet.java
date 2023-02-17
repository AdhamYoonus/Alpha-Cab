package com.alphacab.controllers;

import com.alphacab.dao.CustomerDAO;
import com.alphacab.models.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Directs servlet to the URL /updateCustomer
@WebServlet(name = "UpdateCustomerServlet", urlPatterns = {"/updateCustomer"})
public class UpdateCustomerServlet extends HttpServlet 
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
        String name = request.getParameter("name");
        String contact = request.getParameter("contactno");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        
        String oldUsername = request.getParameter("oldUsername");
        Customer customer = new Customer();
        customer.setAccessLevel(1);
        customer.setContactNumber(contact);
        customer.setName(name);
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setEmail(email);
        
        CustomerDAO dao = new CustomerDAO();
        dao.updateCustomer(customer, oldUsername);
        response.sendRedirect(request.getContextPath() + "/admin/customer?action=list");
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

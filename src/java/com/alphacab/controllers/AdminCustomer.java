package com.alphacab.controllers;

import com.alphacab.dao.BookingDAO;
import com.alphacab.dao.CustomerDAO;
import com.alphacab.models.Customer;
import com.alphacab.models.Booking;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Directs servlet to the URL /admin/customer
@WebServlet(name = "AdminCustomer", urlPatterns = {"/admin/customer"})
public class AdminCustomer extends HttpServlet 
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
            case "register":
                forwardRequest("customer/register", request, response);
                break;
            case "update":
                String username = request.getParameter("username");
                request.setAttribute("customer", new CustomerDAO().getCustomerWithUsername(username));
                forwardRequest("customer/update", request, response);
                break;
            case "list":
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
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String contact = request.getParameter("contactno");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        
        Customer customer = new Customer();
        customer.setAccessLevel(1);
        customer.setContactNumber(contact);
        customer.setName(name);
        customer.setUsername(username);
        customer.setEmail(email);
        customer.setPassword(password);
        
        CustomerDAO dao = new CustomerDAO();
        dao.insertCustomer(customer);
        response.sendRedirect("customer?action=list");
        
    }
    
    private void forwardRequest(String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("/WEB-INF/jsp/view/" + page + ".jsp").forward(request, response);
    }
    
    private void forwardToListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        List<Customer> list = new CustomerDAO().getAll();
        System.out.println("List size=" + list.size());
        request.setAttribute("list", list);
        forwardRequest("customer/list", request, response);
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

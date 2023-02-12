package com.alphacab.filters;

import com.alphacab.models.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminAuthenticationFilter implements Filter 
{
    public AdminAuthenticationFilter() {
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException 
    {
        HttpSession session = ((HttpServletRequest) request).getSession();
        User user = (User) session.getAttribute("user");
        System.out.println("INSIDE ADMIN AUTHENTICATION FILTER.");
        if(user.getAccessLevel() != 3)
        {
            ((HttpServletResponse) response).sendRedirect("login");
            return;
        }
        chain.doFilter(request, response);
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() 
    {
        System.out.println("Admin Authentication Filter destroyed.");
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) 
    {
        System.out.println("Admin Authentication filter instantiated.");
    }
    
}
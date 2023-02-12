package com.alphacab.filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter 
{
    public AuthenticationFilter() 
    {
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
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException
    {
        System.out.println("NO ONE IS LOGGED IN, INSIDE FILTER.");
        System.out.println("INSIDE AUTHENTICATION FILTER.");
        HttpSession session = ((HttpServletRequest)request).getSession(false);
        if(session == null || session.getAttribute("user") == null)
            ((HttpServletResponse)response).sendRedirect(((HttpServletRequest) request).getContextPath() +"/login");
        else
            chain.doFilter(request, response);
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() 
    {
        System.out.println("Filter destroyed.");
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) 
    {
        System.out.println("Filter instantiated.");
    }
    
}
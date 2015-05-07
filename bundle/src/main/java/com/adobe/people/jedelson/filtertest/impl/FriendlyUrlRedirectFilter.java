package com.adobe.people.jedelson.filtertest.impl;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.felix.scr.annotations.sling.SlingFilter;
import org.apache.felix.scr.annotations.sling.SlingFilterScope;

@SlingFilter(name = "friendly-url-redirect-filter", scope = SlingFilterScope.REQUEST, order = 1)
public class FriendlyUrlRedirectFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException,
            ServletException {
        if (request instanceof HttpServletRequest && ((HttpServletRequest) request).getParameter("redirect") != null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/content/geometrixx/en.html");
            requestDispatcher.forward(request, response);
        } else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
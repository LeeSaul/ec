package com.ls.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by LS on 2017/9/26 17:12.
 * To Be or Not to Be
 */
@WebFilter(filterName = "UserFilter")
public class UserFilter implements Filter {
    private String uncheckPath;
    private String customer = null;
    private String sendRedirectPath = null;
    FilterConfig config;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();

        List<String> listPath = Arrays.asList(uncheckPath.split(","));
        String path = request.getServletPath();
        System.out.println(path);
        System.out.println(listPath.contains(path));
        if (listPath.contains(path)) {
            chain.doFilter(req, resp);
        } else {
            Object cust = session.getAttribute(customer);
            if (cust != null) {
                chain.doFilter(req, resp);
            } else {
                response.sendRedirect(sendRedirectPath);
                return;
            }
        }

    }
    public void init(FilterConfig config) throws ServletException {
        this.config = config;
        ServletContext context = config.getServletContext();
        uncheckPath = context.getInitParameter("uncheckPath");
        customer = context.getInitParameter("customer");
        sendRedirectPath = context.getInitParameter("sendRedirectPath");
    }
}

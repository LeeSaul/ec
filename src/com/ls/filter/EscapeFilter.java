package com.ls.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by LS on 2017/9/26 17:13.
 * To Be or Not to Be
 */
//@WebFilter(filterName="EscapeFilter",urlPatterns="/*")
public class EscapeFilter implements Filter {
    FilterConfig filterConfig;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=new EscapeWrapper((HttpServletRequest) req);
        chain.doFilter(request, resp);

    }

    public void init(FilterConfig config) throws ServletException {
        this.filterConfig=config;

    }

}

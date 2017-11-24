package com.ls.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by LS on 2017/9/26 17:02.
 * To Be or Not to Be
 */
@WebFilter(filterName = "EncodingFilter",urlPatterns = {"/*"},
        initParams = {
        @WebInitParam(name = "encoding",value = "UTF-8")
})
public class EncodingFilter implements Filter {
    private  String  encoding;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        if ("GET".equals(request.getMethod())){
            req=new EncodingWrapper(request,encoding);
        }else{
            req.setCharacterEncoding(encoding);
        }
        resp.setCharacterEncoding(encoding);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        encoding   = config.getInitParameter("encoding");
    }

}

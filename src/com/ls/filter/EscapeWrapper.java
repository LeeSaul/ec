package com.ls.filter;

import org.apache.commons.lang.StringEscapeUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Created by LS on 2017/9/26 17:13.
 * To Be or Not to Be
 */
public class EscapeWrapper extends HttpServletRequestWrapper {
    public EscapeWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        String value= getRequest().getParameter(name);
        String s = StringEscapeUtils.escapeHtml(value);
        System.out.println("s"+s);
        return  s;
    }
}

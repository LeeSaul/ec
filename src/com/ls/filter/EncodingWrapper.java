package com.ls.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;

/**
 * Created by LS on 2017/9/26 17:06.
 * To Be or Not to Be
 */
public class EncodingWrapper extends HttpServletRequestWrapper {
    private  String   encoding;
    public EncodingWrapper(HttpServletRequest request, String encoding) {
        super(request);
        this.encoding=encoding;
    }

    @Override
    public String getParameter(String name){
        String value = getRequest().getParameter(name);
        System.out.println("value"+value);
        if (value!=null){
            try {
                byte[]  b=value.getBytes("UTF-8");
                value  =new  String (b,encoding);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return  value;
    }
}

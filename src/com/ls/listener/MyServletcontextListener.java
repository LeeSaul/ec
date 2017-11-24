package com.ls.listener; /**
 * Created by LS on 2017/9/26 16:51.
 * To Be or Not to Be
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@WebListener()
public class MyServletcontextListener implements ServletContextListener {
    public  static   String DRIVER;
    public   static    String  URL;
    public   static  String  USERNAME;
    public   static    String  PASSWORD;

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
        ServletContext context = sce.getServletContext();
        InputStream stream = context.getResourceAsStream("/WEB-INF/conf/database.properties");
        if (stream!=null){
            BufferedReader br=new BufferedReader(new InputStreamReader(stream));
            String s=null;
            try {
                while ((s=br.readLine())!=null){
                    if (s.trim().charAt(0)!='#'){
                        parse(s);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private  void  parse(String s){
        String[] strings = s.split("=");
        String key=strings[0].trim().toUpperCase();
        String value=strings[1].trim();
        if (key.equals("DRIVER")){
            DRIVER=value;
        }else  if(key.equals("URL")){
            URL=value;
        }else  if(key.equals("USERNAME")){
            USERNAME=value;
        }else  if(key.equals("PASSWORD")){
            PASSWORD=value;
        }
    }
    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
        System.out.println("应用程序结束");
    }
}

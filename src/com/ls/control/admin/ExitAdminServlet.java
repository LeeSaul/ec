package com.ls.control.admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by LS on 2017/9/26 21:44.
 * To Be or Not to Be
 */
@WebServlet("/exit_admin.do")
public class ExitAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.invalidate();
        Cookie adminName=null;
        Cookie adminPassword=null;
        Cookie[] cookies = request.getCookies();
        if (cookies!=null){
            for (Cookie cookie : cookies) {
                if (cookie.getName().trim().equals("adminName")){
                    adminName=cookie;
                    adminName.setMaxAge(0);
                }
                if (cookie.getName().trim().equals("adminPassword")){
                    adminPassword=cookie;
                    adminPassword.setMaxAge(0);
                    System.out.println("1111111111111111111111111111");
                }
            }
            if (adminName!=null&&adminPassword!=null){
                response.addCookie(adminName);
                response.addCookie(adminPassword);
            }
        }
        response.sendRedirect("welcome.jsp");
    }
}

package com.ls.control.product;

import com.ls.entity.ShelfProductInfos;
import com.ls.service.ShelfProductInfosService;
import com.ls.service.impl.ShelfProductInfosServiceImpl;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by LS on 2017/9/17 7:54.
 * To Be or Not to Be
 */
@WebServlet(name = "ShelfProductInfosServlet",urlPatterns = "/shelf_product.view")
public class ShelfProductInfosServlet extends HttpServlet {
    private ShelfProductInfosService shelfProductInfosService;

    @Override
    public void init() throws ServletException {
        super.init();
        shelfProductInfosService=new ShelfProductInfosServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取要查找的页数
        String page = request.getParameter("page");
        String number =request.getParameter("number");
        List<ShelfProductInfos> shelfProductInfos = shelfProductInfosService.listAllShelfProductInfos(new Integer(number),new Integer(page));
        if (shelfProductInfos!=null){
            JSONArray jsonArray = JSONArray.fromObject(shelfProductInfos);
            System.out.println(jsonArray);
            response.getWriter().println(jsonArray);
        }else{
            response.getWriter().println("NO");
        }
    }
}

package com.ls.control.stock;

import com.ls.entity.InnerStockInfo;
import com.ls.service.InnerStockInfoService;
import com.ls.service.impl.InnerStockInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by LS on 2017/9/14 7:45.
 * To Be or Not to Be
 */
@WebServlet("/show_innerStock.view")
public class ShowInnerStockServlet extends HttpServlet {
    private InnerStockInfoService innerStockInfoService;

    @Override
    public void init() throws ServletException {
        super.init();
        innerStockInfoService=new InnerStockInfoServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        List<InnerStockInfo> innerStockInfos = innerStockInfoService.listInnerStockInfo();
        if (innerStockInfos!=null){
            request.setAttribute("innerStocks",innerStockInfos);
            request.getRequestDispatcher("page/stock/showInnerStocks.jsp").forward(request,response);
        }else {
            request.setAttribute("info","ÔÝÎÞÈë¿â¼ÇÂ¼");
            request.getRequestDispatcher("page/stock/showInnerStocks.jsp").forward(request,response);
        }
    }
}

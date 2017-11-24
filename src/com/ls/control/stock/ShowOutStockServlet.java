package com.ls.control.stock;

import com.ls.dao.OutStockInfoDao;
import com.ls.entity.OutStockInfo;
import com.ls.service.OutStockInfoService;
import com.ls.service.impl.OutStockInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by LS on 2017/9/25 19:52.
 * To Be or Not to Be
 */
@WebServlet(name = "ShowOutStockServlet",urlPatterns = "/show_outStock.view")
public class ShowOutStockServlet extends HttpServlet {
    OutStockInfoService outStockInfoService;

    @Override
    public void init() throws ServletException {
        super.init();
        outStockInfoService=new OutStockInfoServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        List<OutStockInfo> outStockInfos = outStockInfoService.showOutStock();
        request.setAttribute("outStocks",outStockInfos);
        request.getRequestDispatcher("page/stock/showOutStocks.jsp").forward(request,response);
    }
}

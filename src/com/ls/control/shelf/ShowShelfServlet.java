package com.ls.control.shelf;

import com.ls.entity.ShelfInfo;
import com.ls.service.ShelfInfoService;
import com.ls.service.impl.ShelfInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by LS on 2017/9/15 8:29.
 * To Be or Not to Be
 */
@WebServlet("/show_shelf.view")
public class ShowShelfServlet extends HttpServlet {
    private ShelfInfoService shelfInfoService;

    @Override
    public void init() throws ServletException {
        super.init();
        shelfInfoService=new ShelfInfoServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        List<ShelfInfo> shelfInfos = shelfInfoService.listShelfInfo();
        if (shelfInfos!=null){
            request.setAttribute("shelfInfos",shelfInfos);
            request.getRequestDispatcher("page/shelf/showShelf.jsp").forward(request,response);
        }else {
            request.setAttribute("info","暂无商品信息");
            request.getRequestDispatcher("page/shelf/showShelf.jsp").forward(request,response);
        }
    }
}

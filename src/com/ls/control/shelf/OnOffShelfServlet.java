package com.ls.control.shelf;

import com.ls.entity.Admin;
import com.ls.entity.Shelf;
import com.ls.entity.ShelfInfo;
import com.ls.service.ShelfInfoService;
import com.ls.service.ShelfService;
import com.ls.service.impl.ShelfInfoServiceImpl;
import com.ls.service.impl.ShelfServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by LS on 2017/9/14 21:24.
 * To Be or Not to Be
 */
@WebServlet("/on_off_shelf.do")
public class OnOffShelfServlet extends HttpServlet {
    private ShelfService shelfService;
    private ShelfInfoService shelfInfoService;

    @Override
    public void init() throws ServletException {
        super.init();
        shelfService = new ShelfServiceImpl();
        shelfInfoService = new ShelfInfoServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");*/
        Integer productId = Integer.parseInt(request.getParameter("productId"));
        String stockNumber = request.getParameter("stockNumber");
        String shelfStatus = request.getParameter("shelfStatus");
        System.out.println("shelfStatus"+shelfStatus);

        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        Integer adminId = admin.getId();
        String info;
        if (stockNumber.trim().length()==0) {
            info="该商品没有库存";
        }else {
            String oper = request.getParameter("oper");

            if (oper.equals("on") && (shelfStatus.equals("未上架"))) {
                Integer onShelfId = shelfService.onShelf(productId, adminId);
                if (onShelfId > 0) {
                    info = "上架成功";
                } else {
                    info = "上架失败";
                }

            } else if (oper.equals("on") && (shelfStatus.equals("已下架"))) {
                boolean b = shelfService.turnOnShelf(productId, adminId);
                if (b) {
                    info = "上架成功";
                } else {
                    info = "上架成功";
                }
            } else if (oper.equals("off") && (shelfStatus.equals("已上架"))) {
                boolean b = shelfService.turnOffShelf(productId, adminId);
                if (b) {
                    info = "下架成功";
                } else {
                    info = "下架失败";
                }
            } else {
                System.out.println("失败");
                info = "失败";
            }
        }
        List<ShelfInfo> shelfInfos = shelfInfoService.listShelfInfo();
        request.setAttribute("info", info);
        if (shelfInfos != null) {
            request.setAttribute("shelfInfos", shelfInfos);
            request.getRequestDispatcher("page/shelf/showShelf.jsp").forward(request, response);
        } else {
            request.setAttribute("info", "暂无商品信息");
            request.getRequestDispatcher("page/shelf/showShelf.jsp");
        }
    }
}

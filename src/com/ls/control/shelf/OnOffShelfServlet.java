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
            info="����Ʒû�п��";
        }else {
            String oper = request.getParameter("oper");

            if (oper.equals("on") && (shelfStatus.equals("δ�ϼ�"))) {
                Integer onShelfId = shelfService.onShelf(productId, adminId);
                if (onShelfId > 0) {
                    info = "�ϼܳɹ�";
                } else {
                    info = "�ϼ�ʧ��";
                }

            } else if (oper.equals("on") && (shelfStatus.equals("���¼�"))) {
                boolean b = shelfService.turnOnShelf(productId, adminId);
                if (b) {
                    info = "�ϼܳɹ�";
                } else {
                    info = "�ϼܳɹ�";
                }
            } else if (oper.equals("off") && (shelfStatus.equals("���ϼ�"))) {
                boolean b = shelfService.turnOffShelf(productId, adminId);
                if (b) {
                    info = "�¼ܳɹ�";
                } else {
                    info = "�¼�ʧ��";
                }
            } else {
                System.out.println("ʧ��");
                info = "ʧ��";
            }
        }
        List<ShelfInfo> shelfInfos = shelfInfoService.listShelfInfo();
        request.setAttribute("info", info);
        if (shelfInfos != null) {
            request.setAttribute("shelfInfos", shelfInfos);
            request.getRequestDispatcher("page/shelf/showShelf.jsp").forward(request, response);
        } else {
            request.setAttribute("info", "������Ʒ��Ϣ");
            request.getRequestDispatcher("page/shelf/showShelf.jsp");
        }
    }
}

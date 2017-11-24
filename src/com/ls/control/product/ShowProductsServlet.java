package com.ls.control.product;

import com.ls.entity.Product;
import com.ls.service.ProductService;
import com.ls.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by LS on 2017/9/12 19:37.
 * To Be or Not to Be
 */
@WebServlet("/show_product.view")
public class ShowProductsServlet extends HttpServlet {
    ProductService productService;

    @Override
    public void init() throws ServletException {
        super.init();
        productService=new ProductServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        List<Product> products = productService.listProduct();
        if (products==null){
            request.setAttribute("info","暂时没有商品可以查看，请增加商品");
        }
        HttpSession session = request.getSession();
        session.setAttribute("products",products);
        request.getRequestDispatcher("page/product/showProducts.jsp").forward(request,response);
    }
}

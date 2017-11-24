package com.ls.control.product;

import com.ls.entity.Product;
import com.ls.entity.ProductDetail;
import com.ls.entity.ProductInfo;
import com.ls.service.ProductDetailService;
import com.ls.service.impl.ProductDetailServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

/**
 * Created by LS on 2017/9/12 19:45.
 * To Be or Not to Be
 */
@WebServlet("/show_product_detail.view")
public class ShowProductDetailServlet extends HttpServlet {
    ProductDetailService productDetailService;

    @Override
    public void init() throws ServletException {
        super.init();
        productDetailService=new ProductDetailServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        int productIdInt = Integer.parseInt(request.getParameter("productId"));
        ProductDetail detailByProductId = productDetailService.findProductDetailByProductId(productIdInt);
        HttpSession session = request.getSession();
        List<Product> products = (List<Product>) session.getAttribute("products");
        Product tempProduct=null;
        for (Product product : products) {
            if (product.getId()==productIdInt){
                tempProduct=product;
                break;
            }
        }
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProduct(tempProduct);
        productInfo.setProductDetail(detailByProductId);
        request.setAttribute("productInfo",productInfo);
        String oper = request.getParameter("oper");
        if (oper.trim().equals("search")){
            request.getRequestDispatcher("page/product/showProductDetail.jsp").forward(request,response);
        }else if(oper.trim().equals("update")){
            request.getRequestDispatcher("page/product/updateProduct.jsp").forward(request,response);
        }else {
            System.out.println("²Ù×÷´íÎó");
        }
    }
}

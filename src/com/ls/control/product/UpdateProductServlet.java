package com.ls.control.product;

import com.ls.entity.Product;
import com.ls.entity.ProductDetail;
import com.ls.entity.ProductInfo;
import com.ls.service.ProductDetailService;
import com.ls.service.ProductService;
import com.ls.service.impl.ProductDetailServiceImpl;
import com.ls.service.impl.ProductServiceImpl;
import com.ls.util.ProductImageID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

/**
 * Created by LS on 2017/9/13 16:44.
 * To Be or Not to Be
 */
@WebServlet("/update_product_detail.do")
@MultipartConfig
public class UpdateProductServlet extends HttpServlet {
    ProductService productService;
    ProductDetailService productDetailService;

    @Override
    public void init() throws ServletException {
        super.init();
        productService=new ProductServiceImpl();
        productDetailService=new ProductDetailServiceImpl();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        Integer pId = Integer.parseInt(request.getParameter("pId"));
        String productName = request.getParameter("productName");
        String productPrice=request.getParameter("productPrice");
        String productType = request.getParameter("productType");
        String productCaption = request.getParameter("productCaption");
        String smallImage=null;
        String bigImage=null;

        String imageID = ProductImageID.productImgID(productName);
        ServletContext context = request.getServletContext();
        System.out.println("context==="+context);
        String basePath = context.getRealPath("") + File.separator + "images" + File.separator;
        System.out.println("basePath"+basePath);
        File file=new File(basePath,imageID);
        if (!file.exists()){
            file.mkdir();
        }
        String absolutePath=basePath+File.separator+imageID+ File.separator;
        Collection<Part> parts = request.getParts();
        if (parts!=null){
            for (Part part : parts) {
                if (part.getName().trim().toUpperCase().endsWith("IMAGE")){
                    String fileName = fileName(part);
                    String imagePath  = "images" + File.separator + imageID + File.separator + fileName;
                    System.out.println("-----"+fileName);
                    System.out.println(fileName.length());
                    if (fileName.length()>0){
                        if (part.getName().trim().toUpperCase().contains("SMALL")){
                            smallImage=imagePath;
                        }else if (part.getName().trim().toUpperCase().contains("BIG")){
                            bigImage=imagePath;
                        }else {
                            continue;
                        }
                        writeTo(part ,absolutePath,fileName);
                    }
                }
            }
        }
        System.out.println("smallImage"+smallImage);
        System.out.println("bigImage"+bigImage);
        ProductDetail productDetail=new ProductDetail();
        productDetail.setProductId(pId);
        productDetail.setSmallImage(smallImage);
        productDetail.setBigImage(bigImage);
        productDetail.setProductCaption(productCaption);
        boolean b1 = productService.updateProduct(pId, productName, productPrice, productType);
        boolean b = productDetailService.updateProductDetail(productDetail);
        if (b&&b1){
            request.setAttribute("info","更新成功");
            request.getRequestDispatcher("show_product.view").forward(request,response);
        }else {
            request.setAttribute("info","更新失败");
            request.getRequestDispatcher("show_product.view").forward(request,response);
        }
    }

    private void writeTo(Part part, String absolutePath, String fileName) throws IOException {
        File file=new File(absolutePath,fileName);
        InputStream is = part.getInputStream();
        FileOutputStream fos = new FileOutputStream(file);
        byte[] car=new byte[1024];
        int len=-1;
        while ((len=is.read(car))!=-1){
            fos.write(car,0,len);
        }
        fos.flush();
        is.close();
        fos.close();
    }

    private String fileName(Part part) {
        String header = part.getHeader("content-disposition");
        String filename = header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\""));
        return filename;
    }
}

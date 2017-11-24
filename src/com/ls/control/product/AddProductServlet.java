package com.ls.control.product;



import com.ls.entity.ProductDetail;
import com.ls.service.ProductDetailService;
import com.ls.service.ProductService;
import com.ls.service.impl.ProductDetailServiceImpl;
import com.ls.service.impl.ProductServiceImpl;
import com.ls.util.ProductImageID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

/**
 * Created by LS on 2017/9/11 23:00.
 * To Be or Not to Be
 */
@WebServlet("/add_product.do")
@MultipartConfig
public class AddProductServlet extends HttpServlet {
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

        String productName = request.getParameter("productName");
        String productPrice=request.getParameter("productPrice");
        String productType = request.getParameter("productType");
        String productCaption = request.getParameter("productCaption");
        String smallImage=null;
        String bigImage=null;
        Collection<Part> parts = request.getParts();
        ServletContext context = request.getServletContext();
        String basePath = context.getRealPath("") + File.separator + "images" + File.separator;
        String imageID = ProductImageID.productImgID(productName);
        File file=new File(basePath,imageID);
        if (!file.exists()){
            file.mkdir();
        }
        String absolutePath=basePath+File.separator+imageID+ File.separator;
        for (Part part : parts) {

            if (  part.getName().toUpperCase().trim().endsWith("IMAGE")){
                String filename=fileName(part);
                String imagePath  = "images" + File.separator + imageID + File.separator + filename;
                if (part.getName().trim().toLowerCase().indexOf("small")!=-1){
                    smallImage= imagePath;
                }else if(part.getName().trim().toLowerCase().indexOf("big")!=-1){
                    bigImage=imagePath;
                }else{
                    continue;
                }
                writeTo(part ,absolutePath,filename);
            }
        }
        int productBackId = productService.addProductBackId(productName, productPrice, productType);
        if (productBackId!=-1){
            ProductDetail productDetail=new ProductDetail();
            productDetail.setProductId(productBackId);
            productDetail.setSmallImage(smallImage);
            productDetail.setBigImage(bigImage);
            productDetail.setProductCaption(productCaption);
            boolean b = productDetailService.addProductDetail(productDetail);
            if (b){
                request.setAttribute("info","增加成功");
                request.getRequestDispatcher("page/product/productManger.jsp").forward(request,response);
            }
        }

    }

    private void writeTo(Part part, String absolutePath, String filename) throws IOException {
        File file=new File(absolutePath,filename);
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
        String fileName = header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\""));
        return fileName;
    }
}

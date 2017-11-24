package com.ls.service.impl;
import com.ls.dao.ProductDetailDao;
import com.ls.dao.impl.ProductDetailDaoImpl;
import com.ls.entity.ProductDetail;
import com.ls.service.ProductDetailService;

/**
 * Created by LS on 2017/9/12 8:26.
 * To Be or Not to Be
 */
public class ProductDetailServiceImpl implements ProductDetailService{
    private ProductDetailDao productDetailDao;

    public ProductDetailServiceImpl() {
        productDetailDao=new ProductDetailDaoImpl();
    }

    @Override
    public boolean addProductDetail(ProductDetail productDetail) {
        return productDetailDao.addProductDetail(productDetail);
    }

    @Override
    public ProductDetail findProductDetailByProductId(int productId) {
        return productDetailDao.findProductDetailByProductId(productId);
    }

    @Override
    public boolean updateProductDetail(ProductDetail productDetail) {
        //СͼƬ���»����Ǵ�ͼƬ���»���������ͼ������
        boolean b;
        if (productDetail.getBigImage()==null&&productDetail.getSmallImage()!=null){
            b=productDetailDao.updateSmallImage(productDetail);
        }else if (productDetail.getBigImage()!=null&&productDetail.getSmallImage()==null){
            b=productDetailDao.updateBigImage(productDetail);
        }else if (productDetail.getBigImage()!=null&&productDetail.getSmallImage()!=null){
            b=productDetailDao.updateSmallAndBigImage(productDetail);
        }else {
            b=productDetailDao.updateCaption(productDetail);
        }
        return b;
    }
}

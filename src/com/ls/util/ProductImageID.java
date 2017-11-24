package com.ls.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by LS on 2017/9/12 18:47.
 * To Be or Not to Be
 */
public class ProductImageID {
    public synchronized static String productImgID(String productName){
        Random random=new Random(System.currentTimeMillis());
        long randNum=Math.abs(random.nextLong());
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMDDmmhhss");
        String format = simpleDateFormat.format(date);
        String imgID=productName+randNum+format;
        return imgID;
    }
}

package com.ls.service.impl;

import com.ls.dao.ShelfDao;
import com.ls.dao.impl.ShelfDaoImpl;
import com.ls.entity.Shelf;
import com.ls.service.ShelfService;

/**
 * Created by LS on 2017/9/14 22:13.
 * To Be or Not to Be
 */
public class ShelfServiceImpl implements ShelfService {
    private ShelfDao shelfDao;

    public ShelfServiceImpl() {
        shelfDao = new ShelfDaoImpl();
    }

    @Override
    public Integer onShelf(Integer productId, Integer adminId) {
        Shelf shelf = new Shelf();
        shelf.setAdminId(adminId);
        shelf.setProductId(productId);
        shelf.setShelfStatus(Shelf.SHELF_ON);
        return shelfDao.insertShelf(shelf);
    }

    @Override
    public boolean turnOnShelf(Integer productId, Integer adminId) {
        Shelf shelf = new Shelf();
        shelf.setAdminId(adminId);
        shelf.setProductId(productId);
        shelf.setShelfStatus(Shelf.SHELF_ON);
        return shelfDao.updateShelf(shelf);
    }

    @Override
    public boolean turnOffShelf(Integer productId, Integer adminId) {
        Shelf shelf = new Shelf();
        shelf.setAdminId(adminId);
        shelf.setProductId(productId);
        shelf.setShelfStatus(Shelf.SHELF_OFF);
        return shelfDao.updateShelf(shelf);
    }

    @Override
    public Shelf findShelfByProductId(Integer productId) {
        return shelfDao.findShelfByProductId(productId);
    }

    @Override
    public Shelf findShelfByShelfId(Integer shelfId) {
        return shelfDao.findShelfByShelfId(shelfId);
    }
}

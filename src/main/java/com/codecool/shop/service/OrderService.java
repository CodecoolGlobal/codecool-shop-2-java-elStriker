package com.codecool.shop.service;

import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Product;

import java.util.*;

public class OrderService {

    private OrderDao orderDao;

    private ProductDao productDao;


    public OrderService(OrderDao orderDao, ProductDao productDao) {
        this.orderDao = orderDao;
        this.productDao = productDao;

    }

    public void addNewProduct(int id) {
        orderDao.add(productDao.find(id));
    }

    public void addNewProducts(int productId, int productNumber) {
        Product newOrder = productDao.find(productId);
        orderDao.removeAll(newOrder);
        for (int i = 0; i < productNumber; i++) {
            orderDao.add(newOrder);
        }
    }

    public Set<Product> getUniqueProducts() {
        Set<Product> uniqueProducts = new HashSet<>();
        for (Product product : orderDao.getAll()) {
            uniqueProducts.add(product);
        }
        return uniqueProducts;
    }

    public Map<String, Integer> getProductCounts() {
        Map<String, Integer> productCounts = new HashMap<>();
        for (Product product : orderDao.getAll()) {
            productCounts.put(product.getName(), orderDao.getNumberOfProducts(product));
        }
        return productCounts;
    }

    public double getTotalPrice() {
        return orderDao.getTotalPrice();
    }





}

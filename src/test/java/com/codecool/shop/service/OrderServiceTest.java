package com.codecool.shop.service;

import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.OrderDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import com.codecool.shop.model.dto.CheckOutDto;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderServiceTest {

    private OrderService orderService;

    private OrderDao orderDao;

    private ProductDao productDao;

    @Test
    public void getUniqueProducts_nonEmpty_returnProducts() {
        List<Product> productList = new ArrayList<>();
        Set<Product> uniqueProducts = new HashSet<>();
        ProductCategory tablet = new ProductCategory("Tablet", "Hardware", "A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
        Supplier amazon = new Supplier("Amazon", "Digital content and services");
        Product product = new Product("Amazon Fire", new BigDecimal("49.9"), "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", tablet, amazon);
        productList.add(product);
        productList.add(product);
        uniqueProducts.add(product);
        orderDao = mock(OrderDaoMem.class);
        productDao = ProductDaoMem.getInstance();
        orderService = new OrderService(orderDao, productDao);
        when(orderDao.getAll()).thenReturn(productList);
        assertTrue(uniqueProducts.equals(orderService.getUniqueProducts()));
    }

    @Test
    public void getProductCounts_nonEmpty_returnCounts() {
        List<Product> productList = new ArrayList<>();
        Map<String, Integer> productCounts = new HashMap<>();
        ProductCategory tablet = new ProductCategory("Tablet", "Hardware", "A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
        Supplier amazon = new Supplier("Amazon", "Digital content and services");
        Product product = new Product("Amazon Fire", new BigDecimal("49.9"), "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", tablet, amazon);
        productList.add(product);
        productList.add(product);
        productCounts.put("Amazon Fire", 2);
        orderDao = mock(OrderDaoMem.class);
        productDao = ProductDaoMem.getInstance();
        orderService = new OrderService(orderDao, productDao);
        when(orderDao.getAll()).thenReturn(productList);
        when(orderDao.getNumberOfProducts(product)).thenReturn(2);
        assertTrue(productCounts.equals(orderService.getProductCounts()));

    }
    @Test
    public void getCheckOutData_returnData() {
        orderDao = OrderDaoMem.getInstance();
        productDao = ProductDaoMem.getInstance();
        orderService = new OrderService(orderDao, productDao);
        CheckOutDto checkOutDto = new CheckOutDto("grtgdd", "vgref@fgrdf.com", "545345", "gdgrdg", "ghfhtf");
        orderService.addCheckOutData(checkOutDto);
        assertTrue(checkOutDto.equals(orderService.getCheckOutData()));
    }


    @Test
    public void addNewProduct_nonExistingId_throwsIllegalArgumentException() {
        orderDao = OrderDaoMem.getInstance();
        productDao = mock(ProductDaoMem.class);
        orderService = new OrderService(orderDao, productDao);
        when(productDao.find(anyInt())).thenThrow(IllegalArgumentException.class);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            orderService.addNewProduct(anyInt());
        });

    }

    @Test
    public void getTotalPrice_returnTotalPrice() {
        orderDao = OrderDaoMem.getInstance();
        productDao = ProductDaoMem.getInstance();
        orderService = new OrderService(orderDao, productDao);
        ProductCategory tablet = new ProductCategory("Tablet", "Hardware", "A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
        Supplier amazon = new Supplier("Amazon", "Digital content and services");
        Product product = new Product("Amazon Fire", new BigDecimal("49.9"), "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", tablet, amazon);
        orderDao.getAll().add(product);
        orderDao.getAll().add(product);
        System.out.println(orderService.getTotalPrice());
        assertTrue(Double.parseDouble("99.8") == orderService.getTotalPrice());

    }




}

package com.codecool.shop.service;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceTest {

    private ProductService productService;

    private ProductCategoryDao productCategoryDao;

    private ProductDao productDao;

    @Test
    public void getProductCategory_existingId_returnCategory() {
        productCategoryDao = mock(ProductCategoryDaoMem.class);
        productDao = ProductDaoMem.getInstance();
        productService = new ProductService(productDao, productCategoryDao);
        ProductCategory tablet = new ProductCategory("Tablet", "Hardware", "A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
        when(productCategoryDao.find(anyInt())).thenReturn(tablet);
        assertTrue(tablet.equals(productService.getProductCategory(anyInt())));
    }

    @Test
    public void getProductCategory_nonExistingId_throwIllegalArgumentException() throws IllegalArgumentException {
        productCategoryDao = mock(ProductCategoryDaoMem.class);
        productDao = ProductDaoMem.getInstance();
        productService = new ProductService(productDao, productCategoryDao);
        when(productCategoryDao.find(anyInt())).thenThrow(IllegalArgumentException.class);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            productService.getProductCategory(anyInt());
        });
    }

    @Test
    public void getProductsForCategory_existingId_returnProducts() {
        productCategoryDao = mock(ProductCategoryDaoMem.class);
        productDao = mock(ProductDaoMem.class);
        productService = new ProductService(productDao, productCategoryDao);
        List<Product> productList = new ArrayList<>();
        ProductCategory tablet = new ProductCategory("Tablet", "Hardware", "A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
        Supplier amazon = new Supplier("Amazon", "Digital content and services");
        Product product = new Product("Amazon Fire", new BigDecimal("49.9"), "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", tablet, amazon);
        productList.add(product);
        when(productCategoryDao.find(anyInt())).thenReturn(tablet);
        when(productDao.getBy(tablet)).thenReturn(productList);
        assertTrue(productList.equals(productService.getProductsForCategory(anyInt())));


    }

    @Test
    public void getProductsForCategory_nonExistingId_throwIllegalArgumentException() {
        productCategoryDao = mock(ProductCategoryDaoMem.class);
        productDao = ProductDaoMem.getInstance();
        productService = new ProductService(productDao, productCategoryDao);
        when(productCategoryDao.find(anyInt())).thenThrow(IllegalArgumentException.class);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            productService.getProductsForCategory(anyInt());
        });

    }
}

package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        //setting up a new supplier
        Supplier amazon = new Supplier("Amazon", "Digital content and services");
        supplierDataStore.add(amazon);
        Supplier lenovo = new Supplier("Lenovo", "Computers");
        supplierDataStore.add(lenovo);
        Supplier mjam = new Supplier("Mjam", "Food");
        supplierDataStore.add(mjam);
        Supplier zara = new Supplier("Zara", "Clothing");
        supplierDataStore.add(zara);
        Supplier nike = new Supplier("Nike", "Sport wear");
        supplierDataStore.add(nike);
        Supplier apple = new Supplier("Apple", "Electronics");
        supplierDataStore.add(apple);

        //setting up a new product category
        //default category
        ProductCategory defaultCategory = new ProductCategory("", "Default", "Default");
        ProductCategory tablet = new ProductCategory("Tablet", "Hardware", "A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
        ProductCategory shoes = new ProductCategory("Sneakers", "Footwear", "A shoe with a rubber sole that is designed for people to wear while running, playing sports.");
        ProductCategory food = new ProductCategory("Food", "Food", "Products to consume and satisfy your hunger.");
        ProductCategory drink = new ProductCategory("Drink", "Drink", "Products to quench your thirst.");
        ProductCategory pants = new ProductCategory("Pants", "Clothing", "An outer garment covering each leg separately and usually extending from the waist to the ankle");
        ProductCategory shirt = new ProductCategory("Shirt", "Clothing", "a garment for the upper body made of cotton or a similar fabric, with a collar and sleeves, and with buttons down the front.");
        ProductCategory computer = new ProductCategory("Computer", "Hardware", "An electronic device for storing and processing data, typically in binary form, according to instructions given to it in a variable program.");
        ProductCategory smartWatch = new ProductCategory("Watch", "Accessory", "a mobile device with a touchscreen display, designed to be worn on the wrist.");

        //add category to dataStore
        productCategoryDataStore.add(defaultCategory);
        productCategoryDataStore.add(tablet);
        productCategoryDataStore.add(shoes);
        productCategoryDataStore.add(food);
        productCategoryDataStore.add(drink);
        productCategoryDataStore.add(pants);
        productCategoryDataStore.add(shirt);
        productCategoryDataStore.add(computer);
        productCategoryDataStore.add(smartWatch);

        //setting up products and printing it
        productDataStore.add(new Product("Amazon Fire", new BigDecimal("49.9"), "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", tablet, amazon));
        productDataStore.add(new Product("Lenovo IdeaPad Miix 700", new BigDecimal("479"), "USD", "Keyboard cover is included. Fanless Core m5 processor. Full-size USB ports. Adjustable kickstand.", tablet, lenovo));
        productDataStore.add(new Product("Amazon Fire HD 8", new BigDecimal("89"), "USD", "Amazon's latest Fire HD 8 tablet is a great value for media consumption.", tablet, amazon));

        productDataStore.add(new Product("Domino's Pizza", new BigDecimal("18"), "USD", "Best pizza in the neighbourhood", defaultCategory, mjam));
    }
}

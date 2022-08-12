package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.database.DatabaseManager;
import com.codecool.shop.dao.database.Property;
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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


@WebListener
public class Initializer implements ServletContextListener {
    private final DatabaseManager databaseManager = new DatabaseManager();
    private ResultSet resultSet;
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        try (Connection con = databaseManager.getConnection()){
            DbDataRetriever db = new DbDataRetriever(con);
            db.retrieveSuppliers();
            createSuppliers(con);
            createCategories(con);
            CreateProducts(con);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


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
        ProductCategory tablet = new ProductCategory("Tablet", "Hardware", "A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
        ProductCategory shoes = new ProductCategory("Shoes", "Footwear", "A shoe with a rubber sole that is designed for people to wear while running, playing sports.");
        ProductCategory food = new ProductCategory("Food", "Food", "Products to consume and satisfy your hunger.");
        ProductCategory drink = new ProductCategory("Drink", "Drink", "Products to quench your thirst.");
        ProductCategory pants = new ProductCategory("Pants", "Clothing", "An outer garment covering each leg separately and usually extending from the waist to the ankle");
        ProductCategory shirt = new ProductCategory("Shirt", "Clothing", "a garment for the upper body made of cotton or a similar fabric, with a collar and sleeves, and with buttons down the front.");
        ProductCategory computer = new ProductCategory("Computer", "Hardware", "An electronic device for storing and processing data, typically in binary form, according to instructions given to it in a variable program.");
        ProductCategory smartWatch = new ProductCategory("Watch", "Accessory", "a mobile device with a touchscreen display, designed to be worn on the wrist.");
        //add category to dataStore
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

        productDataStore.add(new Product("Domino's Pizza", new BigDecimal("18"), "USD", "Best pizza in the neighbourhood", food, mjam));
        productDataStore.add(new Product("Carbonara", new BigDecimal("70"), "USD", "Organic, home-grown spaghetti with cream", food, mjam));
        productDataStore.add(new Product("Better Big Mac", new BigDecimal("50"), "USD", "A lot better version of the crappy McDonald's Big Mac", food, mjam));

        productDataStore.add(new Product("Air force 1", new BigDecimal("2000"), "USD", "Best selling nike shoes of all times", shoes, nike));
        productDataStore.add(new Product("Tap-dancing shoes", new BigDecimal("1"), "USD", "A must have for every smart person", shoes, zara));
        productDataStore.add(new Product("Converse Run Star Motion", new BigDecimal("149"), "USD", "Perfect for you if you are into weird stuff", shoes, nike));

        productDataStore.add(new Product("Coke", new BigDecimal("5"), "USD", "Most effective drink to give you diabetes", drink, mjam));
        productDataStore.add(new Product("Butter-Beer", new BigDecimal("20"), "USD", "Magical drink to make your loved ones happier.", drink, amazon));
        productDataStore.add(new Product("Coffee", new BigDecimal("0"), "USD", "Liquid gold for free. Just pay the 20 USD shipping fee.", drink, apple));

        productDataStore.add(new Product("Khaki-pants", new BigDecimal("99"), "USD", "\n" +
                "“Khakis” and “chinos” are both used to describe casual trousers made with a 100% cotton twill fabric. Technically, “khaki” is a color (light-brown drab), while “chinos” are a style of pant, so strictly speaking, khakis are brown-colored chinos.", pants, zara));
        productDataStore.add(new Product("Shorts", new BigDecimal("49"), "USD", "Shorts are a garment worn over the pelvic area, circling the waist and splitting to cover the upper part of the legs, sometimes extending down to the knees but not covering the entire length of the leg.", pants, amazon));
        productDataStore.add(new Product("Trousers", new BigDecimal("59"), "USD", "Trousers, also spelled trowsers, also called pants or slacks, an outer garment covering the lower half of the body from the waist to the ankles and divided into sections to cover each leg separately.", pants, nike));

        productDataStore.add(new Product("Hawaii-Shirt", new BigDecimal("1"), "USD", "A short-sleeved, loose-fitting, open-collar shirt originally worn in Hawaii, made of lightweight fabric printed in colorful, often bold designs of flowers, leaves, birds, beaches, etc.", shirt, zara));
        productDataStore.add(new Product("Polo shirt", new BigDecimal("35"), "USD", "a close-fitting pullover often knit shirt with short or long sleeves and turnover collar or banded neck.", shirt, mjam ));
        productDataStore.add(new Product("Voldemort shirt", new BigDecimal("99999"), "USD", "BEST SHIRT IN THE WHOLE WORLD.", shirt, amazon));

        productDataStore.add(new Product("Elder wand Computer", new BigDecimal("1337"), "USD", "Fastest computer and best magic wand in the world.", computer, apple));
        productDataStore.add(new Product("Not a lenovo Gaming PC", new BigDecimal("2999"), "USD", "A monster gaming pc that will scratch your gaming itch.", computer, lenovo));
        productDataStore.add(new Product("Amazon Retro PC", new BigDecimal("69"), "USD", "If you feel like the 80's and 90's were better, buy this.", computer, amazon));

        productDataStore.add(new Product("Xiaomi smartwatch", new BigDecimal("0.2"), "USD", "Some chinese crap - Sun Tzu.", smartWatch, amazon));
        productDataStore.add(new Product("Apple watch", new BigDecimal("1293"), "USD", "The most expensive, unneccessary thing in your life, but you will buy it because u addicted bruv.", smartWatch, apple));
        productDataStore.add(new Product("Garmin Fenix 7X", new BigDecimal("999"), "USD", "Solar powered, sport watch that will make everyone excited to see you run.", smartWatch, amazon));
    }

    private void CreateProducts(Connection con) {
    }

    private void createCategories(Connection con) {
    }

    private void createSuppliers(Connection con) throws SQLException {
        Statement statement = con.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM suppliers");

        while (resultSet.next()) {
            String name = resultSet.getString(2);
            String description = resultSet.getString(3);

        }
    }
}

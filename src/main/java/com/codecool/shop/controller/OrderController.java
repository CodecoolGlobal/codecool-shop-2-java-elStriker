package com.codecool.shop.controller;

import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.OrderDaoMem;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.service.ProductService;
import com.codecool.shop.config.TemplateEngineUtil;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"/order"})
public class OrderController extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        ProductService productService = new ProductService(productDataStore,productCategoryDataStore);
        OrderDaoMem cart = OrderDaoMem.getInstance();

        String newOrderId = req.getParameter("id");
        Product newOrder = productDataStore.find(Integer.valueOf(Integer.parseInt(newOrderId)));
        cart.add(newOrder);
        System.out.println(cart.getData().get(0));

        String site = new String("http://localhost:8080/");
        resp.sendRedirect(site);

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        OrderDaoMem cart = OrderDaoMem.getInstance();
        Map<String, String> productCounts = new HashMap<>();
        //Map<String, Integer> productPrices = new HashMap<>();

        for (Product product : cart.getData()) {
            productCounts.put(product.getName(), "Number: " + cart.getNumberOfProducts(product));
           // productPrices.put(product.getName(), Integer.valueOf(product.getPrice()));
        }

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("products", cart.getAll());
        context.setVariable("productcounts", productCounts);
        context.setVariable("totalprice", cart.getTotalPrice());
        context.setVariable("totalpriceInCurrency", "Total price: " + cart.getTotalPrice() + " USD");

        engine.process("order/cart.html", context, resp.getWriter());

    }



}

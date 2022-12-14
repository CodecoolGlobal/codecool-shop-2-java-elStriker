package com.codecool.shop.controller;

import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.OrderDaoMem;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.service.OrderService;
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


@WebServlet(urlPatterns = {"/order"})
public class OrderController extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ProductDao productDataStore = ProductDaoMem.getInstance();
        OrderDaoMem cart = OrderDaoMem.getInstance();
        OrderService orderService = new OrderService(cart, productDataStore);

        String site = new String("http://localhost:8080/");
        if (req.getParameter("id") != null) {
            String newOrderId = req.getParameter("id");
            if (req.getParameter("number") != null) {
                if (req.getParameter("number") != "") {
                    int productNumber = Integer.valueOf(Integer.parseInt(req.getParameter("number")));
                    orderService.addNewProducts(Integer.valueOf(Integer.parseInt(newOrderId)), productNumber);
                }
                site = "http://localhost:8080/order";
            } else {
                orderService.addNewProduct(Integer.valueOf(Integer.parseInt(newOrderId)));
            }
        }
        System.out.println(cart.getAll());
        resp.sendRedirect(site);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ProductDao productDataStore = ProductDaoMem.getInstance();
        OrderDao cart = OrderDaoMem.getInstance();
        OrderService orderService = new OrderService(cart, productDataStore);


        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("products", orderService.getUniqueProducts());
        context.setVariable("productcounts", orderService.getProductCounts());
        context.setVariable("totalprice", orderService.getTotalPrice());
        context.setVariable("totalpriceInCurrency", "Total price: " + orderService.getTotalPrice() + " USD");

        engine.process("order/cart.html", context, resp.getWriter());

    }



}

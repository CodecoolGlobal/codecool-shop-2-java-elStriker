package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.OrderDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import com.codecool.shop.service.OrderService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;

@WebServlet(urlPatterns = {"/confirmation"})
public class ConfirmationController extends HttpServlet {

    ProductDao productDataStore = ProductDaoMem.getInstance();
    OrderDaoMem cart = OrderDaoMem.getInstance();
    OrderService orderService = new OrderService(cart, productDataStore);

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.registerTypeAdapter(OrderDaoMem.class, new OrderSerializer());

        Gson gson = gsonBuilder.create();
        String orderJson = gson.toJson(cart);
        String orderName = LocalDate.now().toString();

       try (FileWriter file = new FileWriter("/home/martin/projects/codecool-shop-2-java-elStriker/src/main/resources/"+orderName+".json")) {
            file.write(orderJson);
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("products", orderService.getUniqueProducts());
        context.setVariable("productcounts", orderService.getProductCounts());
        context.setVariable("totalprice", orderService.getTotalPrice());
        context.setVariable("totalpriceInCurrency", "Total price: " + orderService.getTotalPrice() + " USD");
        context.setVariable("costumerData", orderService.getCheckOutData());
        System.out.println(orderService.getCheckOutData().getName());
        context.setVariable("paymentData", orderService.getPaymentData());

        engine.process("order/confirmation.html", context, resp.getWriter());

    }


}

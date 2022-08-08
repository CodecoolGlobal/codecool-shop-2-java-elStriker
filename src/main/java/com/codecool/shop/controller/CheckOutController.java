package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/check-out"})
public class CheckOutController extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        int phoneNumber = Integer.parseInt(req.getParameter("phone-number"));
        String billingAddress = req.getParameter("billing-address");
        String shippingAddress = req.getParameter("shipping-address");

        /*make interface checkOut Interface or record
        create implementation for the checkout OR
        create new checkOutInfo object with the parameters
        give it over to the verification Service
        and BOOM
         */

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());

        engine.process("order/checkOut.html", context, resp.getWriter());
    }
}

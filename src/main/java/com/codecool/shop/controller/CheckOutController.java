package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.model.dto.CheckOutDto;
import com.codecool.shop.service.VerificationService;
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
    VerificationService verificationService = new VerificationService();
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phoneNumber = req.getParameter("phone-number");
        String billingAddress = req.getParameter("billing-address");
        String shippingAddress = req.getParameter("shipping-address");
        CheckOutDto checkOutDto = new CheckOutDto(name, email, phoneNumber, billingAddress, shippingAddress);
        if (verificationService.validateCheckout(checkOutDto)){
            // #TODO change to payment
            System.out.println("sending to index");
            resp.sendRedirect("product/index.html");
        } else {
            System.out.println("sending to checkout bqack");
            resp.sendRedirect("check-out");
        }
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

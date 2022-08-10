package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.model.dto.PaymentDto;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/payment"})
public class PaymentController extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long ccnumber = Long.parseLong(req.getParameter("ccnumber"));
        String ccexp = req.getParameter("ccexp");
        int cvc = Integer.parseInt(req.getParameter("cvc"));
        String name = req.getParameter("name");
        System.out.println(name +" "+ ccnumber +" "+ ccexp +" "+ cvc);
        PaymentDto paymentDto = new PaymentDto(ccnumber, ccexp, cvc, name);

        resp.sendRedirect("/confirmation");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        engine.process("order/payment.html", context, resp.getWriter());

    }
}

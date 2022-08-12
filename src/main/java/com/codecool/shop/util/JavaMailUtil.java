package com.codecool.shop.util;

import java.util.Properties;
import javax.mail.*;
import javax.mail.Authenticator;
import javax.mail.internet.*;

public class JavaMailUtil {
    public static void sendMail(String receipient) throws MessagingException {
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        String myAccountEmail = "*********@gmail.com";
        String password = "*******";

        Session session = Session.getInstance(properties, new Authenticator(){
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        Message message = prepareMessage(session, myAccountEmail, receipient);
        Transport.send(message);
        System.out.println("Email sent successfully");
    }


    private static Message prepareMessage(Session session, String myAccountEmail, String receipient) throws MessagingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(myAccountEmail));
        message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse(receipient));
        message.setSubject("Your Order Confirmation");

        String msg = "Hello, Thank you for your order!";

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        return message;
    }

}

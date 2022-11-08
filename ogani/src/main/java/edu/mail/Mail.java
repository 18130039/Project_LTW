package edu.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.Properties;

public class Mail {
    public static void sendMail(){
        Properties pro = new Properties();
        pro.put("mail.smtp.host","smtp.gmail.com");
        pro.put("mail.smtp.port","587");
        pro.put("mail.smtp.auth","true");
        pro.put("mail.smtp.starttls.enable","true");

        String username = "toannguyenitit@gmail.com";
        String password = "mukjlrupkcptfmhn";

        Session session = Session.getInstance(pro,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username,password);
                    }
                });

        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress("uyfftydif@gmail.com","OTONA"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("birdtoan2@gmail.com"));
            message.setSubject("Test");
            message.setText("Hello World");
            Transport.send(message);
            System.out.println("Done");

        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        sendMail();
    }
}

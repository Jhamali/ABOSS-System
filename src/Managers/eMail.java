/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import java.io.File;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author dubze
 */
public class eMail {

    static String content = "QR Code";
    static String userName = "comp2140email@gmail.com";
    static String password = "universit";
    
    

    public static void send(String email) {
        String user = System.getProperty("user.name");
        String to = email;

        //Get the session object  
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        });

        //compose message  
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(userName));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(content);
            MimeBodyPart p1 = new MimeBodyPart();
            p1.setText("Customer QR Code");
            MimeMultipart mp = new MimeMultipart();
            MimeBodyPart img = new MimeBodyPart();

            String filename = "/Users/" + user + "/Documents/QR.png";//change accordingly  
            DataSource source = new FileDataSource(filename);
            img.setDataHandler(new DataHandler(source));
            img.setFileName(filename);
            mp.addBodyPart(img);
            message.setContent(mp);
            //message.setText("Request");

            //send message  
            Transport.send(message);

            System.out.println("message sent successfully");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

}

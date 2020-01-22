package com.codegym.task.task40.task4003;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

/* 
Sending an email with a file attachment

*/

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.sendMail("name.lastname@gmail.com", "password", "friend@gmail.com");
    }

    public void sendMail(final String username, final String password, final String recipients) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));

            setSubject(message, "Test message");
            setAttachment(message, "c:/text.txt");

            Transport.send(message);
            System.out.println("The message was sent.");

        } catch (MessagingException e) {
            System.out.println("Error while sending: " + e.toString());
        }
    }

    public static void setSubject(Message message, String subject) throws MessagingException {
        message.setSubject(subject);
    }

    public static void setAttachment(Message message, String filename) throws MessagingException {
        MimeBodyPart p = new MimeBodyPart();
        FileDataSource fds = new FileDataSource(filename);
        p.setDataHandler(new DataHandler(fds));
        p.setFileName(fds.getName());
        Multipart mp = new MimeMultipart();
        mp.addBodyPart(p);
        message.setContent(mp);
    }
}
package com.pinsystem.utils;


import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailUtility {

    public static void sendEmail(String to, String subject, String body, String attachmentPath) {
        // Set up the mail server properties
    	Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS
        props.put("mail.smtp.host", "smtp.gmail.com"); // Use Gmail SMTP server
        props.put("mail.smtp.port", "587"); // Use port 587 for TLS

        // Create a session with an authenticator
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("rajsharma.9331@gmail.com", "rrfi oyvw vijc lsrm"); // Replace with your email and password
            }
        });

        try {
            // Create a MimeMessage
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("rajsharma.9331@gmail.com")); // Your email address
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);

            // Create the email body
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setText(body);

            // Attach the report
            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(attachmentPath); // Make sure to handle IOException

            // Create a multipart message
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            multipart.addBodyPart(attachmentPart);

            // Set the multipart message to the email message
            message.setContent(multipart);

            // Send the email
            Transport.send(message);
            System.out.println("Email sent successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to send email: " + e.getMessage());
        }
    }
}
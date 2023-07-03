package spring.Email.Service;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;
import java.util.Properties;



@Service
public class EmailService {

    public boolean sendEmail(String subject, String message, String to) {
        boolean f = false;
        String from = "Gnanesh1926@gmail.com";
        String host = "smtp.gmail.com";

        Properties properties = new Properties();
        System.out.println("Properties: " + properties);

        // host set
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Step 1: Get the session object

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("gnanesh1926@gmail.com", "lbmizjiydqrswnyd");
            }
        });
        session.setDebug(true);

        try {
            // Step 2: Compose the message
            MimeMessage mimeMessage = new MimeMessage(session);

            // Set from email
            mimeMessage.setFrom(new InternetAddress(from));

            // Add recipient to the message
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Add subject to the message
            mimeMessage.setSubject(subject);

            // Add text to the message
            mimeMessage.setText(message);

            // Step 3: Send the message using Transport class
            Transport.send(mimeMessage);

            System.out.println("Email sent successfully...");
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }
}


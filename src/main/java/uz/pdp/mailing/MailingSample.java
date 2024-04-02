package uz.pdp.mailing;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailingSample {

    private static final String username = "otabekpanoev01@gmail.com";
    private static final String password = "ndda gvqw mreo sdyk";
    private static final String recipient = "iamotabekpanoev01@gmail.com";
    public static void main(String[] args) throws Exception {

        Properties properties = getProperties();

        Session session = getSession(properties);

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

        message.setSubject("This is test mail from G38");
//        message.setText("Hi we are going to exam");
        message.setContent("<h1 style=\"color:red;\"> Hi we are going to exam </h1>", "text/html");

        Transport.send(message);
        System.out.println("End");
    }

    private static Session getSession(Properties properties) {
        return Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        return properties;
    }
}

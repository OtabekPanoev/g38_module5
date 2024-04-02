package uz.pdp.mailing;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Properties;

public class MailtrapTesting {

    private static final String username = "df0cdf2a9e2881";
    private static final String password = "9538928a0cb6bf";
    private static final String recipient = "iamotabekpanoev01@gmail.com";

    public static void main(String[] args) throws Exception {

//        v1();

        Properties properties = getProperties();

        Session session = getSession(properties);

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        message.setSubject("we age going to send files");

        Multipart multipart = new MimeMultipart();

        /*MimeBodyPart mimeBodyPart = new MimeBodyPart();
        DataSource dataSource = new FileDataSource("Otabek Panoev.pdf");
        DataHandler dataHandler = new DataHandler(dataSource);
        mimeBodyPart.setFileName("Resume.pdf");
        mimeBodyPart.setDataHandler(dataHandler);*/

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        DataSource dataSource = new FileDataSource("resume.txt");
        DataHandler dataHandler = new DataHandler(dataSource);
        mimeBodyPart.setFileName("Resume.txt");
        mimeBodyPart.setDataHandler(dataHandler);


        MimeBodyPart mimeBodyPart2 = new MimeBodyPart();
        String body = """
                <div>
                <h1 style=\"color:red;\"> Hi we are going to exam </h1>
                <img src="data:image/png;base64,%s" width=100 />
                </div>
                """.formatted(getBase64AsString());
        mimeBodyPart2.setContent(body, "text/html");


        multipart.addBodyPart(mimeBodyPart);
        multipart.addBodyPart(mimeBodyPart2);

        message.setContent(multipart);

        Transport.send(message);
        System.out.println("End");
    }

    private static String getBase64AsString() throws Exception {
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] bytes = Files.readAllBytes(Path.of("m1.png"));
        String encodedString = encoder.encodeToString(bytes);
        System.out.println("encodedString = " + encodedString);
        return encodedString;
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
        properties.put("mail.smtp.host", "smtp.mailtrap.io");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.tls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        return properties;
    }

    private static void v1() throws MessagingException {
        Properties properties = getProperties();

        Session session = getSession(properties);

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

        message.setSubject("This is test mail from G38");
        message.setContent("<h1 style=\"color:red;\"> Hi we are going to exam </h1>", "text/html");

        Transport.send(message);
        System.out.println("End");
    }
}

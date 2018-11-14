package utils;

import config.EmailConfig;
import entity.Account;
import entity.AccountDetail;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author Shado
 */
public class AutoSendEmail {

    public void sentEmail(String fromEmail, String password, String toEmail, String subject, String text) {
        // TODO
        // Change to configuration file      

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setReplyTo(InternetAddress.parse(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);
            System.out.println("Done!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public String emailContent( String email, String activeCode) {
        String text
                = "\n\nThank you for register system. You must login and active code:"
                + "\n\nEmail User : " + email
                + "\n Code Active  : " + activeCode
                + "\n\nThank you"
                + EmailConfig.SIGNATURE;
        return text;
    }

    public String emailContent_ResetPassword(String email, String newPassword) {
        String text = " Khôi phục mật khẩu thành công"
                + "\n\n Email: " + email
                + "\n Mật khẩu mới : " + newPassword
                + "\n\n Cảm ơn bạn đã sử dụng dịch vụ của chúng tôi!"
                + EmailConfig.SIGNATURE;
        return text;
    }

}

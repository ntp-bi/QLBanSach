package ntp.utils;

import javax.mail.*;
import javax.mail.internet.*;

import java.util.Properties;

public class EmailUtil {

	private static final String SMTP_HOST = "smtp.your-email-provider.com";
	private static final String SMTP_PORT = "587";
	private static final String USERNAME = "your-email@example.com";
	private static final String PASSWORD = "your-email-password";

	public static void sendEmail(String emailTo, String subject, String message) {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", SMTP_HOST);
		properties.put("mail.smtp.port", SMTP_PORT);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(USERNAME, PASSWORD);
			}
		});

		try {
			Message emailMessage = new MimeMessage(session);
			emailMessage.setFrom(new InternetAddress(USERNAME));
			emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
			emailMessage.setSubject(subject);
			emailMessage.setText(message);

			Transport.send(emailMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}

package com.asu.ser.util;

import java.util.Properties;
import java.util.logging.Level;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.logging.Logger;
/**
 * @author akhilesh
 */

public class MailServer {

	private static Logger LOGGER = Logger.getLogger(MailServer.class.getName());
	
	private static final String USERNAME = "team8.ser515@gmail.com";
	private static final String PASSWORD = "aujisrmliyexaydg";

	public static void sendMail(String toAddress, String subject, String content) throws Exception {
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(USERNAME, PASSWORD);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("noreply.arithemeticeval@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
			message.setSubject(subject);
			message.setText(content);

			Transport.send(message);

			LOGGER.log(Level.INFO, "Mail has been sent successfully to " +toAddress);

		} catch (MessagingException e) {
			LOGGER.log(Level.SEVERE, "Error" , e);
		}
	}

}

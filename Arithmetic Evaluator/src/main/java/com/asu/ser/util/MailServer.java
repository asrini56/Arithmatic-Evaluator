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
import java.util.logging.Level;
import java.util.logging.Logger;

public class MailServer {

	private static final String USERNAME = "team8.ser515@gmail.com";
	private static final String PASSWORD = "aujisrmliyexaydg";

	public static void sendMail(String toAddress, String subject, String content) throws Exception {
		 Properties properties = new Properties();
	        properties.setProperty("mail.smtp.host", "smtp.zoho.com");
	        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
	        properties.setProperty("mail.smtp.port", "465");
	        properties.setProperty("mail.smtp.socketFactory.port", "465");
	        properties.put("mail.smtp.starttls.enable", "true");
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.debug", "true");
	        properties.put("mail.store.protocol", "pop3");
	        properties.put("mail.transport.protocol", "smtp");
	        properties.put("mail.debug.auth", "true");
	        properties.setProperty( "mail.pop3.socketFactory.fallback", "false");
	        Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator() 
	        {   @Override
	            protected PasswordAuthentication getPasswordAuthentication() 
	            {   return new PasswordAuthentication("team8.ser515@zoho.com","Qwertyui@9");
	            }
	        });
	        try 
	        {   MimeMessage message = new MimeMessage(session);
	            message.setFrom(new InternetAddress("team8.ser515@zoho.com"));
	            message.setRecipients(MimeMessage.RecipientType.TO,InternetAddress.parse(toAddress));
	            message.setSubject(subject);
	            message.setText(content);
	            Transport.send(message);
	        } 
	        catch (MessagingException e) 
	        {
				LOGGER.log(Level.SEVERE, "Error" , e);
	        }

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

			System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}

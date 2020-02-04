package com.iaco2code.springdemo.sendemail;

import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailUtil {

	public static void sendMail(String recepient,String codice) throws Exception {
		System.out.println("Preparing to send email");
		Properties properties= new Properties();
		
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port","587");
		
		String myAccountEmail = "andrea.iacovone@scaiconsulting.it";
		String password="Consulting%2";
//		mail.smtp.outh
//		mail.smtp.starttls.enable
//		mail.smtp.host
//		mail.smt.port
		
		
		Session session = Session.getInstance(properties,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication(myAccountEmail,password);
			}
		});
		
		Message message = prepareMessage(session,myAccountEmail,recepient,codice); 
		
		Transport.send(message);
		System.out.println("Message sent succesfully");
	}
	
	
	
	private static Message prepareMessage(Session session,String myAccountEmail,String recepient,String codice) {
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("My First Email from Java App");
			String htmlCode= "<h1> WE LOVE JAVA </h1> <br/> <h2> <b> Next Line <b></h2>"+codice+"";
			message.setContent(htmlCode,"text/html");
			message.setFrom(new InternetAddress(myAccountEmail));
			return message;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE,null,e);
		}
		return null;
	}
}

















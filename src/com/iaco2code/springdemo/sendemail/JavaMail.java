package com.iaco2code.springdemo.sendemail;


public class JavaMail {

	public static void send_email(String email,String codice) {
		try {
			JavaMailUtil.sendMail(email,codice);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package com.iaco2code.springdemo.sendemail;

import java.util.Random;

public class Code {

	
	
	public static String generateCode() {
		Random rnd = new Random();
		int n = 100000 + rnd.nextInt(900000);
		String a = String.valueOf(n);
		return a;
	}
}

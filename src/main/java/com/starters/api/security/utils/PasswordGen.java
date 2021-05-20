package com.starters.api.security.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGen {

	public static void main(String[] args) {
		
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
			System.out.println(encoder.encode("starter"));
		}
}


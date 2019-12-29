package com.rs.fer.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HBUtil;

public class RegistrationMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();

		User user = new User();

		user.setFirstname("wwwwqqq");
		user.setMiddlename("sudhan");
		user.setLastname("kamireddy");
		user.setUsername("madhu");
		user.setPassword("madhu");
		user.setEmail("madhu@rs.com");
		user.setMobile("133145565");

		boolean isRegister = ferService.registration(user);

		if (isRegister) {
			System.out.println("Registration is done successfully...");
		} else {
			System.out.println("Registration is failed...");
		}

	}

}

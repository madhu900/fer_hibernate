package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class LoginMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();

		boolean login = ferService.login("madhu", "madhu");
		if (login) {
			System.out.println("login success");
		} else {
			System.out.println("fail to login");
		}

	}
}

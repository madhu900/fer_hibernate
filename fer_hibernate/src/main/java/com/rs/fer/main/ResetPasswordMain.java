package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class ResetPasswordMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();

		boolean resetPassword = ferService.resetPassword(1, "1234", "madhu");

		if (resetPassword) {
			System.out.println("resetPassword success");
		} else {
			System.out.println("fail to resetPassword");
		}

	}

}

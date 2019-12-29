package com.rs.fer.main;


import java.util.Optional;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetUserMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();
		int userid = 3;
		User getUser = ferService.getUser(userid);
	Optional<User> isExistence = Optional.ofNullable(getUser);
		if (isExistence.isPresent()) {
			System.out.println(getUser.getEmail());
			System.out.println("Record Fetched Successful");

		} else {
			System.out.println("failed");
		}

	}

}

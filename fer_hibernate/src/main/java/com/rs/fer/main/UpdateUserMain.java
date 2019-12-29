package com.rs.fer.main;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class UpdateUserMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();

		User user = new User();

		user.setId(3);
		user.setFirstname("madhu");
		user.setMiddlename("sudhan");
		user.setLastname("kamireddy");
		user.setEmail("rs@gamil.com");
		user.setMobile("122637373");

		Address address = new Address();
		address.setId(4);
		address.setAddress1("madhapur");
		address.setAddress2("hyd");
		address.setCity("HYD");
		address.setState("TS");
		address.setCountry("India");
		address.setZip("6374789");
		address.setUserid(1);

		user.setAddress(address);
		boolean updatePersonal = ferService.updateUser(user);
		if (updatePersonal) {
			System.out.println("successfully...");
		} else {
			System.out.println("Failed..");
		}

	}

}

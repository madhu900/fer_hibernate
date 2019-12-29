package com.rs.fer.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HBUtil;

public class DeleteExpenseMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();

		boolean deleteExpense = ferService.deleteExpense(1);

		if (deleteExpense) {
			System.out.println("deleted success");
		} else {
			System.out.println("fail to Delete");
		}

	}

}

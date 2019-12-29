package com.rs.fer.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HBUtil;

public class AddExpenseMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();

		Expense expense = new Expense();

		expense.setExpensetype("type1");
		expense.setDate("2019-11-27");
		expense.setPrice(100);
		expense.setNoofitems(1);
		expense.setTotal(1);
		expense.setBywhom("madhu");
		expense.setUserid(2);

		boolean addExpenseRec = ferService.addExpense(expense);

		if(addExpenseRec) {
			System.out.println("Expense Added successfully...");
		} else {
			System.out.println("Expense Added  failed...");
		}

	}

}

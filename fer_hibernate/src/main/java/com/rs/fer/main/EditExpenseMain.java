package com.rs.fer.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HBUtil;

public class EditExpenseMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();

		Expense expense = new Expense();

		expense.setId(1);
		expense.setExpensetype("type3");
		expense.setDate("2019-11-26");
		expense.setPrice(200);
		expense.setNoofitems(2);
		expense.setTotal(2);
		expense.setBywhom("sudhan");

		boolean editExpense = ferService.editExpense(expense);

		if (editExpense) {
			System.out.println("Expense Edited successfully...");
		} else {
			System.out.println("Expense Edited  failed...");
		}

	}

}

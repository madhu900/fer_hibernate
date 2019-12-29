package com.rs.fer.main;

import java.util.Iterator;
import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetExpensesMain {

	public static void main(String[] args) {

		FERService ferservice = new FERServiceImpl();
		int userid = 1;
		List<Expense> expenses = ferservice.getExpenses(userid);

		for (Expense expense : expenses) {
			System.out.println(expense.getId());
		}

	}

}

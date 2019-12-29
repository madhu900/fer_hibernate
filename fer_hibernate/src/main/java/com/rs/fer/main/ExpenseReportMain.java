package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class ExpenseReportMain {

	public static void main(String[] args) {

		FERService ferservice = new FERServiceImpl();
		int id = 1;
		String expensetype = "type1";
		String fromdate = "2019-11-27";
		String todate = "2019-11-27";
		List<Expense> expenseReport = ferservice.expenseReport(id, expensetype, fromdate, todate);

	}

}

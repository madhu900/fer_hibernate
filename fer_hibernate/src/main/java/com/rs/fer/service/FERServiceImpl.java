package com.rs.fer.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.util.HBUtil;

public class FERServiceImpl implements FERService {

	public boolean registration(User user) {
		boolean isRegister = false;
		try {
			Integer numberOfRecordInserted = (Integer) HBUtil.getSession().save(user);
			HBUtil.getTranctionCommit();
			System.out.println("no of records inserted:" + numberOfRecordInserted);
			isRegister = numberOfRecordInserted > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HBUtil.closeSession();
		}
		return isRegister;

	}

	public boolean login(String username, String password) {
		boolean isLogin = false;
		try {
			isLogin = HBUtil.getSession().createQuery("from User u where u.username=? and u.password=?")
					.setParameter(0, username).setParameter(1, password).list().stream().iterator().hasNext();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HBUtil.closeSession();
		}
		return isLogin;
	}

	public boolean editExpense(Expense expense) {

		boolean editExpenseRec = false;
		Session session = HBUtil.getSession();
		try {
			session.update(expense);
			HBUtil.getTranctionCommit();
			editExpenseRec = true;
		} catch (Exception e) {
			editExpenseRec = true;
			e.printStackTrace();

		} finally {
			HBUtil.closeSession();
		}
		return editExpenseRec;
	}

	public boolean deleteExpense(int expenseId) {

		boolean deletexpenseRec = false;
		Session session = HBUtil.getSession();
		try {
			Expense expense = (Expense) session.load(Expense.class, new Integer(expenseId));
			session.delete(expense);
			HBUtil.getTranctionCommit();
			deletexpenseRec = true;

		} catch (Exception e) {
			deletexpenseRec = false;
			e.printStackTrace();
		} finally {
			HBUtil.closeSession();
		}
		return deletexpenseRec;
	}

	public boolean resetPassword(int userId, String currentPassword, String newPassword) {

		boolean resetPassword = false;
		Session session = HBUtil.getSession();
		try {
			User user = (User) session.load(User.class, userId);
			if (currentPassword.equals(user.getPassword())) {
				user.setPassword(newPassword);
				HBUtil.getTranctionCommit();
				resetPassword = true;
			}
			System.out.println(newPassword + ", " + userId + ", " + currentPassword);

		} catch (Exception e) {
			resetPassword = false;
			e.printStackTrace();
		} finally {
			HBUtil.closeSession();
		}

		return resetPassword;
	}

	public List<Expense> getExpenses(int userId) {

		Session session = HBUtil.getSession();
		Transaction transaction = null;
		List<Expense> expenses = new ArrayList<Expense>();
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Expense where userId=?");
			query.setParameter(0, userId);
			transaction.commit();
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return expenses;
	}

	public Expense getExpense(int expenseId) {
		Session session = HBUtil.getSession();
		Expense expense = null;
		try {
			expense = (Expense) session.load(Expense.class, expenseId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HBUtil.closeSession();
		}

		return expense;
	}

	@SuppressWarnings("unchecked")
	public List<Expense> expenseReport(int userId, String expenseType, String fromDate, String toDate) {
		List expenseReport = new ArrayList();

		try {

			HBUtil.getSession().createQuery("from expense where expensetype=? and date between ? and ?")
					.setParameter(1, expenseType).setParameter(2, fromDate).setParameter(3, toDate).list().stream()
					.forEach(expense -> {
						expenseReport.add(expense);
					});

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HBUtil.closeSession();
			;
		}

		return expenseReport;
	}

	@SuppressWarnings("unchecked")
	public User getUser(int userId) {

		User user = new User();

		try {
			Query setParameter = HBUtil.getSession()
					.createQuery("from User u LEFT JOIN Address a ON u.id=a.userid WHERE u.id=?")
					.setParameter(1, userId);
			List list = setParameter.list();
			Iterator iterator = list.iterator();
			while (iterator.hasNext()) {
				user = (User) iterator.next();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HBUtil.closeSession();
		}

		return user;
	}

	public boolean updateUser(User user) {

		boolean isUpdate = false;

		try {
			HBUtil.getSession().saveOrUpdate(user);
			HBUtil.getTranctionCommit();
			isUpdate = true;
		} catch (Exception e) {
			isUpdate = false;
			e.printStackTrace();
		} finally {
			HBUtil.closeSession();
		}

		return isUpdate;
	}

	public boolean addExpense(Expense expense) {

		int addExpenseRec = 0;

		try {

			addExpenseRec = (Integer) HBUtil.getSession().save(expense);
			HBUtil.getTranctionCommit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HBUtil.closeSession();
		}

		return addExpenseRec > 0;
	}

}

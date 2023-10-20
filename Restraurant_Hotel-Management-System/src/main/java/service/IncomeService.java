package service;

import dao.IncomeDao;

public class IncomeService {
	IncomeDao incomeDao=new IncomeDao();
	public boolean updateIncome(double income) {
		return incomeDao.updateIncome(income);
	}
}

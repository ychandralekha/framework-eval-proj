package com.cts.dao;

import java.text.ParseException;
import java.util.List;

import com.cts.bean.CustomerAccount;
import com.cts.bean.TotalCustomerDetails;
import com.cts.exception.BankException;

public interface ICustomerBank {
	public boolean addNewCustomer(CustomerAccount customer,
			String selectedBankName) throws BankException;

	public List<TotalCustomerDetails> finalBalance() throws ParseException,
			BankException;
}

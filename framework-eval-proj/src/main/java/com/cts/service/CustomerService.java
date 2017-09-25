package com.cts.service;

import java.text.ParseException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.bean.CustomerAccount;
import com.cts.bean.TotalCustomerDetails;
import com.cts.dao.CustomerDaoImplementation;
import com.cts.exception.BankException;

@Service("customerService")
public class CustomerService {
	public static final Logger LOG = Logger.getLogger(CustomerService.class);
	@Autowired
	CustomerDaoImplementation customerDao;

	public boolean addCustomer(CustomerAccount customer, String selectedBankName)
			throws BankException {
		LOG.info("adding customer -service");
		return customerDao.addNewCustomer(customer, selectedBankName);
	}

	public List<TotalCustomerDetails> displayCustomer() throws ParseException,
			BankException {
		LOG.info("display customer -service");
		return customerDao.finalBalance();
	}
}

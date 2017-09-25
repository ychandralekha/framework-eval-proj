package com.cts.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.bean.Banks;
import com.cts.dao.BankDaoImplementation;
import com.cts.exception.BankException;

@Service("bankService")
public class BankService {
	public static final Logger LOG = Logger.getLogger(BankService.class);
	@Autowired
	BankDaoImplementation bankDao;

	public boolean addBank(Banks bank) throws BankException {
		LOG.info("add a bank-service");
		return bankDao.addBank(bank);
	}

	public boolean editBank(String oldName, String changedName)
			throws BankException {
		LOG.info("edit a bank-service");
		return bankDao.editBank(oldName, changedName);
	}

	public List<Banks> displayBank() {
		LOG.info("display a bank-service");
		return bankDao.displayBank();
	}

	public boolean deleteBank(String oldBank) throws BankException {
		LOG.info("delete a bank-service");
		return bankDao.deleteBank(oldBank);
	}
}

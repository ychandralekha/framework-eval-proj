package com.cts.dao;

import java.util.List;

import com.cts.bean.Banks;
import com.cts.exception.BankException;

public interface IAdminBank {
	public boolean addBank(Banks bank) throws BankException;

	public boolean editBank(String oldBankName, String changedBank)
			throws BankException;

	public List<Banks> displayBank() throws BankException;

	public boolean deleteBank(String oldBank) throws BankException;
}

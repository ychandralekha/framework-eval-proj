package com.cts.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.bean.Banks;
import com.cts.bean.CustomerAccount;
import com.cts.bean.TotalCustomerDetails;
import com.cts.exception.BankException;

@Repository("customerDao")
public class CustomerDaoImplementation implements ICustomerBank {
	public static final Logger LOG = Logger
			.getLogger(CustomerDaoImplementation.class);
	@Autowired
	SessionFactory sessionFactory;
	Session session;

	public boolean addNewCustomer(CustomerAccount customer,
			String selectedBankName) throws BankException {
		try {
			LOG.info("adding new customer");
			System.out.println(customer);
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Banks banks = new Banks();
			banks.setBankName(selectedBankName);
			customer.setBanks(banks);
			System.out.println(customer);
			session.save(customer);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			throw new BankException("Error in adding Customer");
		}
		return true;
	}

	public List<TotalCustomerDetails> finalBalance() throws ParseException,
			BankException {
		try {
			LOG.info("Set of records with final balance");
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			sdf.setLenient(false);
			long days = 0;
			long finalBalance = 0;
			session = sessionFactory.openSession();
			Query query = session.createQuery("from customer");
			List<CustomerAccount> customerAccounts = query.list();
			List<TotalCustomerDetails> totalCustomerDetails = new ArrayList<TotalCustomerDetails>();
			for (CustomerAccount account : customerAccounts) {
				System.out.println(account);
				TotalCustomerDetails totalDetails = new TotalCustomerDetails();
				Date enteredDate = sdf.parse(account.getDate());
				int balance = account.getAmount();
				if (account.getTenure() != null) {
					Date currentDate = Calendar.getInstance().getTime();
					long diff = currentDate.getTime() - enteredDate.getTime();
					days = diff / 1000 / 60 / 60 / 24;
					finalBalance = balance
							+ (((balance * (7 / 100)) / 365) * days);
				} else {
					finalBalance = balance;
				}
				totalDetails.setAccountNumber(account.getAccountNumber());
				totalDetails.setAccountType(account.getAccountType());
				totalDetails.setAmount(account.getAmount());
				totalDetails.setDate(account.getDate());
				totalDetails.setFinalAmount(finalBalance);
				totalDetails.setName(account.getName());
				if (account.getTenure() != null)
					totalDetails
							.setTenure(String.valueOf((account.getTenure())));
				else
					totalDetails.setTenure("Not Applicable");

				System.out.println(totalDetails);
				totalCustomerDetails.add(totalDetails);
			}
			session.close();
			return totalCustomerDetails;
		} catch (Exception e) {
			throw new BankException("Display error");
		}
	}
}

package com.cts.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.bean.Banks;
import com.cts.exception.BankException;

@Repository("bankDao")
public class BankDaoImplementation implements IAdminBank {
	public static final Logger LOG = Logger
			.getLogger(BankDaoImplementation.class);
	@Autowired
	SessionFactory sessionFactory;
	Session session;

	public boolean addBank(Banks bank) throws BankException {
		try {

			LOG.info("adding a bank -dao");
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(bank);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			throw new BankException("Bank already exists");
		}
		return true;
	}

	public boolean editBank(String oldBankName, String changedBank)
			throws BankException {
		try {
			LOG.info("edit bank -dao");
			session = sessionFactory.openSession();

			Query query = session
					.createQuery("update Banks set bankName=:newBankName where bankName=:oldBankName");
			query.setString("oldBankName", oldBankName);
			query.setString("newBankName", changedBank);

			query.executeUpdate();
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			session.close();
		} catch (Exception e) {
			throw new BankException("edit wasn't successful");
		}
		return true;
	}

	public List<Banks> displayBank() {
		LOG.info("display banks -dao");
		List<Banks> banks = new ArrayList<Banks>();
		session = sessionFactory.openSession();
		Query query = session
				.createQuery("from Banks where displayStatus=:display");
		query.setString("display", "1");
		banks = query.list();
		session.close();
		return banks;
	}

	public boolean deleteBank(String oldBank) throws BankException {
		try {
			LOG.info("delete bank- dao");
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Query query = session
					.createQuery("update Banks set displayStatus=:olddisplayStatus where displayStatus=:newdisplayStatus and bankName=:bank");
			query.setString("olddisplayStatus", "0");
			query.setString("newdisplayStatus", "1");
			query.setString("bank", oldBank);
			query.executeUpdate();
			transaction.commit();
			session.close();
		} catch (Exception e) {
			throw new BankException("Delete unsuccessful");
		}
		return true;
	}
}

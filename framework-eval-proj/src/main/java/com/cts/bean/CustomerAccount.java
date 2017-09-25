package com.cts.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerAccount {
	@Id
	private String accountNumber;
	private String name;
	private String accountType;
	private Integer amount;
	private String date;
	private Integer tenure;
	private String display = "1";
	@ManyToOne
	@JoinColumn(name = "nameOfBank")
	private Banks banks;

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public Banks getBanks() {
		return banks;
	}

	public void setBanks(Banks banks) {
		this.banks = banks;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getTenure() {
		return tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	public CustomerAccount(String accountNumber, String name,
			String accountType, Integer amount, String date, Integer tenure,
			String display, Banks banks) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.accountType = accountType;
		this.amount = amount;
		this.date = date;
		this.tenure = tenure;
		this.display = display;
		this.banks = banks;
	}

	public CustomerAccount() {
		super();
	}

	@Override
	public String toString() {
		return "accountNumber=" + accountNumber + ", name=" + name
				+ ", accountType=" + accountType + ", amount=" + amount
				+ ", date=" + date + ", tenure=" + tenure + ", display="
				+ display + ", banks=" + banks;
	}

}

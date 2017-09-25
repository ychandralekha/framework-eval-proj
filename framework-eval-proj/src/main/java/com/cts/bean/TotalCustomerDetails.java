package com.cts.bean;

public class TotalCustomerDetails {
	private String accountNumber;
	private String name;
	private String accountType;
	private Integer amount;
	private String date;
	private String tenure;
	private Long FinalAmount;

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

	public String getTenure() {
		return tenure;
	}

	public void setTenure(String tenure) {
		this.tenure = tenure;
	}

	public Long getFinalAmount() {
		return FinalAmount;
	}

	public void setFinalAmount(Long finalAmount) {
		FinalAmount = finalAmount;
	}

	@Override
	public String toString() {
		return "accountNumber=" + accountNumber + ", name=" + name
				+ ", accountType=" + accountType + ", amount=" + amount
				+ ", date=" + date + ", tenure=" + tenure + ", FinalAmount="
				+ FinalAmount;
	}
}

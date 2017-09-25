package com.cts.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AdminBank")
public class Banks {
	@Id
	private String bankName;
	private String displayStatus = "1";

	public String getDisplayStatus() {
		return displayStatus;
	}

	public void setDisplayStatus(String displayStatus) {
		this.displayStatus = displayStatus;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public String toString() {
		return "bankName=" + bankName;
	}

	public Banks(String bankName) {

		this.bankName = bankName;
		this.displayStatus = "1";
	}

	public Banks() {

	}

}

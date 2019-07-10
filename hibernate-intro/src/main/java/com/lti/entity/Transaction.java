package com.lti.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TBL_TRANSACTION")
public class Transaction {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="TX_NO")
	private long txno;
	
	@Column(name="TX_DATE")
	private Date date;
	@Column(name="TX_TYPE")
	private String type;
	private double amount;
	
	@ManyToOne
	private Account account;

	public long getTxno() {
		return txno;
	}

	public void setTxno(long txno) {
		this.txno = txno;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
	
	
}

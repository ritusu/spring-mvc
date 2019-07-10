package com.lti.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "TBL_ACCOUNT")

public class Account {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="AC_NO")
	private long acno;
	@Column(name = "AC_TYPE")
	private String type;
	
	private String name;
	private double balance;
	
	@OneToMany(mappedBy="account")//this mapped by value comes from the transaction table in which account object is kept
	private Set<Transaction> transactions;

	public long getAcno() {
		return acno;
	}

	public void setAcno(long acno) {
		this.acno = acno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}	
	
	

}

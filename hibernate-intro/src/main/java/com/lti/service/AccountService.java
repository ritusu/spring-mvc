package com.lti.service;

import java.util.Date;
import java.util.List;

import com.lti.Dao.AccountDao;
import com.lti.Dao.CustomerDao;
import com.lti.entity.Account;
import com.lti.entity.Customer;
import com.lti.entity.Transaction;

//classes which contain business logicare commonly referred as service classes
//people who use this naming conversation in webServices(SOAP/REST)
public class AccountService {
	
	public void openAccount(Account acc) {
		
		AccountDao dao=new AccountDao();
		dao.save(acc);
		//apart from this we might write/execute the code for sending email to the customer here
	}
	
	public void withdraw(long acno, double amount) {
		AccountDao dao=new AccountDao();
		Account acc=(Account) dao.fetchById(Account.class,acno);
		
		Transaction tx=new Transaction();
		if(acc.getBalance()-amount>0) {
		     
			acc.setBalance(acc.getBalance()-amount);
		
			tx.setAccount(acc);
			tx.setDate(new Date());
			tx.setType("Withdraw");
		
			
			dao.save(tx);
			dao.save(acc);
		}
		
	}
	
	public void deposit(long acno, double amount) {
		AccountDao dao=new AccountDao();
		Account acc=(Account) dao.fetchById(Account.class,acno);
		
		Transaction tx=new Transaction();
		acc.setBalance(acc.getBalance()+amount);
		tx.setAccount(acc);
		tx.setDate(new Date());
		tx.setType("Deposit");
	
		
		dao.save(tx);
		dao.save(acc);
	}
	
	public void transfer(long fromAcno,long toAcno, double amount) {
		AccountDao dao=new AccountDao();
		Account acc1=(Account) dao.fetchById(Account.class,fromAcno);
		Account acc2=(Account) dao.fetchById(Account.class,toAcno);
		
		acc1.setBalance(acc1.getBalance()-amount);
		acc2.setBalance(acc2.getBalance()+amount);
		dao.save(acc1);
		dao.save(acc2);
		
		Transaction tx1=new Transaction();
		tx1.setAccount(acc1);
		tx1.setDate(new Date());
		tx1.setType("Money Transfer");
		tx1.setAmount(amount);
		
		Transaction tx2=new Transaction();
		tx2.setAccount(acc1);
		tx2.setDate(new Date());
		tx2.setType("Money recieved");
		tx2.setAmount(amount);
		
		dao.save(tx1);
		dao.save(tx2);
	
		
	}
	
	public double checkBalance(long acno) {
		AccountDao dao=new AccountDao();
		Account acc=(Account) dao.fetchById(Account.class,acno);
		return acc.getBalance();
	}
	
	public List<Transaction> miniStatement(long acno){
	
		AccountDao  dao= new AccountDao();
		List<Transaction> tx= dao.fetchMiniStatement(acno);
		for(Transaction a : tx) {
			System.out.println(a.getAmount());
			System.out.println(a.getTxno());
			System.out.println(a.getDate());
			System.out.println(a.getType());
		
	}
		return tx;

}
	

}

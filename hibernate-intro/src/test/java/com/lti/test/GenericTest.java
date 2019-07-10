package com.lti.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.lti.Dao.AccountDao;
import com.lti.Dao.GenericDao;
import com.lti.entity.Account;
import com.lti.entity.Album;
import com.lti.entity.Transaction;
import com.lti.service.AccountService;

public class GenericTest {

	
	@Test
	public void testOpenAccount() {
		AccountService accServ=new AccountService();
		Account acc=new Account();
		acc.setName("Khushboo");
		acc.setType("Savings");
		acc.setBalance(50000);
		accServ.openAccount(acc);
		
	}
	
	
	@Test
	public void testWithdrawAccount() {
	
		AccountService accServ=new AccountService();
	//	accServ.withdraw(141,100);

		Transaction tx=new Transaction();
		tx.setAmount(100);
		accServ.withdraw(141,tx.getAmount());
		
	
	
	}
	
	@Test
	public void testDepositAccount() {
	
		AccountService accServ=new AccountService();
	//	accServ.withdraw(141,100);
	
		Transaction tx=new Transaction();
		tx.setAmount(100);
		accServ.deposit(141,tx.getAmount());
		
	
	
	}
	
	@Test
	public void testTransferAccount() {
	
		AccountService accServ=new AccountService();
	//	accServ.withdraw(141,100);
	
		Transaction tx=new Transaction();
		tx.setAmount(1000);
		accServ.transfer(151,148,tx.getAmount());
		
	
	
	}
	
	@Test
	public void testFetch() {
		
		AccountService accServ=new AccountService();
		accServ.miniStatement(141);
	}
	
	@Test
	public void testFetchAccount() {
		
		AccountDao dao=new AccountDao();
		List<Account> acc= dao.fetchAccountByBalance(39000);
		for(Account a : acc) {
			System.out.println(a.getAcno());
			System.out.println(a.getBalance());
			System.out.println(a.getName());
			System.out.println(a.getType());
		
	}
	}
	
	
	@Test
	public void testFetchAccountByTrans() {
		
		AccountDao dao=new AccountDao();
	
		List<Account> acc= dao.fetchAccountByTransaction("Withdraw",100);
		for(Account a : acc) {
			System.out.println(a.getAcno());
			System.out.println(a.getBalance());
			System.out.println(a.getName());
			System.out.println(a.getType());
		
	}
	}
	

	
	
	}




package com.lti.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("hdfc")
public class ATMimplByHdfc implements ATM {

	@Autowired
	@Qualifier("icici")
	Bank bank;
	public void withdraw(double amount) {
		System.out.println("in hdfc");
		bank.communicate(amount);
		
		
	}

	
}

package com.lti.component;

import org.springframework.stereotype.Component;

@Component("icici")
public class BankImplByIcici implements Bank {

	public double communicate(double amount) {
	    System.out.println("in icici");
		return amount * 100;
	}

}

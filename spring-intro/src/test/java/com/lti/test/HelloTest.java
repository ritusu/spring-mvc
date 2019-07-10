package com.lti.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.component.ATM;
import com.lti.component.Calculator;
import com.lti.component.CurrencyConverter;
import com.lti.component.HelloWorld;
import com.lti.component.HelloWorldInterface;
import com.lti.component.TextEditor;

public class HelloTest {

	public static void main(String[] args) {
		//loading Spring's IoC container
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		
		for(int i=0 ;i<5;i++) {
		//accessing one of the bean
		HelloWorldInterface hw= (HelloWorldInterface) context.getBean("hw"); //bean id
		System.out.println(hw.sayHello("Shreena"));
		}
		
		/*
		 * Calculator cc=(Calculator) context.getBean("cal");
		 * System.out.println(cc.add(15,15)); System.out.println(cc.sub(0,15));
		 * 
		 * CurrencyConverter conv=(CurrencyConverter) context.getBean("cc");
		 * System.out.println(conv.convertDollarToRupees(50));
		 * 
		 * TextEditor te=(TextEditor)context.getBean("te"); te.load("document");
		 * 
		 * ATM atm=(ATM)context.getBean("hdfc"); atm.withdraw(10);
		 */
	}
}

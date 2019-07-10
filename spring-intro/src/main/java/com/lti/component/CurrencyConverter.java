package com.lti.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//component annotation is used to tell spring to create the object of that class
//"cc" ---> is the ID (which is similar to bean ID)
@Component("cc") //alternative to <bean id= "..."  class= "...">
public class CurrencyConverter {

	@Autowired
	private CurrentValueOfDollar cv;
	
	public double convertDollarToRupees(double dollars) {
		return dollars * cv.dollarValue()  ;
	}
}
 
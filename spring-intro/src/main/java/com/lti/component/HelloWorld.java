package com.lti.component;

public class HelloWorld implements HelloWorldInterface {

	public HelloWorld() {
		System.out.println("Constructor of HelloWorld");
		
	}
	public String sayHello(String name) {
		return "Hello" + name;
	}
}
package com.lti.component;

import org.springframework.stereotype.Component;

@Component("sc")
public class SpellChecker {

	
	public void spellCheck(String doc) {
	System.out.println(doc+"in spell checker");
}
}


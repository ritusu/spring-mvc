package com.lti.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("te")
public class TextEditor {
	
    @Autowired
	private SpellChecker sp;
	
    public void load(String doc) {
	//	SpellChecker sc=new SpellChecker();
		System.out.println(doc+"in load of texteditor");
    	sp.spellCheck(doc);
	}
}

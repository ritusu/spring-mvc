package com.lti.training.exam.model;

import java.util.ArrayList;
import java.util.List;

public class QuestionBankLoader {

	Option o1, o2, o3, o4;
	List<Option> opts;
	Question q;

	public List<Question> fetchQuestionsOnJava() {

		QuestionBank qb = new QuestionBank();
		qb.addNewSubject("Java");
		// New Question
		q = new Question();
		q.setQuestion("what is a class?");
		List<Option> opts = new ArrayList<Option>();

		o1 = new Option();
		o1.setOption("class is an template for an object");
		o1.setRightAnswer(true);

		o2 = new Option();
		o2.setOption("class is an instance of an object");
		o2.setRightAnswer(false);

		o3 = new Option();
		o3.setOption("class is an another name for object");
		o3.setRightAnswer(false);

		o4 = new Option();
		o4.setOption("all of the above");
		o4.setRightAnswer(false);

		opts.add(o1);
		opts.add(o2);
		opts.add(o3);
		opts.add(o4);
		q.setOptions(opts);
		qb.addNewQuestion("Java", q);

		// New Question
		q = new Question();
		q.setQuestion("What is the range of short data type in Java?");
		opts = new ArrayList<Option>();

		Option o1 = new Option();
		o1.setOption("-128 to 127");
		o1.setRightAnswer(false);

		Option o2 = new Option();
		o2.setOption("-32768 to 32767");
		o2.setRightAnswer(true);

		Option o3 = new Option();
		o3.setOption("-2147483648 to 2147483647");
		o3.setRightAnswer(false);

		Option o4 = new Option();
		o4.setOption("None of the mentioned");
		o4.setRightAnswer(false);

		opts.add(o1);
		opts.add(o2);
		opts.add(o3);
		opts.add(o4);
		q.setOptions(opts);
		qb.addNewQuestion("Java", q);

		// New Question
		q = new Question();
		q.setQuestion("Which of these selection statements test only for equality?");
		opts = new ArrayList<Option>();

		o1 = new Option();
		o1.setOption("if");
		o1.setRightAnswer(false);

		o2 = new Option();
		o2.setOption("switch");
		o2.setRightAnswer(true);

		o3 = new Option();
		o3.setOption("if & switch");
		o3.setRightAnswer(false);

		o4 = new Option();
		o4.setOption("none of the mentioned");
		o4.setRightAnswer(false);

		opts.add(o1);
		opts.add(o2);
		opts.add(o3);
		opts.add(o4);
		q.setOptions(opts);
		qb.addNewQuestion("Java", q);

		// New Question
		q = new Question();
		q.setQuestion("Which of these jump statements can skip processing the remainder of the code in its body for a particular iteration?");
		opts = new ArrayList<Option>();

		o1 = new Option();
		o1.setOption("break");
		o1.setRightAnswer(false);

		o2 = new Option();
		o2.setOption("return");
		o2.setRightAnswer(false);

		o3 = new Option();
		o3.setOption("exit");
		o3.setRightAnswer(false);

		o4 = new Option();
		o4.setOption("continue");
		o4.setRightAnswer(true);

		opts.add(o1);
		opts.add(o2);
		opts.add(o3);
		opts.add(o4);
		q.setOptions(opts);
		qb.addNewQuestion("Java", q);

		// New Question
		q = new Question();
		q.setQuestion("Which of these method of String class is used to obtain character at specified index?");
		opts = new ArrayList<Option>();

		o1 = new Option();
		o1.setOption("char()");
		o1.setRightAnswer(false);

		o2 = new Option();
		o2.setOption("Charat()");
		o2.setRightAnswer(false);

		o3 = new Option();
		o3.setOption("charat()");
		o3.setRightAnswer(false);

		o4 = new Option();
		o4.setOption("charAt()");
		o4.setRightAnswer(true);

		opts.add(o1);
		opts.add(o2);
		opts.add(o3);
		opts.add(o4);
		q.setOptions(opts);
		qb.addNewQuestion("Java", q);

		
		return qb.getQuestionsFor("Java");
	}
}

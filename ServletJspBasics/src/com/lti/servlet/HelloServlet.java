package com.lti.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
//@WebServlet("/hello.lti")
public class HelloServlet extends HttpServlet {
	
	
	public void init()  throws ServletException{
		System.out.println("init called...");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do get called......");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	public void destroy() {
		System.out.println("Destroy called....!");
	
	}

}

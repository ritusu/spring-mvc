package com.lti.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.exception.DataAccessException;
import com.lti.training.Product;
import com.lti.training1.ProductDao;

@WebServlet("/ProductControllerServlet")
public class ProductControllerServlet extends HttpServlet {
	int pagesize=5;
	int currentPosition=0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String page=request.getParameter("page");
	if(page!=null) {
		if(page.equals("next"))
			currentPosition+=pagesize;
		else if(page.equals("prev"))
			currentPosition -=pagesize;
	
	}
	else
		currentPosition=0;
 ProductDao dao=new ProductDao();
 try {
	List<Product> products=dao.fetchProducts(currentPosition, currentPosition+pagesize);
HttpSession session=request.getSession();
session.setAttribute("current5products", products);
response.sendRedirect("viewProducts.jsp");
 
 }
 catch (DataAccessException e) {
	throw new ServletException("ProductControllerServlet encountered "+"problem while accessing the dao",e);
}
	
	
	
	}
}

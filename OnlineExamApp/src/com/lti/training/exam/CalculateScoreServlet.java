package com.lti.training.exam;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.training.exam.model.Option;
import com.lti.training.exam.model.Question;

/**
 * Servlet implementation class CalculateScoreServlet
 */
@WebServlet("/CalculateScoreServlet")
public class CalculateScoreServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//picking up the current question from the Session
		HttpSession session = request.getSession();
		Question q= (Question) request.getSession().getAttribute("currentQs");
		
		//reading value of the Radio Button
		int optionSelected = Integer.parseInt(request.getParameter("op"));
		
		//int score=0;
		Integer score = (Integer)session.getAttribute("score");
		if(score==null)
			score=0;
		//checking if the selected option is the right answer
		
		Option op = q.getOptions().get(optionSelected);
		if(op.isRightAnswer())
			score++;
		
		session.setAttribute("score", score);
		response.sendRedirect("QuestionLoaderServlet");
		
	}

}

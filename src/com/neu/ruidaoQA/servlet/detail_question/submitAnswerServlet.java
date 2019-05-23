package com.neu.ruidaoQA.servlet.detail_question;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class submitAnswer
 */
@WebServlet("/submitAnswer")
public class submitAnswerServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ans_text = request.getParameter("ans_text");
		String user_id = request.getParameter("user_id");
		String question_id = request.getParameter("question_id");
		String ans_time = request.getParameter("ans_time");
		//System.out.println(ans_text+"-------"+user_id+"-------"+question_id+"---"+ans_time);
		
		
	}

}

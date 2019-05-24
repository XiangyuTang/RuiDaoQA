package com.neu.ruidaoQA.servlet.detail_question;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.ruidaoQA.entity.Question;
import com.neu.ruidaoQA.service.impl.QuestionServiceimpl;

/**
 * Servlet implementation class toDetailQuesServlet
 */
@WebServlet("/toDetailQues")
public class toDetailQuesServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Integer question_id = Integer.parseInt(request.getParameter("question_id"));
		QuestionServiceimpl qsip = new QuestionServiceimpl();
		Question q = qsip.getQuestion(question_id);
		request.getSession().setAttribute("Question", q);
		response.sendRedirect("detailQues.html");
		//request.getRequestDispatcher("detailQues.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}

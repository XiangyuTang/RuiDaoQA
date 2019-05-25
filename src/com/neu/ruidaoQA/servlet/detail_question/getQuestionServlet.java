package com.neu.ruidaoQA.servlet.detail_question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.ruidaoQA.dao.impl.QuestionDaoimpl;
import com.neu.ruidaoQA.entity.Question;
import com.sun.istack.internal.Pool.Impl;

/**
 * Servlet implementation class getServlet
 */
@WebServlet("/getQuestionServlet")
public class getQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	QuestionDaoimpl impl = new QuestionDaoimpl();
	
    public getQuestionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Question selectQuestion = impl.selecctQuestion(q);
		
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		//与数据库交互的方法
		HttpSession session = request.getSession();
		List<Question> getQuestionByType = impl.getQuestionByType(1);
		//System.out.println(getQuestionByType.indexOf(0));
		session.setAttribute("getQuestionByType", getQuestionByType);
		System.out.println(getQuestionByType.get(1).getQues_title());
		session.setAttribute("title1", getQuestionByType.get(0).getQues_title().toString());
		//response.sendRedirect("loginIndex.jsp");
		request.getRequestDispatcher("loginIndex.jsp").forward(request, response);
		


	}

}

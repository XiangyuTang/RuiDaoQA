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
import com.neu.ruidaoQA.entity.Question;
import com.neu.ruidaoQA.service.impl.QuestionServiceimpl;
import com.sun.istack.internal.Pool.Impl;

/**
 * Servlet implementation class getServlet
 */
@WebServlet("/getQuestionServlet")
public class getQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	QuestionServiceimpl impl = new QuestionServiceimpl();
	
    public getQuestionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("id");
		Integer id;
		if (idString == null) {
			idString = "1";
			id = Integer.parseInt(idString);
		}else {
			id = Integer.parseInt(idString);
		}
		//与数据库交互的方法
//		HttpSession session = request.getSession();
		List<Question> getQuestionByType = impl.getQuestionByType(id);
//		System.out.println(getQuestionByType.indexOf(0));
		request.setAttribute("getQuestionByType", getQuestionByType);
//		session.setAttribute("getQuestionByType", getQuestionByType.get(2).getQues_title());
//		System.out.println(getQuestionByType.get(1).getContent());
//		session.setAttribute("title1", getQuestionByType.get(0).getQues_title().toString());
		request.getRequestDispatcher("loginIndex.jsp").forward(request, response);
//		System.out.println(getQuestionByType.get(0).getAnswer().getContent());


	}

}

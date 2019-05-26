package com.neu.ruidaoQA.servlet.index_question;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.ruidaoQA.entity.Question;
import com.neu.ruidaoQA.service.impl.QuestionServiceimpl;


@WebServlet("/searchQues")
public class searchQuesServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String txt = request.getParameter("searchtxt");
		QuestionServiceimpl qsip = new QuestionServiceimpl();
		ArrayList<Question> searchlist = qsip.getSearchResult(txt);
		if(searchlist.isEmpty())
		{
			request.getSession().setAttribute("isSearchEmpty", 1);
		}
		else
		{
			request.getSession().setAttribute("isSearchEmpty", 0);
			request.getSession().setAttribute("searchResult", searchlist);
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}

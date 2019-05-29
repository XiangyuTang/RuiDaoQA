package com.neu.ruidaoQA.servlet.detail_question;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.neu.ruidaoQA.entity.QuestionType;
import com.neu.ruidaoQA.service.impl.QuestionTypeServiceimpl;

/**
 * Servlet implementation class getQuestionTypeServlet
 */
@WebServlet("/getQuestionTypeServlet")
public class getQuestionTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getQuestionTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		QuestionTypeServiceimpl qt=new QuestionTypeServiceimpl();
		ArrayList<QuestionType> types=qt.getQuestiontypes();
		Gson gson=new Gson();
		String jsonStr=gson.toJson(types);
		response.getWriter().write(jsonStr);
		
	}

}

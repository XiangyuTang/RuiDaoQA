package com.neu.ruidaoQA.servlet.detail_question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.neu.ruidaoQA.entity.Question;
import com.neu.ruidaoQA.service.impl.QuestionServiceimpl;

/**
 * Servlet implementation class showUsersQuestionListServlet
 */
@WebServlet("/showUsersQuestionListServlet")
public class showUsersQuestionListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showUsersQuestionListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/javascript;charset=utf-8");
		QuestionServiceimpl q=new QuestionServiceimpl();
		int user_id=Integer.parseInt(request.getParameter("user_id"));
	   ArrayList<Question> questions=q.getQuestionLists(user_id);
		Gson gson=new Gson();
		String jsonStrs=gson.toJson(questions);
		System.out.println("得到user_id为"+user_id+"的jsonStrs：");
		System.out.println(jsonStrs);
		response.getWriter().write(jsonStrs);
	}

}

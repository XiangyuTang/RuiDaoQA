package com.neu.ruidaoQA.servlet.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.neu.ruidaoQA.entity.Answer;
import com.neu.ruidaoQA.entity.Question;
import com.neu.ruidaoQA.service.impl.AnswerServiceimpl;
import com.neu.ruidaoQA.service.impl.QuestionServiceimpl;
import com.neu.ruidaoQA.service.impl.UserServiceimpl;

/**
 * Servlet implementation class showUsersAnswerListServlet
 */
@WebServlet("/showUsersAnswerList")
public class showUsersAnswerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showUsersAnswerListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/javascript;charset=utf-8");
		int user_id=Integer.parseInt(request.getParameter("user_id"));
		UserServiceimpl userServiceimpl=new UserServiceimpl();

		
		ArrayList<Object[]> objs=userServiceimpl.getAnswersList(user_id);

		
	
	
	
		Gson gson=new Gson();
		String jsonStr=gson.toJson(objs);
//		System.out.println("获得user_id为"+user_id+"回答列表：");
//		System.out.println(jsonStr);

		response.getWriter().write(jsonStr);
		
	}

}

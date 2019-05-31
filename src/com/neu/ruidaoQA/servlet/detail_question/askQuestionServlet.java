package com.neu.ruidaoQA.servlet.detail_question;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.ruidaoQA.entity.Question;
import com.neu.ruidaoQA.service.impl.QuestionServiceimpl;

/**
 * Servlet implementation class askQuestion
 */
@WebServlet("/askQuestion")
public class askQuestionServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/javascript;charset=utf-8");
		int question_type_id=Integer.parseInt(request.getParameter("type"));
//		System.out.println("已获取问题类型："+question_type_id);
		int user_id=Integer.parseInt(request.getParameter("user_id"));
//		System.out.println("已获取用户id："+user_id);
		String question_content=request.getParameter("desc");
//		System.out.println("已获取问题内容："+question_content);
		String question_title=request.getParameter("title");
//		System.out.println("已获取问题标题："+question_title);
		QuestionServiceimpl q=new QuestionServiceimpl();
		Question question=q.createQuestion(null, user_id, question_type_id, question_content, 0, 0, null, question_title);
		int count=q.addQuestion(question);

		if(count>0) {
			
			response.getWriter().write("success");
			
		}else {
			response.getWriter().write("failed");
		}
	}

}

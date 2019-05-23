package com.neu.ruidaoQA.servlet.detail_question;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.ruidaoQA.service.impl.UserServiceimpl;

/**
 * Servlet implementation class favoriteQuesServlet
 */
@WebServlet("/favoriteQues")
public class favoriteQuesServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer user_id = Integer.parseInt(request.getParameter("user_id"));
		Integer question_id = Integer.parseInt(request.getParameter("question_id"));
		Integer flag = Integer.parseInt(request.getParameter("flag"));
		UserServiceimpl usip = new UserServiceimpl();
		if(flag==1)
			usip.addFavorite(question_id, user_id);//收藏问题表添加数据，相应问题的收藏量+1通过触发器实现
		else
			usip.deleteFavorite(question_id, user_id);//收藏问题表删除数据，相应问题的收藏量-1通过触发器实现
		
	}

}

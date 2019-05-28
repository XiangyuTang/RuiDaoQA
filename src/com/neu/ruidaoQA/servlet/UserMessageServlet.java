package com.neu.ruidaoQA.servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.ruidaoQA.entity.User;
import com.neu.ruidaoQA.service.UserService;
import com.neu.ruidaoQA.service.impl.UserServiceimpl;

/**
 * Servlet implementation class UserMessageServlet
 */
@WebServlet("/UserMessageServlet")
public class UserMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserService us = new UserServiceimpl();
		System.out.println(request.getSession().getAttribute("currentUserName").toString());
		System.out.println(request.getSession().getAttribute("currentPassword").toString());
		List<User> lu=us.findAllUser(request.getSession().getAttribute("currentUserName").toString(),request.getSession().getAttribute("currentPassword").toString());
//		request.getSession().setAttribute("current_user_id", lu.get(0).getUser_id());
		request.setAttribute("List",lu);
		request.getRequestDispatcher("UserMessage.jsp").forward(request,response);
	}

}

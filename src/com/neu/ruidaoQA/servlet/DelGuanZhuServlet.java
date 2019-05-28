package com.neu.ruidaoQA.servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.ruidaoQA.entity.User;
import com.neu.ruidaoQA.service.DelGuanZhuService;
import com.neu.ruidaoQA.service.UserService;
import com.neu.ruidaoQA.service.impl.DelGuanZhuServiceimpl;
import com.neu.ruidaoQA.service.impl.UserServiceimpl;

/**
 * Servlet implementation class DelGuanZhuServlet
 */
@WebServlet("/DelGuanZhuServlet")
public class DelGuanZhuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelGuanZhuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int follow_user_id = Integer.parseInt(request.getParameter("id"));
		UserService us = new UserServiceimpl();
		List<User> lu=us.findAllUser(request.getSession().getAttribute("currentUserName").toString(),request.getSession().getAttribute("currentPassword").toString());
		int this_user_id = lu.get(0).getUser_id();
		DelGuanZhuService dgz = new DelGuanZhuServiceimpl();
		dgz.deleteFollow(this_user_id, follow_user_id);
		request.getRequestDispatcher("GuanZhuServlet").forward(request,response);
 	}

}

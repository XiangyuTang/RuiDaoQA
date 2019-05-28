package com.neu.ruidaoQA.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.ruidaoQA.entity.User;
import com.neu.ruidaoQA.service.CounterFollow;
import com.neu.ruidaoQA.service.UserService;
import com.neu.ruidaoQA.service.impl.CounterFollowimpl;
import com.neu.ruidaoQA.service.impl.UserServiceimpl;

/**
 * Servlet implementation class CounterFollowGuanZhuServlet
 */
@WebServlet("/CounterFollowGuanZhuServlet")
public class CounterFollowGuanZhuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CounterFollowGuanZhuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService us = new UserServiceimpl();
		List<User> lu=us.findAllUser(request.getSession().getAttribute("currentUserName").toString(),request.getSession().getAttribute("currentPassword").toString());
		int zhujue = lu.get(0).getUser_id();
		CounterFollow cf = new CounterFollowimpl();
		List<Integer> renshu = cf.counterFollow(zhujue);
		request.getSession().setAttribute("List", renshu);
		request.getRequestDispatcher("userinfo.jsp").forward(request,response);
//		request.getRequestDispatcher("UploadServlet").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

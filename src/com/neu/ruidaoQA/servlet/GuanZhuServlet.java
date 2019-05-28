package com.neu.ruidaoQA.servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.ruidaoQA.entity.User;
import com.neu.ruidaoQA.service.GuanZhuService;
import com.neu.ruidaoQA.service.UserService;
import com.neu.ruidaoQA.service.impl.GuanZhuServiceimpl;
import com.neu.ruidaoQA.service.impl.UserServiceimpl;

/**
 * Servlet implementation class GuanZhuServlet
 */
@WebServlet("/GuanZhuServlet")
public class GuanZhuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuanZhuServlet() {
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
		GuanZhuService gzs = new GuanZhuServiceimpl();
		UserService us = new UserServiceimpl();
		List<User> lu=us.findAllUser(request.getSession().getAttribute("currentUserName").toString(),request.getSession().getAttribute("currentPassword").toString());
		List<User> guanzhus = gzs.selectGuanZhus(lu.get(0).getUser_id());
		request.setAttribute("List", guanzhus);
		request.getRequestDispatcher("guanzhu.jsp").forward(request,response);
	}

}

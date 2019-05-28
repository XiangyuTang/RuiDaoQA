package com.neu.ruidaoQA.servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.ruidaoQA.entity.User;
import com.neu.ruidaoQA.service.FansMessageService;
import com.neu.ruidaoQA.service.UserService;
import com.neu.ruidaoQA.service.impl.FansMessageServiceimpl;
import com.neu.ruidaoQA.service.impl.UserServiceimpl;

/**
 * Servlet implementation class FansMessageServlet
 */
@WebServlet("/FansMessageServlet")
public class FansMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FansMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FansMessageService fs = new FansMessageServiceimpl();
		UserService us = new UserServiceimpl();
		List<User> lu=us.findAllUser(request.getSession().getAttribute("currentUserName").toString(),request.getSession().getAttribute("currentPassword").toString());
		System.out.println("mmmmmmmmmm"+lu.get(0).getUser_id());
		List<User> fans = fs.selectFans(lu.get(0).getUser_id());
		System.out.println("hhhhhhhhhhhhhh"+fans.size());
		request.setAttribute("List", fans);
		request.getRequestDispatcher("FansMessage.jsp").forward(request,response);
	}

}

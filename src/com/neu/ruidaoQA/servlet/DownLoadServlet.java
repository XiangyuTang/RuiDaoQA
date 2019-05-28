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
 * Servlet implementation class DownLoadServlet
 */
@WebServlet("/DownLoadServlet")
public class DownLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownLoadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService us = new UserServiceimpl();
		List<User> lu=us.findAllUser(request.getSession().getAttribute("currentUserName").toString(),request.getSession().getAttribute("currentPassword").toString());
		String pathHeadPicture = lu.get(0).getHead_photo();
		System.out.println("ddddddddddddddddddddddddd"+pathHeadPicture);
		request.setAttribute("HeadPhotoPath", pathHeadPicture);
		
		request.getRequestDispatcher("userInfo.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

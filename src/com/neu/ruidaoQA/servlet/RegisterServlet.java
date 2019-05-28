package com.neu.ruidaoQA.servlet;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.ruidaoQA.service.RegisterService;
import com.neu.ruidaoQA.service.impl.RegisterServiceimpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = null;
		
		
		
		if((request.getParameter("password")).equals(request.getParameter("repass"))) {
			password = request.getParameter("password");
		}else {
			response.getWriter().print("两次密码输入不一致，请认真核对");
		}
		
		String newPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			System.out.print(password);
			byte[] mimamd5=md.digest(password.getBytes());
			newPassword = Arrays.toString(mimamd5);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String nickname = request.getParameter("nickname");
		String birthday = request.getParameter("birthday");
		String introduce = request.getParameter("introduce");
		String sex = request.getParameter("sex");
		
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-DD");
		boolean dateflag=true;
		Date date =null;
		try
		{
date = (Date) format.parse(birthday);
		} catch (ParseException e)
		{
			dateflag=false;
		}
		
		// System.out.println("日期是否满足要求"+dateflag);
		if(dateflag) {
			RegisterService reg = new RegisterServiceimpl();
			int i=reg.addUser(email,newPassword,nickname,date,introduce,sex);
			request.getRequestDispatcher("login.html").forward(request,response);
		}else {
			response.sendRedirect("login.html");
		}
		

		
	}

}

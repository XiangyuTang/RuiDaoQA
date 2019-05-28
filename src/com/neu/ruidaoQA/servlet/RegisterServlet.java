package com.neu.ruidaoQA.servlet;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("tesxt/javascript;charset=utf-8");
		String email = request.getParameter("email");
		String password = null;
		if((request.getParameter("password")).equals(request.getParameter("repass"))) {
			String oldPassword = request.getParameter("password");
			try {
				MessageDigest md = MessageDigest.getInstance("md5");
				byte[] mimamd5=md.digest(oldPassword.getBytes());
				password = Arrays.toString(mimamd5);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			response.getWriter().print("两次密码输入不一致，请认真核对");
		}
		String nickname = request.getParameter("nickname");
		String birthday = request.getParameter("birthday");
		String introduce = request.getParameter("introduce");
		String sex = request.getParameter("sex");
		RegisterService reg = new RegisterServiceimpl();
		System.out.print(nickname+birthday);
		int i=reg.addUser(email,password,nickname,java.sql.Date.valueOf(birthday),introduce,sex);
	}

}

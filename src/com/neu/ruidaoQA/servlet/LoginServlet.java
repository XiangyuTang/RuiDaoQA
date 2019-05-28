package com.neu.ruidaoQA.servlet;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.ruidaoQA.entity.User;
import com.neu.ruidaoQA.service.LoginService;
import com.neu.ruidaoQA.service.UserService;
import com.neu.ruidaoQA.service.impl.LoginServiceimpl;
import com.neu.ruidaoQA.service.impl.UserServiceimpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("尼玛死了");
		String p1 = request.getParameter("userName");
		String oldp2 = request.getParameter("pass");
		String p3 = request.getParameter("saveorno");
		String p2 = null;
		try {
			MessageDigest md=MessageDigest.getInstance("md5");
			byte[] mimamd5=md.digest(oldp2.getBytes());
			p2 = Arrays.toString(mimamd5);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		LoginService l = new LoginServiceimpl();
		int bool = l.checkLogin(p1, p2);
		
		
		if(bool == 0) {//用户名错了
			request.setAttribute("errorMsg", "用户名不存在");
			request.getRequestDispatcher("login.html").forward(request, response);
		}else if(bool == 1) {//密码错了
			request.setAttribute("errorMsg", "用户名存在,但是密码错误");
			request.getRequestDispatcher("login.html").forward(request, response);
		}else if(bool == 2){
			request.getSession().setAttribute("currentUserName",p1);
			request.getSession().setAttribute("currentPassword",p2);
			UserService us = new UserServiceimpl();
			List<User> lu=us.findAllUser(p1,p2);
			System.out.println(lu.size());
			System.out.println(lu.get(0));
			System.out.println(lu.get(0).getUser_id());
			//System.out.println("oooooooo"+lu.get(0).getHead_photo());
			//System.out.println(lu.get(0).getHead_photo().length());
			if(lu.get(0).getHead_photo()==null) {
				lu.get(0).setHead_photo("images/avatar/0.jpg");//默认0.jpg
			}
			request.getSession().setAttribute("current_user_id", lu.get(0).getUser_id());
			System.out.println("login"+lu.get(0).getHead_photo()+lu.get(0).getUser_id());
			request.getSession().setAttribute("filename", lu.get(0).getHead_photo());
			us.addHeadPhoto(Integer.parseInt(request.getSession().getAttribute("current_user_id").toString()),lu.get(0).getHead_photo());
			request.getSession().setAttribute("CurrentUser", lu.get(0));
			if (null!=p3 && p3.equals("1")) {
				Cookie cookie = new Cookie("savedname",p1);
				cookie.setMaxAge(60*5);
				response.addCookie(cookie);
			}
//			response.sendRedirect("self.jsp");
//			response.sendRedirect("userinfo.jsp");
			request.getRequestDispatcher("CounterFollowGuanZhuServlet").forward(request,response);
			System.out.println("chenggogn");
		}
	}

}

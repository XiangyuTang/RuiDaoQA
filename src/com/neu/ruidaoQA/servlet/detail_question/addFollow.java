package com.neu.ruidaoQA.servlet.detail_question;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.ruidaoQA.service.impl.UserServiceimpl;

/**
 * Servlet implementation class addFollow
 */
@WebServlet("/addFollow")
public class addFollow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addFollow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer this_user_id = Integer.parseInt(request.getParameter("this_user_id"));
		String fangfa = request.getParameter("fangfa");
//		Integer follow_user_id = (Integer) request.getSession().getAttribute("user_id");
		int follow_user_id = 2;
		UserServiceimpl userServiceimpl = new UserServiceimpl();
		if (fangfa.equals("add")) {
			userServiceimpl.addFollow(this_user_id, follow_user_id);
		}else if (fangfa.equals("delete")) {
			userServiceimpl.deleteFollow(this_user_id, follow_user_id);
		}else {
			response.getWriter().print("参数有误");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

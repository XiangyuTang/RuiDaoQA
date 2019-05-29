package com.neu.ruidaoQA.servlet.detail_question;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.ruidaoQA.service.impl.AnswerServiceimpl;
import com.neu.ruidaoQA.service.impl.CommentServiceimpl;

/**
 * Servlet implementation class addAccliamforComment
 */
@WebServlet("/addAcclaimforComment")
public class addAccliamforComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addAccliamforComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer commernt_id = Integer.parseInt(request.getParameter("comment_id"));
		String fangfa = request.getParameter("fangfa");
		CommentServiceimpl commentServiceimpl = new CommentServiceimpl();
		if (fangfa.equals("add")) {
			commentServiceimpl.addAcclaim_number(commernt_id);
		}else if(fangfa.equals("delete")) {
			commentServiceimpl.deleteAcclaim_number(commernt_id);
		}else {
			response.getWriter().print("参数有误");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer commernt_id = Integer.parseInt(request.getParameter("comment_id"));
		String fangfa = request.getParameter("fangfa");
		CommentServiceimpl commentServiceimpl = new CommentServiceimpl();
		if (fangfa.equals("add")) {
			commentServiceimpl.addAcclaim_number(commernt_id);
		}else if(fangfa.equals("delete")) {
			commentServiceimpl.deleteAcclaim_number(commernt_id);
		}else {
			response.getWriter().print("参数有误");
		}
	}

}

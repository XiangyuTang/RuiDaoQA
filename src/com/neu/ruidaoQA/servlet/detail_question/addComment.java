package com.neu.ruidaoQA.servlet.detail_question;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.ruidaoQA.service.impl.CommentServiceimpl;

/**
 * Servlet implementation class addComment
 */
@WebServlet("/addComment")
public class addComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer answer_id = Integer.parseInt(request.getParameter("answer_id"));
//		Integer user_id = (Integer) request.getSession().getAttribute("user_id");
		Integer user_id = 2;
		String comment_content = request.getParameter("comment_content");
		Integer comment_flag = Integer.parseInt(request.getParameter("comment_flag"));
		String time = request.getParameter("time");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//设置日期格式        
		Date submit_time = null;
		try {
			submit_time = df.parse(time);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		CommentServiceimpl commentServiceimpl = new CommentServiceimpl();
		int i = commentServiceimpl.addComment(answer_id, user_id, comment_content, comment_flag, 0, submit_time);
		response.getWriter().print(i);
	}

}

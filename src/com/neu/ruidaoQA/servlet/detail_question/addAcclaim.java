package com.neu.ruidaoQA.servlet.detail_question;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.ruidaoQA.service.impl.AnswerServiceimpl;

/**
 * Servlet implementation class addAcclaim
 */
@WebServlet("/addAcclaim")
public class addAcclaim extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addAcclaim() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer answer_id = Integer.parseInt(request.getParameter("answer_id"));
		System.out.println(answer_id);
		String fangfa = request.getParameter("fangfa");
		AnswerServiceimpl answerServiceimpl = new AnswerServiceimpl();
		if (fangfa.equals("add")) {
			answerServiceimpl.addAcclaim_number(answer_id);
			System.out.println(answer_id);
		}else if(fangfa.equals("delete")) {
			answerServiceimpl.deleteAcclaim_number(answer_id);
			System.out.println(answer_id);
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

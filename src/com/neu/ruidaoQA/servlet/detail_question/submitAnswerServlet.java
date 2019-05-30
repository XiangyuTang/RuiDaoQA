package com.neu.ruidaoQA.servlet.detail_question;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.ruidaoQA.entity.Answer;
import com.neu.ruidaoQA.service.sensitiveWordService;
import com.neu.ruidaoQA.service.impl.AnswerServiceimpl;
import com.neu.ruidaoQA.service.impl.sensitiveWordimpl;


/**
 * Servlet implementation class submitAnswer
 */
@WebServlet("/submitAnswer")
public class submitAnswerServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ans_text = request.getParameter("ans_text");
		sensitiveWordimpl swip = new sensitiveWordimpl();
		String return_text = swip.replaceBadWord(ans_text, 2, "*");//敏感词过滤，2代表最大匹配原则，将敏感词替换为*
		request.getServletContext().setAttribute("return_text", return_text);
		System.out.println("-----"+request.getServletContext().getAttribute("return_text"));
		Integer user_id = Integer.parseInt(request.getParameter("user_id"));
		Integer question_id = Integer.parseInt(request.getParameter("question_id"));
		String ans_time = request.getParameter("ans_time");
	     //String转换为java.util.Date
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//设置日期格式        
		Date submit_time = null;
		try {
			submit_time = df.parse(ans_time);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AnswerServiceimpl asip = new AnswerServiceimpl();
		Answer ans = asip.createAnswer(null, question_id, user_id, return_text, 0, 0, 0, submit_time);
		asip.add_answer(ans);
		response.getWriter().print(return_text);
		/*System.out.println(ans_text+"-------"+user_id+"-------"+question_id+"---"+ans_time);
		System.out.println(ans_text+"-------"+user_id+"-------"+question_id+"---"+submit_time);*/
		
	}

}

package com.neu.ruidaoQA.servlet.detail_question;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.ruidaoQA.entity.Answer;
import com.neu.ruidaoQA.entity.Question;
import com.neu.ruidaoQA.service.impl.AnswerServiceimpl;
import com.neu.ruidaoQA.service.impl.QuestionServiceimpl;

/**
 * Servlet implementation class getAnswerByAcclaimNumServlet
 */
@WebServlet("/getAnswerByAcclaimNum")
public class getAnswerByAcclaimNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AnswerServiceimpl impl = new AnswerServiceimpl(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getAnswerByAcclaimNumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Answer> getAnswerByAcclaimNum = impl.getAnswerByAcclaimNum();
		request.setAttribute("getAnswerByAcclaimNum", getAnswerByAcclaimNum);
		
		String s = "";
        for(Answer a:getAnswerByAcclaimNum){
        	s+="<dd>"+
					"<a href='toDetailQues?question_id="+a.getQuestion_id() +"'>"+a.getContent()+"</a> <span><i class='iconfont'>&#xe60b;</i> "+a.getDianzan_num()+"</span" + 
				"</dd>";
        }
        
        response.getWriter().print(s);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

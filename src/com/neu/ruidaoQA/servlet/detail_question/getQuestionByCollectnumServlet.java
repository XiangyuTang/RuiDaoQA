package com.neu.ruidaoQA.servlet.detail_question;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.ruidaoQA.entity.Question;
import com.neu.ruidaoQA.service.impl.QuestionServiceimpl;

/**
 * Servlet implementation class getQuestionByCollectnum
 */
@WebServlet("/getQuestionByCollectnum")
public class getQuestionByCollectnumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QuestionServiceimpl impl = new QuestionServiceimpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getQuestionByCollectnumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Question> getQuestionByCollectNum = impl.getQuestionByCollectNum();
		request.setAttribute("getQuestionByCollectNum", getQuestionByCollectNum);
//		System.out.println(getQuestionByCollectNum.get(1).getQues_title());
		
		
		String s = "";
        for(Question q:getQuestionByCollectNum){
			s+="<dd>"+
					"<a href='toDetailQues?question_id="+q.getQuestion_id() +"'>"+q.getQues_title()+"</a> <span><i class='iconfont'>&#xe60b;</i> "+q.getCollect_num()+"</span" + 
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

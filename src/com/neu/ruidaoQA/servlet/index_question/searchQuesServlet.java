package com.neu.ruidaoQA.servlet.index_question;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.ruidaoQA.entity.Question;
import com.neu.ruidaoQA.service.impl.QuestionServiceimpl;


@WebServlet("/searchQues")
public class searchQuesServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String txt = request.getParameter("searchtxt");
		QuestionServiceimpl qsip = new QuestionServiceimpl();
		ArrayList<Question> searchlist = qsip.getSearchResult(txt);
		if(searchlist.isEmpty())
		{
			request.getSession().setAttribute("isSearchEmpty", 1);
		}
		else
		{
			request.getSession().setAttribute("isSearchEmpty", 0);
			request.getSession().setAttribute("searchResult", searchlist);
			String s = "";
			for(Question q:searchlist){
	        	s+="<div class='fly-panel box'>"+
						"<h1><a href='toDetailQues?question_id="+q.getQuestion_id()+"'>"+q.getQues_title()+"</a></h1>"+
						"<div class='question-info'><span class='question-answer-num'>"+q.getAnswer_num()+"回答</span> <span class='question-follow-num'>"+q.getCollect_num()+"人收藏</span></div>"+
						"<div class='detail-about'>"+
							"<a class='jie-user' href=''> <img "+
								"src='images/uer.jpg' alt='头像'> <cite> 压缩"+
									"<em>2017-05-01发布</em> </cite> </a>"+
							"<div class='detail-hits' data-id='{{rows.id}}'>"+
								"<button class='layui-btn layui-btn-radius layui-btn-sm' style='width:80px; border-radius:20px;'>关注</button>"+
							"</div>"+
						"</div>"+
						"<div class='detail-body photos' style='margin-bottom: 0px;'>"+
							"<p>"+q.getContent()+
							"</p>"+
						"</div>"+
						"<div class='jieda-reply'>"+
								"<input type='hidden' name='answer_id' value='2'/>"+
								"<span class='jieda-zan zanok' type='zan'>"+
									"<i class='layui-icon layui-icon-praise' style='font-size: 20px; color: #009688;' title='赞'></i><em style='font-size: 15px; color: #009688;'>"+12+"</em>"+
								"</span>"+
								"<span class='jieda-zan zanok' type='zan'><i "+
									"class='layui-icon layui-icon-tread' style='font-size: 20px; color: #009688;' title='踩'></i><em style='font-size: 15px; color: #009688;'>3</em>"+
								"</span>"+
								"<span class='jieda-zan zanok' type='zan'><i "+
									"class='layui-icon layui-icon-reply-fill'  style='font-size: 20px; color: #009688;' title='评论'></i><em style='font-size: 15px; color: #009688;'>"+q.getAnswer_num()+"</em>"+
								"</span>"+
								"<div class='jieda-admin'>"+
									"<span class='jieda-accept' type='accept'>"+
								"</div>"+
						"</div>"+
				"</div>";
	        }
			
			response.getWriter().print(s);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}

}

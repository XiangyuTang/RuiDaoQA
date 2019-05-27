package com.neu.ruidaoQA.servlet.detail_question;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.ruidaoQA.dao.impl.QuestionDaoimpl;
import com.neu.ruidaoQA.entity.Question;
import com.neu.ruidaoQA.service.impl.QuestionServiceimpl;
import com.sun.istack.internal.Pool.Impl;

/**
 * Servlet implementation class getServlet
 */
@WebServlet("/getQuestion")
public class getQuestionServlet extends HttpServlet implements java.io.Serializable{
	

	QuestionServiceimpl impl = new QuestionServiceimpl();
	
    public getQuestionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("topic"));
		System.out.println(id);
		//与数据库交互的方法
		HttpSession session = request.getSession();
		List<Question> getQuestionByType = impl.getQuestionByType(id);
		session.setAttribute("getQuestionByType", getQuestionByType);	
		//session.setAttribute("title1", getQuestionByType.get(0).getQues_title().toString());

		String s = "";
        for(Question q:getQuestionByType){
        	s+="<div class='fly-panel box'>"+
					"<h1><a href='toDetailQues?question_id="+q.getQuestion_id()+"'>"+q.getQues_title()+"</a></h1>"+
					"<div class='question-info'><span class='question-answer-num'>"+q.getAnswer_num()+"回答</span> <span class='question-follow-num'>"+q.getCollect_num()+"人收藏</span></div>"+
					"<div class='detail-about'>"+
						"<a class='jie-user' href=''> <img "+
							"src='"+q.getAnswer().getUser().getHead_photo()+"' alt='头像'> <cite> "+q.getAnswer().getUser().getNick_name()+" "+
								"<em>"+q.getAnswer().getPublish_time()+"</em> </cite> </a>"+
						"<div class='detail-hits' data-id='{{rows.id}}'>"+
						"<input type='hidden' name='user_id' value='"+q.getAnswer().getUser().getUser_id()+"' /><span></span>"+
							"<button class='layui-btn layui-btn-radius layui-btn-sm' style='width:80px; border-radius:20px;'>关注</button>"+
						"</div>"+
					"</div>"+
					"<div class='detail-body photos' style='margin-bottom: 0px;'>"+
						"<p>"+q.getAnswer().getContent()+
						"</p>"+
					"</div>"+
					"<div class='jieda-reply'>"+
							"<input type='hidden' name='answer_id' value='"+q.getAnswer().getAnswer_id()+"'/>"+
							"<span class='jieda-zan zanok' type='zan'>"+
								"<i class='layui-icon layui-icon-praise' style='font-size: 20px; color: #009688;' title='赞'></i><em style='font-size: 15px; color: #009688;'>"+q.getAnswer().getDianzan_num()+"</em>"+
							"</span>"+
							"<span class='jieda-zan zanok' type='zan'><i "+
								"class='layui-icon layui-icon-tread' style='font-size: 20px; color: #009688;' title='踩'></i><em style='font-size: 15px; color: #009688;'>"+q.getAnswer().getCai_num()+"</em>"+
							"</span>"+
							/*"<span class='jieda-zan zanok' type='zan'><i "+
								"class='layui-icon layui-icon-reply-fill'  style='font-size: 20px; color: #009688;' title='评论'></i><em style='font-size: 15px; color: #009688;'>"+q.getAnswer_num()+"</em>"+
							"</span>"+*/
							"<div class='jieda-admin'>"+
								"<span class='jieda-accept' type='accept'>"+
							"</div>"+
					"</div>"+
			"</div>";
        }
		response.getWriter().print(s);
}
		//request.getRequestDispatcher("index.jsp").forward(request, response);



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String idString = request.getParameter("id");
//		Integer id;
//		if (idString == null) {
//			idString = "1";
//			id = Integer.parseInt(idString);
//		}else {
//			id = Integer.parseInt(idString);
//		}
//		//与数据库交互的方法
////		HttpSession session = request.getSession();
//		List<Question> getQuestionByType = impl.getQuestionByType(id);
////		System.out.println(getQuestionByType.indexOf(0));
//		request.setAttribute("getQuestionByType", getQuestionByType);
////		session.setAttribute("getQuestionByType", getQuestionByType.get(2).getQues_title());
////		System.out.println(getQuestionByType.get(1).getContent());
////		session.setAttribute("title1", getQuestionByType.get(0).getQues_title().toString());
//		request.getRequestDispatcher("loginIndex.jsp").forward(request, response);
////		System.out.println(getQuestionByType.get(0).getAnswer().getContent());


	}

}

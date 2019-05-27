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

import com.alibaba.fastjson.JSON;
import com.neu.ruidaoQA.dao.impl.QuestionDaoimpl;
import com.neu.ruidaoQA.entity.FlowLoadJson;
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
    
    public String doQues(Question q)
    {
    	String s = "";
    	if(q.getAnswer()==null)//说明该问题没有人回答
    	{
    		s+="<div class='fly-panel box'>"+
					"<h1><a href='toDetailQues?question_id="+q.getQuestion_id()+"'>"+q.getQues_title()+"</a></h1>"+
					"<div class='question-info'><span class='question-answer-num'>"+0+"回答</span> <span class='question-follow-num'>"+q.getCollect_num()+"人收藏</span></div>"+
					
					"<div class='detail-body photos' style='margin-bottom: 0px;'>"+
						"<p>"+"该回答为空."+
						"</p>"+
					"</div>"+
					
			"</div>";
    	}
    	else {
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
							"<div class='jieda-admin'>"+
								"<span class='jieda-accept' type='accept'>"+
							"</div>"+
					"</div>"+
			"</div>";
    	}
    	return s;
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=UTF-8");
		int id = Integer.parseInt(request.getParameter("topic"));
		System.out.println(id);
		//与数据库交互的方法
		HttpSession session = request.getSession();
		List<Question> getQuestionByType = impl.getQuestionByType(id);
		session.setAttribute("getQuestionByType", getQuestionByType);	
		//session.setAttribute("title1", getQuestionByType.get(0).getQues_title().toString());
		String s = "";
		int ques_size = getQuestionByType.size();//得到当前类型问题的总条数
		int pages = ques_size%3==0?ques_size/3:ques_size/3+1;//得到流加载应该划分的页数，设每页加载3条数据
		String perPageQues[] = new String[pages];//创建每页的问题存储数组
		for(int i=0;i<pages;i++)
		{
			perPageQues[i] = "";
		}
		int page = 0;
		//除了最后一页，之前的页都加载满3条
		for(int i=0;i<(pages-1)*3;i+=3,page++)
		{
			perPageQues[page] += doQues(getQuestionByType.get(i));
			perPageQues[page] += doQues(getQuestionByType.get(i+1));
			perPageQues[page] += doQues(getQuestionByType.get(i+2));
		}
		//最后一页单独判断
		if(ques_size%3==0)
		{
			perPageQues[page] += doQues(getQuestionByType.get(ques_size-3));
			perPageQues[page] += doQues(getQuestionByType.get(ques_size-2));
			perPageQues[page] += doQues(getQuestionByType.get(ques_size-1));
		}
		else if(ques_size%3==2)
		{
			perPageQues[page] += doQues(getQuestionByType.get(ques_size-2));
			perPageQues[page] += doQues(getQuestionByType.get(ques_size-1));
		}
		else
		{
			perPageQues[page] += doQues(getQuestionByType.get(ques_size-1));
		}
		//Json对象封装，以传到ajax前台
		FlowLoadJson fljson = new FlowLoadJson(perPageQues,pages);
		//将java中的对象转为json字符串
		String str = JSON.toJSONString(fljson);
		
        /*for(Question q:getQuestionByType){
        	if(q.getAnswer()==null)//说明该问题没有人回答
        	{
        		s+="<div class='fly-panel box'>"+
    					"<h1><a href='toDetailQues?question_id="+q.getQuestion_id()+"'>"+q.getQues_title()+"</a></h1>"+
    					"<div class='question-info'><span class='question-answer-num'>"+0+"回答</span> <span class='question-follow-num'>"+q.getCollect_num()+"人收藏</span></div>"+
    					
    					"<div class='detail-body photos' style='margin-bottom: 0px;'>"+
    						"<p>"+"该回答为空."+
    						"</p>"+
    					"</div>"+
    					
    			"</div>";
        	}
        	else {
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
    							"<div class='jieda-admin'>"+
    								"<span class='jieda-accept' type='accept'>"+
    							"</div>"+
    					"</div>"+
    			"</div>";
        	}
        }*/
		response.getWriter().print(str);
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

package com.neu.ruidaoQA.servlet.detail_question;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.ruidaoQA.entity.Answer;
import com.neu.ruidaoQA.entity.Question;
import com.neu.ruidaoQA.entity.User;
import com.neu.ruidaoQA.service.impl.AnswerServiceimpl;
import com.neu.ruidaoQA.service.impl.QuestionServiceimpl;
import com.neu.ruidaoQA.service.impl.UserServiceimpl;

import javafx.scene.control.Alert;

/**
 * Servlet implementation class toDetailQuesServlet
 */
@WebServlet("/toDetailQues")
public class toDetailQuesServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				//response.getWriter().append("Served at: ").append(request.getContextPath());		
//				Integer question_id = Integer.parseInt(request.getParameter("question_id"));
				Integer question_id = 14;
				QuestionServiceimpl qsip = new QuestionServiceimpl();
				UserServiceimpl usip = new UserServiceimpl();
				AnswerServiceimpl answerServiceimpl = new AnswerServiceimpl();
				ServletContext servletContext = request.getServletContext();
				User currentUser = (User) servletContext.getAttribute("CurrentUser");
				System.out.println(currentUser);
				if (currentUser == null) {
//					response.sendRedirect("index.jsp");
					List<Answer> answers = answerServiceimpl.getAnswerslist(question_id,currentUser);//得到其answer的回答者是否在收藏域中
//					for (Answer answer: answers) {
//						System.out.println(answer.getUser().getFollow_flag());
//					}
//					Integer have1 = qsip.haveQuestion(question_id, currentUser.getUser_id());////得到其question是否在收藏域中
					Question q = qsip.getQuestion(question_id);
					q.setCollect_flag(0);
					Integer user_id = q.getUser_id();
//					Integer haveUser = usip.haveUser(user_id, currentUser.getUser_id());//得到其user是否被关注
					User u = usip.getUser(user_id);
					u.setFollow_flag(0);
					request.setAttribute("User", u);
					request.setAttribute("Question", q);
					request.setAttribute("answerlist", answers);
					request.getRequestDispatcher("detailQues.jsp").forward(request, response);
				}else {
//				System.out.println(currentUser.getUser_id());
				List<Answer> answers = answerServiceimpl.getAnswerslist(question_id,currentUser);//得到其answer的回答者是否在收藏域中
				for (Answer answer: answers) {
					System.out.println(answer.getUser().getFollow_flag());
				}
				Integer have1 = qsip.haveQuestion(question_id, currentUser.getUser_id());////得到其question是否在收藏域中
				Question q = qsip.getQuestion(question_id);
				q.setCollect_flag(have1);
				Integer user_id = q.getUser_id();
				Integer haveUser = usip.haveUser(user_id, currentUser.getUser_id());//得到其user是否被关注
				User u = usip.getUser(user_id);
				u.setFollow_flag(haveUser);
				request.setAttribute("User", u);
				request.setAttribute("Question", q);
				request.setAttribute("answerlist", answers);
				request.getRequestDispatcher("detailQues.jsp").forward(request, response);
				}
				
//				List<Answer> answers = answerServiceimpl.getAnswerslist(question_id,currentUser.getUser_id());//得到其answer的回答者是否在收藏域中
//				Integer have1 = qsip.haveQuestion(question_id, currentUser.getUser_id());////得到其question是否在收藏域中
//				Question q = qsip.getQuestion(question_id);
//				q.setCollect_flag(have1);
//				System.out.println(servletContext.getAttribute("CurrentUser"));
//				Integer user_id = q.getUser_id();
//				Integer haveUser = usip.haveUser(user_id, currentUser.getUser_id());//得到其user是否被关注
//				User u = usip.getUser(user_id);
//				u.setFollow_flag(haveUser);
//				request.setAttribute("User", u);
//				request.setAttribute("Question", q);
//				request.setAttribute("answerlist", answers);
//				System.out.println(q.getContent());	
//				request.getRequestDispatcher("detailQues.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}

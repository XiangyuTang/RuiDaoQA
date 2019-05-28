package com.neu.ruidaoQA.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import com.neu.ruidaoQA.dao.impl.AnswerDaoimpl;
import com.neu.ruidaoQA.dao.impl.CommentDaoimpl;
import com.neu.ruidaoQA.dao.impl.FollowDaoimpl;
import com.neu.ruidaoQA.dao.impl.UserDaoimpl;
import com.neu.ruidaoQA.entity.Answer;
import com.neu.ruidaoQA.entity.Comment;
import com.neu.ruidaoQA.entity.User;
import com.neu.ruidaoQA.service.AnswerService;

public class AnswerServiceimpl implements AnswerService {

	@Override//增加相应回答点赞数
	public int addAcclaim_number(int answer_id) {
		AnswerDaoimpl answerDaoimpl = new AnswerDaoimpl();
		int i = answerDaoimpl.addAcclaim_number(answer_id);
		return i;
	}

	@Override//增加相应回答踩数
	public int addDefame_number(int answer_id) {
		AnswerDaoimpl answerDaoimpl = new AnswerDaoimpl();
		int i = answerDaoimpl.addDefame_number(answer_id);
		return i;
	}
	

	@Override//取消相应回答点赞
	public int deleteAcclaim_number(int answer_id) {
		AnswerDaoimpl answerDaoimpl = new AnswerDaoimpl();
		int i = answerDaoimpl.deleteAcclaim_number(answer_id);
		return i;
	}



	@Override
	public int getAQuesiton_idByAnswer_id(int answer_id) {
		AnswerDaoimpl answerDaoimpl = new AnswerDaoimpl();
		return answerDaoimpl.getAQuesiton_idByAnswer_id(answer_id);
	}

	@Override
	public ArrayList<Answer> getAnswerLists(int user_id) {
		// TODO Auto-generated method stub
	  AnswerDaoimpl answerServiceimpl = new AnswerDaoimpl();
		return answerServiceimpl.getAnswerLists(user_id);
	}

	@Override//取消相应回答踩
	public int deleteDefame_number(int answer_id) {
		AnswerDaoimpl answerDaoimpl = new AnswerDaoimpl();
		int i = answerDaoimpl.deleteDefame_number(answer_id);
		return i;
	}
	
	@Override
	public int add_answer(Answer ans) {
		// TODO Auto-generated method stub
		AnswerDaoimpl answerDaoimpl = new AnswerDaoimpl();
		int i = answerDaoimpl.addAnswer(ans);
		return i;
	}
	
	@Override
	public Answer createAnswer(Integer answer_id, Integer question_id, Integer user_id, String content,
			Integer dianzan_num, Integer cai_num, Integer comment_num, Date publish_time) {
		Answer ans = new Answer(answer_id, question_id, user_id, content, dianzan_num, cai_num, comment_num, publish_time);
		return ans;
		
		
	}
	
	public void test1() {
		AnswerDaoimpl a1 = new AnswerDaoimpl();
		Answer a = a1.selectAnswer(1);
			System.out.print(a.getAnswer_id());
			System.out.print(a.getQuestion_id());
			System.out.print(a.getUser_id());
			System.out.print(a.getContent());
			System.out.print(a.getDianzan_num());
			System.out.print(a.getCai_num());
			System.out.print(a.getComment_num());
			System.out.print(a.getPublish_time());
			System.out.println();
		}
	
	public static void main(String[] args) {//测试类
//		AnswerServiceimpl answerServiceimpl = new AnswerServiceimpl();
//		int i = answerServiceimpl.addAcclaim_number(1);
//		System.out.println(i);
//		int j = answerServiceimpl.addDefame_number(1);
//		System.out.println(j);
//		
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//设置日期格式        
//		Date date = null;
//		try {
//			date = df.parse("2019-05-23 16:01:42");
//		} catch (java.text.ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Answer ans = new Answer(null, 2, 1, "我要回答", 0, 0, 0, date);
//		int k = answerServiceimpl.add_answer(ans);
//		System.out.println(k);
//		
//		AnswerServiceimpl answerServiceimpl1 = new AnswerServiceimpl();
//		answerServiceimpl.test1();
		AnswerServiceimpl answerServiceimpl2 = new AnswerServiceimpl();
		answerServiceimpl2.getAnswerslist(2,1);
		
	}

	@Override//根据问题id获取最热的十条回答及其评论
	public List<Answer> getAnswerslist(int question_id,Integer user_id) {
		AnswerDaoimpl answerDaoimpl = new AnswerDaoimpl();
		CommentDaoimpl commentDaoimpl = new CommentDaoimpl();
		UserDaoimpl userDaoimpl = new UserDaoimpl();
		FollowDaoimpl followDaoimpl = new FollowDaoimpl();
		ArrayList<Integer> follow_user_idlist = followDaoimpl.getFollow_user_idlist(user_id);
		List<Answer> answers = answerDaoimpl.getAnswersList(question_id);
//		Collections.reverse(answers);
		for (Answer answer:answers ) {
			User user = userDaoimpl.selectUserByAnswer_id(answer.getAnswer_id());
			answer.setUser(user);
			if (follow_user_idlist.contains(user.getUser_id())) {
				user.setFollow_flag(1);
			}else {
				user.setFollow_flag(0);
			}
			List<Comment> comments = commentDaoimpl.getCommentsList(answer.getAnswer_id());
//			Collections.reverse(comments);
			for (Comment comment:comments) {
				User user1 = userDaoimpl.selectUserByComment_id(comment.getComment_id());
				comment.setUser(user1);
			}
			answer.setComments(comments);
		}
		return answers;
	}

	@Override
	public Integer getNewAnswer_id() {
		AnswerDaoimpl answerDaoimpl = new AnswerDaoimpl();
		Integer newAnswer_id = answerDaoimpl.getNewAnswer_id();
		return newAnswer_id;
	}
	
	@Override
	public List<Answer> getAnswerByAcclaimNum() {
		// TODO Auto-generated method stub
		AnswerDaoimpl answerDaoimpl = new AnswerDaoimpl();
		List<Answer> getAnswerByAcclaimNum = answerDaoimpl.getAnswerByAcclaimNum();
//		System.out.println("bbbbbbbbbbbbbbb"+getAnswerByAcclaimNum.size());
//		System.out.println(getAnswerByAcclaimNum.get(0).getContent());
		return getAnswerByAcclaimNum;
	}
}

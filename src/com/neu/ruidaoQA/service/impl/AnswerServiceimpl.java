package com.neu.ruidaoQA.service.impl;

import java.util.Date;
import java.text.SimpleDateFormat;
import com.neu.ruidaoQA.dao.impl.AnswerDaoimpl;
import com.neu.ruidaoQA.dao.impl.UserDaoimpl;
import com.neu.ruidaoQA.entity.Answer;
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
		AnswerServiceimpl answerServiceimpl = new AnswerServiceimpl();
		int i = answerServiceimpl.addAcclaim_number(1);
		System.out.println(i);
		int j = answerServiceimpl.addDefame_number(1);
		System.out.println(j);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//设置日期格式        
		Date date = null;
		try {
			date = df.parse("2019-05-23 16:01:42");
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Answer ans = new Answer(null, 2, 1, "我要回答", 0, 0, 0, date);
		int k = answerServiceimpl.add_answer(ans);
		System.out.println(k);
		
		AnswerServiceimpl answerServiceimpl1 = new AnswerServiceimpl();
		answerServiceimpl.test1();
	}

	

	
}

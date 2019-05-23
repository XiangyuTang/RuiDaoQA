package com.neu.ruidaoQA.service.impl;

import java.sql.Date;
import java.sql.Timestamp;

import com.neu.ruidaoQA.dao.impl.AnswerDaoimpl;
import com.neu.ruidaoQA.entity.Answer;
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
	
	@Override
	public int add_answer(Answer ans) {
		// TODO Auto-generated method stub
		AnswerDaoimpl answerDaoimpl = new AnswerDaoimpl();
		int i = answerDaoimpl.addAnswer(ans);
		return i;
	}
	
	
	public static void main(String[] args) {//测试类
		AnswerServiceimpl answerServiceimpl = new AnswerServiceimpl();
		int i = answerServiceimpl.addAcclaim_number(1);
		System.out.println(i);
		int j = answerServiceimpl.addDefame_number(1);
		System.out.println(j);
		Timestamp time = new Timestamp(1, 2, 3, 4, 5, 6, 7);
		Date date = new Date(1000);
		Answer ans = new Answer(2, 2, 1, "我要回答", 0, 0, 0, date);
		int k = answerServiceimpl.add_answer(ans);
		System.out.println(k);
	}

	
}

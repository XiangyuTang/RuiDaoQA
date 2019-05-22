package com.neu.ruidaoQA.service.impl;

import com.neu.ruidaoQA.dao.impl.AnswerDaoimpl;
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
	
	public static void main(String[] args) {//测试类
		AnswerServiceimpl answerServiceimpl = new AnswerServiceimpl();
		int i = answerServiceimpl.addAcclaim_number(1);
		System.out.println(i);
		int j = answerServiceimpl.addDefame_number(1);
		System.out.println(j);
	}
}

package com.neu.ruidaoQA.dao.impl;

import com.neu.ruidaoQA.dao.AnswerDao;
import com.neu.ruidaoQA.dbutil.BaseDao;

public class AnswerDaoimpl extends BaseDao implements AnswerDao{
	@Override//增加相应回答点赞数
	public int addAcclaim_number(int answer_id) {
		Object[] params = new Object[] {answer_id};
		String sql  = "update answer set acclaim_number = acclaim_number+1  where answer_id = ?";
		int i = super.executeIUD(sql, params);
		return i;
	}

	@Override//增加相应回答踩数
	public int addDefame_number(int answer_id) {
		Object[] params = new Object[] {answer_id};
		String sql  = "update answer set defame_number = defame_number+1  where answer_id = ?";
		int i = super.executeIUD(sql, params);
		return i;
	}
	
	public static void main(String[] args) {//测试类
		AnswerDaoimpl answerDaoimpl = new AnswerDaoimpl();
		answerDaoimpl.addAcclaim_number(1);
		answerDaoimpl.addDefame_number(1);
	}
}

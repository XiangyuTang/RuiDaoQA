package com.neu.ruidaoQA.dao.impl;

import com.neu.ruidaoQA.dao.AnswerDao;
import com.neu.ruidaoQA.dbutil.BaseDao;
import com.neu.ruidaoQA.entity.Answer;

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
	
	@Override//取消相应回答点赞
	public int deleteAcclaim_number(int answer_id) {
		Object[] params = new Object[] {answer_id};
		String sql  = "update answer set acclaim_number = acclaim_number-1  where answer_id = ?";
		int i = super.executeIUD(sql, params);
		return i;
	}

	@Override//取消相应回答踩
	public int deleteDefame_number(int answer_id) {
		Object[] params = new Object[] {answer_id};
		String sql  = "update answer set defame_number = defame_number-1  where answer_id = ?";
		int i = super.executeIUD(sql, params);
		return i;
	}
	
	public static void main(String[] args) {//测试类
		AnswerDaoimpl answerDaoimpl = new AnswerDaoimpl();
		answerDaoimpl.addAcclaim_number(1);
		answerDaoimpl.addDefame_number(1);
	}
	
	@Override//增加一行question的answer
	public int addAnswer(Answer ans) {
		// TODO Auto-generated method stub
		Object[] params = new Object[] {ans.getAnswer_id(),ans.getQuestion_id(),ans.getUser_id(),ans.getContent(),
				ans.getDianzan_num(),ans.getCai_num(),ans.getComment_num(),ans.getPublish_time()};
		String sql = "insert into answer values(?,?,?,?,?,?,?,?)";
		int i = super.executeIUD(sql, params);
		return i;
	}
	
}

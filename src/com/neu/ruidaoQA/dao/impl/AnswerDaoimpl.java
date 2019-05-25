package com.neu.ruidaoQA.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	@Override
	public Answer selectAnswer(int question_id) {
		// TODO Auto-generated method stub
		Object[] params = new Object[] {question_id};
		String sql = "select * from answer where question_id = ? order by comment_number DESC";
		ResultSet rs = super.executeSelect(sql, params);
		Answer a = new Answer(null, null, null, null, null, null, null, null);
		try {
			if (rs.next()) {
				a.setAnswer_id(rs.getInt(1));
				a.setQuestion_id(rs.getInt(2));
				a.setUser_id(rs.getInt(3));
				a.setContent(rs.getString(4));
				a.setDianzan_num(rs.getInt(5));
				a.setCai_num(rs.getInt(6));
				a.setComment_num(rs.getInt(7));
				a.setPublish_time(rs.getDate(8));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return a;
	}

	@Override//获取最热的10条回答
	public List<Answer> getAnswersList(int question_id) {
		Object[] params = new Object[] {question_id};
		String sql = "select * from answer where question_id =? order by comment_number DESC";
		ResultSet rsResultSet = super.executeSelect(sql, params);
		List<Answer> answers = new ArrayList<Answer>();
		int number = 0;
		try {
			rsResultSet.last();
			number = rsResultSet.getRow();
			System.out.println(number);
			rsResultSet.first();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			super.closeAll(con, super.pst, rsResultSet);
		}
		if (number <= 10) {
			try {
				while (rsResultSet.next()) {
					Answer answer = new Answer();
					answer.setAnswer_id(rsResultSet.getInt(1));
					answer.setQuestion_id(rsResultSet.getInt(2));
					answer.setUser_id(rsResultSet.getInt(3));
					answer.setContent(rsResultSet.getString(4));
					answer.setDianzan_num(rsResultSet.getInt(5));
					answer.setCai_num(rsResultSet.getInt(6));
					answer.setComment_num(rsResultSet.getInt(7));
					answer.setPublish_time(rsResultSet.getDate(8));
					answers.add(answer);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				super.closeAll(con, super.pst, rsResultSet);
			}
		}else {
			try {
				for (int i = 0; i < 10; i++) {
					Answer answer = new Answer();
					answer.setAnswer_id(rsResultSet.getInt(1));
					answer.setQuestion_id(rsResultSet.getInt(2));
					answer.setUser_id(rsResultSet.getInt(3));
					answer.setContent(rsResultSet.getString(4));
					answer.setDianzan_num(rsResultSet.getInt(5));
					answer.setCai_num(rsResultSet.getInt(6));
					answer.setComment_num(rsResultSet.getInt(7));
					answer.setPublish_time(rsResultSet.getDate(8));
					answers.add(answer);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				super.closeAll(con, super.pst, rsResultSet);
			}
		}
		return answers;
	}
}

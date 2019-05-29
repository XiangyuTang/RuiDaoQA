package com.neu.ruidaoQA.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.neu.ruidaoQA.dao.AnswerDao;
import com.neu.ruidaoQA.dbutil.BaseDao;
import com.neu.ruidaoQA.entity.Answer;
import com.sun.org.apache.regexp.internal.recompile;

import jdk.nashorn.internal.ir.Flags;

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
		String sql = "select * from answer where question_id = ? order by acclaim_number DESC";
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
			e.printStackTrace();
		} finally {
			super.closeAll(BaseDao.con, BaseDao.pst, rs);
		}
		return a;
	}
	@Override
	public ArrayList<Answer> getAnswerLists(int user_id) {
		Object[] params=new Object[] {user_id};
		ArrayList<Answer> answers=new ArrayList<Answer>();
		String sql="select * from answer where user_id=? order by time desc";
		ResultSet rs=super.executeSelect(sql, params);
		try {
			while(rs.next()) {
				int answer_id=rs.getInt(1);
				int question_id=rs.getInt(2);
				String content=rs.getString(4);
				int agree_number=rs.getInt(5);
				int diss_number=rs.getInt(6);
				int comment_num=rs.getInt(7);
				
				Date time=rs.getDate(8);
				Answer answer=new Answer(answer_id, question_id, user_id, content, agree_number, diss_number, comment_num, time);
				answers.add(answer);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			super.closeAll(BaseDao.con, BaseDao.pst, rs);
		}
		
		return answers;
		
	}

	@Override
	public int getAQuesiton_idByAnswer_id(int answer_id) {
		Object[] params = new Object[] {answer_id};
		String sql = "select question_id from answer where answer_id = ? ";
		int question_id=0;
		ResultSet rs = super.executeSelect(sql, params);
		try {
			if(rs.next()) {
				question_id=rs.getInt(1);
				return question_id;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return 0;
		
	}
	@Override//获取最热的10条回答
	public List<Answer> getAnswersList(int question_id) {
		Object[] params = new Object[] {question_id};
		String sql = "select * from answer where question_id =? order by acclaim_number DESC";
		ResultSet rsResultSet = super.executeSelect(sql, params);
		List<Answer> answers = new ArrayList<Answer>();
		int i = 0;
		try {
			while (rsResultSet.next()) {
				i++;
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
				if (i == 10) {
					return answers;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.closeAll(BaseDao.con, BaseDao.pst, rs);
		}
		return answers;
	}
	
	@Override
	public List<Answer> getAnswerByAcclaimNum() {
		// TODO Auto-generated method stub
		String sql = "select * from answer order by comment_number DESC";
		ResultSet rs = super.executeSelect(sql, null);
		List<Answer> getAnswerByAcclaimNum = new ArrayList<Answer>();
		int i = 0;
		try {
			while (rs.next()) {
				i++;
				Answer answer = new Answer();
				answer.setAnswer_id(rs.getInt(1));
				answer.setQuestion_id(rs.getInt(2));
				answer.setUser_id(rs.getInt(3));
				answer.setContent(rs.getString(4));
				answer.setDianzan_num(rs.getInt(5));
				answer.setCai_num(rs.getInt(6));
				answer.setComment_num(rs.getInt(7));
				answer.setPublish_time(rs.getDate(8));
				getAnswerByAcclaimNum.add(answer);
				if (i == 10) {
//					return getAnswerByAcclaimNum;
					break;
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			super.closeAll(con, super.pst, rs);
		}
//		return getAnswerByAcclaimNum;
		return getAnswerByAcclaimNum;
	}

	@Override
	public Integer getNewAnswer_id() {
		Object[] params = new Object[] {0};
		String sql = "select max(answer_id) from answer where answer_id>?";
		ResultSet rsResultSet = super.executeSelect(sql, params);
		Integer answer_id = null;
		try {
			while (rsResultSet.next()) {
				answer_id = rsResultSet.getInt(1);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			super.closeAll(BaseDao.con, BaseDao.pst, rs);
		}
		return answer_id;
	}
}

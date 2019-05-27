package com.neu.ruidaoQA.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import com.neu.ruidaoQA.dao.QuestionDao;
import com.neu.ruidaoQA.dbutil.BaseDao;
import com.neu.ruidaoQA.entity.Question;

public class QuestionDaoimpl extends BaseDao implements QuestionDao {
	public int addQuestion(Question q) {
		Integer question_id = q.getQuestion_id();
		Integer user_id = q.getUser_id();
		Integer question_type = q.getQues_type_id();
		String question_content = q.getContent();
		Integer collect_number = q.getCollect_num();
		Integer answer_number = q.getAnswer_num();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=sdf.format(new Date());
		
		String ques_type = q.getQues_title();
		Object[] params = new Object[] { question_id, question_type, user_id, question_content, collect_number,
				answer_number, date, ques_type };
		String sql = "insert into question values(?,?,?,?,?,?,?,?)";
		int i = super.executeIUD(sql, params);
		return i;
	}
	
	@Override
	public Question getQuestion(int question_id) {
		Question q = new Question();
		Object[] params = new Object[] { question_id };
		String sql = "select * from question where question_id=?";
		ResultSet rs = super.executeSelect(sql, params);
		try {
			if (rs.next()) {
				q.setQuestion_id(rs.getInt(1));
				q.setQues_type_id(rs.getInt(2));
				q.setUser_id(rs.getInt(3));
				q.setContent(rs.getString(4));
				q.setCollect_num(rs.getInt(5));
				q.setAnswer_num(rs.getInt(6));
				q.setPublish_time(rs.getDate(7));
				q.setQues_title(rs.getString(8));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			super.closeAll(BaseDao.con, BaseDao.pst, rs);
		}
		return q;
	}
	@Override
	public ArrayList<Question> getQuestionLists(int user_id) {
		// TODO Auto-generated method stub
		ArrayList<Question> questions=new ArrayList<Question>();
		Object[] params=new Object[] {user_id};
		String sql="select * from question where user_id=?";
		ResultSet rs=super.executeSelect(sql, params);
		try {
			while(rs.next()) {
				int question_id=rs.getInt(1);
				int question_type=rs.getInt(2);
				String question_content=rs.getString(4);
				int collect_number=rs.getInt(5);
				int answer_number=rs.getInt(6);
				Date time=rs.getTimestamp(7);
				String question_title=rs.getString(8);
				Question q=new Question(question_id, user_id, question_type, question_content, collect_number, answer_number, time, question_title);
				questions.add(q);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll(BaseDao.con, BaseDao.pst, rs);
		}
		return questions;
	}

	@Override
	public List<Question> getQuestionByType(int kinds_id) {
		// TODO Auto-generated method stub
		Object[] params = new Object[] {kinds_id};
		String sql = "select * from question where question_type=? order by answer_number DESC";
		ResultSet rs = super.executeSelect(sql, params);
		List<Question> list = new ArrayList<Question>();
		int i = 0;
		try {
			while (rs.next()) {
				i++;
				Question question = new Question();
				question.setQuestion_id(rs.getInt(1));
				question.setQues_type_id(rs.getInt(2));
				question.setUser_id(rs.getInt(3));
				question.setContent(rs.getString(4));
				question.setCollect_num(rs.getInt(5));
				question.setAnswer_num(rs.getInt(6));
				question.setPublish_time(rs.getDate(7));
				question.setQues_title(rs.getString(8));
				list.add(question);
				if (i==10) {
					return list;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			super.closeAll(con, super.pst, rs);
		}
		return list;
	}
	
	
	@Override
	public ArrayList<Question> getSearchResult(String txt) {
		ArrayList<Question> list = new ArrayList<Question>();
		Object[] params = new Object[] {txt,txt};
		String sql = "select * from question where question_content like \"%\"?\"%\" or question_title like \"%\"?\"%\" order by answer_number DESC";//转义字符
		ResultSet rs = super.executeSelect(sql, params);
		try {
			while(rs.next()) {
				Question question = new Question();
				question.setQuestion_id(rs.getInt(1));
				question.setQues_type_id(rs.getInt(2));
				question.setUser_id(rs.getInt(3));
				question.setContent(rs.getString(4));
				question.setCollect_num(rs.getInt(5));
				question.setAnswer_num(rs.getInt(6));
				question.setPublish_time(rs.getDate(7));
				question.setQues_title(rs.getString(8));
				list.add(question);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {//测试类
		
		/*Question q=new Question(null,1,1,"惹惹惹",1,1,null,"嘿嘿嘿");
		System.out.print("dasds");
		QuestionDaoimpl qdi=new QuestionDaoimpl();
		System.out.print(qdi.addQuestion(q));*/
		QuestionDaoimpl qdi=new QuestionDaoimpl();
		ArrayList<Question> list = qdi.getSearchResult("坤");
		System.out.println(list.size());
	}

	@Override
	public List<Question> getQuestionByCollectNum() {
		// TODO Auto-generated method stub
		String sql = "select * from question order by collect_number DESC";
		ResultSet rs = super.executeSelect(sql, null);
		List<Question> getQuestionByCollectNum = new ArrayList<Question>();
		int i = 0;
		try {
			while (rs.next()) {
				i++;
				Question question = new Question();
				question.setQuestion_id(rs.getInt(1));
				question.setQues_type_id(rs.getInt(2));
				question.setUser_id(rs.getInt(3));
				question.setContent(rs.getString(4));
				question.setCollect_num(rs.getInt(5));
				question.setAnswer_num(rs.getInt(6));
				question.setPublish_time(rs.getDate(7));
				question.setQues_title(rs.getString(8));
				getQuestionByCollectNum.add(question);
				if (i==10) {
					return getQuestionByCollectNum;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			super.closeAll(con, super.pst, rs);
		}
		return getQuestionByCollectNum;
	}

	
}

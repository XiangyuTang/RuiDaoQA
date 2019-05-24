package com.neu.ruidaoQA.dao.impl;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	public List<Question> getQuestionByType(int kinds_id) {
		// TODO Auto-generated method stub
		Object[] params = new Object[] {kinds_id};
		String sql = "select * from question where question_type=? order by answer_number DESC";
		ResultSet rs = super.executeSelect(sql, params);
		List<Question> list = new ArrayList<Question>();
		try {
			while (rs.next()) {
				Question question = new Question(null, null, null, null, null, null, null, null);
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			super.closeAll(con, super.pst, rs);
		}
		return list;
	}
	
	public static void main(String[] args) {//测试类
		
		Question q=new Question(null,1,1,"惹惹惹",1,1,null,"嘿嘿嘿");
		System.out.print("dasds");
		QuestionDaoimpl qdi=new QuestionDaoimpl();
		System.out.print(qdi.addQuestion(q));
	}



	
}

package com.neu.ruidaoQA.dao.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		    String dateStr=sdf.format(q.getPublish_time());

		Object[] params = new Object[] { question_id, question_type, user_id, question_content, collect_number,
				answer_number, dateStr };
		String sql = "insert into question values(?,?,?,?,?,?,?)";
		int i = super.executeIUD(sql, params);

		return i;

	}

	
	public static void main(String[] args) {//测试类
		Question q=new Question(1,1,1,"cas",1,1,null);
		System.out.print("dasds");
		QuestionDaoimpl qdi=new QuestionDaoimpl();
		System.out.print(qdi.addQuestion(q));
	}
}

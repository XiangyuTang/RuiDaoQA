package com.neu.ruidaoQA.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.neu.ruidaoQA.dao.impl.QuestionDaoimpl;
import com.neu.ruidaoQA.entity.Answer;
import com.neu.ruidaoQA.entity.Question;
import com.neu.ruidaoQA.entity.User;
import com.neu.ruidaoQA.service.QuestionService;

public class QuestionServiceimpl implements QuestionService{

	@Override
	public int addQuestion(Question q) {
		// TODO Auto-generated method stub
		QuestionDaoimpl qdi=new QuestionDaoimpl();
		int i =qdi.addQuestion(q);
		return i;
	}

	@Override
	public Question createQuestion(Integer question_id, Integer user_id, Integer ques_type_id, String content,
			Integer collect_num, Integer answer_num, Date publish_time,String ques_title) {
		// TODO Auto-generated method stub
		Question q=new Question( question_id,  user_id,  ques_type_id,  content,
			 collect_num,  answer_num, publish_time,ques_title);
		return q;
	}
	
	public void test() {
		QuestionDaoimpl q1 = new QuestionDaoimpl();
		List<Question> list = q1.getQuestionByType(1);
		for (Question question:list) {
			System.out.print(question.getQuestion_id());
			System.out.print(question.getQues_type_id());
			System.out.print(question.getUser_id());
			System.out.print(question.getContent());
			System.out.print(question.getCollect_num());
			System.out.print(question.getAnswer_num());
			System.out.print(question.getPublish_time());
			System.out.print(question.getQues_title());
			System.out.println();
		}
	}
	public ArrayList<Question> getQuestionLists(int user_id){
		QuestionDaoimpl qdi=new QuestionDaoimpl();
		ArrayList<Question> questions=qdi.getQuestionLists(user_id);
	
		
		
		return questions;
	}
	@Override
	public Question getQuestion(int question_id) {
		// TODO Auto-generated method stub
		Question q = null;
		QuestionDaoimpl qdi=new QuestionDaoimpl();
		q = qdi.getQuestion(question_id);
		return q;
	}

	
	public static void main(String[] args) {
		QuestionServiceimpl questionServiceimpl = new QuestionServiceimpl();
		questionServiceimpl.test();
	}

	@Override
	public List<Answer> getAnswersList(int question_id) {
		// TODO Auto-generated method stub
		return null;
	}
	


	
}


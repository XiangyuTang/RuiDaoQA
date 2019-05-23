package com.neu.ruidaoQA.service.impl;

import java.sql.Date;
import java.util.UUID;
import com.neu.ruidaoQA.dao.impl.QuestionDaoimpl;
import com.neu.ruidaoQA.entity.Question;
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
		String uuid=UUID.randomUUID().toString().replace("-", "");
		return q;
	}

}

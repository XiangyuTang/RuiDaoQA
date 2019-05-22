package com.neu.ruidaoQA.dao.impl;

import com.neu.ruidaoQA.dao.QuestionDao;
import com.neu.ruidaoQA.dbutil.BaseDao;
import com.neu.ruidaoQA.entity.Question;

public class QuestionDaoimpl extends BaseDao implements QuestionDao{
	public int addQuestion(Question q) {
		Integer question_id=q.getQuestion_id();
		Integer user_id=q.getUser_id();
		Integer question_type=q.getQues_type_id();
		String question_content=q.getContent();
		Integer collect_number=q.getCollect_num();
		
		
		return 0;
		
	}

}

package com.neu.ruidaoQA.service;

import java.sql.Date;

import com.neu.ruidaoQA.entity.Question;

public interface QuestionService {
	public int addQuestion(Question q);
	public Question createQuestion(Integer question_id, Integer user_id, Integer ques_type_id, String content, Integer collect_num,
			Integer answer_num, Date publish_time,String ques_title);
	public Question getQuestion(int question_id);
}

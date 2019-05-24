package com.neu.ruidaoQA.dao;

import java.util.List;

import com.neu.ruidaoQA.entity.Question;

public interface QuestionDao {
	public int addQuestion(Question q);

	public Question getQuestion(int question_id);

	List<Question> getQuestionByType(int kinds_id);//根据kinds_id选出热度最高的5条话题

}

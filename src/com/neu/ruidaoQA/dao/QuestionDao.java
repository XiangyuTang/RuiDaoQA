package com.neu.ruidaoQA.dao;

import java.util.ArrayList;
import java.util.List;

import com.neu.ruidaoQA.entity.Question;

public interface QuestionDao {
	public int addQuestion(Question q);

	public Question getQuestion(int question_id);

	public ArrayList<Question> getQuestionLists(int user_id);
	
	public List<Question> getQuestionByType(int kinds_id);//根据kinds_id选出热度最高的5条话题
	
	public ArrayList<Question> getSearchResult(String txt);
	
	public List<Question> getQuestionByCollectNum();//从所有话题中选出回答数最多的10条话题
	
	public List<Question> getQuestionByTypeandnumber(Integer kinds_id, Integer min, Integer max);
}

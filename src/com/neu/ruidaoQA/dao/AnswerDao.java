package com.neu.ruidaoQA.dao;

public interface AnswerDao {
	int addAcclaim_number(int answer_id);//增加相应回答点赞数
	int addDefame_number(int answer_id);//增加相应回答踩数
}

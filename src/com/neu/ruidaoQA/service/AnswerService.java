package com.neu.ruidaoQA.service;

import com.neu.ruidaoQA.entity.Answer;

public interface AnswerService {
	int addAcclaim_number(int answer_id);//增加相应回答点赞数
	int addDefame_number(int answer_id);//增加相应回答踩数
	int add_answer(Answer ans);
}

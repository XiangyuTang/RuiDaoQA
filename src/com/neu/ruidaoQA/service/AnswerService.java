package com.neu.ruidaoQA.service;

import java.util.Date;

import com.neu.ruidaoQA.entity.Answer;

public interface AnswerService {
	int addAcclaim_number(int answer_id);//增加相应回答点赞数
	int deleteAcclaim_number(int answer_id);//取消相应回答点赞
	int addDefame_number(int answer_id);//增加相应回答踩数
	int deleteDefame_number(int answer_id);//取消相应回答踩	
	int add_answer(Answer ans);
	Answer createAnswer(Integer answer_id, Integer question_id, Integer user_id, String content, Integer dianzan_num,
			Integer cai_num, Integer comment_num, Date publish_time);
}

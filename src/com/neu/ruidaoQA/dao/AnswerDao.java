package com.neu.ruidaoQA.dao;

import com.neu.ruidaoQA.entity.Answer;

public interface AnswerDao {
	int addAcclaim_number(int answer_id);//增加相应回答点赞数
	int deleteAcclaim_number(int answer_id);//取消相应回答的点赞
	int addDefame_number(int answer_id);//增加相应回答踩数
	int deleteDefame_number(int answer_id);//取消相应回答踩数
	int addAnswer(Answer ans);//增加一行question的answer
	Answer selectAnswer(int question_id);//选出一个话题评论量最多的回答
	
}

package com.neu.ruidaoQA.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.neu.ruidaoQA.entity.Answer;

public interface AnswerService {
	int addAcclaim_number(int answer_id);//增加相应回答点赞数
	int deleteAcclaim_number(int answer_id);//取消相应回答点赞
	int addDefame_number(int answer_id);//增加相应回答踩数
	int deleteDefame_number(int answer_id);//取消相应回答踩	
	int add_answer(Answer ans);
	Answer createAnswer(Integer answer_id, Integer question_id, Integer user_id, String content, Integer dianzan_num,
			Integer cai_num, Integer comment_num, Date publish_time);
	List<Answer> getAnswerslist(int question_id);//根据问题id获取最热的十条回答及其评论
	public ArrayList<Answer> getAnswerLists(int user_id);
	List<Answer> getAnswerByAcclaimNum();////按照点赞数多少选出所有回答
	Integer getNewAnswer_id();//选出新增答案的id
	public int getAQuesiton_idByAnswer_id(int answer_id);
}

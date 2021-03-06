package com.neu.ruidaoQA.dao;

import java.util.ArrayList;
import java.util.List;

import com.neu.ruidaoQA.entity.Answer;

public interface AnswerDao {
	int addAcclaim_number(int answer_id);//增加相应回答点赞数
	int deleteAcclaim_number(int answer_id);//取消相应回答的点赞
	int addDefame_number(int answer_id);//增加相应回答踩数
	int deleteDefame_number(int answer_id);//取消相应回答踩数
	int addAnswer(Answer ans);//增加一行question的answer
	Answer selectAnswer(int question_id);//选出一个话题评论量最多的回答
	List<Answer> getAnswersList(int question_id);//根据问题id获取最热的十条回答
	ArrayList<Answer> getAnswerLists(int user_id);//根据用户id来获取历史回答列表
	List<Answer> getAnswerByAcclaimNum();//按照点赞数多少选出所有回答
	Integer getNewAnswer_id();//选出新增答案的id
	public int getAQuesiton_idByAnswer_id(int answer_id);


}

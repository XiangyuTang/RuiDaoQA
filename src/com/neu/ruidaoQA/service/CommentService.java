package com.neu.ruidaoQA.service;

import java.util.Date;

public interface CommentService {
	int addAcclaim_number(int comment_id);//增加相应评论的点赞数
	//添加一条评论
	int addComment(Integer answer_id,Integer user_id,String comment_content, Integer comment_flag,Integer acclaim_number,Date time);
}

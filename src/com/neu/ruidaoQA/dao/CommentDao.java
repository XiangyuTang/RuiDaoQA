package com.neu.ruidaoQA.dao;

public interface CommentDao {
	int addAcclaim_number(int comment_id);//增加相应评论的点赞数（评论没有踩，数据库没有相应设计）
	int addComment()
}

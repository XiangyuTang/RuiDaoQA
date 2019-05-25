package com.neu.ruidaoQA.dao;

import java.util.List;

import com.neu.ruidaoQA.entity.Comment;

public interface CommentDao {
	int addAcclaim_number(int comment_id);//增加相应评论的点赞数（评论没有踩，数据库没有相应设计）
	int addComment(Comment comment);//增加评论
	List<Comment> getCommentsList(int answer_id);//根据answer_id选出其热度最高的十条评论
}

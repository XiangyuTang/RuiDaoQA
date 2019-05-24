package com.neu.ruidaoQA.service.impl;

import java.util.Date;

import com.neu.ruidaoQA.dao.impl.CommentDaoimpl;
import com.neu.ruidaoQA.entity.Comment;
import com.neu.ruidaoQA.service.CommentService;

public class CommentServiceimpl implements CommentService{

	@Override
	public int addAcclaim_number(int comment_id) {//增加相应评论点赞数
		CommentDaoimpl commentDaoimpl = new CommentDaoimpl();
		int i = commentDaoimpl.addAcclaim_number(comment_id);
		return i;
	}
	
	public static void main(String[] args) {//测试类
		CommentServiceimpl commentServiceimpl = new CommentServiceimpl();
		int i =commentServiceimpl.addAcclaim_number(1);
		System.out.println(i);
	}

	@Override
	public int addComment(Integer answer_id, Integer user_id, String comment_content, Integer comment_flag, Integer acclaim_number,
			Date time) {
		Comment comment = new Comment(null,answer_id,user_id,comment_content,comment_flag,acclaim_number,time);
		CommentDaoimpl commentDaoimpl = new CommentDaoimpl();
		int i = commentDaoimpl.addComment(comment);
		return i;
	}
}

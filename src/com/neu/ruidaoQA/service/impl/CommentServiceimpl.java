package com.neu.ruidaoQA.service.impl;

import com.neu.ruidaoQA.dao.impl.CommentDaoimpl;
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
}

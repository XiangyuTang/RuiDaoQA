package com.neu.ruidaoQA.dao.impl;

import com.neu.ruidaoQA.dao.CommentDao;
import com.neu.ruidaoQA.dbutil.BaseDao;
import com.neu.ruidaoQA.entity.Comment;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class CommentDaoimpl extends BaseDao implements CommentDao{
	
	@Override
	public int addAcclaim_number(int comment_id) {//增加相应评论的点赞数
		Object[] params = new Object[] {comment_id};
		String sql  = "update comment set acclaim_number = acclaim_number+1  where comment_id = ?";
		int i = super.executeIUD(sql, params);
		return i;
	}
	
	public static void main(String[] args) {//测试类
		CommentDaoimpl commentDaoimpl = new CommentDaoimpl();
		int i = commentDaoimpl.addAcclaim_number(1);
		System.out.println(i);
	}

	@Override//增加一条评论
	public int addComment(Comment comment) {
		Object[] params = new Object[] {comment.getAnswer_id(),comment.getUser_id(),comment.getContent(),comment.getFlag(),comment.getDianzan_num(),comment.getPublish_time()};
		String sql = "insert into comment(answer_id,user_id,comment_content,comment_flag,acclaim_number,time) values(?,?,?,?,?,?)";
		int i = super.executeIUD(sql, params);
		return i;
	}
}

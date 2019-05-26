package com.neu.ruidaoQA.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.neu.ruidaoQA.dao.CommentDao;
import com.neu.ruidaoQA.dbutil.BaseDao;
import com.neu.ruidaoQA.entity.Answer;
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

	@Override//根据answer_id选出其最热的10条评论
	public List<Comment> getCommentsList(int answer_id) {
		Object[] params = new Object[] {answer_id};
		String sql = "select * from comment where answer_id =? order by acclaim_number DESC";
		ResultSet rsResultSet = super.executeSelect(sql, params);
		List<Comment> comments = new ArrayList<Comment>();
		int i = 0;
		try {
			while (rsResultSet.next()) {
				i++;
				Comment comment = new Comment();
				comment.setComment_id(rsResultSet.getInt(1));
				comment.setAnswer_id(rsResultSet.getInt(2));
				comment.setUser_id(rsResultSet.getInt(3));
				comment.setContent(rsResultSet.getString(4));
				comment.setFlag(rsResultSet.getInt(5));
				comment.setDianzan_num(rsResultSet.getInt(6));
				comment.setPublish_time(rsResultSet.getDate(7));
				comments.add(comment);
				if (i == 10) {
					return comments;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			super.closeAll(con, super.pst, rsResultSet);
		}
		return comments;
	}

	@Override
	public int deleteAcclaim_number(int comment_id) {//取消相应评论的点赞
		Object[] params = new Object[] {comment_id};
		String sql  = "update comment set acclaim_number = acclaim_number-1  where comment_id = ?";
		int i = super.executeIUD(sql, params);
		return i;
	}
}

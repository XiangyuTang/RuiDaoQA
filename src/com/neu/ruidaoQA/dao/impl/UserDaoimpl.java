package com.neu.ruidaoQA.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;

import com.neu.ruidaoQA.dao.UserDao;
import com.neu.ruidaoQA.dbutil.BaseDao;
import com.neu.ruidaoQA.entity.Comment;
import com.neu.ruidaoQA.entity.User;

public class UserDaoimpl extends BaseDao implements UserDao{

	@Override
	public ArrayList<Comment> getComments(int user_id){
		Object[] params = new Object[] {user_id};
		String sql = "select * from comment where answer_id in (select answer_id from answer where user_id=?) order by time DESC";
		ArrayList<Comment> comments=new ArrayList<Comment>();
		ResultSet rs = super.executeSelect(sql, params);
		try {
			while(rs.next()) {
				
				int comment_id=rs.getInt(1);
				int answer_id=rs.getInt(2);
				int comment_user_id=rs.getInt(3);
				String content=rs.getString(4);
				int flag=rs.getInt(5);
				int acclaim_number=rs.getInt(6);
				Date time=rs.getTimestamp(7);
				Comment comment=new Comment(comment_id,answer_id,comment_user_id,content,flag,acclaim_number,time);
				comments.add(comment);				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.closeAll(BaseDao.con, BaseDao.pst, rs);
		}
		return comments;
		
	}

	@Override
	public User selectUser(int user_id) {
		// TODO Auto-selectUsergenerated method stub
		Object[] params = new Object[] {user_id};
		String sql = "select * from users where user_id = ?";
		ResultSet rs = super.executeSelect(sql, params);
		User u = new User(null, null, null, null, null, null, null, null);
		try {
			if (rs.next()) {
				u.setUser_id(rs.getInt(1));
				u.setNick_name(rs.getString(2));
				u.setSex(rs.getString(3));
				u.setBirthday(rs.getDate(4));
				u.setPassword(rs.getString(5));
				u.setEmail(rs.getString(6));
				u.setHead_photo(rs.getString(7));
				u.setIntroduce(rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			super.closeAll(con, super.pst, rs);
		}
		return u;
	}
	
	public static void main(String[] args) {//娴嬭瘯绫�
		
//		Question q=new Question(null,1,1,"鎯规児鎯�",1,1,null,"鍢垮樋鍢�");
//		System.out.print("dasds");
//		QuestionDaoimpl qdi=new QuestionDaoimpl();
//		System.out.print(qdi.addQuestion(q));
		

	}

	@Override//根据question_id选出其对应的用户
	public User selectUserByAnswer_id(int Answer_id) {
		Object[] params = new Object[] {Answer_id};
		String sql = "select * from users where user_id in (select user_id from answer where answer_id =?)";
		ResultSet rsResultSet = super.executeSelect(sql, params);
		User user = new User();
		try {
			while (rsResultSet.next()) {
				user.setUser_id(rsResultSet.getInt(1));
				user.setNick_name(rsResultSet.getString(2));
				user.setSex(rsResultSet.getString(3));
				user.setBirthday(rsResultSet.getDate(4));
				user.setPassword(rsResultSet.getString(5));
				user.setEmail(rsResultSet.getString(6));
				user.setHead_photo(rsResultSet.getString(7));
				user.setIntroduce(rsResultSet.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			super.closeAll(con, super.pst, rsResultSet);
		}
		
		return user;
	}

	@Override//根据comment_id选出其对应的用户
	public User selectUserByComment_id(int comment_id) {
		Object[] params = new Object[] {comment_id};
		String sql = "select * from users where user_id in (select user_id from comment where comment_id =?)";
		ResultSet rsResultSet = super.executeSelect(sql, params);
		User user = new User();
		try {
			while (rsResultSet.next()) {
				user.setUser_id(rsResultSet.getInt(1));
				user.setNick_name(rsResultSet.getString(2));
				user.setSex(rsResultSet.getString(3));
				user.setBirthday(rsResultSet.getDate(4));
				user.setPassword(rsResultSet.getString(5));
				user.setEmail(rsResultSet.getString(6));
				user.setHead_photo(rsResultSet.getString(7));
				user.setIntroduce(rsResultSet.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			super.closeAll(con, super.pst, rsResultSet);
		}
		
		return user;
	}
	
}

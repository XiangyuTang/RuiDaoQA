package com.neu.ruidaoQA.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	public User selectUser(Object[] params) {
		// TODO Auto-generated method stub
		ResultSet rs = super.executeSelect("select * from users where email=? and userPwd=?", params);
		User u2=new User();
		try {
			if (rs.next()) {
				u2.setUser_id(rs.getInt(1));
				u2.setNick_name(rs.getString(2));
				u2.setSex(rs.getString(3));
				u2.setBirthday(rs.getDate(4));
				u2.setPassword(rs.getString(5));
				u2.setEmail(rs.getString(6));
				u2.setHead_photo(rs.getString(7));
				u2.setIntroduce(rs.getString(8));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			super.closeAll(BaseDao.con, BaseDao.pst, rs);
		}
		return u2;
	}
	public int addUser(Object[] params) {
		// TODO Auto-generated method stub
		int rs = super.executeIUD("insert into users(nickname,sex,birthday,userPwd,email,head_photo,introduce) "
				+ "values(?,?,?,?,?,?,?)",new Object[] {params[2],params[5],params[3],params[1],params[0],null,params[4]} );
		try {
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			
		}
		return rs;
	}


	@Override
	public int updateUser(User u) {
		// TODO Auto-generated method stub
		//不更新headphoto的值
		int rs = super.executeIUD("update users set nickname=?,sex=?,birthday=?,userPwd=?,email=?,introduce=? where user_id=?",
				new Object[] {u.getNick_name(),u.getSex(),u.getBirthday(),u.getPassword(),u.getEmail(),u.getIntroduce(),u.getUser_id()});
		try {
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			
		}
		return rs;
	}

	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from users";
		ResultSet rs = super.executeSelect(sql, null);
		List<User> lu = new ArrayList<User>();
		try {
			while(rs.next()) {
				User u = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
				lu.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lu;
	}
	@Override
	public void addHeadPhoto(Object[] params) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String sql = "update users set head_photo = ? where user_id = ?";
		super.executeIUD(sql, params);
	}

	@Override
	public User selectUser(int user_id) {
		// TODO Auto-selectUsergenerated method stub
		Object[] params = new Object[] {user_id};
		String sql = "select * from users where user_id = ?";
		ResultSet rs = super.executeSelect(sql, params);
		User u = new User(null, null, null, null, null, null, null, null);
		try {
			while (rs.next()) {
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

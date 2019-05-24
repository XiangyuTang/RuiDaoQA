package com.neu.ruidaoQA.dao.impl;

import java.sql.ResultSet;
import java.time.Year;

import com.neu.ruidaoQA.dao.UserDao;
import com.neu.ruidaoQA.dbutil.BaseDao;
import com.neu.ruidaoQA.entity.User;

public class UserDaoimpl extends BaseDao implements UserDao{

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
			// TODO: handle exception
			e.printStackTrace();
		}
		return u;
	}
	
	public static void main(String[] args) {//娴嬭瘯绫�
		
//		Question q=new Question(null,1,1,"鎯规児鎯�",1,1,null,"鍢垮樋鍢�");
//		System.out.print("dasds");
//		QuestionDaoimpl qdi=new QuestionDaoimpl();
//		System.out.print(qdi.addQuestion(q));
		

	}
	
}

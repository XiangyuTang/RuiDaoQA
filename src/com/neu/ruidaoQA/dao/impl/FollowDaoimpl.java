package com.neu.ruidaoQA.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.neu.ruidaoQA.dao.FollowDao;
import com.neu.ruidaoQA.dbutil.BaseDao;

public class FollowDaoimpl extends BaseDao implements FollowDao {

	@Override
	public int addFollow(int this_user_id, int follow_user_id) {//根据两人的id号添加关注
		Object[] params = new Object[] {this_user_id, follow_user_id};
		String sql  = "insert into follow(this_user_id, follow_user_id) values (?,?)";
		int i = super.executeIUD(sql, params);
		return i;
	}

	@Override
	public int deleteFollow(int this_user_id, int follow_user_id) {//根据两人的id号取消关注
		Object[] params = new Object[] {this_user_id, follow_user_id};
		String sql  = "delete from follow where this_user_id=? and follow_user_id=?";
		int i = super.executeIUD(sql, params);
		return i;
	}

	@Override
	public ArrayList<Integer> getFollow_user_idlist(int this_user_id) {
		ArrayList<Integer> follow_user_idlists = new ArrayList<Integer>();
		Object[] params=new Object[] {this_user_id};
		String sql="select follow_user_id from follow where this_user_id=?";
		ResultSet rs=super.executeSelect(sql, params);
		try {
			while(rs.next()) {
				follow_user_idlists.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			super.closeAll(BaseDao.con, BaseDao.pst, rs);
		}
		return follow_user_idlists;
	}
	
}

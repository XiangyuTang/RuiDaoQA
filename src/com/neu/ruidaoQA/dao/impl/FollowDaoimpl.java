package com.neu.ruidaoQA.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neu.ruidaoQA.dao.FollowDao;
import com.neu.ruidaoQA.dbutil.BaseDao;
import com.neu.ruidaoQA.entity.Follow;

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
	public List<Follow> selectFollowById(int Id) {
		// TODO Auto-generated method stub
		System.out.println("bbbbbbbbbbbb"+Id);
		String sql = "select * from follow where follow_user_id = "+Id;
		ResultSet rs = super.executeSelect(sql, null);
		
		List<Follow> lf = new ArrayList<Follow>();
		try {
			if(rs!=null) {
				
			
			while(rs.next()) {
				Follow f = new Follow();
				
				f.setFollow_id(rs.getInt(1));
				f.setThis_user_id(rs.getInt(2));
				f.setFollow_user_id(rs.getInt(3));
				lf.add(f);
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("eeeeeeeeeeeeeeeee"+lf.get(0).getFollow_user_id());
		return lf;
	}

	@Override
	public List<Follow> selectGuanZhuById(int Id) {
		// TODO Auto-generated method stub
		String sql = "select * from follow where this_user_id = "+Id;
		ResultSet rs = super.executeSelect(sql,null);
		List<Follow> lf = new ArrayList<Follow>();
		try {
			while(rs.next()) {
				Follow f = new Follow();
				f.setFollow_id(rs.getInt(1));
				f.setThis_user_id(rs.getInt(2));
				f.setFollow_user_id(rs.getInt(3));
				lf.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lf;
	}
}

package com.neu.ruidaoQA.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.neu.ruidaoQA.dao.CommentDao;
import com.neu.ruidaoQA.dao.FavoriteDao;
import com.neu.ruidaoQA.dbutil.BaseDao;
import com.neu.ruidaoQA.entity.Question;

public class FavoriteDaoimpl extends BaseDao implements FavoriteDao{

	@Override
	public int addFavorite(int question_id, int user_id) {//根据user_id和question_id添加收藏
		Object[] params = new Object[] {question_id, user_id};
		String sql  = "insert into favorite(question_id, user_id) values (?,?)";
		int i = super.executeIUD(sql, params);
		return i;
	}

	@Override
	public int deleteFavorite(int question_id, int user_id) {//根据user_id和question_id删除收藏
		Object[] params = new Object[] {question_id, user_id};
		String sql  = "delete from favorite where question_id=? and user_id=?";
		int i = super.executeIUD(sql, params);
		return i;
	}

	@Override
	public ArrayList<Question> getFavoriteQuestions(int user_id) {
		// TODO Auto-generated method stub
		ArrayList<Question> questions=new ArrayList<Question>();
		Object[] params=new Object[] {user_id};
		String sql="select * from question where question_id in (select question_id from favorite where user_id=?)";
		ResultSet rs=super.executeSelect(sql, params);
		try {
			while(rs.next()) {
				int question_id=rs.getInt(1);
				int user_id_ask=rs.getInt(3);
				int question_type=rs.getInt(2);
				String question_content=rs.getString(4);
				int collect_number=rs.getInt(5);
				int answer_number=rs.getInt(6);
				Date time=rs.getTimestamp(7);
				String question_title=rs.getString(8);
				Question q=new Question(question_id, user_id_ask, question_type, question_content, collect_number, answer_number, time, question_title);
				questions.add(q);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			super.closeAll(BaseDao.con, BaseDao.pst, rs);
		}
		return questions;
	}
	
}

package com.neu.ruidaoQA.dao.impl;

import com.neu.ruidaoQA.dao.CommentDao;
import com.neu.ruidaoQA.dao.FavoriteDao;
import com.neu.ruidaoQA.dbutil.BaseDao;

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
	
}

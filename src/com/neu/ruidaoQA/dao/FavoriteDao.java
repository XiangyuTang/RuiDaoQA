package com.neu.ruidaoQA.dao;

public interface FavoriteDao {
	int addFavorite(int question_id, int user_id);//根据user_id和question_id添加收藏
	int deleteFavorite(int question_id, int user_id);//根据user_id和question_id删除收藏
}

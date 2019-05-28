package com.neu.ruidaoQA.dao;
import java.util.ArrayList;

import com.neu.ruidaoQA.entity.Question;

public interface FavoriteDao {
	int addFavorite(int question_id, int user_id);//根据user_id和question_id添加收藏
	int deleteFavorite(int question_id, int user_id);//根据user_id和question_id删除收藏
	public ArrayList<Question> getFavoriteQuestions(int user_id);
	public ArrayList<Integer> getFavoriteQuestion_id(int user_id);//选出其收藏的问题id列表
}

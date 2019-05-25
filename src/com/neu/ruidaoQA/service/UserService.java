package com.neu.ruidaoQA.service;

import java.util.ArrayList;

import com.neu.ruidaoQA.entity.Question;

public interface UserService {
	public void dologin();
	public void dologout();
	public void doregister();
	public int addFollow(int this_user_id, int follow_user_id);
	public int deleteFollow(int this_user_id, int follow_user_id);
	public int addFavorite(int question_id, int user_id);
	public int deleteFavorite(int question_id, int user_id);
	public ArrayList<Question> getFavoriteQuestions(int user_id) ;

	
}

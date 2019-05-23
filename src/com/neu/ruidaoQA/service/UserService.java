package com.neu.ruidaoQA.service;

public interface UserService {
	public void dologin();
	public void dologout();
	public void doregister();
	public int addFollow(int this_user_id, int follow_user_id);
	public int deleteFollow(int this_user_id, int follow_user_id);
	public int addFavorite(int question_id, int user_id);
	public int deleteFavorite(int question_id, int user_id);
	
}

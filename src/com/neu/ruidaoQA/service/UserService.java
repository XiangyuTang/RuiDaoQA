package com.neu.ruidaoQA.service;

import java.util.ArrayList;
import java.util.List;

import com.neu.ruidaoQA.entity.Comment;
import com.neu.ruidaoQA.entity.Question;
import com.neu.ruidaoQA.entity.User;

public interface UserService {
	public void dologin();
	public void dologout();
	public void doregister();
	public int addFollow(int this_user_id, int follow_user_id);
	public int deleteFollow(int this_user_id, int follow_user_id);
	public int addFavorite(int question_id, int user_id);
	public int deleteFavorite(int question_id, int user_id);
	public ArrayList<Question> getFavoriteQuestions(int user_id) ;
	public String getUserName(int user_id);
	public ArrayList<Object[]> getAnswersList(int user_id);
	public ArrayList<Comment> getComments(int user_id);
	public ArrayList<Object[]> showMessages(int user_id);
	List<User> findAllUser(String userName, String Password);//显示个人信息
	void addHeadPhoto(int id, String path);
	
}

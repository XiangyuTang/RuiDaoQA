package com.neu.ruidaoQA.dao;
import java.util.ArrayList;
import java.util.List;

import com.neu.ruidaoQA.entity.Comment;
import javax.jws.soap.SOAPBinding.Use;

import com.neu.ruidaoQA.entity.User;

public interface UserDao {
	User selectUser(int user_id);//根据user_id选出对应的用户信息
	User selectUserByAnswer_id(int question_id);//根据Answer_id选出其对应的用户
	User selectUserByComment_id(int comment_id);//根据comment_id选出其对应的用户
	public ArrayList<Comment> getComments(int user_id);
	User selectUser(Object[] params);
	int  addUser(Object[] params);
	int updateUser(User u);
	int deleteUser(int id);
	List<User> findAll();
	void addHeadPhoto(Object[] params);
}

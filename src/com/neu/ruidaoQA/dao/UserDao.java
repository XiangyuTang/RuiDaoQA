package com.neu.ruidaoQA.dao;

import javax.jws.soap.SOAPBinding.Use;

import com.neu.ruidaoQA.entity.User;

public interface UserDao {
	User selectUser(int user_id);//根据user_id选出对应的用户信息
	User selectUserByAnswer_id(int question_id);//根据Answer_id选出其对应的用户
	User selectUserByComment_id(int comment_id);//根据comment_id选出其对应的用户
}

package com.neu.ruidaoQA.dao;

import javax.jws.soap.SOAPBinding.Use;

import com.neu.ruidaoQA.entity.User;

public interface UserDao {
	User selectUser(int user_id);//根据user_id选出对应的用户信息
}

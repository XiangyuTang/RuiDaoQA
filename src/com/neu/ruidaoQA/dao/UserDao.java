package com.neu.ruidaoQA.dao;

import javax.jws.soap.SOAPBinding.Use;

import com.neu.ruidaoQA.entity.User;

public interface UserDao {
	User selectUser(int user_id);//����user_idѡ����Ӧ���û���Ϣ
}

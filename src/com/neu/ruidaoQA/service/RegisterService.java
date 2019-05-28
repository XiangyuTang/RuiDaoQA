package com.neu.ruidaoQA.service;

import java.util.Date;

import com.neu.ruidaoQA.entity.User;

public interface RegisterService {
	int addUser(String email,String password,String nickname,Date birthday,String introduce,String sex);
}

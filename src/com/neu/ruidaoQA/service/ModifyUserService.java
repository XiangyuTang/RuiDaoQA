package com.neu.ruidaoQA.service;

import java.util.Date;

import com.neu.ruidaoQA.entity.User;

public interface ModifyUserService {
	//更新前端传来的信息
	User updateUser(int user_id, String nickname,String sex,String birthday,String email,String introduce,String password, String old);
}

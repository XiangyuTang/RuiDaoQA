package com.neu.ruidaoQA.service.impl;

import java.util.Date;

import com.neu.ruidaoQA.dao.UserDao;
import com.neu.ruidaoQA.dao.impl.UserDaoimpl;
import com.neu.ruidaoQA.entity.User;
import com.neu.ruidaoQA.service.RegisterService;

public class RegisterServiceimpl implements RegisterService{

	@Override
	public int addUser(String email, String password, String nickname, Date birthday, String introduce,String sex) {
		// TODO Auto-generated method stub
		UserDao ud = new UserDaoimpl();
		int i = ud.addUser(new Object[] {email,password,nickname,birthday,introduce,sex});
		return i;
	}

	

}

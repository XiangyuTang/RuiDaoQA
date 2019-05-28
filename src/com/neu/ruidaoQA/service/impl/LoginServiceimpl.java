package com.neu.ruidaoQA.service.impl;

import java.sql.ResultSet;

import com.neu.ruidaoQA.dao.UserDao;
import com.neu.ruidaoQA.dao.impl.UserDaoimpl;
import com.neu.ruidaoQA.entity.User;
import com.neu.ruidaoQA.service.LoginService;

public class LoginServiceimpl implements LoginService{

	@Override
	public int checkLogin(String username, String password) {
		int bool = 0;
		Object[] params =new Object[]{username,password};
		//ResultSet rs = super.executeSelect("select * from user_info where name=?", params);
		UserDao ud = new UserDaoimpl();
		User u = ud.selectUser(params);
		if(u.getEmail()==null) {
			bool=0;
		}else {
			if((u.getPassword()).equals(password)){
				bool = 2;
			}else {
				bool = 1;
			}
		}
		return bool;
	}

}

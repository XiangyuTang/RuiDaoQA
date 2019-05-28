package com.neu.ruidaoQA.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;

import com.neu.ruidaoQA.dao.UserDao;
import com.neu.ruidaoQA.dao.impl.UserDaoimpl;
import com.neu.ruidaoQA.entity.User;
import com.neu.ruidaoQA.service.ModifyUserService;



public class ModifyUserServiceimpl implements ModifyUserService{

	@Override
	public User updateUser(int user_id, String nickname, String sex, String birthday, String email, String introduce,
			String password) {
		// TODO Auto-generated method stub
		UserDao ud = new UserDaoimpl();
		
		String newPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] mimamd5=md.digest(password.getBytes());
			newPassword = Arrays.toString(mimamd5);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		User u = new User(user_id, nickname,sex,java.sql.Date.valueOf(birthday),newPassword,email,null,introduce);
		ud.updateUser(u);
		User newUser=ud.selectUser(user_id);
		return newUser;
	}

	

}

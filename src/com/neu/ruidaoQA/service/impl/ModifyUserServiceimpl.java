package com.neu.ruidaoQA.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.apache.naming.java.javaURLContextFactory;

import com.neu.ruidaoQA.dao.UserDao;
import com.neu.ruidaoQA.dao.impl.UserDaoimpl;
import com.neu.ruidaoQA.entity.User;
import com.neu.ruidaoQA.service.ModifyUserService;



public class ModifyUserServiceimpl implements ModifyUserService{

	@Override
	public User updateUser(int user_id, String nickname, String sex, String birthday, String email, String introduce,
			String password,String oldPass) {
		// TODO Auto-generated method stub
		UserDao ud = new UserDaoimpl();
		User u = new User();
		
		
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-DD");
		boolean dateflag=true;
		Date date =null;
		try
		{
			date = (Date) format.parse(birthday);
		} catch (ParseException e)
		{
			dateflag=false;
		}

		
		
		if(oldPass.equals(password)) {
			String string1 = "";
			u = new User(user_id , nickname,sex,date,oldPass,email,string1,introduce);
		}else {
			String newPassword = null;
			try {
				MessageDigest md = MessageDigest.getInstance("md5");
				byte[] mimamd5=md.digest(password.getBytes());
				newPassword = Arrays.toString(mimamd5);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			u = new User(user_id, nickname,sex,date,newPassword,email,null,introduce);
		}
		
		ud.updateUser(u);
		User newUser=ud.selectUser(user_id);
		return newUser;
	}


	

}

package com.neu.ruidaoQA.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.neu.ruidaoQA.dao.FollowDao;
import com.neu.ruidaoQA.dao.UserDao;
import com.neu.ruidaoQA.dao.impl.FollowDaoimpl;
import com.neu.ruidaoQA.dao.impl.UserDaoimpl;
import com.neu.ruidaoQA.entity.Follow;
import com.neu.ruidaoQA.entity.User;
import com.neu.ruidaoQA.service.FansMessageService;

public class FansMessageServiceimpl implements FansMessageService{

	@Override
	public List<User> selectFans(int id) {
		// TODO Auto-generated method stub
		FollowDao fd = new FollowDaoimpl();
		List<Follow> lf = fd.selectFollowById(id);
		System.out.println("ttttttttttt"+lf.size());
		UserDao ud = new UserDaoimpl();
		List<User> lu = new ArrayList<User>();
		for(int i=0; i<lf.size();i++) {
			User u = ud.selectUser(lf.get(i).getThis_user_id());
			System.out.println(lf.get(i).getThis_user_id());
			lu.add(u);
		}
		return lu;
	}

}

package com.neu.ruidaoQA.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.neu.ruidaoQA.dao.FollowDao;
import com.neu.ruidaoQA.dao.UserDao;
import com.neu.ruidaoQA.dao.impl.FollowDaoimpl;
import com.neu.ruidaoQA.dao.impl.UserDaoimpl;
import com.neu.ruidaoQA.entity.Follow;
import com.neu.ruidaoQA.entity.User;
import com.neu.ruidaoQA.service.GuanZhuService;

public class GuanZhuServiceimpl implements GuanZhuService{

	@Override
	public List<User> selectGuanZhus(int id) {
		FollowDao fd = new FollowDaoimpl();
		List<Follow> lf = fd.selectGuanZhuById(id);
		UserDao ud = new UserDaoimpl();
		List<User> lu = new ArrayList<User>();
		for(int i=0; i<lf.size();i++) {
			User u = ud.selectUser(lf.get(i).getFollow_user_id());
			lu.add(u);
		}
		return lu;
	}

}

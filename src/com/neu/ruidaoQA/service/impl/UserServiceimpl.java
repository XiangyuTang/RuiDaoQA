package com.neu.ruidaoQA.service.impl;

import com.neu.ruidaoQA.dao.impl.FollowDaoimpl;
import com.neu.ruidaoQA.service.UserService;

public class UserServiceimpl implements UserService{

	@Override
	public void dologin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dologout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doregister() {
		// TODO Auto-generated method stub
		
	}
	
	public int addFollow(int this_user_id, int follow_user_id) {//根据两人的id号添加关注
		FollowDaoimpl followDaoimpl = new FollowDaoimpl();
		int i = followDaoimpl.addFollow(this_user_id, follow_user_id);
		return i;
	}
	
	public int deleteFollow(int this_user_id, int follow_user_id) {//根据两人的id号取消关注
		FollowDaoimpl followDaoimpl = new FollowDaoimpl();
		int i = followDaoimpl.deleteFollow(this_user_id, follow_user_id);
		return i;
	}
	
	public static void main(String[] args) {//测试类
		UserServiceimpl userServiceimpl = new UserServiceimpl();
		int i = userServiceimpl.addFollow(1, 2);
		System.out.println(i);
//		int j = userServiceimpl.deleteFollow(1, 2);
//		System.out.println(j);
	}
	
}

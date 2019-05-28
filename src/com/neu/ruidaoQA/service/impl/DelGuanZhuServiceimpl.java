package com.neu.ruidaoQA.service.impl;

import com.neu.ruidaoQA.dao.FollowDao;
import com.neu.ruidaoQA.dao.impl.FollowDaoimpl;
import com.neu.ruidaoQA.service.DelGuanZhuService;

public class DelGuanZhuServiceimpl implements DelGuanZhuService{

	@Override
	public int deleteFollow(int this_user_id, int follow_user_id) {
		// TODO Auto-generated method stub
		FollowDao fd = new FollowDaoimpl();
		fd.deleteFollow(this_user_id, follow_user_id);
		return 0;
	}

}

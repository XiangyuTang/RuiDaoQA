package com.neu.ruidaoQA.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.neu.ruidaoQA.dao.FollowDao;
import com.neu.ruidaoQA.dao.impl.FollowDaoimpl;
import com.neu.ruidaoQA.entity.Follow;
import com.neu.ruidaoQA.entity.User;
import com.neu.ruidaoQA.service.CounterFollow;

public class CounterFollowimpl implements CounterFollow{

	@Override
	public List<Integer> counterFollow(int zhujue_id) {
		// TODO Auto-generated method stub
		List<Integer> renshu = new ArrayList<Integer>();
		FollowDao fd = new FollowDaoimpl();
		List<Follow> guanzhu = fd.selectGuanZhuById(zhujue_id);
		List<Follow> fans = fd.selectFollowById(zhujue_id);
		renshu.add(guanzhu.size());
		renshu.add(fans.size());
		return renshu;
	}

}

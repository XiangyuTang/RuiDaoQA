package com.neu.ruidaoQA.dao;

public interface FollowDao {
	int addFollow(int this_user_id, int follow_user_id);//根据两人的id号添加关注
	int deleteFollow(int this_user_id, int follow_user_id);//根据两人的id号取消关注
}

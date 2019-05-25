package com.neu.ruidaoQA.service.impl;

import java.util.ArrayList;

import com.neu.ruidaoQA.dao.impl.FavoriteDaoimpl;
import com.neu.ruidaoQA.dao.impl.FollowDaoimpl;
import com.neu.ruidaoQA.dao.impl.UserDaoimpl;
import com.neu.ruidaoQA.entity.Question;
import com.neu.ruidaoQA.entity.User;
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
		//System.out.println(i);
		return i;
	}
	
	public int deleteFollow(int this_user_id, int follow_user_id) {//根据两人的id号取消关注
		FollowDaoimpl followDaoimpl = new FollowDaoimpl();
		int i = followDaoimpl.deleteFollow(this_user_id, follow_user_id);
		return i;
	}
	
	public int addFavorite(int question_id, int user_id) {//根据question_id和user_id添加收藏
		FavoriteDaoimpl favoriteDaoimpl = new FavoriteDaoimpl();
		int i = favoriteDaoimpl.addFavorite(question_id, user_id);
		return i;
	}
	
	public int deleteFavorite(int question_id, int user_id) {//根据question_id和user_id删除收藏
		FavoriteDaoimpl favoriteDaoimpl = new FavoriteDaoimpl();
		int i = favoriteDaoimpl.deleteFavorite(question_id, user_id);
		return i;
	}
	
	public void test1() {
		UserDaoimpl u1 = new UserDaoimpl();
		User u = u1.selectUser(1);
			System.out.print(u.getUser_id());
			System.out.print(u.getNick_name());
			System.out.print(u.getSex());
			System.out.print(u.getBirthday());
			System.out.print(u.getPassword());
			System.out.print(u.getEmail());
			System.out.print(u.getHead_photo());
			System.out.print(u.getIntroduce());
			System.out.println();
		}
	
	public static void main(String[] args) {//测试类
		UserServiceimpl userServiceimpl = new UserServiceimpl();
//		int i = userServiceimpl.addFollow(1, 2);
//		System.out.println(i);
//		int j = userServiceimpl.deleteFollow(1, 2);
//		System.out.println(j);
		int i = userServiceimpl.addFavorite(1, 1);
		System.out.println(i);
		
		UserServiceimpl userServiceimpl1 = new UserServiceimpl();
		userServiceimpl1.test1();
	}

	@Override
	public ArrayList<Question> getFavoriteQuestions(int user_id) {
		// TODO Auto-generated method stub
		FavoriteDaoimpl favoriteDaoimpl = new FavoriteDaoimpl();
		ArrayList<Question> questions=favoriteDaoimpl.getFavoriteQuestions(user_id);
		return questions;
	}
	
}

package com.neu.ruidaoQA.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.neu.ruidaoQA.dao.UserDao;
import com.neu.ruidaoQA.dao.impl.FavoriteDaoimpl;
import com.neu.ruidaoQA.dao.impl.FollowDaoimpl;
import com.neu.ruidaoQA.dao.impl.UserDaoimpl;
import com.neu.ruidaoQA.entity.Answer;
import com.neu.ruidaoQA.entity.Comment;
import com.neu.ruidaoQA.entity.Question;
import com.neu.ruidaoQA.entity.User;
import com.neu.ruidaoQA.service.UserService;

public class UserServiceimpl implements UserService{

	@Override
	public String getUserName(int user_id) {
		UserDaoimpl ul=new UserDaoimpl();
		User user=ul.selectUser(user_id);
		return user.getNick_name();
	}

	@Override
	public ArrayList<Comment> getComments(int user_id){
		UserDaoimpl ud=new UserDaoimpl();
		ArrayList<Comment> comments=ud.getComments(user_id);
		return comments;
		
	}
	@Override
	public ArrayList<Object[]> showMessages(int user_id){
		UserServiceimpl userServiceimpl=new UserServiceimpl();
		AnswerServiceimpl answerService=new AnswerServiceimpl();
		ArrayList<Object[]> objs=new ArrayList<Object[]>();
		ArrayList<Comment> comments=userServiceimpl.getComments(user_id);
		ArrayList<Integer> quesiton_ids=new ArrayList<Integer>();
		for(Comment comment:comments) {
			quesiton_ids.add(answerService.getAQuesiton_idByAnswer_id(comment.getAnswer_id()));
		}
		for(int i=0;i<comments.size();i++) {
			int question_id=quesiton_ids.get(i);
			String nick_name=userServiceimpl.getUserName(comments.get(i).getUser_id());		
			String content = comments.get(i).getContent();
			
			 DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //HH表示24小时制；  
	         String datetime = dFormat.format(comments.get(i).getPublish_time());
	         Object[] obj=new Object[] {question_id,nick_name,content,datetime};
	         objs.add(obj);
		}
		

		
		return objs;
	}
	@Override
	public List<User> findAllUser(String userName, String Password) {
		// TODO Auto-generated method stub
//		System.out.println("wwwwwwwwwwwwwwwwwwww");
		Object[] params =new Object[]{userName,Password};
		UserDao ud = new UserDaoimpl();
		User u = ud.selectUser(params);
//		System.out.println("wwwwwwwwwwwwwwwwwwww");
		List<User> lu = new ArrayList<User>();
		lu.add(u);
//		System.out.println(lu.size());
		return lu;
	}

	@Override
	public void addHeadPhoto(int id, String path) {
		// TODO Auto-generated method stub
		UserDao ud = new UserDaoimpl();
		Object[] params = new Object[] {path,id};
		ud.addHeadPhoto(params);
	}


	@Override
	public ArrayList<Object[]> getAnswersList(int user_id) {
		
			AnswerServiceimpl answerService=new AnswerServiceimpl();
			UserServiceimpl userServiceimpl=new UserServiceimpl();
			QuestionServiceimpl quesitonServiceimpl=new QuestionServiceimpl();
			ArrayList<Answer> answers=answerService.getAnswerLists(user_id);
			ArrayList<Integer> quesiton_ids=new ArrayList<Integer>();
			for(Answer answer:answers) {
				quesiton_ids.add(answer.getQuestion_id());
			}
			ArrayList<Question> questions=new ArrayList<Question>();
			for(int i=0;i<quesiton_ids.size();i++) {
				questions.add(quesitonServiceimpl.getQuestion(quesiton_ids.get(i)));
			}
			ArrayList<Object[]> objs=new ArrayList<Object[]>();
			for(int i=0;i<answers.size();i++) {
				int question_id=answers.get(i).getQuestion_id();
				String question_title=questions.get(i).getQues_title();
				int question_answer_num=questions.get(i).getAnswer_num();
				int question_collect_num=questions.get(i).getCollect_num();
				String nickname=userServiceimpl.getUserName(user_id);
				String answer_content=answers.get(i).getContent();
				int comment_number=answers.get(i).getComment_num();
				int acclaim_number=answers.get(i).getDianzan_num();
				Object[] obj=new Object[] {question_id,question_title,question_answer_num,question_collect_num,
						nickname,answer_content,comment_number,acclaim_number};
				objs.add(obj);
				
			}
			return objs;
		
	}

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
	
	public User getUser(int user_id)
	{
		User u = null;
		UserDaoimpl udip = new UserDaoimpl();
		u = udip.selectUser(user_id);
		return u;
		
	}
	
	public void test1() {
		UserDaoimpl u1 = new UserDaoimpl();
		User u = u1.selectUser(1);
//			System.out.print(u.getUser_id());
//			System.out.print(u.getNick_name());
//			System.out.print(u.getSex());
//			System.out.print(u.getBirthday());
//			System.out.print(u.getPassword());
//			System.out.print(u.getEmail());
//			System.out.print(u.getHead_photo());
//			System.out.print(u.getIntroduce());
//			System.out.println();
		}
	
	public static void main(String[] args) {//测试类
		UserServiceimpl userServiceimpl = new UserServiceimpl();
//		int i = userServiceimpl.addFollow(1, 2);
//		System.out.println(i);
//		int j = userServiceimpl.deleteFollow(1, 2);
//		System.out.println(j);
		int i = userServiceimpl.addFavorite(1, 1);
//		System.out.println(i);
		
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
	public Integer haveUser(Integer follow_user_id, Integer this_user_id) {
		FollowDaoimpl followDaoimpl = new FollowDaoimpl();
		ArrayList<Integer> follow_user_idlist = followDaoimpl.getFollow_user_idlist(this_user_id);
		if (follow_user_idlist.contains(follow_user_id)) {
			return 1;
		}else {
			return 0;
		}
	}
	
}

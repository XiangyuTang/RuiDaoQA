package com.neu.ruidaoQA.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.neu.ruidaoQA.dao.impl.AnswerDaoimpl;
import com.neu.ruidaoQA.dao.impl.FavoriteDaoimpl;
import com.neu.ruidaoQA.dao.impl.FollowDaoimpl;
import com.neu.ruidaoQA.dao.impl.QuestionDaoimpl;
import com.neu.ruidaoQA.dao.impl.UserDaoimpl;
import com.neu.ruidaoQA.entity.Answer;
import com.neu.ruidaoQA.entity.Question;
import com.neu.ruidaoQA.entity.User;
import com.neu.ruidaoQA.service.QuestionService;
import com.neu.ruidaoQA.servlet.detail_question.favoriteQuesServlet;

public class QuestionServiceimpl implements QuestionService{
	@Override
	public int addQuestion(Question q) {
		// TODO Auto-generated method stub
		QuestionDaoimpl qdi=new QuestionDaoimpl();
		int i =qdi.addQuestion(q);
		return i;
	}

	@Override
	public Question createQuestion(Integer question_id, Integer user_id, Integer ques_type_id, String content,
			Integer collect_num, Integer answer_num, Date publish_time,String ques_title) {
		// TODO Auto-generated method stub
		Question q=new Question( question_id,  user_id,  ques_type_id,  content,
			 collect_num,  answer_num, publish_time,ques_title);
		return q;
	}
	
	public void test() {
		QuestionDaoimpl q1 = new QuestionDaoimpl();
		List<Question> list = q1.getQuestionByType(1);
		for (Question question:list) {
			System.out.print(question.getQuestion_id());
			System.out.print(question.getQues_type_id());
			System.out.print(question.getUser_id());
			System.out.print(question.getContent());
			System.out.print(question.getCollect_num());
			System.out.print(question.getAnswer_num());
			System.out.print(question.getPublish_time());
			System.out.print(question.getQues_title());
			System.out.println();
		}
	}
	public ArrayList<Question> getQuestionLists(int user_id){
		QuestionDaoimpl qdi=new QuestionDaoimpl();
		ArrayList<Question> questions=qdi.getQuestionLists(user_id);
	
		
		
		return questions;
	}
	@Override
	public Question getQuestion(int question_id) {
		// TODO Auto-generated method stub
		Question q = null;
		QuestionDaoimpl qdi=new QuestionDaoimpl();
		q = qdi.getQuestion(question_id);
		return q;
	}

	
	public static void main(String[] args) {
		QuestionServiceimpl questionServiceimpl = new QuestionServiceimpl();
		questionServiceimpl.test();
	}

	@Override
	public List<Answer> getAnswersList(int question_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> getQuestionByType(int kinds_id) {
		// TODO Auto-generated method stub
		QuestionDaoimpl questionDaoimpl = new QuestionDaoimpl();
		AnswerDaoimpl answerDaoimpl = new AnswerDaoimpl();
		UserDaoimpl userDaoimpl = new UserDaoimpl();
		List<Question> list = questionDaoimpl.getQuestionByType(kinds_id);
		for (Question question:list) {
			Answer answer = answerDaoimpl.selectAnswer(question.getQuestion_id());
			if (answer.getUser_id() == null||answer.getAnswer_id() == null) {
				User user = userDaoimpl.selectUser(1);
				answer.setUser(user);
				continue;
			}
			User user = userDaoimpl.selectUser(answer.getUser_id());
			answer.setUser(user);
			question.setAnswer(answer);
		}
		return list;
	}

	@Override
	public ArrayList<Question> getSearchResult(String txt) {
		// TODO Auto-generated method stub
		ArrayList<Question> list = new ArrayList<Question>();
		QuestionDaoimpl qdip = new QuestionDaoimpl();
		list = qdip.getSearchResult(txt);
		return list;
	}
	
	@Override
	public List<Question> getQuestionByCollectNum() {
		// TODO Auto-generated method stub
		QuestionDaoimpl questionDaoimpl = new QuestionDaoimpl();
		List<Question> getQuestionByCollectNum = questionDaoimpl.getQuestionByCollectNum();

		//System.out.println(getQuestionByCollectNum.get(0).getQues_title());

		return getQuestionByCollectNum;
	}

	@Override
	public List<Question> getQuestionByTypeAndnumber(Integer kinds_id, Integer min, Integer max,Integer user_id ) {
		if(user_id == 0) {
			QuestionDaoimpl questionDaoimpl = new QuestionDaoimpl();
			AnswerDaoimpl answerDaoimpl = new AnswerDaoimpl();
			UserDaoimpl userDaoimpl = new UserDaoimpl();
			FollowDaoimpl followDaoimpl = new FollowDaoimpl();
			FavoriteDaoimpl favoriteDaoimpl = new FavoriteDaoimpl();
			List<Question> questions = questionDaoimpl.getQuestionByTypeandnumber(kinds_id, min, max);
			for(Question question:questions) {
				Answer answer = answerDaoimpl.selectAnswer(question.getQuestion_id());
				if (answer.getUser_id() == null) {
					User user = userDaoimpl.selectUser(1);
					answer.setUser(user);
					continue;
				}
				User selectUser = userDaoimpl.selectUser(answer.getUser_id());
				answer.setUser(selectUser);
				User selectUser2 = userDaoimpl.selectUser(question.getUser_id());
				question.setUser(selectUser2);
				answer.getUser().setFollow_flag(0);
				question.setCollect_flag(0);
			}
			return questions;
		}else {
			QuestionDaoimpl questionDaoimpl = new QuestionDaoimpl();
			AnswerDaoimpl answerDaoimpl = new AnswerDaoimpl();
			UserDaoimpl userDaoimpl = new UserDaoimpl();
			FollowDaoimpl followDaoimpl = new FollowDaoimpl();
			FavoriteDaoimpl favoriteDaoimpl = new FavoriteDaoimpl();
			ArrayList<Integer> follow_user_idlist = followDaoimpl.getFollow_user_idlist(user_id);
			ArrayList<Integer> favoriteQuestion_id = favoriteDaoimpl.getFavoriteQuestion_id(user_id);
			List<Question> questions = questionDaoimpl.getQuestionByTypeandnumber(kinds_id, min, max);		
			for(Question question:questions) {
				Answer answer = answerDaoimpl.selectAnswer(question.getQuestion_id());
				if (answer.getUser_id() == null) {
					User user = userDaoimpl.selectUser(1);
					answer.setUser(user);
					continue;
				}
				User selectUser = userDaoimpl.selectUser(answer.getUser_id());
				answer.setUser(selectUser);
				User selectUser2 = userDaoimpl.selectUser(question.getUser_id());
				question.setUser(selectUser2);
				if (follow_user_idlist.contains(answer.getUser_id())) {
					answer.getUser().setFollow_flag(1);
				}else {
					answer.getUser().setFollow_flag(0);
				}
				if (favoriteQuestion_id.contains(question.getQuestion_id())) {
					question.setCollect_flag(1);
					
				}else {
					question.setCollect_flag(0);
				}
			}
			return questions;
		}
	}
//	public Integer haveQuestion(Integer question_id, Integer user_id) {
//		FavoriteDaoimpl favoriteDaoimpl = new FavoriteDaoimpl();
//		ArrayList<Integer> favoriteQuestion_id = favoriteDaoimpl.getFavoriteQuestion_id(user_id);
//		if (favoriteQuestion_id.contains(question_id)) {
//			return 1;
//		}else {
//			return 0;
//		}
//	}

	public Integer haveQuestion(Integer question_id, Integer user_id) {
		FavoriteDaoimpl favoriteDaoimpl = new FavoriteDaoimpl();
		ArrayList<Integer> favoriteQuestion_id = favoriteDaoimpl.getFavoriteQuestion_id(user_id);
		if (favoriteQuestion_id.contains(question_id)) {
			return 1;
		}else {
			return 0;
		}
	}

	
}


package com.neu.ruidaoQA.entity;

import java.sql.Date;

public class Question {
	private Integer question_id;
	private Integer user_id;
	private Integer ques_type_id;
	private String content;
	private Integer collect_num;//这个问题被收藏的数量
	private Integer answer_num;
	private Date publish_time;
	private String ques_title;
	
	public Question(Integer question_id, Integer user_id, Integer ques_type_id, String content, Integer collect_num,
			Integer answer_num, Date publish_time,String ques_title) {
		super();
		this.question_id = question_id;
		this.user_id = user_id;
		this.ques_type_id = ques_type_id;
		this.content = content;
		this.collect_num = collect_num;
		this.answer_num = answer_num;
		this.publish_time = publish_time;
		this.ques_title = ques_title;
	}
	public Integer getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(Integer question_id) {
		this.question_id = question_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getQues_type_id() {
		return ques_type_id;
	}
	public void setQues_type_id(Integer ques_type_id) {
		this.ques_type_id = ques_type_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getCollect_num() {
		return collect_num;
	}
	public void setCollect_num(Integer collect_num) {
		this.collect_num = collect_num;
	}
	public Integer getAnswer_num() {
		return answer_num;
	}
	public void setAnswer_num(Integer answer_num) {
		this.answer_num = answer_num;
	}
	public Date getPublish_time() {
		return publish_time;
	}
	public void setPublish_time(Date publish_time) {
		this.publish_time = publish_time;
	}
	public String getQues_title() {
		return ques_title;
	}
	public void setQues_title(String ques_title) {
		this.ques_title = ques_title;
	}
	
	
}

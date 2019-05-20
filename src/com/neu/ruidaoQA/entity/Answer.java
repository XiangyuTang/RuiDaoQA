package com.neu.ruidaoQA.entity;

import java.sql.Date;

public class Answer {
	private Integer answer_id;
	private Integer question_id;
	private Integer user_id;
	private String content;
	private Integer dianzan_num;
	private Integer cai_num;
	private Integer comment_num;
	private Date publish_time;
	
	public Answer(Integer answer_id, Integer question_id, Integer user_id, String content, Integer dianzan_num,
			Integer cai_num, Integer comment_num, Date publish_time) {
		super();
		this.answer_id = answer_id;
		this.question_id = question_id;
		this.user_id = user_id;
		this.content = content;
		this.dianzan_num = dianzan_num;
		this.cai_num = cai_num;
		this.comment_num = comment_num;
		this.publish_time = publish_time;
	}
	public Integer getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(Integer answer_id) {
		this.answer_id = answer_id;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getDianzan_num() {
		return dianzan_num;
	}
	public void setDianzan_num(Integer dianzan_num) {
		this.dianzan_num = dianzan_num;
	}
	public Integer getCai_num() {
		return cai_num;
	}
	public void setCai_num(Integer cai_num) {
		this.cai_num = cai_num;
	}
	public Integer getComment_num() {
		return comment_num;
	}
	public void setComment_num(Integer comment_num) {
		this.comment_num = comment_num;
	}
	public Date getPublish_time() {
		return publish_time;
	}
	public void setPublish_time(Date publish_time) {
		this.publish_time = publish_time;
	}
	
}

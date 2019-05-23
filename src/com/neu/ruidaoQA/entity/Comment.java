package com.neu.ruidaoQA.entity;

import java.util.Date;

/**
 * 二级评论
 * 
 * */
public class Comment {
	private Integer comment_id;
	private Integer answer_id;
	private Integer user_id;
	private String content;
	private String flag;//flag标志区分是回答的评论，还是评论的评论
	private Integer goal_id;//如果是评论的评论，标记父级评论的id
	private Integer dianzan_num;
	private Date publish_time;
	
	public Comment(Integer comment_id, Integer answer_id, Integer user_id, String content, String flag, Integer goal_id,
			Integer dianzan_num, Date publish_time) {
		super();
		this.comment_id = comment_id;
		this.answer_id = answer_id;
		this.user_id = user_id;
		this.content = content;
		this.flag = flag;
		this.goal_id = goal_id;
		this.dianzan_num = dianzan_num;
		this.publish_time = publish_time;
	}
	public Integer getComment_id() {
		return comment_id;
	}
	public void setComment_id(Integer comment_id) {
		this.comment_id = comment_id;
	}
	public Integer getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(Integer answer_id) {
		this.answer_id = answer_id;
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
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public Integer getGoal_id() {
		return goal_id;
	}
	public void setGoal_id(Integer goal_id) {
		this.goal_id = goal_id;
	}
	public Integer getDianzan_num() {
		return dianzan_num;
	}
	public void setDianzan_num(Integer dianzan_num) {
		this.dianzan_num = dianzan_num;
	}
	public Date getPublish_time() {
		return publish_time;
	}
	public void setPublish_time(Date publish_time) {
		this.publish_time = publish_time;
	}
	
	
}

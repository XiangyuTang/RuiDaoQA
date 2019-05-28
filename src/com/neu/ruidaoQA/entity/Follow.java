package com.neu.ruidaoQA.entity;

public class Follow {
	private int follow_id;
	private int this_user_id;
	private int follow_user_id;
	
	public Follow(int follow_id, int this_user_id, int follow_user_id) {
		follow_id = this.follow_id;
		this_user_id = this.this_user_id;
		follow_user_id = this.follow_user_id;
	}
	
	public Follow() {
		
	}

	public int getFollow_id() {
		return follow_id;
	}

	public void setFollow_id(int follow_id) {
		this.follow_id = follow_id;
	}

	public int getThis_user_id() {
		return this_user_id;
	}

	public void setThis_user_id(int this_user_id) {
		this.this_user_id = this_user_id;
	}

	public int getFollow_user_id() {
		return follow_user_id;
	}

	public void setFollow_user_id(int follow_user_id) {
		this.follow_user_id = follow_user_id;
	}
	
	
}

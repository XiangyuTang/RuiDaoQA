package com.neu.ruidaoQA.entity;

public class User {
	private Integer user_id;
	private String nick_name;
	private String sex;
	private String birthday;
	private Integer phone_num;
	private String password;
	private String email;
	private String head_photo;
	private String introduce;
	
	public User(Integer user_id, String nick_name, String sex, String birthday, Integer phone_num, String password,
			String email, String head_photo, String introduce) {
		super();
		this.user_id = user_id;
		this.nick_name = nick_name;
		this.sex = sex;
		this.birthday = birthday;
		this.phone_num = phone_num;
		this.password = password;
		this.email = email;
		this.head_photo = head_photo;
		this.introduce = introduce;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Integer getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(Integer phone_num) {
		this.phone_num = phone_num;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHead_photo() {
		return head_photo;
	}
	public void setHead_photo(String head_photo) {
		this.head_photo = head_photo;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	
}

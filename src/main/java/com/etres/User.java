package com.etres;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
	
	private Integer userId;
	private String userName;
	private Integer age;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", age=" + age + ", birthday=" + birthday + "]";
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public User(Integer userId, String userName, Integer age, Date birthday) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.age = age;
		this.birthday = birthday;
	}
	public User() {
		super();
	}

	
	

	
	
}

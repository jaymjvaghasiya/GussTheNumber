package com.bean;

public class UserLogBean {
	private Integer id;
	private Integer num;
	private String email;
	private String date;
	
	public UserLogBean() {
		super();
	}

	public UserLogBean(Integer id, Integer num, String email, String date) {
		super();
		this.id = id;
		this.num = num;
		this.email = email;
		this.date = date;
	}



	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
	
}

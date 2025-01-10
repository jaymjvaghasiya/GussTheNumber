package com.bean;

public class LogBean {
	
	private Integer userid;
	private String email;
	private String date;
	private Integer num;
	private Integer credits;
	
	public LogBean() {
		super();
	}
	
	public LogBean(Integer userid, String email, String date, Integer num, Integer credits) {
		super();
		this.userid = userid;
		this.email = email;
		this.date = date;
		this.num = num;
		this.credits = credits;
	}

	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getCredits() {
		return credits;
	}
	public void setCredits(Integer credits) {
		this.credits = credits;
	}
	

}

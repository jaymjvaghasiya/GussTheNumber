package com.bean;

public class UserBean {
	private Integer id;
	private String name;
	private String email;
	private String password;
	private Integer credits;
	
	public UserBean() {
		super();
	}
	public UserBean(Integer id, String name, String email, String password, Integer credits) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.credits = credits;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getCredits() {
		return credits;
	}
	public void setCredits(Integer credits) {
		this.credits = credits;
	}
}

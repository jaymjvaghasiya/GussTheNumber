package com.bean;

public class UserIdBean {
	private Integer userid;
	private Integer usercredits;
	private String useremail;
	
	public UserIdBean() {
		super();
	}

	public UserIdBean(Integer userid, Integer usercredits, String useremail) {
		super();
		this.userid = userid;
		this.usercredits = usercredits;
		this.useremail = useremail;
	}


	public String getUseremail() {
		return useremail;
	}


	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}


	public Integer getUsercredits() {
		return usercredits;
	}

	public void setUsercredits(Integer usercredits) {
		this.usercredits = usercredits;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	
}

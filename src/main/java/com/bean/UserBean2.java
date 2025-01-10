package com.bean;

import org.springframework.web.multipart.MultipartFile;


public class UserBean2 {
	private String name;
	private String email;
	private String password;
	private String imagePath;
	
	private MultipartFile[] profilePic;
	
	
	public MultipartFile[] getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(MultipartFile[] profilePic) {
		this.profilePic = profilePic;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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
	
}

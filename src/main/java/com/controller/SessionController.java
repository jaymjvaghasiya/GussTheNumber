package com.controller;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.bean.UserBean;
import com.bean.UserBean2;
import com.dao.UserDao;

import jakarta.servlet.http.HttpSession;


@Controller
public class SessionController {
	
	@Autowired
	UserDao userdao;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping("login")
	public String userLogin() {
		return "Login";
	}
	
	@GetMapping("signup")
	public String userSignup() {
		return "Signup";
	}
	
	@PostMapping("addPlayear")
	public String addNewPlayear(UserBean user) {
		String encodedPass = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPass);
		Integer i = userdao.addNewPlayear(user);
		if(i > 0) return "redirect:/login";
		return "signup";
	}
	
	@PostMapping("loginplayear")
	public String loginPlayear(UserBean user, HttpSession session) {
		UserBean userAuthenticated = userdao.AutheticatePlayear(user);
		if(userAuthenticated != null) {
			System.out.println("userAuthenticated: " + userAuthenticated.getPassword());
			
			boolean flag = passwordEncoder.matches(user.getPassword(), userAuthenticated.getPassword());
			if(flag) {	
				session.setAttribute("id", userAuthenticated.getId());
				session.setAttribute("userCredits", userAuthenticated.getCredits());
				session.setAttribute("userEmail", userAuthenticated.getEmail());
				return "redirect:/userdashboard";
			}
		}
		return "Login";
	}
	
	@GetMapping("userdashboard")
	public String userDashboard() {
		return "UserDashboard";
	}
	
	@GetMapping("getsignup")
	public String getSignup() {
		return "Signup2";
	}
	
	@PostMapping("adduser2")
	public String addUser2(UserBean2 user, Model model) {
		Integer i = 0;
		StringBuilder userpics = new StringBuilder();
//		
		for(MultipartFile file : user.getProfilePic()) {
//			System.out.println("All photo name: " + file.getOriginalFilename());
			File newFile = new File("F:\\2.Royal\\Spring - Tejas Sir\\SpringGame\\src\\main\\webapp\\images\\"+user.getEmail(), file.getOriginalFilename());
			if(!file.getContentType().startsWith("image")) {
				model.addAttribute("Only Images is accepted.");
			} else {			
				try {
					userpics.append("images/"+user.getEmail()+"/"+file.getOriginalFilename()+",");
					FileUtils.writeByteArrayToFile(newFile, file.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		String encpass = passwordEncoder.encode(user.getPassword());
		user.setPassword(encpass);
		user.setImagePath(userpics.toString());
		userdao.addUser(user);
		
		String[] up = userpics.toString().split(",");
		model.addAttribute("myimages", up);
		return "Login";
	}
	
	@PostMapping("loginuser")
	public String loginUser(UserBean2 userBean, Model model) {
		UserBean2 dbuser = userdao.getLoginUser(userBean.getEmail());
		System.out.println("dbuser:" + dbuser);
		if(dbuser == null) {
			model.addAttribute("error", "Invalide Credential");
		} else {
			System.out.println("db pass : " + dbuser.getPassword() + " : " + dbuser.getEmail());
			System.out.println("user pass : " + userBean.getPassword());
			boolean flag = passwordEncoder.matches(userBean.getPassword(), dbuser.getPassword());
			if(flag) {				
				return "UserDashboard";
			} else {
				model.addAttribute("error", "Invalide Credential");
			}
		}
		return "Login";
	}
}

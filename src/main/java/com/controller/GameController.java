package com.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.LogBean;
import com.bean.UserBean;
import com.bean.UserIdBean;
import com.dao.UserDao;

import jakarta.servlet.http.HttpSession;


@Controller
public class GameController {
	
	@Autowired
	UserDao userDao;
	
	@GetMapping("playgame")
	public String playGame(UserIdBean userID, Model model) {
		if(userID.getUsercredits() > 0)
			return "Game";
		else 
			model.addAttribute("message", "Your credit is lessthen 0, So thanks for playing the game, and now u r fired. Please don't mind.");
		return "UserDashboard";
	}
	
	@PostMapping("checknum")
	public String checkNum(LogBean logBean, HttpSession session) {
		Random random = new Random();
		Integer randomNum = random.nextInt(10) + 1;
		Integer credits = 0;
		if(logBean.getNum() > 0 && logBean.getNum() <= 10) {
			if(randomNum == logBean.getNum()) {
				credits = userDao.addCredits(logBean);
				System.out.println("Match successfull.");
				System.out.println(randomNum + " = " + logBean.getNum());
			} else {
				credits = userDao.minusCredits(logBean);
				System.out.println("Incorrect match.");
				System.out.println(randomNum + " != " + logBean.getNum());
			}
		} else {
			
		}
		session.setAttribute("userCredits", credits);
		if(credits == 0) {
			session.setAttribute("id", logBean.getUserid());
			session.setAttribute("userCredits", credits);
			return "redirect:/UserDashboard";
		} 
		return "Game";
	}
	
	@GetMapping("leaderboard")
	public String leaderboard(UserIdBean userID, Model model) {
		List<UserBean> users = userDao.getAllPlayears();
		UserBean user = userDao.getOnePLayer(userID);
		model.addAttribute("user", user);
		model.addAttribute("players", users);
		return "MainDashboard";
	}
	
}

package com.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.LogBean;
import com.bean.UserBean;
import com.bean.UserBean2;
import com.bean.UserIdBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate jdbc;
	
	public Integer addNewPlayear(UserBean user) {
		String qry = "INSERT INTO PLAYEARS(NAME, EMAIL, PASSWORD) VALUES (?, ?, ?)";
		Integer i = 0;
		try {
			i = jdbc.update(qry, user.getName(), user.getEmail(), user.getPassword());			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public UserBean AutheticatePlayear(UserBean user) {
		UserBean playear = null;
		
		String qry = "SELECT * FROM PLAYEARS WHERE EMAIL = ?";
		
		try {
			 playear = jdbc.queryForObject(qry, new BeanPropertyRowMapper<>(UserBean.class), new Object[] {user.getEmail()});
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return playear;
	}
	
	public Integer addCredits(LogBean logBean) {
		Integer id = logBean.getUserid();
		Integer i = 0, j = 0;
		String qry1 = "UPDATE PLAYEARS SET CREDITS = CREDITS + 100 WHERE ID = ?";
		String qry2 = "INSERT INTO PLAYEARLOGS(USERID, EMAIL, DATE, CREDITS, INCDEC) VALUES (?, ?, ?, ?, ?)";
		StringBuilder str = new StringBuilder("+100");
		Integer credits = logBean.getCredits() + 100;
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDateTime = currentDateTime.format(formatter);
		
		try {
			i = jdbc.update(qry1, id);
			j = jdbc.update(qry2, logBean.getUserid(), logBean.getEmail(), formattedDateTime, credits, str.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
		return credits;
	}
	
	public Integer minusCredits(LogBean logBean) {
		Integer id = logBean.getUserid();
		Integer i = 0, j = 0;
		String qry1 = "UPDATE PLAYEARS SET CREDITS = CREDITS - 10 WHERE ID = ?";
		String qry2 = "INSERT INTO PLAYEARLOGS(USERID, EMAIL, DATE, CREDITS, INCDEC) VALUES (?, ?, ?, ?, ?)";
		StringBuilder str = new StringBuilder("-10");
		Integer credits = logBean.getCredits() - 10;
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDateTime = currentDateTime.format(formatter);
		
		try {
			i = jdbc.update(qry1, id);
			j = jdbc.update(qry2, logBean.getUserid(), logBean.getEmail(), formattedDateTime, credits, str.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
		return credits;
	}
	
	public UserBean getOnePLayer(UserIdBean userID) {
		String qry = "SELECT * FROM PLAYEARS WHERE ID = ?";
		UserBean player = null;
			
		try {			
			player = jdbc.queryForObject(qry, new BeanPropertyRowMapper<>(UserBean.class), new Object[] {userID.getUserid()});
		} catch(Exception e) {
			e.printStackTrace();
		}
		return player;
	}
	
	public List<UserBean> getAllPlayears() {
		String qry = "SELECT * FROM PLAYEARS ORDER BY CREDITS DESC";
		List<UserBean> users = null;
		
		try {
			users = jdbc.query(qry, new BeanPropertyRowMapper<>(UserBean.class));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
	public Integer addUser(UserBean2 user) {
		String qry = "INSERT INTO USERS2(NAME2, EMAIL2, PASSWORD2, IMAGEPATH) VALUES (?, ?, ?, ?)";
		Integer i = 0;
		try {
			i = jdbc.update(qry, user.getName(), user.getEmail(), user.getPassword(), user.getImagePath());			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public UserBean2 getLoginUser(String email) {
		String qry = "SELECT * FROM USERS2 WHERE EMAIL2 = ?";
		UserBean2 user = null;
		System.out.println("email : " + email);
		try {
			user = jdbc.queryForObject(qry, new BeanPropertyRowMapper<>(UserBean2.class), new Object[] {email});
			System.out.println("User email: " + user.getEmail() + " : " + user);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
				
	}
}

package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.User;

@Controller
public class HomeLoanController {
	@Autowired
	JdbcTemplate jdbctemplate;
	
	Boolean isUser=false;
	
	@RequestMapping("home")
	public String home() {
		
		return "home.jsp";
	}
	@RequestMapping("/")
	public String login() {
		
		return "UserLogin.jsp";
	}
	@PostMapping("validate")
	public String validateUser(User user) {
		String sql="Select * from user where login_id=? and passwd=?";
		int result=jdbctemplate.queryForList(sql, user.getLogId(),user.getPassword()).size();
		if(result == 1)
			return "redirect:home";
		else
		return "redirect:/";
	}
	@RequestMapping("apply")
	public String applyLoan() {
		return "ApplyLoan.jsp";
	}
	@RequestMapping("repaySchedule")
	public String repaySchedule() {
		
		return "RepaySchedule.jsp";
	}
	@RequestMapping("prepay")
	public String prepay() {
		
		return "PrePayLoan.jsp";
	}
	@RequestMapping("foreclose")
	public String foreclose() {
		
		return "ForeCloseLoan.jsp";
	}
	
}

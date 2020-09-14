package com.shivam.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.shivam.dao.UserDao;
import com.shivam.entities.LoginUser;
import com.shivam.entities.RegisterUser;

@Controller
@SessionAttributes("userEmail")
public class UserController {
	
	@Autowired
	UserDao userDao;
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpSession session;
	
	@GetMapping("/register")
	public String register(@ModelAttribute RegisterUser registerUser) 
	{
		return "register";
	}
	
	@PostMapping("/RegisterUser")
	public String registerUser(@Valid @ModelAttribute RegisterUser registerUser,BindingResult bindingResult,Model model) 
	{
		if(bindingResult.hasErrors())
		{
			return "redirect:/register";
		}
		
		userDao.saveUserDetails(registerUser);
		session.setAttribute("userState", registerUser);
		model.addAttribute("userEmail", registerUser.getEmail());
		return "welcome";
	}
	
	@GetMapping("/login")
	public String loginPage(@ModelAttribute LoginUser loginUser) {
		return "login";
	}
	
	@PostMapping("/LoginUser")
	public String loginUser(@Valid @ModelAttribute LoginUser loginUser,BindingResult bindingResult,Model model)
	{
		if(bindingResult.hasErrors())
		{
			return "redirect:/login";
		}
		
		else if(userDao.getUserByEmailPassword(loginUser)==null)
		{
			// invalid login id, password
			request.setAttribute("messages", "Invalid email/password!");
			return "redirect:/login";
		}
		
		session.setAttribute("userState", loginUser);
		
		model.addAttribute("userEmail", loginUser.getEmail());
		return "welcome";
	}
	
	@GetMapping("/Logout")
	public String logoutUser(@ModelAttribute LoginUser loginUser) {
		request.getSession().invalidate();
		return "login";
	}
}

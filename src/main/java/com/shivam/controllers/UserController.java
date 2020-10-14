package com.shivam.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.shivam.dao.UserDao;
import com.shivam.entities.LoginUser;
import com.shivam.entities.RegisterUser;

@Controller
//@SessionAttributes("userEmail")
public class UserController {
	
	@Autowired
	UserDao userDao;
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpSession session;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(@ModelAttribute RegisterUser registerUser) 
	{
		if(session.getAttribute("userEmail")!=null)
			return "redirect:/todos";
		
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute RegisterUser registerUser,BindingResult bindingResult,Model model) 
	{
		if(bindingResult.hasErrors())
		{
			return "redirect:/register";
		}
		
		userDao.saveUserDetails(registerUser);
		session.setAttribute("userState", registerUser);
		session.setAttribute("message", "Registration Successful! Login to proceed");
		//model.addAttribute("userEmail", registerUser.getEmail());
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(@ModelAttribute LoginUser loginUser) {
		
		if(session.getAttribute("userEmail")!=null)
			return "redirect:/todos";
		
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
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
		session.setAttribute("userEmail", loginUser.getEmail());
//		model.addAttribute("userEmail", loginUser.getEmail());
		return "redirect:/todos";
	}
	
	@RequestMapping(value = "/Logout",method = RequestMethod.GET)
	public String logoutUser(@ModelAttribute LoginUser loginUser,SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		request.getSession().invalidate();
		return "login";
	}
}

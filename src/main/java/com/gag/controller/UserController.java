package com.gag.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gag.controller.manager.UserManager;
import com.gag.model.User;
import com.gag.util.exceptions.RegisterException;


@Controller
public class UserController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showMain() {
		return "index";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	@RequestMapping(value = "/showlogin", method = RequestMethod.GET)
	public String showLoginPage() {	
		//Return the login page
		return "login";
	}
	
	@RequestMapping(value="/login", method= RequestMethod.POST)
	public String login(Model model, HttpServletRequest request, HttpSession session) {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			UserManager.USER_MANAGER.loginUser(username, password);
			session.setAttribute("username", username);
			return "index";
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "login";
		}
	}
	
	@RequestMapping(value = "/showRegister", method = RequestMethod.GET)
	public String showRegister() {
		// return the register page
		return "register";
	}
	
	@RequestMapping(value="/register", method= RequestMethod.POST)
	public String register(HttpServletRequest request, Model model, HttpSession session) {
		try {
			String pass = request.getParameter("password");
			String pass2 = request.getParameter("password2");
			if (!pass.equals(pass2)) {
				throw new RegisterException("passwords should match");
			}
			
			User user = new User(	request.getParameter("firstName"), request.getParameter("lastName"), 
									request.getParameter("username"), request.getParameter("password"), 
									request.getParameter("email"));
			UserManager.USER_MANAGER.registerUser(user);
			session.setAttribute("username", user.getUsername());
			return "index";
		} catch (RegisterException | SQLException e) {
			model.addAttribute("error", e.getMessage());
			return "register";
		}
	}
}

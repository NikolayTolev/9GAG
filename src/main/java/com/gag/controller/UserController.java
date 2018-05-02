package com.gag.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gag.controller.manager.UserManager;
import com.gag.model.Gender;
import com.gag.model.User;
import com.gag.model.dao.GenderDAO;
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
	
	@RequestMapping(value="/showSettings", method = RequestMethod.GET)
	public String showSettings(Model model, HttpSession session) {
		try {
			if (session.getAttribute("user") == null) {
				model.addAttribute("error", "We don't know who you are. Please, login first.");
				return "login";
			}
			List<Gender> genders = GenderDAO.GENDER_DAO.getAllGenders();
			model.addAttribute("genders", genders);
			// return settings page
			return "settings";
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "settings";
		}
		
	}
	
	@RequestMapping(value="/login", method= RequestMethod.POST)
	public String login(Model model, HttpServletRequest request, HttpSession session) {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User user = UserManager.USER_MANAGER.loginUser(username, password);
			session.setAttribute("user", user);
			session.setMaxInactiveInterval(5);
			return "index";
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "login";
		}
	}
	
	@RequestMapping(value = "/showRegister", method = RequestMethod.GET)
	public String showRegister(Model model) {
		try {
			List<Gender> genders = GenderDAO.GENDER_DAO.getAllGenders();
			model.addAttribute("genders", genders);
			// return the register page
			return "register";
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "register";
		}
		
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
									request.getParameter("email"), Integer.parseInt(request.getParameter("gender")));
			synchronized (UserController.class) {
				UserManager.USER_MANAGER.registerUser(user);
			}
			session.setAttribute("user", user);
			session.setMaxInactiveInterval(5);
			return "index";
		} catch (RegisterException | SQLException e) {
			model.addAttribute("error", e.getMessage());
			return "register";
		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String changeUserData(Model model, HttpSession session, HttpServletRequest request) {
		try {
			if (session.getAttribute("user") == null) {
				model.addAttribute("error", "We don't know who you are. Please, login first.");
				return "login";
			}
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String biography = request.getParameter("biography");
			int genderId = Integer.parseInt(request.getParameter("gender"));
			
			User user = (User) session.getAttribute("user");
			UserManager.USER_MANAGER.changeProfile(user, firstName, lastName, biography, genderId);
			model.addAttribute("success", "Data changed successfuly.");
			return "settings";
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "settings";
		}
	}

	@RequestMapping(value = "/deleteAccount", method = RequestMethod.POST)
	public String deleteAccount(HttpSession session, Model model) {
		try {
			if (session.getAttribute("user") == null) {
				model.addAttribute("error", "We don't know who you are. Please, login first.");
				return "login";
			}
			User user = (User) session.getAttribute("user");
			UserManager.USER_MANAGER.deleteAccount(user);
			session.invalidate();
			return "index";
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "login";
		}
	}
}

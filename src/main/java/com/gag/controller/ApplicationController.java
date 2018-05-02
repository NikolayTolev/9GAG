package com.gag.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gag.model.Country;
import com.gag.model.Gender;
import com.gag.model.dao.CountryDAO;
import com.gag.model.dao.GenderDAO;

@Controller
public class ApplicationController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showMain() {
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
			List<Country> countries = CountryDAO.COUNTRY_DAO.getAllCountries();
			session.setAttribute("genders", genders);
			session.setAttribute("countries", countries);
			// return settings page
			return "settings";
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "settings";
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
}
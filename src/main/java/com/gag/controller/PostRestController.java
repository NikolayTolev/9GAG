package com.gag.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gag.model.Post;
import com.gag.model.dao.PostDAO;

@Controller
public class PostRestController {

	@RequestMapping(value="/posts",method = RequestMethod.GET)
	public String getPosts(Model m) throws Exception{
		try {
		
			m.addAttribute("posts", (List<Post>) PostDAO.POST_DAO.getFreshPosts());
		  } catch ( Exception e) {
			  return "index";		
		  }
		return "index";
	}
	
}

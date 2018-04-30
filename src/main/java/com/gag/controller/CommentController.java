package com.gag.controller;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gag.controller.manager.CommentManager;
import com.gag.model.Comment;
import com.gag.model.Post;
import com.gag.model.User;
import com.gag.model.dao.CommentDAO;
import com.gag.model.dao.UserDAO;

@Controller
public class CommentController {

	@RequestMapping(value = "/comment", method = RequestMethod.POST)
	public String comment(Model model, HttpServletRequest req) {
		try {
			Post post = (Post) req.getAttribute("post");
			User user = UserDAO.USER_DAO.getUserByUsername((String)req.getSession().getAttribute("username"));
			String content = (String)req.getAttribute("content");
			Comment com = new Comment(post, user, content);
			CommentManager.COMMENT_MANAGER.writeComment(post, com);
			return "index";
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "index";
		}
	}
	
	@RequestMapping(value = "/comment", method = RequestMethod.DELETE)
	public String deleteComment(Model model, HttpServletRequest req) {
		try {
			Comment comment = (Comment) req.getAttribute("comment");
			CommentManager.COMMENT_MANAGER.removeComment(comment);
			return "index";
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "index";
		}
	}
	
	@RequestMapping(value = "/voteComment", method = RequestMethod.POST)
	public String voteComment(Model model, HttpServletRequest request, HttpSession session) {
		try {
			User user = UserDAO.USER_DAO.getUserByUsername((String) session.getAttribute("username"));
			Comment comment = (Comment) request.getAttribute("comment");
			CommentDAO.COMMENT_DAO.voteComment(user, comment, (int) request.getAttribute("vote"));
			return "index";
		} catch (SQLException e) {
			model.addAttribute("error", e.getMessage());
			return "index";
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "index";
		}
	}
	
	
}

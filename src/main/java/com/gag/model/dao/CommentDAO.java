package com.gag.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gag.model.Comment;
import com.gag.model.Post;
import com.gag.model.User;
import com.gag.model.db.DBManager;

public enum CommentDAO implements ICommentDAO {

	COMMENT_DAO;
	private Connection con;
	
	private CommentDAO() {
		con = DBManager.DB_MANAGER.getConnection();
	}

	@Override
	public Comment getCommentById(int id) throws Exception {
		String sql="SELECT id, date, content, users_id, posts_id, comments_id FROM comments WHERE id =? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Comment comment = null;
		if (rs.next()) {
			comment = new Comment(rs.getInt("id"), rs.getDate("date"), PostDAO.POST_DAO.getPostsById(rs.getInt("posts_id")),
											UserDAO.USER_DAO.getUserById(rs.getInt("users_id")), rs.getString("content"));
		}
		return comment;
	}

	@Override
	public void saveComment(Post p, Comment c) throws Exception {
		String sql = "INSERT INTO comments (content, users_id, posts_id) VALUES (?, ?, ?);";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, c.getContent());
		ps.setInt(2, c.getOwner().getId());
		ps.setInt(3, p.getId());
		ps.executeUpdate();
	}

	@Override
	public void deleteComment(Comment c) throws Exception {
		String sql = "DELETE FROM comments WHERE id=?;";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, c.getId());
		ps.executeUpdate();
	}

	@Override
	public void saveSubComment(Comment parent, Comment child) throws SQLException {
		String sql = "INSERT INTO comments (content, users_id, posts_id, comments_id) VALUES (?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, child.getContent());
		ps.setInt(2, child.getOwner().getId());
		ps.setInt(3, parent.getPost().getId());
		ps.setInt(4, parent.getId());
		ps.executeUpdate();
	}

	@Override
	public void voteComment(User user, Comment comment, int voteType) throws Exception {
		String sql = "INSERT INTO comments_have_votes (vote, comments_is, users_id) VALUES (?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, voteType);
		ps.setInt(2, comment.getId());
		ps.setInt(3, user.getId());
		ps.executeUpdate();
	}

	@Override
	public List<Comment> getCommentsByPost(Post post) throws Exception {
		String sql = "SELECT id, date, content, users_id, posts_id, comments_id FROM comments WHERE posts_id=?;";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, post.getId());
		ResultSet rs = ps.executeQuery();
		List<Comment> comments = new ArrayList<>();
		while(rs.next()) {
			Comment com = new Comment(rs.getInt("id"), rs.getDate("date"), PostDAO.POST_DAO.getPostsById(rs.getInt("posts_id")),
					UserDAO.USER_DAO.getUserById(rs.getInt("users_id")), rs.getString("content"));
			comments.add(com);
		}
		return comments;
	}

	@Override
	public void updateComment(Comment c) throws Exception {
		String sql = "UPDATE comments SET content=? WHERE id=?;";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, c.getContent());
		ps.setInt(2, c.getId());
		ps.executeUpdate();
	}
}

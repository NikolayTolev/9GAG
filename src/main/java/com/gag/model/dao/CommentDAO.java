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
		String sql="SELECT id, date, content, user_id, post_id, comment_id FROM comments WHERE id =? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Comment comment = null;
		if (rs.next()) {
			comment = new Comment(rs.getInt("id"), rs.getDate("date"), PostDAO.POST_DAO.getPostsById(rs.getInt("post_id")),
											UserDAO.USER_DAO.getUserById(rs.getInt("user_id")), rs.getString("content"));
		}
		return comment;
	}

	@Override
	public void saveComment(Post p, Comment c) throws Exception {
		String sql = "INSERT INTO comments (content, user_id, post_id) VALUES (?, ?, ?);";
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
		String sql = "INSERT INTO comments (content, user_id, post_id, comment_id) VALUES (?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, child.getContent());
		ps.setInt(2, child.getOwner().getId());
		ps.setInt(3, parent.getPost().getId());
		ps.setInt(4, parent.getId());
		ps.executeUpdate();
	}

	@Override
	public void voteComment(User user, Comment comment, int voteType) throws Exception {
		String sql = "INSERT INTO comments_have_votes (vote, comment_id, user_id) VALUES (?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, voteType);
		ps.setInt(2, comment.getId());
		ps.setInt(3, user.getId());
		ps.executeUpdate();
	}

	@Override
	public List<Comment> getCommentsByPost(Post post) throws Exception {
		String sql = "SELECT id, date, content, user_id, post_id, comment_id FROM comments WHERE post_id=?;";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, post.getId());
		ResultSet rs = ps.executeQuery();
		List<Comment> comments = new ArrayList<>();
		while(rs.next()) {
			Comment com = new Comment(rs.getInt("id"), rs.getDate("date"), PostDAO.POST_DAO.getPostsById(rs.getInt("post_id")),
					UserDAO.USER_DAO.getUserById(rs.getInt("user_id")), rs.getString("content"));
			comments.add(com);
			com.setReplies(getCommentsByComment(com));
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

	@Override
	public List<Comment> getCommentsByComment(Comment comment) throws Exception {
		String sql = "SELECT c.id, c.date, c.content, c.user_id, c.post_id, c.comment_id FROM comments c"
					 + "JOIN comment p ON (c.comment_id = p.id) WHERE p.id = ?;";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, comment.getId());
		ResultSet rs = ps.executeQuery();
		List<Comment> comments = new ArrayList<>();
		while(rs.next()) {
			comments.add(new Comment(rs.getInt("id"), rs.getDate("date"), PostDAO.POST_DAO.getPostsById(rs.getInt("post_id")), 
					               	UserDAO.USER_DAO.getUserById(rs.getInt("user_id")), rs.getString("content")));
		}
		return comments;
	}

	@Override
	public void deleteCommentVote(User user, Comment comment) throws Exception {
		String sql = "DELETE FROM comments_have_votes WHERE comment_id = ? AND users_id = ?;";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, comment.getId());
		ps.setInt(2, user.getId());
		ps.executeUpdate();
	}

	@Override
	public int countVotesOfComment(Comment comment) throws Exception {
		String sql = "SELECT SUM(vote) AS vote FROM comments_have_votes WHERE comment_id = ?;";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, comment.getId());
		ResultSet rs = ps.executeQuery();
		int result = 0;
		if (rs.next()) {
			result = rs.getInt("vote");
		}
		return result;
	}
}

package com.gag.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gag.model.BCrypt;
import com.gag.model.User;
import com.gag.model.db.DBManager;

public enum UserDAO implements IUserDAO {

	USER_DAO;
	private Connection con;

	private UserDAO() {
		con = DBManager.DB_MANAGER.getConnection();
	}

	@Override
	public void saveUser(User u) throws SQLException {
		String sql = "INSERT INTO users (email, password, username, first_name, last_name, gender_id) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, u.getEmail());
		ps.setString(2, BCrypt.hashpw(u.getPassword(), BCrypt.gensalt()));
		ps.setString(3, u.getUsername());
		ps.setString(4, u.getFirstName());
		ps.setString(5, u.getLastName());
		ps.setInt(6, u.getGenderId());
		ps.executeUpdate();
	}

	@Override
	public void deleteUser(User u) throws SQLException {
		String sql = "DELETE FROM users WHERE username=? AND email=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, u.getUsername());
		ps.setString(2, u.getEmail());
		ps.executeUpdate();
	}

	@Override
	public User getUserById(int id) throws SQLException {
		String sql = "SELECT id, email, password, username, first_name, last_name, photo, biography, country_id FROM users"
				+ " WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return new User(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"),
					rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getString("biography"),
					rs.getInt("gender_id"), rs.getInt("country_id"));
		}
		return null;
	}

	@Override
	public User getUserByUsername(String username) throws SQLException {
		String sql = "SELECT id, email, password, username, first_name, last_name, photo, biography, gender_id, country_id FROM users"
				+ " WHERE username=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return new User(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"),
					rs.getString("username"), rs.getString("password"), rs.getString("email"),
					rs.getString("biography"), rs.getInt("gender_id"), rs.getInt("country_id"));
		}
		return null;
	}

	@Override
	public String checkForEmail(String email) throws SQLException {
		String sql = "SELECT email FROM users WHERE email=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return rs.getString("email");
		}
		return null;
	}

	@Override
	public String checkForUsername(String username) throws SQLException {
		String sql = "SELECT username FROM users WHERE username=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return rs.getString("username");
		}
		return null;
	}

	@Override
	public void updateUserData(User u) throws Exception {
		String sql = "UPDATE users SET first_name=?, last_name=?, biography=?, gender_id=?, country_id=? WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, u.getFirstName());
		ps.setString(2, u.getLastName());
		ps.setString(3, u.getBiography());
		ps.setInt(4, u.getGenderId());
		ps.setInt(5, u.getCountryId());
		ps.setInt(6, u.getId());
		ps.executeUpdate();
	}
}

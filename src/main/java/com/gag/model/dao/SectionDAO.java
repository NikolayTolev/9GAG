package com.gag.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import com.gag.model.Section;
import com.gag.model.db.DBManager;

public enum SectionDAO implements ISectionDAO{

  SECTION_DAO;
	
	private Connection con;

	SectionDAO(){
		con=DBManager.DB_MANAGER.getConnection();
	}

	@Override
	public Section getSectionById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Section getSectionByName(String name) throws SQLException {
	   String sql="SELECT id, name FROM sections WHERE name=?";
	   PreparedStatement ps= con.prepareStatement(sql);
	   ps.setString(1, name);
	   ResultSet rs = ps.executeQuery();
	   rs.next();
	   Section s= new Section(rs.getInt("id"), rs.getString("name"));
	   return s;
	}

	@Override
	public Collection<Section> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
}

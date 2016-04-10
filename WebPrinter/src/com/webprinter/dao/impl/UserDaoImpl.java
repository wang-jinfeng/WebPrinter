package com.webprinter.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.webprinter.dao.UserDao;
import com.webprinter.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean addUser(User user) {
		String sqlStr = "insert into user(uname,pwd) values(?,?)";
		Object[] params = new Object[] { user.getUserName(), user.getPassword() };
		jdbcTemplate.update(sqlStr, params);
		return false;
	}

	public User findUserByUserName(String userName) {
		String sqlStr = "select id,user_name,password from user where user_name=?";
		final User user = new User();
		jdbcTemplate.query(sqlStr, new Object[] { userName },
				//能否封装
				new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						user.setId(rs.getInt("id"));
						user.setUserName(rs.getString("user_name"));
						user.setPassword(rs.getString("password"));
					}
				});
		return user;
	}

	public boolean delete(User user) {
		int updLines = 0;
		String sqlStr = "delete from user where id=?";
		Object[] params = new Object[] { user.getId() };
		updLines = jdbcTemplate.update(sqlStr, params);
		return updLines > 0;
	}

	public List<User> findAll() {
		String sqlStr = "select * from user where user_name=?";
		List<User> userList;
		userList = jdbcTemplate.queryForList(sqlStr, User.class);
		return userList;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

}

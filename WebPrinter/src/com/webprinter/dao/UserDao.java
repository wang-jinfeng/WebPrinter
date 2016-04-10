package com.webprinter.dao;

import java.util.List;

import com.webprinter.entity.User;

/**
 * 
 * @author apple
 *
 */
public interface UserDao {
	public boolean addUser(User user);
	public User findUserByUserName(String userName);
	public boolean delete(User user);
	public List<User> findAll();
	
}

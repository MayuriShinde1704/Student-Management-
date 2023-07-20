package com.user.dao.daoimpl;

import java.util.List;

import com.user.model.User;

public interface UserDAO {

	void insertUser(User user) throws Exception;

	User selectUser(int id) throws Exception;

	List<User> selectAllUsers() throws Exception;

	boolean deleteUser(int id) throws Exception;

	boolean updateUser(User user) throws Exception;

}

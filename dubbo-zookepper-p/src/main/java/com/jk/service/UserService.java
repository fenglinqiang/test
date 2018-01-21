package com.jk.service;

import com.jk.model.User;

import java.util.List;

public interface UserService {

	String userService(Integer pageSize, Integer start, User user);
	
	User queryUpdate(Integer taid);
	
	void updateUser(User user);

	List<com.jk.model.Tree> findTree(int i);
}

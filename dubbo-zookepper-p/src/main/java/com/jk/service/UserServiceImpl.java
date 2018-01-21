package com.jk.service;

import java.util.List;

import com.jk.model.Tree;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.jk.dao.UserDao;
import com.jk.model.User;


public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public String userService(Integer pageSize, Integer start, User user) {
		long count = userDao.userDaocount(user);
		List<User> list = userDao.userDaofind(pageSize, start, user);

		JSONObject object = new JSONObject();
		object.put("total", count);
		object.put("rows", list);

		return object.toString();
	}

	/* (non-Javadoc)    
	 * @see com.jk.service.UserService#queryUpdate(java.lang.Integer)    
	 */
	@Override
	public User queryUpdate(Integer taid) {
		// TODO Auto-generated method stub
		return userDao.queryUpdate(taid);
	}

	/* (non-Javadoc)    
	 * @see com.jk.service.UserService#updateUser(com.jk.model.User)    
	 */
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
	}

	@Override
	public List<Tree> findTree(int i) {
		List<Tree> list = userDao.findTree(i);
		return list;
	}

}

package com.wms.api.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wms.api.base.dao.BaseDAO;
import com.wms.api.dao.UserDAO;
import com.wms.api.model.User;

@Repository
public class UserDaoImpl implements UserDAO {
	@Autowired
	private BaseDAO<User> userBaseDAO;

	@Override
	public User findByUsername(String username) {
		if (username != null) {
			List<User> userList = userBaseDAO.findByColumn(User.class, "username", username);
			if (userList.size() != 0) {
				return userList.get(0);
			}
		}
		return null;
	}

	@Override
	public void deleteById(long id) {
		if (id != 0) {
			userBaseDAO.deleteById(User.class, id);
		}
	}

	@Override
	public User findById(Long id) {
		if (id != 0) {
			User user = userBaseDAO.findById(User.class, id);
			if (user != null) {
				return user;
			}
		}
		return null;
	}

	@Override
	public Long save(User user) {
		if (user != null) {
			return (Long) userBaseDAO.save(user);
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		List<User> users = userBaseDAO.findAll(User.class);
		if (users != null) {
			return users;
		}
		return null;
	}
}

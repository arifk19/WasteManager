package com.wms.api.dao;

import java.util.List;

import com.wms.api.model.User;

public interface UserDAO {
	User findByUsername(String username);

	void deleteById(long id);

	User findById(Long id);

	Long save(User user);

	List<User> findAll();
}

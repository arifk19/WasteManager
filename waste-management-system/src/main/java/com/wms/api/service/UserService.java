package com.wms.api.service;

import java.util.List;

import com.wms.api.dto.UserDto;
import com.wms.api.model.User;

public interface UserService {

	Long save(UserDto user);

	List<User> findAll();

	void delete(long id);

	User findOne(String username);

	User findById(Long id);
}
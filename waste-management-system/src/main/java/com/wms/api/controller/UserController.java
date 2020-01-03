package com.wms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wms.api.dto.ProductCategoryDTO;
import com.wms.api.dto.UserDto;
import com.wms.api.enums.SecurityError;
import com.wms.api.model.User;
import com.wms.api.response.BaseResponse;
import com.wms.api.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

	@Autowired
	MessageSource messageSource;

	@Autowired
	private UserService userService;

	// @Secured({"ROLE_ADMIN", "ROLE_USER"})
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> listUser() {
		return userService.findAll();
	}

	// @Secured("ROLE_USER")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	//// @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public User getOne(@PathVariable(value = "id") Long id) {
		return userService.findById(id);
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String saveUser(@RequestBody UserDto user) {
		Long response = userService.save(user);
		if (response != null) {
			return "success reponse data saved in database.";
		}
		return "fail to store in database.";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/find-user-by-name", method = RequestMethod.POST)
	public ResponseEntity<?> findByUserName(@RequestBody UserDto user) {
		final User userDetails = userService.findOne(user.getUsername());
		if (userDetails != null) {
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.OK.value(),
					messageSource.getMessage("user.detail.message", null, null), userDetails), HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(
					new BaseResponse(HttpStatus.BAD_REQUEST.value(),
							messageSource.getMessage("user.not.available", null, null), userDetails),
					HttpStatus.NOT_FOUND);
		}
		
	}
}
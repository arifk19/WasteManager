package com.wms.api.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wms.api.base.dao.BaseDAO;
import com.wms.api.dao.RoleDAO;
import com.wms.api.model.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	private BaseDAO<Role> roleBaseDAO;

	@Override
	public Role findById(Long id) {
		if (id != 0) {
			Role role = roleBaseDAO.findById(Role.class, id);
			if (role != null) {
				return role;
			}
		}
		return null;
	}
}

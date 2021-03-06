package com.rentcar.app.service.impl;

import java.util.List;

import com.rentcar.app.dao.UserProfileDao;
import com.rentcar.app.model.UserProfile;
import com.rentcar.app.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
    UserProfileDao dao;

	public UserProfile findById(int id) {
		return dao.findById(id);
	}

	public UserProfile findByType(String type){
		return dao.findByType(type);
	}

	public List<UserProfile> findAll() {
		return dao.findAll();
	}
}

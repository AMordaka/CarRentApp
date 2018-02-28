package com.rentcar.app.service;

import java.util.List;

import com.rentcar.app.model.UserProfile;


public interface UserProfileService {

	UserProfile findById(int id);

	UserProfile findByType(String type);
	
	List<UserProfile> findAll();
	
}

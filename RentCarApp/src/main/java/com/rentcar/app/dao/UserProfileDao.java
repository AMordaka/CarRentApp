package com.rentcar.app.dao;

import java.util.List;

import com.rentcar.app.model.UserProfile;


public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}

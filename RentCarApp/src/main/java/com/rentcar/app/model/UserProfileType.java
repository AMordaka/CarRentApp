package com.rentcar.app.model;

import java.io.Serializable;

public enum UserProfileType implements Serializable{
	USER("USER"),
	ADMIN("ADMIN"),
    DEALER("DEALER");
	
	String userProfileType;
	
	private UserProfileType(String userProfileType){
		this.userProfileType = userProfileType;
	}
	
	public String getUserProfileType(){
		return userProfileType;
	}
	
}

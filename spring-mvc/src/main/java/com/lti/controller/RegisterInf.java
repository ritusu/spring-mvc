package com.lti.controller;

import com.lti.entity.User;

public interface RegisterInf {

	public void addNewUser(User user);
	
	public User fetch(String email);


}
package com.lti.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.lti.entity.User;

@Component
public class RegisterDao implements RegisterInf {
	
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void addNewUser(User user) {
	em.persist(user);
	}

	
	public User fetch(String email) {
		
		return (User) em.createQuery("select u from User u where u.email=:em")
				.setParameter("em", email).getSingleResult();
		
		
	}
	}

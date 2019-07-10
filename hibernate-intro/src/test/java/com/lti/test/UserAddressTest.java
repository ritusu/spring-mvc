package com.lti.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lti.Dao.GenericDao;
import com.lti.entity.Address;
import com.lti.entity.User;

public class UserAddressTest {

	@Test
	public void addNewUser() {
		User user = new User();
		 user.setEmail("avinash@gmail.com");
		 user.setName("Avinash");
		
		 GenericDao dao = new GenericDao();
		 dao.save(user);
	}
	
	@Test
	public void addAddressForAnExistingUser() {

		GenericDao dao = new GenericDao();
		User user = (User) dao.fetchById(User.class, 225);
		
		Address addr = new Address();
		addr.setCity("DELHI");
		addr.setState("INDIA");
		addr.setPincode(654321);
		addr.setUser(user);
		dao.save(addr);
		
	}
	
	@Test
	public void addUserAndAddressTogether() {

		   User user = new User();
		   user.setEmail("majrul@gmail.com");
		   user.setName("MAJRUL");
		
		    Address addr = new Address();
			addr.setCity("PARIS");
			addr.setState("ITLY");
			addr.setPincode(987654);
			
			user.setAddress(addr);
			addr.setUser(user);
			
			GenericDao dao = new GenericDao();
			dao.save(user);
	}
	
	@Test
	public void fetchUserAndAddressBoth() {
		
		GenericDao dao = new GenericDao();
		User user = (User) dao.fetchById(User.class, 236);
		System.out.println(user.getName());
		System.out.println(user.getEmail());
		
		Address addr = user.getAddress();
		System.out.println(addr.getCity());
		System.out.println(addr.getState());
		System.out.println(addr.getPincode());
	}
	
	
	

}



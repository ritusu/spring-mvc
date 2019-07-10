package com.lti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_TBL")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "U_ID")
	private int id;
	private String name;
	private String email;
	
	//FETCH will control -->Select
	//CASCADE will control --> Insert ,Update, Delete
	@OneToOne(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL ) 
	private Address address; 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}

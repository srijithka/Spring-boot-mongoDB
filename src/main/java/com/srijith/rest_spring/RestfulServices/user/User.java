package com.srijith.rest_spring.RestfulServices.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

public class User {
	@Id
	private Integer id;
	private String name;
	private Date date;
	
	public User()
	{
		
	}
	public User(int id, String name, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
	}
	public Integer getId() {
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

}

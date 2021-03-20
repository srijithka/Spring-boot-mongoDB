package com.srijith.rest_spring.RestfulServices.post;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.mongodb.core.mapping.Document;

import com.srijith.rest_spring.RestfulServices.user.User;





public class Post {
	@Id
	private Integer id;
	private String message;
	private Date dateCreated;
	
	@ManyToOne
	private Integer userId;
	
	
	
	public Post()
	{
		super();
	}
	public Post(Integer pid,String message,Date dateCreated)
	{
		this.id=pid;
		this.message=message;
		this.dateCreated=dateCreated;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
	
	
	

}

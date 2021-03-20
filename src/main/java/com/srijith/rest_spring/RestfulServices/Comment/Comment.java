package com.srijith.rest_spring.RestfulServices.Comment;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Comment {
	
	@Id
	private CommentId id;
	private String message;
	private Integer likes;
	private Integer dislikes;
	private Date lastModified;
	private Integer userId;
	
	
	public Comment(CommentId id, String message, Integer likes, Integer dislikes, Date lastModified, Integer userId) {
		super();
		this.id = id;
		this.message = message;
		this.likes = likes;
		this.dislikes = dislikes;
		this.lastModified = lastModified;
		this.userId = userId;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public CommentId getId() {
		return id;
	}
	public void setId(CommentId id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getLikes() {
		return likes;
	}
	public void setLikes(Integer likes) {
		this.likes = likes;
	}
	public Integer getDislikes() {
		return dislikes;
	}
	public void setDislikes(Integer dislikes) {
		this.dislikes = dislikes;
	}
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	
	

}

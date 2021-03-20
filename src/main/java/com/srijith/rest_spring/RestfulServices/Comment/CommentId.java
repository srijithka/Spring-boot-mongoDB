package com.srijith.rest_spring.RestfulServices.Comment;

public class CommentId {
	
	private Integer pid;
	private Integer cid;
	
	
	public CommentId(Integer pid, Integer cid) {
		super();
		this.pid = pid;
		this.cid = cid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	

}

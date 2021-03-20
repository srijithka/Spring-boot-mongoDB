package com.srijith.rest_spring.RestfulServices.post;

import org.springframework.stereotype.Service;


public interface PostRepository {
	public Post classFindByPid(Integer pid);

}

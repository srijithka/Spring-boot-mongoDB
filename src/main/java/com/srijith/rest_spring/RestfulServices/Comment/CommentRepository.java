package com.srijith.rest_spring.RestfulServices.Comment;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CommentRepository extends MongoRepository<Comment,CommentId>{
	
	
	@Query(value="{'id.pid':?0}")
	public List<Comment> customFindByPid(Integer pid);
	
	@Query(value="{'id':?0}")
	public Comment customFindbyId(CommentId id);
	
}

package com.srijith.rest_spring.RestfulServices.post;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends MongoRepository<Post,Integer>,PostRepository{
	
	
	public List<Post> findByUserId(Integer id);
	
	@Query(value="{$and:[{'id':?0},{'userId':?1}]}")
	public Post findByIdAndUserId(Integer id,Integer userId);
	
	@Query(value="{'userId':?0}")
	public List<Post> defFindByUserId(Integer id);
	
	@Query(value="{'id':?0}")
	public Post defFindById(Integer id);
	
	@Query(value="{'id':{$lt:?0}}")
	public List<Post> classQueryFindAllLessThanId(Integer pid);
	
	@Query(value="{'id':?0}")
	public Post defFindByPostId(Integer pid);
	
	

}

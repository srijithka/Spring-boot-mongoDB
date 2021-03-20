package com.srijith.rest_spring.RestfulServices.post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.srijith.rest_spring.RestfulServices.user.UserDaoService;
import com.srijith.rest_spring.RestfulServices.user.UserNotFoundException;

@Service
public class PostDaoService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private UserDaoService userDaoService;

	public List<Post> getAllUserPosts(Integer id) {
		// TODO Auto-generated method stub
		List<Post> posts=new ArrayList<>();
		postRepo.defFindByUserId(id).forEach(posts::add);
		return posts;
		
	}

	public void addPostService(Post post) {
		// TODO Auto-generated method stub
		Query query=new Query();
		postRepo.save(post);
		
	}
	
	public boolean deletePostService(Integer id,Integer pid)
	{
		if(userDaoService.findOne(id)==null)
		{
			
			throw new UserNotFoundException("invalid username");
		}
		else
		{
			
			
			if(postRepo.findByIdAndUserId(pid, id)==null)
			{
				System.out.println("Query failed");
				throw new PostNotFoundException("User has no right to delete or post doesn't exsist");
				//return false;
			}
			else
			{
				System.out.println("Query post available");
				postRepo.deleteById(pid);
				return true;
			}
		}
	}
	
	public Post updatePostService(Integer id,Integer pid,Post post)
	{
		if(userDaoService.findOne(id)==null)
		{
			
			throw new UserNotFoundException("invalid username");
		}
		else
		{
			//System.out.println("the val- "+postRepo)
			if(postRepo.defFindById(pid)==null)
			{
				System.out.println("new post created");
				post.setId(pid);
				postRepo.save(post);
				
				return post;
			}
			else if(postRepo.findByIdAndUserId(pid, id)==null)
			{
				System.out.println("Query failed");
				throw new PostNotFoundException("User has no right to update or post doesn't exsist");
			}
			else
			{
				System.out.println("the post id and user id is -"+post.getId()+" "+post.getUserId());
				if(post.getId()==null)
					post.setId(pid);
				postRepo.save(post);
				return post;
			}
			
		}
	}

	public List<Post> findPostLtId(Integer pid) {
		// TODO Auto-generated method stub
		
		return postRepo.classQueryFindAllLessThanId(pid);
	}
	
	public Post defFindByPostId(Integer pid)
	{
		return postRepo.classFindByPid(pid);
	}
	
	
	
	
	/*
	 * {
        "id": 2,
        "message": "My cisco interview",
        "dateCreated": "2013-03-05T08:40:08.692+00:00",
        "userId": 2
    	}
	 */
	
	

}

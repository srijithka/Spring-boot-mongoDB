package com.srijith.rest_spring.RestfulServices.post;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.srijith.rest_spring.RestfulServices.user.User;
import com.srijith.rest_spring.RestfulServices.user.UserDaoService;
import com.srijith.rest_spring.RestfulServices.user.UserNotFoundException;






@RestController
public class PostController {
	
	@Autowired
	private PostDaoService postDaoService;
	
	@Autowired
	private UserDaoService userDaoService;
	
	@RequestMapping(method=RequestMethod.GET,value="/users/{id}/posts")
	public List<Post> getAllPosts(@PathVariable Integer id)
	{
		return postDaoService.getAllUserPosts(id);
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/users/{id}/post")
	public Post addPost(@RequestBody Post post,@PathVariable Integer id)
	{
		System.out.println("creating the post now");
		if(userDaoService.findOne(id)!=null)
		{
		post.setUserId(id);
		System.out.println(post);
		postDaoService.addPostService(post);
		return post;
		}
		else
		{
			System.out.println("User isn't registered,hence can't create the post");
			throw new PostNotFoundException("No user hence no post can be created");
			
			
		}
		//return null;
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/users/{id}/post/{pid}")
	public void deletePost(@PathVariable Integer id,@PathVariable Integer pid)
	{
		System.out.println("starting delete op1");
		if(postDaoService.deletePostService(id, pid)==true)
		{
			//return null;
		}
		else
		{
			throw new PostNotFoundException("unable to find the post");
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/user/{id}/post/{pid}/update")
	public Post updatePost(@RequestBody Post post,@PathVariable Integer id,@PathVariable Integer pid)
	{
		return postDaoService.updatePostService(id, pid, post);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/posts/{pid}")
	public List<Post> postLessThanId(@PathVariable Integer pid)
	{
		return postDaoService.findPostLtId(pid);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/posts/eq/{pid}")
	public Post findByPid(@PathVariable Integer pid)
	{
		return postDaoService.defFindByPostId(pid);
	}
	
}

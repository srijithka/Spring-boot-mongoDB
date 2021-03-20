package com.srijith.rest_spring.RestfulServices.Comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.srijith.rest_spring.RestfulServices.post.PostDaoService;
import com.srijith.rest_spring.RestfulServices.user.UserDaoService;

@RestController
public class CommentController {
	
	@Autowired
	public CommentService commentService;
	
	@Autowired
	public UserDaoService userDaoService;
	
	@Autowired
	public PostDaoService postDaoService;

	@RequestMapping(method=RequestMethod.GET,value="/comments/{pid}")
	public List<Comment> getAllComments(@PathVariable Integer pid)
	{
		return commentService.getAllComments(pid);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/comments/{pid}/{cid}/{uid}")
	public Comment addComment(@RequestBody Comment comment,@PathVariable Integer pid,@PathVariable Integer cid,@PathVariable Integer uid)
	{
		//System.out.println("hello post method");
		if(userDaoService.findOne(uid)!=null&&postDaoService.defFindByPostId(pid)!=null)
		{
		comment.setId(new CommentId(pid,cid));
		comment.setUserId(uid);
		if(commentService.addComment(comment))
		return comment;
		else
			return null;
		}
		else
		{
			System.out.println("The User or Post Doesn't exsist to comment");
			return null;
		}
	}
}

package com.srijith.rest_spring.RestfulServices.Comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srijith.rest_spring.RestfulServices.Exception.ExceptionResponse;

@Service
public class CommentService {
	
	@Autowired
	public CommentRepository commentRepository;
	
	

	public boolean addComment(Comment comment) {
		// TODO Auto-generated method stub
		if(commentRepository.customFindbyId(comment.getId())==null)
		{
			commentRepository.save(comment);
			return true;
		}
		else
		{
			System.out.println("the Post with the given ID exsists..so can't be created");
			//throw new ExceptionResponse("comment already exsists");
			return  false;
		}
		
	}

	public List<Comment> getAllComments(Integer pid) {
		// TODO Auto-generated method stub
		return commentRepository.customFindByPid(pid);
	}
	
	
	
	

}

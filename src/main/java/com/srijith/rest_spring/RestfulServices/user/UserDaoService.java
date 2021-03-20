package com.srijith.rest_spring.RestfulServices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserDaoService {
	
	@Autowired
	private UserRepo userRepo;
	
	
	private static int userCount=0;
	
	
	
	public List<User> getUsers()
	{
		return (List<User>)userRepo.findAll();
	}
	
	public User saveUser(User user)
	{
		//System.out.println(userCount);
		if(user.getId()==null)
		{
			user.setId(++userCount);
		}
		userRepo.save(user);
		return user;
	}
	public User findOne(Integer id)
	{
		//String id1=Integer.toString(id);
		//System.out.println("the id is - "+id);
		return userRepo.findById(id).get();
	}
	
	public User deleteUser(Integer id)
	{
		/*int flag=-1;
		User deletedUser=null;
		for(User user:users)
		{
			if(user.getId()==id)
			{
				flag=1;
				users.remove(user);
				deletedUser=user;
				break;
				
			}
		}
		if(flag==1)
		{
			return deletedUser;
		}
		else
		{
			return null;
		}*/
		return null;
	}

}

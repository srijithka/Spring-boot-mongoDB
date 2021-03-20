package com.srijith.rest_spring.RestfulServices.user;

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






@RestController
public class UserController {
	
	@Autowired
	private UserDaoService userDaoService;
	
	@RequestMapping(value="/users")
	public List<User> getAllUsers()
	{
		return userDaoService.getUsers();
	}
	@RequestMapping(value="users/{id}")
	public User getOneUser(@PathVariable Integer id)
	{
		User user=userDaoService.findOne(id);
		if(user==null)
			throw new UserNotFoundException("id- "+id);
		
		
		return user;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/users/{foo}")
	public ResponseEntity<Object> addUser(@RequestBody User user,@PathVariable String foo)
	{
		User savedUser=userDaoService.saveUser(user);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/users/delete/{id}")
	public User deleteUser(@PathVariable Integer id)
	{
		User deleteUser=userDaoService.deleteUser(id);
		if(deleteUser==null)
			throw new UserNotFoundException("requested id isn't available - "+id);
		return deleteUser;
	}

}

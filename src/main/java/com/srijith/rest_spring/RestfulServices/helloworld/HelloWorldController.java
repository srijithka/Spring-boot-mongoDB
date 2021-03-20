package com.srijith.rest_spring.RestfulServices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private HelloWorld helloWorld;
	
	@RequestMapping(value="/hello-world")
	public String helloService()
	{
		return "how you doing";
		
		
	}
	
	@RequestMapping(value="/hello-world-bean")
	public HelloWorld hellobean()
	{
		return helloWorld;
	}
	
	@RequestMapping(value="/hello-world-bean/{id}")
	public HelloWorld helloBeanUser(@PathVariable String id)
	{
		return new HelloWorld(id);
	}
	

}

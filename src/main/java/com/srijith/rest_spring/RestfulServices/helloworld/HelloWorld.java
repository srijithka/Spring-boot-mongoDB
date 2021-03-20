package com.srijith.rest_spring.RestfulServices.helloworld;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld {
	
	private String helloWorld;
	
	

	public HelloWorld() {
		super();
		this.helloWorld = "hi srijith";
	}
	

	public HelloWorld(String helloWorld) {
		super();
		this.helloWorld = "hi"+" "+helloWorld;
	}


	public String getHelloWorld() {
		return helloWorld;
	}

	public void setHelloWorld(String helloWorld) {
		this.helloWorld = helloWorld;
	}
	

}

package com.etres.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
	
	
	public String sayHello(String name) {
		return "Hello,"+name;
	}
}

package com.etres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etres.service.HelloService;

@Controller
public class HelloController {
	
	@Autowired
	HelloService helloService;
	
	@RequestMapping(value="hello",method=RequestMethod.GET)
    @ResponseBody
	public String hello() {
		String msg = helloService.sayHello("zhangsanfeng");
		return msg;
	}
	


}

package com.etres.controller;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etres.User;
import com.etres.service.UserService;

@Controller
public class UserController {
	
	@Autowired
   private UserService userService;
	
	// /getUser?userId=1&name=zhansan
	@RequestMapping(path="getUser",method=RequestMethod.GET)
	@ResponseBody
	public String getUser( @RequestParam("id")Integer userId,
			 String name) {
		
		System.out.println("Ãû×Ö"+name);
		return userService.getUserById(userId).toString();
		
	}
	
	@RequestMapping("getUsers")
	@ResponseBody
	public String getUsers(@RequestParam("userids")Integer ids[]) {
		
		System.out.println(Arrays.asList(ids));
		String s="";
		for (Integer integer : ids) {
			s+=userService.getUserById(integer).toString()+"\r\n";
		}
		return s;
	}
	
	//user?usrId=5&name=lisi&age=30&birthday=2010-03-01
	@RequestMapping("usr")
	@ResponseBody
	public User usr(Integer id,String name,Integer age,Date birthday) {
		
		return new User(id,name,age,birthday);
	}
	
	@RequestMapping("usr2")
	@ResponseBody
	//usr2?userId=5&userName=lisi&age=30&birthday=2010-03-01
	public User usr2(User usr) {
		return usr;
	}

}

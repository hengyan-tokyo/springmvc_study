package com.etres.controller;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.etres.ErrorMsg;

@Controller
public class LoginController {
	
	@RequestMapping(path="login",method=RequestMethod.POST)
	public String login(@RequestParam("userName")String username,String password,
			
			Map<String, Object> map) {
		
		System.out.println("username"+username);
		System.out.println("password"+password);
		
		if( StringUtils.isNotBlank(username) && "123456".equals(password)) {
			// /webapp/jsp/list.jsp
			return "list";
		}else {
			ErrorMsg errorMsg = new ErrorMsg();
			errorMsg.setMsg("用户名或密码错误");
			errorMsg.setMsgId("1000");
			map.put("error", errorMsg);
			return "login";
		}
		
	}

}

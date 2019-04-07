package com.etres.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.etres.ErrorMsg;

@Controller
//@SessionAttributes(names="error")
public class LoginController {
	
	@RequestMapping(path="login",method=RequestMethod.POST)
	public String login(@RequestParam("userName")String username,String password,
			
			Map<String, Object> map) {
		
		System.out.println("username"+username);
		System.out.println("password"+password);
		
		if(username.equalsIgnoreCase("xiaoming") && password.equals("123456")) {
			// /webapp/jsp/list.jsp
			return "list2";
		}else {
			ErrorMsg errorMsg = new ErrorMsg();
			errorMsg.setMsg("password error");
			errorMsg.setMsgId("1000");
			map.put("error", errorMsg);
			return "index";
		}
		
	}

}

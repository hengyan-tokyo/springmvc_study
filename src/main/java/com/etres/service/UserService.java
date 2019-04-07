package com.etres.service;

import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.etres.User;

@Service
public class UserService {
	
	private static HashMap<Integer , User> map = new HashMap<Integer, User>(){
		private static final long serialVersionUID = 1L;
		{
			put(1, new User(1, "zhangsan",20, new Date()));
			put(2, new User(2, "lisi",23, new Date()));
			put(3, new User(3, "zhangsan",20, new Date()));
			put(4, new User(4, "zhangsan",20, new Date()));
			
		}
	};
	
	
	public User getUserById(Integer id) {
		return map.get(id);
	}

}

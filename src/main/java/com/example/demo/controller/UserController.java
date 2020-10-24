package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/get/{userId}")
	@ResponseBody
	public User get(@PathVariable Long userId)
	{
		System.out.println("fneifjiejdiwejdiwjdi");
		var abc = userRepository.findById(userId);
		System.out.println(abc.toString());
		return userRepository.findById(userId).get();
	}
	
}



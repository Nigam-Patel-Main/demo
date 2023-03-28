package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("list")
	public List<User> list() {
		return userRepository.list();
	}
	
	@PostMapping("add")
	public Map<String, String> add(@RequestBody User user) {
		userRepository.add(user);
		Map<String, String> map = new HashMap<>();
		map.put("message", "User addded succussfully");
		return map;
	}
	
	
	@GetMapping("delete")
	public String add(@RequestParam Integer id) {
		userRepository.remove(id);
		return "User remove succussfully";
	}
	
	
	@PostMapping("edit")
	public String edit(@RequestBody User user) {
		userRepository.edit(user); 
		return "User edit succussfully.";
	}
	
}

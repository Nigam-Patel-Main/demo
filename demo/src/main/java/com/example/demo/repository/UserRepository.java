package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.dto.User;

@Component
public class UserRepository {
	
	private List<User> userList = null;

	public UserRepository() {
		super();
		this.userList = new ArrayList<>();
	}
	
	public List<User> list(){
		return userList; 
	}
	
	public void add(User user) {
		userList.add(user);
	}
	
	public void edit(User updatedUser) {
		int index =0; 
		for (User user : userList) {
			//1 == 1
			if(user.getId().equals(updatedUser.getId())) {
				break;
			}
			index++;
		}
		String nigam ="";
		System.out.println(index);
		userList.set(index, updatedUser);
		
	}
	
	public void remove(Integer id) {
		this.userList.removeIf(u -> u.getId().equals(id));
	}
}

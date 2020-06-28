package com.hack.equipo4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hack.equipo4.dtos.User;
import com.hack.equipo4.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	public User addUser(User user) {
		userRepository.save(user);
		return user;
		
	}
	
	public boolean doLogin(String login, String password) {
		User usuario = userRepository.findByLogin(login);
		if (usuario == null) {
			return false;
		}
		
		if (usuario.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	
	
	

}

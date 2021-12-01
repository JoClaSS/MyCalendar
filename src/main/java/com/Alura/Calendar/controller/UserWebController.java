package com.Alura.Calendar.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Alura.Calendar.model.UserWeb;
import com.Alura.Calendar.service.UserWebService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserWebController {

	@Autowired
	private UserWebService service;

	@PostMapping
	@ResponseBody
	public String save(@RequestBody UserWeb newUser) {
		return this.service.saveUpdate(newUser);
	}

	@GetMapping("/search/all")
	public List<UserWeb> findAll() {
		return this.service.findAll();
	}

	@GetMapping("/search/login")
	public UserWeb searchUser(@RequestParam(value = "login", required = true) String login){
		return service.searchUser(login);
	}
	
	@GetMapping("/search/active")
	public Optional<UserWeb> searchActive(@RequestParam(value = "active", required = true) Boolean active){
		return service.searchActive(active);
	}
}

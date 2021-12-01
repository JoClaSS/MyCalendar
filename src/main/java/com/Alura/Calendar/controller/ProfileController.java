package com.Alura.Calendar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Alura.Calendar.model.Profile;
import com.Alura.Calendar.model.ProfileDTO;
import com.Alura.Calendar.service.ProfileService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

	@Autowired
	private ProfileService service;

	@PostMapping
	@ResponseBody
	public String save(@RequestBody ProfileDTO dto) {
		return this.service.saveUpdate(dto);
	}

	@GetMapping("/search/all")
	public List<Profile> findAll() {
		return this.service.findAll();
	}
	
	@GetMapping("/search/list")
	public List<Profile> findList(@RequestParam(value = "names", required = true) List<String> list) {
		return this.service.findList(list);
	}


}

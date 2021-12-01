package com.Alura.Calendar.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Alura.Calendar.model.Event;
import com.Alura.Calendar.model.EventDTO;
import com.Alura.Calendar.model.ProfileDTO;
import com.Alura.Calendar.service.EventService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {
	
	@Autowired
	private EventService service;
	
	@PostMapping
	@ResponseBody
	public String save(@RequestBody EventDTO dto) throws ParseException {
		 return this.service.saveUpdate(dto);
	}

	@GetMapping("/search/meeting")
	public Event findEventByName(@RequestParam String name) {
		return this.service.findEventByName(name);
	}
	
	@GetMapping("/search/date")
	public Event findEventByDate(@RequestParam String date) throws ParseException {
		return this.service.findEventByDate(date);
	}
}

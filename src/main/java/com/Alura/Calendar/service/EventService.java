package com.Alura.Calendar.service;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Alura.Calendar.model.Event;
import com.Alura.Calendar.model.EventDTO;
import com.Alura.Calendar.repository.EventRepository;
import com.Alura.Calendar.repository.ProfileRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository repository;
	@Autowired
	private ProfileRepository repositoryProfile;

	public void deleteById(Long id) {
		this.repository.deleteById(id);
	}

	public String saveUpdate(EventDTO dto) throws ParseException {
	   Event event = new Event();
	   event.setProfile(repositoryProfile.findByList(dto.getProfile())); 
	   event.setName(dto.getName());
	   event.setDate_meeting(DateUtils.parseDate(dto.getDate_meeting(), 
			     new String[] { "yyyy-MM-dd HH:mm:ss", "dd/MM-yyyy" }));  
	   try {
		   this.repository.save(event);
		   return "evento criado com sucesso!";
	   }
	   catch(NullPointerException e) {
		   return "Não foi possível criar o evento";
	   }
	}
	
	
    public Event findEventByName(String event_name) {
    	return repository.findEventByName(event_name);
    }
    
    public Event findEventByDate(String date) throws ParseException {
    	Date formatDate = DateUtils.parseDate(date, 
			     new String[] { "yyyy-MM-dd HH:mm:ss", "dd/MM-yyyy" });
    	return repository.findEventByDate(formatDate);
    }
}

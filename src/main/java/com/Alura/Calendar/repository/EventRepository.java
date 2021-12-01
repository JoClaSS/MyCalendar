package com.Alura.Calendar.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Alura.Calendar.model.Event;
import com.Alura.Calendar.model.Profile;

public interface EventRepository extends JpaRepository<Event,Long> {
	
	@Query(value= "select * from event e where (:name is null or e.name= :name)", nativeQuery = true)
	Event findEventByName(@Param("name") String name);
	
	@Query(value= "select * from event e where (:date_meeting is null or e.date_meeting= :date_meeting)", nativeQuery = true)
	Event findEventByDate(@Param("date_meeting") Date date_meeting);
}

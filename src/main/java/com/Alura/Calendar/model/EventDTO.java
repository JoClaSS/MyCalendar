package com.Alura.Calendar.model;

import java.util.List;

import lombok.Data;

@Data
public class EventDTO {
	private String name;
	private String date_meeting;
	private List<String> profile;
}

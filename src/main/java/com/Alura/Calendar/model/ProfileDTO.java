package com.Alura.Calendar.model;

import lombok.Data;

@Data
public class ProfileDTO {
	private Long id;
	private String name;
	private String email;
	private String number;
	private String country;
	private String role;
	private String user;
}

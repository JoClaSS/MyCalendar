package com.Alura.Calendar.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.JoinColumn;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "event")
public class Event {

	@Id
	@SequenceGenerator(name = "seqe", sequenceName = "event_seq", allocationSize = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqe")
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="date_meeting")
	private Date date_meeting;
	@CreationTimestamp
	@Column(name="creation_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creation_time;
	@Column(name="Owner")
	private String Owner;
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinTable(name = "event_profile", joinColumns = @JoinColumn(name = "fk_event"), inverseJoinColumns = @JoinColumn(name = "fk_profile"))
	private List<Profile> profile; 
} 
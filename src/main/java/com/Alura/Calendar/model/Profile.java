package com.Alura.Calendar.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="profile")
public class Profile {
		  @Id
		  @SequenceGenerator(name="seqp",sequenceName="pro_seq", allocationSize = 0)
		  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqp")
		  private Long id;
		  @Column(nullable=false)
		  private String name;
		  @Column(nullable=false)
		  private String email;
		  @Column
		  private String number;
		  @Column(nullable=false)
		  private String country;
		  @Column(nullable=false)
		  private String role;
		  @OneToOne
		  private UserWeb fk_user;
}

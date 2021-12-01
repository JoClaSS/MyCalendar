package com.Alura.Calendar.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="userweb")
public class UserWeb {
		  @Id
		  @SequenceGenerator(name="sequ",sequenceName="user_seq", allocationSize = 0)
		  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sequ")
		  private Long id;
		  @Column(name="login", nullable=false,unique=true)
		  private String login;
		  @Column(name="password", nullable=false)
		  private String password;
		  @Column(name="active", nullable=false)
		  private Boolean active;
}

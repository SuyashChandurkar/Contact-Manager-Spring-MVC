package com.jspiders.springmvc.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Entity
@Data
@Table(name="user_information")
@Component
public class UserDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private  int id;
	@Column(nullable = false,unique = true)
private  String email;
	@Column(nullable = false,unique = true)
private  String password;

}

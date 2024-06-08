package com.jspiders.springmvc.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import lombok.Data;

@Entity
@Data
@Table(name="contact_info")
@Component
public class ContactDto {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
@Column(nullable = false,unique = false)
 private String firstname;
@Column(nullable = false,unique = false)
 private String lastname;
@Column(nullable = false,unique = true)
private   String email;
@Column(nullable = false,unique = true)
private  String phonebumber;




}

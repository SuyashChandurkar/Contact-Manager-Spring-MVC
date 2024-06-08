package com.jspiders.springmvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.springmvc.dao.ContactDao;
import com.jspiders.springmvc.dao.UserDao;
import com.jspiders.springmvc.dto.ContactDto;
import com.jspiders.springmvc.dto.UserDto;

@Component
public class ContactServices {
	@Autowired
private  ContactDto contactDto;
	@Autowired
private ContactDao contactDao;
	
	
	
	public boolean addContact(String firstName, String lastName, String email, String mobile) {
		contactDto.setFirstname(firstName);
		contactDto.setLastname(lastName);
		contactDto.setEmail(email);
		contactDto.setPhonebumber(mobile);
		try {
			contactDao.addContact(contactDto);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}



	public List<ContactDto> viewallcontact() {
		System.out.println("contactservices viewallmethod");
		System.out.println(contactDao);
		List<ContactDto> contacts = contactDao.viewallcontact();
		
		if (contacts.size()>0) {
			System.out.println("end  contactservices viewallmethod");
			return contacts;
		}else {
			System.out.println("end by sending null contactservices viewallmethod");
			return null;
		}
		
	}



	public ContactDto deleteContact(int id) {
		ContactDto contact = contactDao.deleteContact(id);
		return contact;
	}



	public static ContactDto getContact(int id) {
		ContactDto contact = ContactDao.getContact(id);
		return contact;
	}



	public  boolean updateContact(int id, String firstname, String lastname, String email, String mobile) {
		
		try {
			contactDao.updateContact(id,firstname,lastname,email,mobile);
			return true;
		} catch (Exception e) {
			return false;
		}
	}



	public ContactDto searchByOperation(String option, String name) {
		return contactDao.searchByOperation(option, name);
		
	}



	



	

	

}

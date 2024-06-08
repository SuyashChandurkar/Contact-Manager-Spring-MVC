package com.jspiders.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.springmvc.dto.ContactDto;

@Component
public class ContactDao {
@Autowired
private  ContactDto contactDto;
private static EntityManager entityManager;
private static EntityManagerFactory entityManagerFactory;
private static EntityTransaction entityTransaction;


public static void addContact(ContactDto contactDto) {
	openConnection();
	entityTransaction.begin();
	entityManager.persist(contactDto);
	entityTransaction.commit();
	closeConnection();
	
}
  
public static void openConnection() {
	entityManagerFactory=Persistence.createEntityManagerFactory("contact_manager");
	entityManager=entityManagerFactory.createEntityManager();
	entityTransaction=entityManager.getTransaction();
}

public static void closeConnection() {
	if (entityManager!= null) {
		entityManager.close();
	}
	
	if (entityManagerFactory!=null) {
		entityManagerFactory.close();
	}
	
	if (entityTransaction!=null) {
		if (entityTransaction.isActive()) {
			entityTransaction.rollback();
		}
	}
}

public List<ContactDto> viewallcontact() {
	System.out.println("DAO VIEW");
	openConnection();
	Query query=entityManager.createQuery("select contact from ContactDto contact");
	List<ContactDto> contacts = query.getResultList();
	closeConnection();
	System.out.println("end DAO");
	return contacts;
}

public ContactDto deleteContact(int id) {
	openConnection();
	entityTransaction.begin();
	ContactDto contact = entityManager.find(ContactDto.class, id);
	if (contact!=null) {
		entityManager.remove(contact);
	
	}else {
		
	}
	entityTransaction.commit();
	closeConnection();
	
	return contact;
	
}

public static ContactDto getContact(int id) {
	openConnection();
	
	ContactDto contact = entityManager.find(ContactDto.class,id);
	
	closeConnection();
	
	return contact;
}



//public void updateContact(ContactDto contactDto2) {
//	openConnection();
//	entityTransaction.begin();
//	entityManager.persist(contactDto2);
//	entityTransaction.commit();
//	closeConnection();
//	System.out.println("updation complete");
//	
//}

public void updateContact(int id, String firstname, String lastname, String email, String mobile) {
    openConnection();
    entityTransaction.begin();
    
    Query query = entityManager.createQuery("UPDATE ContactDto c SET c.firstname = :firstname, c.lastname = :lastname, c.email = :email, c.phonebumber = :mobile WHERE c.id = :id");
    query.setParameter("id", id);
    query.setParameter("firstname", firstname);
    query.setParameter("lastname", lastname);
    query.setParameter("email", email);
    query.setParameter("mobile", mobile);
    
    int rowsUpdated = query.executeUpdate();
    entityTransaction.commit();
    closeConnection();
    System.out.println("closeconnection");
}

public ContactDto searchByOperation(String option, String name) {
    openConnection();
    // Assuming ContactDto is your entity class representing contacts

    // Create the JPQL query with proper concatenation and spacing
    String jpql = "SELECT contact FROM ContactDto contact WHERE " + option + " LIKE :name";

    // Create the query
    Query query = entityManager.createQuery(jpql);

    // Set the parameter value
    query.setParameter("name", "%" + name + "%");

    // Execute the query and return the single result
    ContactDto contact = (ContactDto) query.getSingleResult();
    System.out.println(contact);
    closeConnection();
    
    return contact;
}

}

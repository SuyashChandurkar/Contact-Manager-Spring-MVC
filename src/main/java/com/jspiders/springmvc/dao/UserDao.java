package com.jspiders.springmvc.dao;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.jspiders.springmvc.dto.UserDto;
@Component
public class UserDao {
	
	private static EntityManager entityManager;
	private static EntityManagerFactory entityManagerFactory;
	private static EntityTransaction entityTransaction;
	
	
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
	
	
	public void adduser(UserDto userDto) {
		openConnection();
		entityTransaction.begin();
		entityManager.persist(userDto);
		entityTransaction.commit();
		closeConnection();
	}
	
	public UserDto findUserByEmailAndPassword(String email,String password) {
		System.out.println("USerDao findUserByEmailAndPassword");
		openConnection();
		Query query = entityManager.createQuery("select user from UserDto user where email=?1 AND password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		UserDto dto= (UserDto)query.getSingleResult();
		System.out.println(dto);
		closeConnection();
		return dto;
		
	}

	public static void deleteUser(int id) {
		openConnection();
		entityTransaction.begin();
		UserDto user = entityManager.find(UserDto.class, id);
		entityManager.remove(user);
		entityTransaction.commit();
		closeConnection();
		
		
	}

	
}

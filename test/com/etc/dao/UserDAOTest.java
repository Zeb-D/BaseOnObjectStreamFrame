package com.etc.dao;

import org.junit.Test;

import com.etc.domain.User;

public class UserDAOTest {
	
	//×¢½â
	@Test
	public void testValidateUser(){
		UserDAO userDAO = new UserDAO();
		System.out.println(userDAO.validateUser(new User("user0","password0")));
	}
	
	@Test
	public void test1(){
		System.out.println(1);
	}
}

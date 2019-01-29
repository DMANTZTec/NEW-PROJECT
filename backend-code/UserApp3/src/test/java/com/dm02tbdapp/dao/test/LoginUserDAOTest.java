package com.dm02tbdapp.dao.test;

import static org.junit.Assert.*;

import org.json.simple.JSONObject;
import org.junit.Test;

import com.dm02tbdapp.dao.LoginUserDAO;

public class LoginUserDAOTest {

	@Test
	public void testLogin(String uid,String pwd) {
	LoginUserDAO userDAO=new LoginUserDAO();
	//JSONObject jsonObj=userDAO.login(String uid,String pwd);
	//assertNotNull(jsonObj);
	}
}
package com.dm_02_tbdapp.dao.test;

import static org.junit.Assert.*;

import org.json.simple.JSONObject;
import org.junit.Test;

import com.dm_02_tbdapp.dao.LoginUserDAO;

public class LoginUserDAOTest {

	@Test
	public void testLogin(String uid,String pwd) {
	LoginUserDAO userDAO=new LoginUserDAO();
	//JSONObject jsonObj=userDAO.login(String uid,String pwd);
	//assertNotNull(jsonObj);
	}
}
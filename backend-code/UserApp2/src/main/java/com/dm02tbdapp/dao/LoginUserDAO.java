package com.dm02tbdapp.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;

import com.dm02tbdapp.utils.JsonToJava;


public class LoginUserDAO {
	final static Logger logger = LogManager.getLogger(LoginUserDAO.class);
public JSONObject login(JSONObject credentials) {
	// jdbc code to get all values from db and compare with userId and password.	
	
JSONObject userCredentialsObj=new JSONObject(credentials);
String userName= (String) userCredentialsObj.get("username");
String pwd= (String) userCredentialsObj.get("password");
String lastName=(String) userCredentialsObj.get("lastName");
String emailId=(String) userCredentialsObj.get("emailId");
String mobileNumber=(String) userCredentialsObj.get("mobileNumber");


System.out.println("username is: "+userName+"and password is: "+pwd);
System.out.println("lastname is: "+ lastName);
System.out.println("emailId is: "+ emailId);
System.out.println("mobileNumber is: "+ mobileNumber);

JSONObject jsonObj=new JSONObject();
jsonObj.put("firstName",userName);
jsonObj.put("password",pwd);
jsonObj.put("lastName",lastName);
jsonObj.put("emailId",emailId);
jsonObj.put("mobileNumber",mobileNumber);




return jsonObj;
}
}

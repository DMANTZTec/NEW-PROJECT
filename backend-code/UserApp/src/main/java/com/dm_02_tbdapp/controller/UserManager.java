package com.dm_02_tbdapp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dm_02_tbdapp.bean.User;
import com.dm_02_tbdapp.dao.AddAddressDAO;
import com.dm_02_tbdapp.dao.LoginUserDAO;
import com.dm_02_tbdapp.dao.LogoutUserDAO;
import com.dm_02_tbdapp.dao.ProductDAO;
import com.dm_02_tbdapp.dao.RegisterNewUserDAO;
import com.dm_02_tbdapp.dao.RegisterUserDAO;
import com.dm_02_tbdapp.dao.RemoveAddressDAO;
import com.dm_02_tbdapp.dao.UpdateAddressDAO;
import com.dm_02_tbdapp.dao.UpdateUserDAO;


@Service
public class UserManager {
	
	
	@Autowired
	RegisterNewUserDAO registerNewUserDAO_Obj;
	
	@Autowired
	ProductDAO productDAOObj;
	
	final static Logger logger = LogManager.getLogger(UserManager.class);
	
	public JSONObject loginUser(JSONObject credentials) {
        LoginUserDAO loginUserObj=new LoginUserDAO();
        JSONObject userProfileJsonObj=null;
        JSONObject responseJsonObj=new JSONObject();
        userProfileJsonObj=loginUserObj.login(credentials);	
        try {
    
    logger.info("json object is created and entered into class UserManager.java .");
	
    responseJsonObj.put("status","success.");
    responseJsonObj.put("reason","entered username and password are correct.");
    responseJsonObj.put("UserProfile", userProfileJsonObj);
    //throw new Exception();
	
		}catch(Exception e) {
			
			responseJsonObj.put("status", "failed");
			responseJsonObj.put("reason", "entered username/password are incorrect");
			userProfileJsonObj=null;
			responseJsonObj.put("UserProfile", userProfileJsonObj);
			
    		logger.error("exception has occured and requested user is not logged in. "+e);	
		
		}
	
	logger.info("this method is responsible to return the json object.");

    return responseJsonObj;
    }
	
	
    public JSONObject registerNewUser(JSONObject newUserObj) {
    	//RegisterNewUserDAO registerNewUserDAO_Obj=new RegisterNewUserDAO();
    	JSONObject userProfileObj=null;
    	JSONObject registerUserObj=new JSONObject();
    	logger.info("Before calling register method");
    	userProfileObj=registerNewUserDAO_Obj.register(newUserObj);
    	logger.info("entered into UserManager class ");
    	logger.info("registeredNewUserObj is: "+newUserObj.get("firstName"));
    	try {
    	    registerUserObj.put("status","registration completed.");
    	    registerUserObj.put("reason", "entered details are valid.");
    	    registerUserObj.put("UserProfile", newUserObj);
    	    
    	}catch(Exception e) {
    		logger.info("Exception has occured we have entered into catch block.");
    		registerUserObj.put("status", "failed to register.");
    		registerUserObj.put("reason", "entered details are not valid.");
    	}
    	
    	logger.info("compleate json object is: "+registerUserObj.toString());
    	return registerUserObj;
    }
	
	
	public JSONObject logoutUser() {
    	LogoutUserDAO logoutObj=new LogoutUserDAO();
    	JSONObject jsonObj=new JSONObject();
    	logger.info("JSON Object is created.In class UserManager.java ");
    	try {
    		logoutObj.logout();
    		jsonObj.put("status", "user logged out successfully.");
    	}catch(Exception e) {
    		jsonObj.put("status", "failed");
    		logger.error("exception has occured and requested user is not logged out. "+e);
    	}
    	logger.info("it is about to return the json object.");
    	
    	return jsonObj;
    }
    
	public JSONObject registerUser(User userObj) {
		logger.info("Enter: registerUser ");
    	RegisterUserDAO registerObj=new RegisterUserDAO();
    	
    	JSONObject jsonObj=new JSONObject();
    	logger.info("JSON Object is created.In class UserManager.java ");
    	try {
    	registerObj.registerUser(userObj);
    	jsonObj.put("status", "success");
    	}catch(Exception e) {
    		jsonObj.put("status", "failed");
    		logger.error("exception has occured and requested user is not registered. "+e);
    	
    	}
    	logger.info("it is about to return the json object.");
    	return jsonObj;
    }
   
    public JSONObject updateUser(User userObj) {
    	JSONObject jsonObj=new JSONObject();
    	logger.info("json object is created and entered into class UserManager.java .");
    	UpdateUserDAO updateObj=new UpdateUserDAO();
    	try {	
    		
    		updateObj.updateUser(userObj);
    		jsonObj.put("status","user updated");
    	}catch(Exception e) {
    		jsonObj.put("status", "failed");
    		logger.error("exception has occured and requested user is not updated. "+e);
    	     
    	}

    	
    	logger.info("it is about to return the json object.");
    	return jsonObj;
    }
    public JSONObject updateAddress(User userObj) {
    	JSONObject jsonObj=new JSONObject();
    	logger.info("json object is created and entered into class UserManager.java .");
    	
    	UpdateAddressDAO updateObj=new UpdateAddressDAO();
    	logger.info("UpdateAddressDAO object is created. ");
    	try{
    		updateObj.updateAddress(userObj);
    		jsonObj.put("status", "updated");
          	} catch(Exception e) {
          		jsonObj.put("status","failed");
         	   logger.error("exception has occured and requested user's address is not updated.  "+e);
                
          	}
    	logger.info("this method is about to return the json object.");
    	
    	return jsonObj;
    }
    
    public JSONObject addAddress(User userObj) {
    	
    	AddAddressDAO addressObj=new AddAddressDAO();
    	JSONObject jsonObj=new JSONObject();
    	logger.info("json object is created and entered into class UserManager.java ."); 
    	try{
    		addressObj.addAddress(userObj);
    		jsonObj.put("status", "address is added");
    	}catch(Exception e) {
    		jsonObj.put("status","failed");
      	   logger.error("exception has occured and requested user's address is not updated.  "+e);
    	}
    	logger.info("this method is about to return the json object.");

    	return jsonObj;
    }
    
    public JSONObject removeAddress(User userObj) {
    	RemoveAddressDAO addressObj=new RemoveAddressDAO();
    	JSONObject jsonObj=new JSONObject();
    	logger.info("json object is created and entered into class UserManager.java .");   
    	try{
        	   addressObj.removeAddress(userObj);
        	   logger.info("requested user's address is removed");
        	   jsonObj.put("status","success");
           }catch(Exception e) {
        	   jsonObj.put("status","failed");
        	   logger.error("exception has occured and requested user's address is not removed.  "+e);
               
           }
           logger.info("this method is about to return the json object.");   
    	return jsonObj;
    }
    
    public JSONObject insertProduct(JSONObject productObj) {
    	JSONObject product_table_obj=productDAOObj.insertProduct(productObj);
    	return product_table_obj;
    }

}

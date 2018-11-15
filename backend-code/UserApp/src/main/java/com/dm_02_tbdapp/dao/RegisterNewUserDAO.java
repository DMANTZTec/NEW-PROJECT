package com.dm_02_tbdapp.dao;


import org.json.simple.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dm_02_tbdapp.controller.UserManager;
import com.dm_02_tbdapp.dao.RegisterNewUserDAO;

@Repository
public class RegisterNewUserDAO {
	final static Logger logger = LogManager.getLogger(RegisterNewUserDAO.class);

	@Autowired
    private JdbcTemplate jdbcTemplate;
	  
	public JSONObject register(JSONObject credentials) {
	// code to register or save into the database.
		
	logger.info("Enter: register()");
	JSONObject userCredentialsObj=new JSONObject(credentials);
	
    //System.out.println("in RegisterNewUserDAO class, UserProfile object is: "+userCredentialsObj.toString());
	String first_name= (String) userCredentialsObj.get("firstName");
	String password= (String) userCredentialsObj.get("password");
	String last_name=(String) userCredentialsObj.get("lastName");
	String email_id=(String) userCredentialsObj.get("emailid");
    String mobile_number=(String)userCredentialsObj.get("mobileNumber");
	
    // code to insert into database
    
    
     
		
		
		String sql="INSERT INTO user_profile VALUES(?,?,?,?,?)";
		/*
		String item=(String) itemDetailsJsonObj.get("item_name");
		Double unitPrice=(Double) itemDetailsJsonObj.get("unit_price");
		Integer quantity=(Integer) itemDetailsJsonObj.get("quantity");
		Double totalPrice=(Double) itemDetailsJsonObj.get("total_price");
		*/		
		
		
	logger.info("Befor callin jdbcTemplate.update");
	logger.info("jdbcTemplate is: "+jdbcTemplate);
	jdbcTemplate.update(sql,new Object[] {first_name,last_name,email_id,password,mobile_number});
	



    
    
/*
	System.out.println("username is: "+userName+"and password is: "+pwd);
	System.out.println("lastname is: "+ lastName);
	System.out.println("emailId is: "+ emailId);
	System.out.println("mobileNumber is: "+ mobileNumber);
*/
	JSONObject userObj=new JSONObject();
	userObj.put("firstName",first_name);
	userObj.put("password",password);
	userObj.put("lastName",last_name);
	userObj.put("emailId",email_id);
	userObj.put("mobileNumber",mobile_number);
	
	
	
	return userObj;
}


}

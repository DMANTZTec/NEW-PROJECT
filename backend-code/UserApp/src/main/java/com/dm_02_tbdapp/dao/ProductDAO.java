package com.dm_02_tbdapp.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class ProductDAO {
	final static Logger logger = LogManager.getLogger(ProductDAO.class);

	@Autowired
    private JdbcTemplate jdbcTemplate;
	  
	public JSONObject insertProduct(JSONObject productObj) {
	// code to register or save into the database.
		
	logger.info("Enter: (.)");
	JSONObject product_tableObj=new JSONObject(productObj);
	
	
    //System.out.println("in RegisterNewUserDAO class, UserProfile object is: "+userCredentialsObj.toString());
	String productId= (String) product_tableObj.get("firstName");
	String productName= (String) product_tableObj.get("password");
	String productSize=(String) product_tableObj.get("lastName");
	String productPrice=(String) product_tableObj.get("emailId");
    String productQuantity=(String) product_tableObj.get("mobileNumber");
	
    // code to insert into database
    
    
     
		
		
		String sql="INSERT INTO product_table VALUES(?,?,?,?,?)";
		
	logger.info("Befor callin jdbcTemplate.update");
	logger.info("jdbcTemplate is: "+jdbcTemplate);
	jdbcTemplate.update(sql,new Object[] {productId,productName,productSize,productPrice,productQuantity});
	



    
    
	JSONObject userObj=new JSONObject();
	userObj.put("productId",productId);
	userObj.put("productName",productName);
	userObj.put("productSize",productSize);
	userObj.put("productPrice",productPrice);
	userObj.put("productQuantity",productQuantity);
	
	
	
	return userObj;

}
}
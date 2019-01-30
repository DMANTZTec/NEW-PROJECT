package com.dm02tbdapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedCaseInsensitiveMap;

import com.dm02tbdapp.bean.Product;

@Repository

public class OrderClientImpl implements OrderClients {
	
	
	ArrayList cart=new ArrayList();
	int noOfItems;
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	
	public JSONObject showCatalog() {
		JSONArray jsonarrayObj=new JSONArray();
		JSONObject jsonMainObj=new JSONObject();
		JSONObject jsonObj=null;
		Product productObj=new Product();
		// write jdbc code to retrive records from database.
	 System.out.println("JdbcTemplate object is: "+jdbcTemplate);
	 String query="select * from catalog";
	 List results=jdbcTemplate.queryForList(query);
	 for(Object result:results) {
		 LinkedCaseInsensitiveMap map=(LinkedCaseInsensitiveMap)result;
		 jsonObj=new JSONObject();
		 for (Object key : map.keySet()) {
			
	         System.out.print(key + " = " + map.get(key) + "; ");
	         
	         jsonObj.put(key, map.get(key));
		 }
		
		 jsonarrayObj.put(jsonObj);
		 
	     System.out.println();
	 }
	 jsonMainObj.put("Catalog",jsonarrayObj);
	 System.out.println(jsonarrayObj.toString());
 
      return jsonMainObj;

		}

	
	public JSONObject order() {
	
   /* 	int i=0;
	int j=1;
	while(i==0) {
	
	
	}  */
		JSONArray jsonarrayObj=new JSONArray();
		JSONObject jsonMainObj=new JSONObject();
		JSONObject jsonObj=null;
		Product productObj=new Product();
		// write jdbc code to retrive records from database.
	 System.out.println("JdbcTemplate object is: "+jdbcTemplate);
	 String query="select * from catalog";
	 List results=jdbcTemplate.queryForList(query);
	 for(Object result:results) {
		 LinkedCaseInsensitiveMap map=(LinkedCaseInsensitiveMap)result;
		 jsonObj=new JSONObject();
		 for (Object key : map.keySet()) {
			
	         System.out.print(key + " = " + map.get(key) + "; ");
	         
	         jsonObj.put(key, map.get(key));
		 }
		
		 jsonarrayObj.put(jsonObj);
		 
	     System.out.println();
	 }
	 jsonMainObj.put("OrderItems",jsonarrayObj);
	 System.out.println(jsonarrayObj.toString());

		
	try {
		JSONArray containerObject= new JSONArray(jsonarrayObj);
		//System.out.println(containerObject.hasKey("")));
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("");
	    
					return null;
	}

	
	public JSONObject updateOrder() {
		
		return null;
	}

	
	public JSONObject cancelOrder() {
		
		return null;
	}

	
	public double priceOfOrder() {
		
		return 0;
	}


	public JSONObject viewOrder() {
		
		return null;
	}
    
	public void quantity() {
			
	}
}

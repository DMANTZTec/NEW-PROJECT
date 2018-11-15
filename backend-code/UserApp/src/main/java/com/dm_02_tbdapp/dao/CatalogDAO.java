package com.dm_02_tbdapp.dao;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedCaseInsensitiveMap;

import com.dm_02_tbdapp.bean.Product;


@Repository
public class CatalogDAO {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public JSONObject showMenu() {
	
	
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
}
